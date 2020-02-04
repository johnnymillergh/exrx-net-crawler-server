package com.jmsoftware.exrxnetcrawlerserver.muscle;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.SaveMusclePayload;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.UpdateMuscleDetailsPayload;
import com.jmsoftware.exrxnetcrawlerserver.muscle.service.MuscleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * <h1>MuscleController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
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

    @PostMapping("/update-muscle-details")
    @ApiOperation(value = "/update-muscle-details", notes = "Update muscle details")
    public ResponseBodyBean<Integer> updateMuscleDetails(@RequestPart List<MultipartFile> muscleImageList,
                                                         @Valid UpdateMuscleDetailsPayload payload) throws IOException {
        muscleService.updateMuscleDetails(muscleImageList, payload);
        return ResponseBodyBean.ofDataAndMessage(200,
                                                 "Succeeded to update muscle details. Muscle name: " + payload.getName());
    }
}
