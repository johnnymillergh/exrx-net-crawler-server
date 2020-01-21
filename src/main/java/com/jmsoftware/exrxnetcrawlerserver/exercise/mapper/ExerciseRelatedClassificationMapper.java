package com.jmsoftware.exrxnetcrawlerserver.exercise.mapper;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseRelatedClassificationPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <h1>ExerciseRelatedClassificationMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:14 PM
 **/
@Mapper
public interface ExerciseRelatedClassificationMapper {
    /**
     * Insert exercise related classification integer.
     *
     * @param exerciseRelatedClassificationPoList the exercise related classification po list
     * @return the integer
     */
    Integer insertExerciseRelatedClassification(List<ExerciseRelatedClassificationPo> exerciseRelatedClassificationPoList);
}
