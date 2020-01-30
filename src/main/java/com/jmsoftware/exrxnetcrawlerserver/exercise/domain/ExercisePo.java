package com.jmsoftware.exrxnetcrawlerserver.exercise.domain;

import lombok.Data;

/**
 * <h1>ExercisePo</h1>
 * <p>
 * Exercise Persistence Object.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:18 PM
 **/
@Data
public class ExercisePo {
    /**
     * The ID of exercise.
     */
    private Long id;
    /**
     * The name of exercise.
     */
    private String name;
    /**
     * Exercise preparation description.
     */
    private String preparation;
    /**
     * Exercise execution description.
     */
    private String execution;
    /**
     * Exercise GIF image path.
     */
    private String exerciseGifPath;
}
