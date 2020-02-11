package com.jmsoftware.exrxnetcrawlerserver.muscle.mapper;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.MusclePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h1>MuscleMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:57 PM
 */
@Mapper
public interface MuscleMapper{
    /**
     * Insert muscle list integer.
     *
     * @param musclePoList the muscle po list
     * @return the integer
     */
    Integer insertMuscleList(@Param("musclePoList") List<MusclePo> musclePoList);

    /**
     * Select by name muscle po.
     *
     * @param nameList the name list
     * @return the muscle po
     */
    MusclePo selectByName(List<String> nameList);

    /**
     * Update by id integer.
     *
     * @param musclePo the muscle po
     * @return the integer
     */
    Integer updateById(MusclePo musclePo);
}
