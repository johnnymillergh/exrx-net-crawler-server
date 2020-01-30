package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <h1>ExerciseRelatedClassificationPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/27/20 1:07 PM
 **/
@Data
public class ExerciseRelatedClassificationPayload {
    @NotEmpty
    private String classificationName;
    @NotNull
    @Range(min = 1, max = 3)
    private Integer exerciseRelatedClassificationType;
}
