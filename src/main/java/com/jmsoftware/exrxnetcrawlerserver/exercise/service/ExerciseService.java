package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExerciseClassificationPayload;

/**
 * <h1>ExerciseService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1 /20/20 4:14 PM
 */
public interface ExerciseService {
    /**
     * Save exercise classification integer.
     *
     * @param payload the payload
     * @return the integer
     */
    Integer saveExerciseClassification(SaveExerciseClassificationPayload payload);
}
