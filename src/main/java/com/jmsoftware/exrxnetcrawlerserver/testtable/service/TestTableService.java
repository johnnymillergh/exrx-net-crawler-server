package com.jmsoftware.exrxnetcrawlerserver.testtable.service;

import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;

/**
 * <h1>TestTableService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/13/20 9:59 AM
 **/
public interface TestTableService {
    /**
     * Get by ID.
     *
     * @param id Long
     * @return TestTablePo
     */
    TestTablePo getById(Long id);
}
