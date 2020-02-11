package com.jmsoftware.exrxnetcrawlerserver.muscle.mapper;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MuscleImagePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>MuscleImageMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:54 PM
 **/
@Mapper
public interface MuscleImageMapper {
    /**
     * Insert muscle image integer.
     *
     * @param muscleImagePo the muscle image po
     * @return the integer
     */
    Integer insertMuscleImage(MuscleImagePo muscleImagePo);
}
