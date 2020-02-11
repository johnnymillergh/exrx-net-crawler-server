package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <h1>ExerciseClassificationPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/26/20 6:23 PM
 **/
@Data
public class ExerciseClassificationPayload {
    /**
     * The name of exercise classification.
     */
    @NotEmpty
    private String name;
    /**
     * The description of exercise classification.
     */
    @NotEmpty
    private String description;
}
