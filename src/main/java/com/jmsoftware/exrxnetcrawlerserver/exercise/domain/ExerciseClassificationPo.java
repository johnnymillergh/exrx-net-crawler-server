package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExerciseClassificationPo</h1>
 * <p>
 * Exercise Classification Persistence Object.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class ExerciseClassificationPo {
    /**
     * The ID of exercise classification.
     */
    private Long id;
    /**
     * The name of exercise classification.
     */
    private String name;
    /**
     * The description of exercise classification.
     */
    private String description;
}
