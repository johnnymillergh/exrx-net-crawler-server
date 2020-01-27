package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <h1>ExerciseRelatedMusclePayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/27/20 3:57 PM
 **/
@Data
public class ExerciseRelatedMusclePayload {
    @NotEmpty
    private String muscleName;
    @NotNull
    @Range(min = 1, max = 7)
    private Integer relatedMuscleType;
}
