package com.jmsoftware.exrxnetcrawlerserver.bodypart.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <h1>SaveBodyPartPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:41 AM
 **/
@Data
public class SaveBodyPartPayload {
    @Valid
    @NotEmpty(message = "The body part name list is not empty.")
    private List<@NotEmpty(message = "The name is not empty.") String> bodyPartNameList;
}
