package com.jmsoftware.exrxnetcrawlerserver.muscle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h1>MuscleMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:57 PM
 */
@Mapper
public interface MuscleMapper extends BaseMapper<MusclePo> {
    /**
     * Insert muscle list integer.
     *
     * @param musclePoList the muscle po list
     * @return the integer
     */
    Integer insertMuscleList(@Param("musclePoList") List<MusclePo> musclePoList);
}
