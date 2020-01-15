package com.jmsoftware.exrxnetcrawlerserver.testtable.domain;

import lombok.Data;

import java.util.Date;

/**
 * <h1>TestTablePo</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/13/20 10:01 AM
 */
@Data
public class TestTablePo {
    /**
     * The Id.
     */
    private Long id;
    /**
     * The String value.
     */
    private String stringValue;
    /**
     * The Int value.
     */
    private Integer intValue;
    /**
     * The Double value.
     */
    private Double doubleValue;
    /**
     * The Datetime value.
     */
    private Date datetimeValue;
}
