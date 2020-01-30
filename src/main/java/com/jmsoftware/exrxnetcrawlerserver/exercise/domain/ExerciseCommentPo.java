package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExerciseCommentPo</h1>
 * <p>
 * Exercise Classification Persistence Object.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class ExerciseCommentPo {
    /**
     * The ID of exercise comment.
     */
    private Long id;
    /**
     * The ID of exercise.
     */
    private Long exerciseId;
    /**
     * The comment.
     */
    private String comment;
}
