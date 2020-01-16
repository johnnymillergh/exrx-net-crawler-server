package com.jmsoftware.exrxnetcrawlerserver.muscle;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.muscle.domain.SaveMusclePayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>MuscleController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 3:13 PM
 **/
@RestController
@RequestMapping("/muscle")
public class MuscleController {
    @PostMapping("/saveMucle")
    public ResponseBodyBean<Integer> saveMuscle(SaveMusclePayload saveMusclePayload) {
        return null;
    }
}
