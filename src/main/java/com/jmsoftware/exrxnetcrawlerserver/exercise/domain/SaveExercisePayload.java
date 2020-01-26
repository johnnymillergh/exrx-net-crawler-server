package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <h1>SaveExercisePayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/26/20 2:20 PM
 **/
@Data
public class SaveExercisePayload {
    @NotEmpty
    private String exerciseName;
    @NotEmpty
    private String preparation;
    @NotEmpty
    private String execution;
    @NotEmpty
    private String comments;
}
