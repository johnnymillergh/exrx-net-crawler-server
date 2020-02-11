package com.jmsoftware.exrxnetcrawlerserver.exercise.mapper;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExercisePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>ExerciseMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1 /20/20 4:14 PM
 */
@Mapper
public interface ExerciseMapper {
    /**
     * Insert exercise integer.
     *
     * @param exercisePo the exercise po
     * @return the integer
     */
    Integer insertExercise(ExercisePo exercisePo);

    /**
     * Select by id exercise po.
     *
     * @param id the id
     * @return the exercise po
     */
    ExercisePo selectById(Long id);

    /**
     * Update exercise gif path by id integer.
     *
     * @param exercisePo the exercise po
     * @return the integer
     */
    Integer updateExerciseGifPathById(ExercisePo exercisePo);
}
