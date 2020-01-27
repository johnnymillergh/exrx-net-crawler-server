package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseCommentPo;

/**
 * <h1>ExerciseCommentService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:43 PM
 **/
public interface ExerciseCommentService {
    /**
     * Save exercise comment integer.
     *
     * @param exerciseCommentPo the exercise comment po
     * @return the integer
     */
    Integer saveExerciseComment(ExerciseCommentPo exerciseCommentPo);
}
