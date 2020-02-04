package com.jmsoftware.exrxnetcrawlerserver.muscle.mapper;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.RelatedMusclePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>RelatedMuscleMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:54 PM
 **/
@Mapper
public interface RelatedMuscleMapper{
    /**
     * Select by muscle id and related muscle id integer.
     *
     * @param relatedMusclePo the related muscle po
     * @return the integer
     */
    Integer selectByMuscleIdAndRelatedMuscleId(RelatedMusclePo relatedMusclePo);

    /**
     * Insert related muscle integer.
     *
     * @param relatedMusclePo the related muscle po
     * @return the integer
     */
    Integer insertRelatedMuscle(RelatedMusclePo relatedMusclePo);
}
