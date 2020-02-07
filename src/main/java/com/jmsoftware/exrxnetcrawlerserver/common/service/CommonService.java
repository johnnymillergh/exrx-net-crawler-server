package com.jmsoftware.exrxnetcrawlerserver.common.service;

import java.util.List;
import java.util.Map;

/**
 * <h1>CommonService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 2/4/20 11:15 AM
 */
public interface CommonService {
    /**
     * Gets application info.
     *
     * @return the application info.
     */
    Map<String, Object> getApplicationInfo();

    /**
     * List database list.
     *
     * @return the list
     */
    List<String> listDatabase();

    /**
     * Initial database.
     *
     * @return false: fail to initial database; true: succeed to initial database.
     */
    boolean initialDatabase();
}
