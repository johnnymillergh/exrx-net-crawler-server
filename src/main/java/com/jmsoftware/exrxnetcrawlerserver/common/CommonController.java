package com.jmsoftware.exrxnetcrawlerserver.common;

import com.jmsoftware.exrxnetcrawlerserver.common.configuration.ProjectProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = {"Common Controller"})
public class CommonController {
    private final ProjectProperty projectProperty;

    public CommonController(ProjectProperty projectProperty) {
        this.projectProperty = projectProperty;
        log.info("URL redirect service initialed. Redirect \"/[contextPath]/\" to Bootstrap Swagger API documentation.");
    }

    @GetMapping("/")
    @ApiOperation(value = "/", notes = "(GET) Redirect to Bootstrap Swagger API documentation")
    public void handleGetRequest(HttpServletResponse response) throws IOException {
        // Redirect to Bootstrap Swagger API documentation
        response.sendRedirect(projectProperty.getContextPath() + "/doc.html?cache=1&lang=en");
    }

    @PostMapping("/")
    @ApiOperation(value = "/", notes = "(POST) Redirect to Bootstrap Swagger API documentation")
    public void handlePostRequest(HttpServletResponse response) throws IOException {
        // Redirect to Bootstrap Swagger API documentation
        response.sendRedirect(projectProperty.getContextPath() + "/doc.html?cache=1&lang=en");
    }
}
