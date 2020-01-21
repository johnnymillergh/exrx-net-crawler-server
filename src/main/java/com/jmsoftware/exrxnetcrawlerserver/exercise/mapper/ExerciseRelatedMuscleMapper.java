package com.jmsoftware.exrxnetcrawlerserver.exercise.mapper;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedMusclePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <h1>ExerciseRelatedMuscleMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:14 PM
 **/
@Mapper
public interface ExerciseRelatedMuscleMapper {
    /**
     * Insert exerciser related muscle integer.
     *
     * @param exerciseRelatedMusclePoList the exercise related muscle po list
     * @return the integer
     */
    Integer insertExerciserRelatedMuscle(List<ExerciseRelatedMusclePo> exerciseRelatedMusclePoList);
}
