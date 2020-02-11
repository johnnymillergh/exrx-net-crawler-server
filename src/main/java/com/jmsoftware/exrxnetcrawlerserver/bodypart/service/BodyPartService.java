package com.jmsoftware.exrxnetcrawlerserver.bodypart.service;

import java.util.List;

/**
 * <h1>BodyPartService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:24 AM
 */
public interface BodyPartService {
    /**
     * Save body part integer.
     *
     * @param bodyPartNameList the body part name list
     * @return the integer
     */
    Integer saveBodyPart(List<String> bodyPartNameList);
}
