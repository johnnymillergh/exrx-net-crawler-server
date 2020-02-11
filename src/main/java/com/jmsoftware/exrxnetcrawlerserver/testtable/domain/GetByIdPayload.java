package com.jmsoftware.exrxnetcrawlerserver.testtable.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <h1>GetByIdPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/13/20 10:05 AM
 */
@Data
public class GetByIdPayload {
    /**
     * The Id.
     */
    @Min(value = 1)
    @NotNull(message = "ID is required.")
    private Long id;
}
