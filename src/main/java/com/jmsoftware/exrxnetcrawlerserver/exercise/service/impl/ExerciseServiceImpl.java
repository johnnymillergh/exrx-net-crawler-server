package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jmsoftware.exrxnetcrawlerserver.common.aspect.ValidateArgument;
import com.jmsoftware.exrxnetcrawlerserver.common.exception.BizException;
import com.jmsoftware.exrxnetcrawlerserver.common.sftp.SftpService;
import com.jmsoftware.exrxnetcrawlerserver.common.sftp.SftpSubDirectory;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.*;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.*;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * <h1>ExerciseServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:15 PM
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseMapper exerciseMapper;
    private final ExerciseClassificationService exerciseClassificationService;
    private final ExerciseRelatedClassificationService exerciseRelatedClassificationService;
    private final ExerciseCommentService exerciseCommentService;
    private final ExerciseRelatedMuscleService exerciseRelatedMuscleService;
    private final MuscleService muscleService;
    private final SftpService sftpService;

    @Override
    public Integer saveExerciseClassification(SaveExerciseClassificationPayload payload) {
        List<ExerciseClassificationPo> exerciseClassificationPoList = new LinkedList<>();
        payload.getExerciseClassificationPayloadList().forEach(exerciseClassificationPayload -> {
            ExerciseClassificationPo exerciseClassificationPo = new ExerciseClassificationPo();
            BeanUtil.copyProperties(exerciseClassificationPayload, exerciseClassificationPo);
            exerciseClassificationPoList.add(exerciseClassificationPo);
        });
        return exerciseClassificationService.saveExerciseClassification(exerciseClassificationPoList);
    }

    @Override
    @ValidateArgument
    @Transactional(rollbackFor = Throwable.class)
    public Long saveExercise(@Valid SaveExercisePayload payload) {
        // Save exercise
        var exercisePo = new ExercisePo();
        exercisePo.setName(payload.getExerciseName());
        exercisePo.setPreparation(payload.getPreparation());
        exercisePo.setExecution(payload.getExecution());
        var optionalExercise = Optional.ofNullable(exerciseMapper.insertExercise(exercisePo));
        optionalExercise.orElseThrow(() -> new BizException("Cannot insert exercise into MySQL!"));
        log.info("Saved exercise, affectedRows = {}, exercise = {}", optionalExercise.get(), exercisePo);

        // Save exercise's related classification
        var exerciseRelatedClassificationPoList = new LinkedList<ExerciseRelatedClassificationPo>();
        payload.getExerciseRelatedClassificationPayloadList().forEach(payload1 -> {
            var optionalExerciseClassificationPo =
                    Optional.of(exerciseClassificationService.getExerciseClassificationByName(payload1.getClassificationName()));
            var po = new ExerciseRelatedClassificationPo();
            po.setExerciseClassificationId(optionalExerciseClassificationPo.get().getId());
            po.setRelatedClassificationType(payload1.getExerciseRelatedClassificationType());
            exerciseRelatedClassificationPoList.add(po);
        });
        var affectedRowsForSavingExerciseRelatedClassification =
                exerciseRelatedClassificationService.saveExerciseRelatedClassification(exerciseRelatedClassificationPoList);
        log.info("Saved exercise related classification, affectedRowsForSavingExerciseRelatedClassification = {}",
                 affectedRowsForSavingExerciseRelatedClassification);

        // Save exercise's comment
        var exerciseCommentPo = new ExerciseCommentPo();
        exerciseCommentPo.setExerciseId(exercisePo.getId());
        exerciseCommentPo.setComment(payload.getComments());
        var affectedRowsForSavingExerciseComment = exerciseCommentService.saveExerciseComment(exerciseCommentPo);
        log.info("Saved exercise comment, affectedRowsForSavingExerciseComment = {}",
                 affectedRowsForSavingExerciseComment);

        // Save exercise's related muscle
        var exerciseRelatedMusclePos = new LinkedList<ExerciseRelatedMusclePo>();
        payload.getExerciseRelatedMusclePayloadList().forEach(item -> {
            var optionalMusclePo = Optional.ofNullable(muscleService.getMuscleByName(item.getMuscleName()));
            optionalMusclePo.ifPresentOrElse(musclePo -> {
                var po = new ExerciseRelatedMusclePo();
                po.setMuscleId(optionalMusclePo.get().getId());
                po.setRelatedMuscleType(item.getRelatedMuscleType());
                exerciseRelatedMusclePos.add(po);
            }, () -> {
                log.warn("Cannot find muscle by name. Given exerciseRelatedMusclePayload: {}", item);
            });
        });
        var affectedRowsForSavingExerciseRelatedMuscle =
                exerciseRelatedMuscleService.saveExerciseRelatedMuscle(exerciseRelatedMusclePos);
        log.info("Saved exercise related muscle, affectedRowsForSavingExerciseRelatedMuscle = {}",
                 affectedRowsForSavingExerciseRelatedMuscle);
        return exercisePo.getId();
    }

    @Override
    public ExercisePo getExerciseById(Long id) {
        if (ObjectUtil.isNull(id)) {
            return null;
        }
        return exerciseMapper.selectById(id);
    }

    @Override
    public Integer updateExerciseGif(ExercisePo exercisePo) {
        if (StringUtils.checkValNull(exercisePo.getExerciseGifPath())) {
            throw new BizException("Invalid exercise's GIF path!");
        }
        return exerciseMapper.updateExerciseGifPathById(exercisePo);
    }

    @Override
    public Integer saveExerciseGif(Long exerciseId, MultipartFile exerciseGif) throws IOException {
        var exercisePo = this.getExerciseById(exerciseId);
        if (!StringUtils.checkValNull(exercisePo.getExerciseGifPath())) {
            var errorMessage = String.format("Already saved exercise's GIF, unable to overwrite! exercisePo = %s",
                                             exercisePo);
            log.error(errorMessage);
            throw new BizException(errorMessage);
        }
        var exerciseGifPath = sftpService.upload(exerciseGif,
                                                 SftpSubDirectory.EXERCISE_GIF.getSubDirectory(),
                                                 FileExistsMode.REPLACE,
                                                 true);
        exercisePo.setExerciseGifPath(exerciseGifPath);
        var affectedRows = this.updateExerciseGif(exercisePo);
        log.info("Saved exercise's GIF. exercisePo = {}, affectedRows = {}", exercisePo, affectedRows);
        return affectedRows;
    }
}
