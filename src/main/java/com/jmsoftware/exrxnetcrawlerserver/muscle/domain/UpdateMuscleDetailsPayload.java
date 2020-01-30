package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <h1>UpdateMuscleDetailsPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/19/20 8:28 AM
 **/
@Data
public class UpdateMuscleDetailsPayload {
    @NotEmpty
    private String name;
    private List<String> otherNames;
    private List<String> relatedMuscleNameList;
}
