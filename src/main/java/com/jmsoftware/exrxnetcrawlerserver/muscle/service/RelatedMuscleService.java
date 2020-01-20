package com.jmsoftware.exrxnetcrawlerserver.muscle.service;

import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.RelatedMusclePo;

/**
 * <h1>RelatedMuscleService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 5:11 PM
 **/
public interface RelatedMuscleService {
    /**
     * Has existed boolean.
     *
     * @param relatedMusclePo the related muscle po
     * @return the boolean
     */
    boolean hasExisted(RelatedMusclePo relatedMusclePo);

    /**
     * Save related muscle integer.
     *
     * @param relatedMusclePo the related muscle po
     * @return the integer
     */
    Integer saveRelatedMuscle(RelatedMusclePo relatedMusclePo);
}
