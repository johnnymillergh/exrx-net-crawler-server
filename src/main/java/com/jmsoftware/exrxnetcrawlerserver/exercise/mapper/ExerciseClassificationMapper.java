package com.jmsoftware.exrxnetcrawlerserver.exercise.mapper;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseClassificationPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <h1>ExerciseClassificationMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:14 PM
 **/
@Mapper
public interface ExerciseClassificationMapper {
    /**
     * Insert exercise classification integer.
     *
     * @param exerciseClassificationPoList the exercise classification po list
     * @return the integer
     */
    Integer insertExerciseClassification(List<ExerciseClassificationPo> exerciseClassificationPoList);

    /**
     * Select by exercise classification name exercise classification po.
     *
     * @param name the name
     * @return the exercise classification po
     */
    ExerciseClassificationPo selectByExerciseClassificationName(String name);
}
