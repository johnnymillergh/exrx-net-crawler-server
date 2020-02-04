package com.jmsoftware.exrxnetcrawlerserver.exercise.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jmsoftware.exrxnetcrawlerserver.common.exception.BizException;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.ExerciseClassificationPo;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.ExerciseClassificationMapper;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>ExerciseClassificationServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:43 PM
 **/
@Service
@RequiredArgsConstructor
public class ExerciseClassificationServiceImpl implements ExerciseClassificationService {
    private final ExerciseClassificationMapper exerciseClassificationMapper;

    @Override
    public Integer saveExerciseClassification(List<ExerciseClassificationPo> exerciseClassificationPoList) {
        if (CollectionUtil.isEmpty(exerciseClassificationPoList)) {
            return 0;
        }
        return exerciseClassificationMapper.insertExerciseClassification(exerciseClassificationPoList);
    }

    @Override
    public ExerciseClassificationPo getExerciseClassificationByName(String name) {
        if (StringUtils.checkValNull(name)) {
            throw new BizException("Invalid exercise classification name!");
        }
        return exerciseClassificationMapper.selectByExerciseClassificationName(name);
    }
}
