package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <h1>SaveExerciseGifPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/27/20 2:16 PM
 **/
@Data
public class SaveExerciseGifPayload {
    @NotNull
    @Min(value = 1L)
    private Long exerciseId;
}
