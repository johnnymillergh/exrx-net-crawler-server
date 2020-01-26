package com.jmsoftware.exrxnetcrawlerserver.exercise;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.exercise.domain.SaveExercisePayload;
import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
@Api(tags = {"Exercise Controller"})
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/save-exercise")
    @ApiOperation(value = "/save-equipment", notes = "Save equipment")
    public ResponseBodyBean<Integer> saveExercise(@RequestPart MultipartFile exerciseGif,
                                                  @Valid SaveExercisePayload payload) {
        return ResponseBodyBean.ofMessage("Saved exercise.");
    }
}
