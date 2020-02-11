package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Getter;

/**
 * <h1>ExerciseRelatedClassificationType</h1>
 * <p>
 * 1 - Utility, 2 - Mechanics, 3 - Force
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/21/20 10:55 AM
 **/
@Getter
public enum ExerciseRelatedClassificationType {
    /**
     * Utility
     */
    UTILITY("Utility", 1),
    /**
     * Mechanics
     */
    MECHANICS("Mechanics", 1),
    /**
     * Force
     */
    FORCE("Force", 1);

    /**
     * The description of enum.
     */
    private String description;
    /**
     * The value stored in database.
     */
    private Integer value;

    ExerciseRelatedClassificationType(String description, Integer value) {
        this.description = description;
        this.value = value;
    }
}
