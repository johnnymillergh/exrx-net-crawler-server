package com.jmsoftware.exrxnetcrawlerserver.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <h1>CommonMapper</h1>
 * <p>
 * Common Mapper
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:26 AM
 */
@Mapper
public interface CommonMapper {
    /**
     * List database list.
     *
     * @return the list
     */
    List<String> listDatabase();

    /**
     * Create database.
     */
    void createDatabase();
}
