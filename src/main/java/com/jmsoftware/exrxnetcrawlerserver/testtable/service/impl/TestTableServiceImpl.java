package com.jmsoftware.exrxnetcrawlerserver.testtable.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;
import com.jmsoftware.exrxnetcrawlerserver.testtable.mapper.TestTableMapper;
import com.jmsoftware.exrxnetcrawlerserver.testtable.service.TestTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>TestTableServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/13/20 9:59 AM
 **/
@Service
@RequiredArgsConstructor
public class TestTableServiceImpl implements TestTableService {
    private final TestTableMapper testTableMapper;

    @Override
    public TestTablePo getById(Long id) {
        return testTableMapper.selectById(id);
    }
}
