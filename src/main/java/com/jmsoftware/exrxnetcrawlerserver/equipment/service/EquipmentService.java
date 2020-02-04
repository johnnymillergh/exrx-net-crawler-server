package com.jmsoftware.exrxnetcrawlerserver.equipment.service;

import com.jmsoftware.exrxnetcrawlerserver.equipment.domain.SaveEquipmentPayload;

/**
 * <h1>EquipmentService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:14 PM
 **/
public interface EquipmentService {
    /**
     * Save equipment integer.
     *
     * @param payload the payload
     * @return the integer
     */
    Integer saveEquipment(SaveEquipmentPayload payload);
}
