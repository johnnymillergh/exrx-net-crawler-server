package com.jmsoftware.exrxnetcrawlerserver.exercise.service;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExercisePo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExerciseClassificationPayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExercisePayload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <h1>ExerciseService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1 /20/20 4:14 PM
 */
public interface ExerciseService {
    /**
     * Save exercise classification integer.
     *
     * @param payload the payload
     * @return the integer
     */
    Integer saveExerciseClassification(SaveExerciseClassificationPayload payload);

    /**
     * Save exercise long.
     *
     * @param payload the payload
     * @return the long
     */
    Long saveExercise(SaveExercisePayload payload);

    /**
     * Gets exercise by id.
     *
     * @param id the id
     * @return the exercise by id
     */
    ExercisePo getExerciseById(Long id);

    /**
     * Update exercise gif integer.
     *
     * @param exercisePo the exercise po
     * @return the integer
     */
    Integer updateExerciseGif(ExercisePo exercisePo);

    /**
     * Save exercise gif integer.
     *
     * @param exerciseId  the exercise id
     * @param exerciseGif the exercise gif
     * @return the integer
     * @throws IOException the io exception
     */
    Integer saveExerciseGif(Long exerciseId, MultipartFile exerciseGif) throws IOException;
}
