package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseClassificationPo;

import java.util.List;

/**
 * <h1>ExerciseClassificationService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:42 PM
 **/
public interface ExerciseClassificationService {
    /**
     * Save exercise classification integer.
     *
     * @param exerciseClassificationPoList the exercise classification po list
     * @return the integer
     */
    Integer saveExerciseClassification(List<ExerciseClassificationPo> exerciseClassificationPoList);

    /**
     * Gets exercise classification by name.
     *
     * @param name the name
     * @return the exercise classification by name
     */
    ExerciseClassificationPo getExerciseClassificationByName(String name);
}
