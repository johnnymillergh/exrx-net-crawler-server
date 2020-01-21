package com.jmsoftware.exrxnetcrawlerserver.common;

import com.jmsoftware.exrxnetcrawlerserver.common.configuration.ProjectProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h1>RedirectController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/21/20 1:18 PM
 **/
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = {"Redirect Controller"})
public class RedirectController {
    private final ProjectProperty projectProperty;

    @PostConstruct
    public void postConstruct() {
        log.info("URL redirect service initialized.");
    }

    @GetMapping("/")
    @ApiOperation(value = "/", notes = "Home page")
    public void handleGetRequest(HttpServletResponse response) throws IOException {
        // Redirect to Bootstrap Swagger API documentation
        response.sendRedirect(projectProperty.getContextPath() + "/static/home.html");
    }
}
