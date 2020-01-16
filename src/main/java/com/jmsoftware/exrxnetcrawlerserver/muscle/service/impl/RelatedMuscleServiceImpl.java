package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.RelatedMuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.RelatedMuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>RelatedMuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 5:11 PM
 **/
@Service
@RequiredArgsConstructor
public class RelatedMuscleServiceImpl implements RelatedMuscleService {
    private final RelatedMuscleMapper relatedMuscleMapper;
}
