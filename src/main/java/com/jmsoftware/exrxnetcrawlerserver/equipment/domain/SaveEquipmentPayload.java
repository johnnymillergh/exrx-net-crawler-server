package com.jmsoftware.exrxnetcrawlerserver.equipment.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <h1>SaveEquipmentPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/21/20 10:41 PM
 **/
@Data
public class SaveEquipmentPayload {
    @NotEmpty
    private String name;
}
