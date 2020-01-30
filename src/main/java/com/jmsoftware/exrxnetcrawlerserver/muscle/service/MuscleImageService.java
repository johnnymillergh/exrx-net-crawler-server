package com.jmsoftware.exrxnetcrawlerserver.muscle.service;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MuscleImagePo;

/**
 * <h1>MuscleImageService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 5:10 PM
 **/
public interface MuscleImageService {
    /**
     * Save muscle image integer.
     *
     * @param muscleImagePo the muscle image po
     * @return the integer
     */
    Integer saveMuscleImage(MuscleImagePo muscleImagePo);
}
