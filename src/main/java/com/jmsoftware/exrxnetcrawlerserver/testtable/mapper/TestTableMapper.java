package com.jmsoftware.exrxnetcrawlerserver.testtable.mapper;

import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <h1>TestTableMapper</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/13/20 10:03 AM
 */
@Mapper
public interface TestTableMapper {
    /**
     * Select by id list.
     *
     * @param id the id
     * @return the list
     */
    TestTablePo selectById(Long id);
}
