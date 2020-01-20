package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExerciseRelatedMusclePo</h1>
 * <p>
 * Exercise Persistence Object.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class ExerciseRelatedMusclePo {
    /**
     * The ID of exercise related muscle.
     */
    private Long id;
    /**
     * The ID of muscle.
     */
    private Long muscleId;
    /**
     * Related muscle type.
     * 1 - target, 2 - synergists, 3 - stabilizers
     */
    private Byte relatedMuscleType;
}
