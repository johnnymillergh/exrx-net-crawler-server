package com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.domain;

import lombok.Data;

/**
 * <h1>KinesiologyGlossaryPo</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:21 PM
 **/
@Data
public class KinesiologyGlossaryPo {
    /**
     * The ID of kinesiology glossary.
     */
    private Long id;
    /**
     * The name kinesiology glossary.
     */
    private String name;
    /**
     * The description of kinesiology glossary.
     */
    private String description;
    /**
     * The parent ID of kinesiology glossary.
     */
    private Integer parentId;
}
