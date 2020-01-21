package com.jmsoftware.exrxnetcrawlerserver;

import com.jmsoftware.exrxnetcrawlerserver.common.configuration.ProjectProperty;
import com.jmsoftware.exrxnetcrawlerserver.common.configuration.ServerConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.TimeZone;


/**
 * ExrxNetCrawlerServerApplication
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/13/20 10:05 AM
 * @see
 * <a href="http://localhost:8080/exrx-net-crawler-server-dev_loc/doc.html?lang=en&cache=1">Click me to view API documentation page</a>
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
public class ExrxNetCrawlerServerApplication {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static ProjectProperty projectProperty;
    private static ServerConfiguration serverConfiguration;

    public ExrxNetCrawlerServerApplication(ProjectProperty projectProperty,
                                           ServerConfiguration serverConfiguration) {
        ExrxNetCrawlerServerApplication.projectProperty = projectProperty;
        ExrxNetCrawlerServerApplication.serverConfiguration = serverConfiguration;
    }

    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();
        SpringApplication.run(ExrxNetCrawlerServerApplication.class, args);
        var endTime = System.currentTimeMillis();
        log.info("🥳 Congratulations! 🎉");
        log.info("{}@{} started successfully!", projectProperty.getProjectArtifactId(), projectProperty.getVersion());
        log.info("Current environment: {} ({})", projectProperty.getEnvironment(),
                 projectProperty.getEnvironmentAlias());
        log.info("Deployment duration: {} seconds ({} ms)", (endTime - startTime) / 1000, (endTime - startTime));
        log.info("App started at {} (timezone - {})", new Date(), TimeZone.getDefault().getDisplayName());
        log.info("{}  App running at{}  - Local:   http://localhost:{}{}{}  - Network: {}",
                 LINE_SEPARATOR, LINE_SEPARATOR, serverConfiguration.getServerPort(), projectProperty.getContextPath(),
                 LINE_SEPARATOR, serverConfiguration.getBaseUrl());
    }
}
