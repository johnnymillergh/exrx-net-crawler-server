package com.jmsoftware.exrxnetcrawlerserver.exercise;

import com.jmsoftware.exrxnetcrawlerserver.exercise.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ExerciseController {
    private final ExerciseService exerciseService;
}
