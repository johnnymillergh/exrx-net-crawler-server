package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * <h1>SaveMusclePayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:32 PM
 **/
@Data
public class SaveMusclePayload {
    @Valid
    private List<MusclePayload> musclePayloadList;
}

