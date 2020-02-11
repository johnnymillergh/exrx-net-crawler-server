package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedClassificationPo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseRelatedClassificationMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseRelatedClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>ExerciseRelatedClassificationServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:44 PM
 **/
@Service
@RequiredArgsConstructor
public class ExerciseRelatedClassificationServiceImpl implements ExerciseRelatedClassificationService {
    private final ExerciseRelatedClassificationMapper exerciseRelatedClassificationMapper;

    @Override
    public Integer saveExerciseRelatedClassification(List<ExerciseRelatedClassificationPo> exerciseRelatedClassificationPoList) {
        if (CollectionUtil.isEmpty(exerciseRelatedClassificationPoList)) {
            return 0;
        }
        return exerciseRelatedClassificationMapper.insertExerciseRelatedClassification(exerciseRelatedClassificationPoList);
    }
}
