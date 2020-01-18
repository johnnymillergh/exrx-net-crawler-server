package com.jmsoftware.exrxnetcrawlerserver.muscle;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.SaveMusclePayload;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <h1>MuscleController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:13 PM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/muscle")
@Api(tags = {"Muscle Controller"})
public class MuscleController {
    private final MuscleService muscleService;

    @PostMapping("/save-muscle")
    @ApiOperation(value = "/save-muscle", notes = "Save muscle")
    public ResponseBodyBean<Integer> saveMuscle(@Valid @RequestBody SaveMusclePayload saveMusclePayload) {
        Integer affectedRows = muscleService.saveMuscleWithDefaultBodyPartId(saveMusclePayload.getMusclePayloadList());
        return ResponseBodyBean.ofDataAndMessage(affectedRows,
                                                 "Succeeded to save muscle. Affected rows: " + affectedRows);
    }
}
