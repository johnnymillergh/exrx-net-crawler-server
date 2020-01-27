package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedMusclePo;

import java.util.List;

/**
 * <h1>ExerciseRelatedMuscleService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:46 PM
 **/
public interface ExerciseRelatedMuscleService {
    /**
     * Save exercise related muscle integer.
     *
     * @param exerciseRelatedMusclePoList the exercise related muscle po list
     * @return the integer
     */
    Integer saveExerciseRelatedMuscle(List<ExerciseRelatedMusclePo> exerciseRelatedMusclePoList);
}
