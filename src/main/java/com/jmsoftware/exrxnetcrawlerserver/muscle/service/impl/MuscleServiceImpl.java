package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePayload;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePo;
import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.MuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>MuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:59 PM
 **/
@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleMapper muscleMapper;

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
}
