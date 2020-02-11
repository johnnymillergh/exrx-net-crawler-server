package com.jmsoftware.exrxnetcrawlerserver.muscle.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MuscleImagePo;
import com.jmsoftware.exrxnetcrawlerserver.muscle.mapper.MuscleImageMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>MuscleImageServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 5:10 PM
 **/
@Service
@RequiredArgsConstructor
public class MuscleImageServiceImpl implements MuscleImageService {
    private final MuscleImageMapper muscleImageMapper;

    @Override
    public Integer saveMuscleImage(MuscleImagePo muscleImagePo) {
        return muscleImageMapper.insertMuscleImage(muscleImagePo);
    }
}
