package com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.mapper.KinesiologyGlossaryMapper;
import com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.service.KinesiologyGlossaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <h1>KinesiologyGlossaryServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:22 PM
 **/
@Service
@RequiredArgsConstructor
public class KinesiologyGlossaryServiceImpl implements KinesiologyGlossaryService {
    private final KinesiologyGlossaryMapper kinesiologyGlossaryMapper;
}
