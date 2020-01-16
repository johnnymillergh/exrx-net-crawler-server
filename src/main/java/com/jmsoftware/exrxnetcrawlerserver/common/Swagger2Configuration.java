package com.jmsoftware.exrxnetcrawlerserver.common;

import cn.hutool.core.collection.CollectionUtil;
import lombok.RequiredArgsConstructor;
import org.apache.maven.model.Developer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Description: Swagger 2 Config.</p>
 * API Documentation:
 * <a href="http://192.168.1.4:8080/jm-spring-boot-template-dev/swagger-ui.html">Click me to view<a/>
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 2019-02-07 16:15
 **/
@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class Swagger2Configuration {
    private final ProjectProperty projectProperty;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(projectProperty.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        String projectArtifactId = projectProperty.getProjectArtifactId();
        String version = projectProperty.getVersion();
        String license = projectProperty.getLicenses().get(0).getUrl();
        if (CollectionUtil.isEmpty(projectProperty.getDevelopers())) {
            return new ApiInfoBuilder()
                    .title(String.format("API for %s@%s (%s)", projectArtifactId, version,
                                         projectProperty.getEnvironmentAlias()))
                    .description(projectArtifactId + ", environment: " + projectProperty.getEnvironmentAlias())
                    .license(license)
                    .version(version)
                    .build();
        }
        Developer developer = projectProperty.getDevelopers().get(0);
        return new ApiInfoBuilder()
                .title(String.format("API for %s@%s (%s)", projectArtifactId, version,
                                     projectProperty.getEnvironmentAlias()))
                .description(projectArtifactId + ", environment: " + projectProperty.getEnvironmentAlias())
                .contact(new Contact(developer.getName(), projectProperty.getUrl(), developer.getEmail()))
                .license(license)
                .version(version)
                .build();
    }
}
