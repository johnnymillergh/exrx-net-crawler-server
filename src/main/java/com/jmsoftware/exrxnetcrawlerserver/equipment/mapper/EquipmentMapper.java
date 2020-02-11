package com.jmsoftware.exrxnetcrawlerserver.equipment.mapper;

import com.jmsoftware.exrxnetcrawlerserver.equipment.domain.EquipmentPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>EquipmentPo</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:14 PM
 **/
@Mapper
public interface EquipmentMapper {
    /**
     * Insert equipment integer.
     *
     * @param equipmentPo the equipment po
     * @return the integer
     */
    Integer insertEquipment(EquipmentPo equipmentPo);
}
