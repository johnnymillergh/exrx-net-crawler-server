package com.jmsoftware.exrxnetcrawlerserver.equipment;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.equipment.domain.SaveEquipmentPayload;
import com.jmsoftware.exrxnetcrawlerserver.equipment.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>EquipmentController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:06 PM
 **/
@RestController
@RequestMapping("/equipment")
@Api(tags = {"Equipment Controller"})
@AllArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping("/save-equipment")
    @ApiOperation(value = "/save-equipment", notes = "Save equipment")
    public ResponseBodyBean<Integer> saveEquipment(@RequestBody SaveEquipmentPayload payload) {
        var affectedRows = equipmentService.saveEquipment(payload);
        return ResponseBodyBean.ofDataAndMessage(affectedRows, "Saved equipment. Affected rows: " + affectedRows);
    }
}
