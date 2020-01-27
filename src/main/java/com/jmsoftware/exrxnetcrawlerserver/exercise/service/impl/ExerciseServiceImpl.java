package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jmsoftware.exrxnetcrawlerserver.common.aspect.ValidateArgument;
import com.jmsoftware.exrxnetcrawlerserver.common.exception.BizException;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.*;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.*;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * <h1>ExerciseServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
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
            var optionalMusclePo = Optional.of(muscleService.getMuscleByName(item.getMuscleName()));
            var po = new ExerciseRelatedMusclePo();
            po.setMuscleId(optionalMusclePo.get().getId());
            po.setRelatedMuscleType(item.getRelatedMuscleType());
            exerciseRelatedMusclePos.add(po);
        });
        var affectedRowsForSavingExerciseRelatedMuscle =
                exerciseRelatedMuscleService.saveExerciseRelatedMuscle(exerciseRelatedMusclePos);
        log.info("Saved exercise related muscle, affectedRowsForSavingExerciseRelatedMuscle = {}",
                 affectedRowsForSavingExerciseRelatedMuscle);
        return exercisePo.getId();
    }
}
