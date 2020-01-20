package com.jmsoftware.exrxnetcrawlerserver.equipment.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.equipment.service.EquipmentService;
import com.jmsoftware.exrxnetcrawlerserver.exercise.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>EquipmentServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:15 PM
 **/
@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentMapper equipmentMapper;
}