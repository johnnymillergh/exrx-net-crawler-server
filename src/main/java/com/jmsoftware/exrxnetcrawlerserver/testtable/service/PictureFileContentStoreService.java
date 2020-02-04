package com.jmsoftware.exrxnetcrawlerserver.testtable.service;

import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.PictureFile;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.stereotype.Service;

/**
 * <h1>FileContentStore</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/22/20 10:55 AM
 **/
@Service
public interface PictureFileContentStoreService extends ContentStore<PictureFile, String> {
}
