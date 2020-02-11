package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedClassificationPo;

import java.util.List;

/**
 * <h1>ExerciseRelatedClassificationService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:44 PM
 **/
public interface ExerciseRelatedClassificationService {
    /**
     * Save exercise related classification integer.
     *
     * @param exerciseRelatedClassificationPoList the exercise related classification po list
     * @return the integer
     */
    Integer saveExerciseRelatedClassification(List<ExerciseRelatedClassificationPo> exerciseRelatedClassificationPoList);
}
