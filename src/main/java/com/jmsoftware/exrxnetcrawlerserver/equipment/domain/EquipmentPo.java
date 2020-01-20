package com.jmsoftware.exrxnetcrawlerserver.equipment.domain;

import lombok.Data;

/**
 * <h1>EquipmentPo</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:14 PM
 **/
@Data
public class EquipmentPo {
    /**
    * The ID of exercise equipment.
    */
    private Long id;
    /**
    * The name of equipment.
    */
    private String name;
}
