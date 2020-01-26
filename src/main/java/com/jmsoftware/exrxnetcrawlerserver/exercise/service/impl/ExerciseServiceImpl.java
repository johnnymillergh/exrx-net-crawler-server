package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseClassificationPo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExerciseClassificationPayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseClassificationMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>ExerciseServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:15 PM
 **/
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseMapper exerciseMapper;
    private final ExerciseClassificationMapper exerciseClassificationMapper;

    @Override
    public Integer saveExerciseClassification(SaveExerciseClassificationPayload payload) {
        List<ExerciseClassificationPo> exerciseClassificationPoList = new LinkedList<>();
        payload.getExerciseClassificationPayloadList().forEach(exerciseClassificationPayload -> {
            ExerciseClassificationPo exerciseClassificationPo = new ExerciseClassificationPo();
            BeanUtil.copyProperties(exerciseClassificationPayload, exerciseClassificationPo);
            exerciseClassificationPoList.add(exerciseClassificationPo);
        });
        return exerciseClassificationMapper.insertExerciseClassification(exerciseClassificationPoList);
    }
}
