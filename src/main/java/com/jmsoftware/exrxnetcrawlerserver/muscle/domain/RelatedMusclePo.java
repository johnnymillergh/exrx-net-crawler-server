package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

/**
 * <h1>RelatedMusclePo</h1>
 * <p>
 * Related muscle persistence object.
 * <p>
 * Corresponded with table `muscle`.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:54 PM
 **/
@Data
public class RelatedMusclePo {
    /**
     * The ID of related muscle.
     */
    private Long id;
    /**
     * The ID of muscle.
     */
    private Long muscleId;
    /**
     * Related mucles's ID.
     */
    private Long relatedMuscleId;
    /**
     * Related muscle type. 0 - the related muscle is parent node; 1 - normal related muscle
     */
    private Byte relatedMuscleType;
}