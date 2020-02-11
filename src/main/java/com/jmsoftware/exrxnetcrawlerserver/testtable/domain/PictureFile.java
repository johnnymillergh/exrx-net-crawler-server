package com.jmsoftware.exrxnetcrawlerserver.testtable.domain;

import lombok.Data;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import java.util.Date;

/**
 * <h1>PictureFile</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/22/20 10:55 AM
 **/
@Data
public class PictureFile {
    private Long id;
    private String name;
    private Date created = new Date();
    private String summary;
    @ContentId
    private String contentId;
    @ContentLength
    private long contentLength;
    private String mimeType = "text/plain";
}
