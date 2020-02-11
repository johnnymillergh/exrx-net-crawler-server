package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedMusclePo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseRelatedMuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseRelatedMuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>ExerciseRelatedMuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:46 PM
 **/
@Service
@RequiredArgsConstructor
public class ExerciseRelatedMuscleServiceImpl implements ExerciseRelatedMuscleService {
    private final ExerciseRelatedMuscleMapper exerciseRelatedMuscleMapper;

    @Override
    public Integer saveExerciseRelatedMuscle(List<ExerciseRelatedMusclePo> exerciseRelatedMusclePoList) {
        if (CollectionUtil.isEmpty(exerciseRelatedMusclePoList)) {
            return 0;
        }
        return exerciseRelatedMuscleMapper.insertExerciserRelatedMuscle(exerciseRelatedMusclePoList);
    }
}
