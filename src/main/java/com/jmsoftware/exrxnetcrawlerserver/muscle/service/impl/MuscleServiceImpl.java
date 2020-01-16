package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.MuscleMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>MuscleServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:59 PM
 **/
@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService {
    private final MuscleMapper muscleMapper;
}
