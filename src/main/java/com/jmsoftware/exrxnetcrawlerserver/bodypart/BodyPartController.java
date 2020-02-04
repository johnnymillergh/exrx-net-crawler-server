package com.jmsoftware.exrxnetcrawlerserver.bodypart;

import com.jmsoftware.exrxnetcrawlerserver.bodypart.domain.SaveBodyPartPayload;
import com.jmsoftware.exrxnetcrawlerserver.bodypart.service.BodyPartService;
import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <h1>BodyPartController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:15 AM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/body-part")
@Api(tags = {"Body Part Controller"})
public class BodyPartController {
    private final BodyPartService bodyPartService;

    @PostMapping("/save-body-part")
    @ApiOperation(value = "/save-body-part", notes = "Save body part")
    public ResponseBodyBean<Integer> saveBodyPart(@Valid @RequestBody SaveBodyPartPayload payload) {
        Integer affectedRows = bodyPartService.saveBodyPart(payload.getBodyPartNameList());
        return ResponseBodyBean.ofDataAndMessage(affectedRows, "Succeed! Inserted record(s): " + affectedRows);
    }
}
