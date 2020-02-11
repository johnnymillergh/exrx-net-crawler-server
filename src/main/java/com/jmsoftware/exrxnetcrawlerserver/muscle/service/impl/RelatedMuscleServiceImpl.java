package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.RelatedMusclePo;
import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.RelatedMuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.RelatedMuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>RelatedMuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 5:11 PM
 **/
@Service
@RequiredArgsConstructor
public class RelatedMuscleServiceImpl implements RelatedMuscleService {
    private final RelatedMuscleMapper relatedMuscleMapper;

    @Override
    public boolean hasExisted(RelatedMusclePo relatedMusclePo) {
        Integer count = relatedMuscleMapper.selectByMuscleIdAndRelatedMuscleId(relatedMusclePo);
        return count > 0;
    }

    @Override
    public Integer saveRelatedMuscle(RelatedMusclePo relatedMusclePo) {
        return relatedMuscleMapper.insertRelatedMuscle(relatedMusclePo);
    }
}
