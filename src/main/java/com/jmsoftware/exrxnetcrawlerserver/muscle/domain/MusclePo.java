package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

/**
 * <h1>MusclePo</h1>
 * <p>
 * Muscle persistence object.
 * <p>
 * Corresponded with table `muscle`.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:55 PM
 * @see <a href='https://exrx.net/Lists/Muscle'>Muscle</a>
 **/
@Data
public class MusclePo {
    /**
     * The ID of muscle.
     */
    private Long id;
    /**
     * The name of muscle.
     */
    private String name;
    /**
     * The muslce's other names.
     */
    private String otherNames;
    /**
     * The parent ID of muscle.
     */
    private Long parentId;
    /**
     * Related body part ID.
     */
    private Long bodyPartId;
}
