package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseCommentPo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseCommentMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>ExerciseCommentServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:43 PM
 **/
@Service
@RequiredArgsConstructor
public class ExerciseCommentServiceImpl implements ExerciseCommentService {
    private final ExerciseCommentMapper exerciseCommentMapper;

    @Override
    public Integer saveExerciseComment(ExerciseCommentPo exerciseCommentPo) {
        if (StringUtils.checkValNull(exerciseCommentPo.getComment())) {
            return 0;
        }
        return exerciseCommentMapper.insertExerciseComment(exerciseCommentPo);
    }
}
