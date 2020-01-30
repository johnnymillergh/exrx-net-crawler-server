package com.jmsoftware.exrxnetcrawlerserver.muscle.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * <h1>MusclePayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/16/20 4:32 PM
 **/
@Data
public class MusclePayload {
    /**
     * The Name.
     */
    @NotEmpty(message = "Name is not empty.")
    private String name;
    /**
     * The Other names.
     */
    private String otherNames;
    /**
     * The Parent id.
     */
    @Min(1)
    private Long parentId;
    /**
     * The Body part id.
     */
    @Min(1)
    private Long bodyPartId;
}
