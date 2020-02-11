package com.jmsoftware.exrxnetcrawlerserver.exercise.mapper;

import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseCommentPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>ExerciseCommentMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:14 PM
 **/
@Mapper
public interface ExerciseCommentMapper {
    /**
     * Insert exercise comment integer.
     *
     * @param exerciseCommentPo the exercise comment po
     * @return the integer
     */
    Integer insertExerciseComment(ExerciseCommentPo exerciseCommentPo);
}
