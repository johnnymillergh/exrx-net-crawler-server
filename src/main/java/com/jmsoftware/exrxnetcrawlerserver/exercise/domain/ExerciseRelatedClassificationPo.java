package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExerciseRelatedClassificationPo</h1>
 * <p>
 * Exercise Persistence Object.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class ExerciseRelatedClassificationPo {
    /**
     * The ID of exercise related classification.
     */
    private Long id;
    /**
     * The exercise classification ID.
     */
    private Long exerciseClassificationId;
    /**
     * 1 - Utility, 2 - Mechanics, 3 - Force
     *
     * @see ExerciseRelatedClassificationType
     */
    private Integer relatedClassificationType;
}
