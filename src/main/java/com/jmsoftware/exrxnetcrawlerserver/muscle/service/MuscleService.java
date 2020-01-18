package com.jmsoftware.exrxnetcrawlerserver.muscle.service;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePayload;

import java.util.List;

/**
 * <h1>MuscleService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:58 PM
 **/
public interface MuscleService {
    /**
     * Save muscle with default body part id integer.
     *
     * @param musclePayloadList the list
     * @return the integer
     */
    Integer saveMuscleWithDefaultBodyPartId(List<MusclePayload> musclePayloadList);
}
