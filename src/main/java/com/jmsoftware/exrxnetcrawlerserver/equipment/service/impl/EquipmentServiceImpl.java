package com.jmsoftware.exrxnetcrawlerserver.equipment.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.common.aspect.ValidateArgument;
import com.jmsoftware.exrxnetcrawlerserver.equipment.domain.SaveEquipmentPayload;
import com.jmsoftware.exrxnetcrawlerserver.equipment.mapper.EquipmentMapper;
import com.jmsoftware.exrxnetcrawlerserver.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * <h1>EquipmentServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:15 PM
 **/
@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentMapper equipmentMapper;

    @Override
    @ValidateArgument
    public Integer saveEquipment(@Valid SaveEquipmentPayload payload) {
        return null;
    }
}
