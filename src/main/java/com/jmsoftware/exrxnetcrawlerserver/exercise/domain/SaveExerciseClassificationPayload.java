package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <h1>SaveExerciseClassificationPayload</h1>
 * <p>
 * Save exercise classification payload
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class SaveExerciseClassificationPayload {
    @Valid
    @NotEmpty
    private List<ExerciseClassificationPayload> exerciseClassificationPayloadList;
}
