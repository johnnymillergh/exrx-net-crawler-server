package com.jmsoftware.exrxnetcrawlerserver.bodypart.domain;

import lombok.Builder;
import lombok.Data;

/**
 * <h1>BodyPartPo</h1>
 * <p>
 * Body Part Persistence Object.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/15/20 9:17 AM
 * @see <a href='https://exrx.net/Lists/Directory'>Body Part</a>
 **/
@Data
@Builder
public class BodyPartPo {
    /**
     * The ID of body part.
     */
    private Long id;
    /**
     * The name of body part.
     */
    private String name;
}

