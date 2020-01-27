package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
    @Valid
    @NotEmpty
    private List<ExerciseRelatedClassificationPayload> exerciseRelatedClassificationPayloadList;
    @NotEmpty
    private String preparation;
    @NotEmpty
    private String execution;
    @NotEmpty
    private String comments;
    @Valid
    @NotEmpty
    private List<ExerciseRelatedMusclePayload> exerciseRelatedMusclePayloadList;
}
