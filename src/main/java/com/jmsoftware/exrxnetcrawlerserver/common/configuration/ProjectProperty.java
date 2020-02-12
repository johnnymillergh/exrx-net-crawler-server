package com.jmsoftware.exrxnetcrawlerserver.common.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.model.Developer;
import org.apache.maven.model.License;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/**
 * <h1>ProjectProperty</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 2019-04-18 13:01
 **/
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "project.property")
public class ProjectProperty {
    private static final String POM_FILE_NAME = "pom.xml";
    private String basePackage;
    private String contextPath;
    private String groupId;
    private String artifactId;
    private String projectArtifactId;
    private String version;
    private String description;
    private String jdkVersion;
    private String environment;
    private String environmentAlias;
    private String url;
    private String inceptionYear;
    private String organizationName;
    private String organizationUrl;
    private String issueManagementSystem;
    private String issueManagementUrl;
    private Model model;
    private List<License> licenses;
    private List<Developer> developers;

    /**
     * Init properties after dependencies injection is done.
     */
    @PostConstruct
    public void postConstruct() {
        log.info("Start to init properties after dependency injection was done.");
        this.model = this.parsePom();
        var optionalModel = Optional.ofNullable(this.model);
        optionalModel.ifPresentOrElse(model1 -> {
            this.licenses = model1.getLicenses();
            this.developers = model1.getDevelopers();
        }, () -> {
            log.error("Cannot found the file 'pom.xml'! Failed to read licenses and developer info.");
        });
    }

    /**
     * Parse pom.xml
     *
     * @return Project model
     */
    private Model parsePom() {
        var reader = new MavenXpp3Reader();
        // Read pom.xml from relative path
        try {
            var pom = new File(POM_FILE_NAME);
            if (pom.exists()) {
                log.info("Found 'pom.xml'. POM path = {}", pom.getPath());
                return reader.read(new FileReader(pom));
            }
        } catch (Exception e) {
            log.error("Exception occurred when reading pom.xml! Filepath: {}", POM_FILE_NAME, e);
        }
        // Read pom.xml from packaged jar
        var pomFilePath = String.format("/META-INF/maven/%s/%s/%s", groupId, artifactId, POM_FILE_NAME);
        log.info("Read 'pom.xml' from packaged jar. Filepath = {}", pomFilePath);
        InputStream pomResourceInputStream;
        try {
            pomResourceInputStream = ProjectProperty.class.getResourceAsStream(pomFilePath);
            log.info("Pom resource: {}", pomResourceInputStream);
        } catch (Exception e) {
            log.error("Exception occurred when getting Pom resource stream!", e);
            return null;
        }
        try {
            log.info("Found 'pom.xml'. POM path = {}", pomFilePath);
            return reader.read(new InputStreamReader(pomResourceInputStream));
        } catch (Exception e) {
            log.error("Exception occurred when reading pom.xml from packaged jar! Filepath: {}, pomResource: {}",
                      pomFilePath, pomResourceInputStream, e);
        }
        return null;
    }
}
