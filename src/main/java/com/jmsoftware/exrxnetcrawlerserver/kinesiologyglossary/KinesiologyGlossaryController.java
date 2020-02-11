package com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary;

import com.jmsoftware.exrxnetcrawlerserver.kinesiologyglossary.service.KinesiologyGlossaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>KinesiologyGlossaryController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/20/20 5:18 PM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/kinesiology-glossary")
public class KinesiologyGlossaryController {
    private final KinesiologyGlossaryService kinesiologyGlossaryService;
}
