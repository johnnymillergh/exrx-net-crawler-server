package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.jmsoftware.exrxnetcrawlerserver.common.CaseConverter;
import com.jmsoftware.exrxnetcrawlerserver.common.SftpService;
import com.jmsoftware.exrxnetcrawlerserver.common.SftpSubDirectory;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.*;
import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.MuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleImageService;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.RelatedMuscleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * <h1>MuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:59 PM
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleMapper muscleMapper;
    private final RelatedMuscleService relatedMuscleService;
    private final MuscleImageService muscleImageService;
    private final SftpService sftpService;


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Integer saveMuscleWithDefaultBodyPartId(List<MusclePayload> musclePayloadList) {
        if (CollectionUtil.isEmpty(musclePayloadList)) {
            return 0;
        }
        List<MusclePo> musclePoList = new LinkedList<>();
        musclePayloadList.forEach(musclePayload -> {
            var muscle = new MusclePo();
            BeanUtil.copyProperties(musclePayload, muscle);
            muscle.setBodyPartId(0L);
            musclePoList.add(muscle);
        });
        return muscleMapper.insertMuscleList(musclePoList);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateMuscleDetails(List<MultipartFile> muscleImageList, UpdateMuscleDetailsPayload payload) throws IOException {
        var optionalMusclePo = Optional.of(muscleMapper.selectByName(payload.getName()));
        var musclePo = optionalMusclePo.get();
        if (CollectionUtil.isNotEmpty(payload.getOtherNames())) {
            musclePo.setOtherNames(CollectionUtil.join(payload.getOtherNames(), ","));
            var affectedRows = muscleMapper.updateById(musclePo);
            log.info("Updated {} muscle. musclePo: {}", affectedRows, musclePo);
        }

        if (CollectionUtil.isNotEmpty(payload.getRelatedMuscleNameList())) {
            payload.getRelatedMuscleNameList().forEach(item -> {
                var relatedMusclePo = new RelatedMusclePo();
                var optionalRelatedMusclePo = Optional.ofNullable(muscleMapper.selectByName(item));
                if (optionalRelatedMusclePo.isEmpty()) {
                    log.warn("The related muscle not found! Muscle name: {}, updateMuscleDetailsPayload:{}", item,
                             payload);
                }
                optionalRelatedMusclePo.ifPresent(relatedMusclePo1 -> {
                    relatedMusclePo.setMuscleId(musclePo.getId());
                    relatedMusclePo.setRelatedMuscleId(relatedMusclePo1.getId());
                    if (!relatedMuscleService.hasExisted(relatedMusclePo)) {
                        var relatedMuscleAffectedRows = relatedMuscleService.saveRelatedMuscle(relatedMusclePo);
                        log.info("Inserted related muscle: {}, affectedRows: {}", relatedMusclePo,
                                 relatedMuscleAffectedRows);
                    }
                });
            });
        }

        for (MultipartFile item : muscleImageList) {
            var subDirectoryOfImage =
                    String.format("%s%s/", SftpSubDirectory.MUSCLE_PICTURE.getSubDirectory(),
                                  CaseConverter.convertToKebabCase(payload.getName()));
            var imagePath = sftpService.upload(item, subDirectoryOfImage, FileExistsMode.REPLACE, true);
            var muscleImagePo = new MuscleImagePo();
            muscleImagePo.setMuscleId(musclePo.getId());
            muscleImagePo.setImagePath(imagePath);
            muscleImagePo.setAlternativeText(musclePo.getName());
            var affectedRows = muscleImageService.saveMuscleImage(muscleImagePo);
            log.info("Saved {} muscle image. muscleImage: {}", affectedRows, muscleImagePo);
        }
    }
}
