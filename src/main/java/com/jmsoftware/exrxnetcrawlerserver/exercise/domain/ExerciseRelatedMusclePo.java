package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExerciseRelatedMusclePo</h1>
 * <p>
 * Exercise Persistence Object.
 *
 * @author Johnny Miller (鍾俊), e-mail: johnnysviva@outlook.com
 * @date 1/21/20 10:53 AM
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
     * <p>Related muscle type. Muscle movement classification.</p>
     * <ul>
     * <li>1 - Agonist</li>
     * <li>2 - Antagonist</li>
     * <li>3 - Target</li>
     * <li>4 - Synergist</li>
     * <li>5 - Stabilizer</li>
     * <li>6 - Dynamic Stabilizer</li>
     * <li>7 - Antagonist Stabilizer</li>
     *
     * </ul>
     * <p>'https://exrx.net/Kinesiology/Glossary#MuscleMovClass' target='_blank' class='url'>https://exrx
     * .net/Kinesiology/Glossary#MuscleMovClass</a>
     * </p>
     *
     * @see ExerciseRelatedMuscleType
     */
    private Integer relatedMuscleType;
}
