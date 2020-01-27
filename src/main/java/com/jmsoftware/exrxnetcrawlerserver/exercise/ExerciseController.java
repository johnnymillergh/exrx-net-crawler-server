package com.jmsoftware.exrxnetcrawlerserver.exercise;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExerciseClassificationPayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExerciseGifPayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExercisePayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * <h1>ExerciseController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 4:13 PM
 **/
@Slf4j
@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
@Api(tags = {"Exercise Controller"})
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/save-exercise")
    @ApiOperation(value = "/save-equipment", notes = "Save equipment")
    public ResponseBodyBean<Long> saveExercise(@Valid @RequestBody SaveExercisePayload payload) {
        var exerciseId = exerciseService.saveExercise(payload);
        log.info("Saved exercise info. exerciseId = {}", exerciseId);
        return ResponseBodyBean.ofDataAndMessage(exerciseId, String.format("Saved exercise info. exerciseId = %d",
                                                                           exerciseId));
    }

    @PostMapping("/save-exercise-gif")
    @ApiOperation(value = "/save-exercise-gif", notes = "Save equipment's GIF")
    public ResponseBodyBean<Integer> saveExerciseGif(@RequestPart MultipartFile exerciseGif,
                                                     @Valid SaveExerciseGifPayload payload) {
        log.info("payload={}", payload);
        return ResponseBodyBean.ofMessage("Saved exercise.");
    }

    @PostMapping("/save-exercise-classification")
    @ApiOperation(value = "/save-exercise-classification", notes = "Save exercise classification")
    public ResponseBodyBean<Integer> saveExerciseClassification(@Valid @RequestBody SaveExerciseClassificationPayload payload) {
        var affectedRows = exerciseService.saveExerciseClassification(payload);
        return ResponseBodyBean.ofDataAndMessage(affectedRows,
                                                 "Saved exercise classification. Affected rows: " + affectedRows);
    }
}
