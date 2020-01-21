package com.jmsoftware.exrxnetcrawlerserver.common.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.model.Developer;
import org.apache.maven.model.License;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/**
 * Description: ProjectProperty, change description here.
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
        optionalModel.ifPresent(model1 -> {
            this.licenses = model1.getLicenses();
            this.developers = model1.getDevelopers();
        });
    }

    /**
     * Alternative way to init properties after dependencies injection is done.
     *
     * @param event application ready event.
     */
    // @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        log.info("Start to init properties. On received event: {}", event.toString());
        this.model = this.parsePom();
        var optionalModel = Optional.ofNullable(this.model);
        optionalModel.ifPresent(model1 -> {
            this.licenses = model1.getLicenses();
            this.developers = model1.getDevelopers();
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
        } catch (IOException | XmlPullParserException e) {
            log.error("Error occurred when read pom.xml. Filepath: {}", POM_FILE_NAME, e);
        }
        // Read pom.xml from packaged jar
        var pomFilePath = String.format("/META-INF/maven/%s/%s/%s", groupId, artifactId, POM_FILE_NAME);
        log.info("Read 'pom.xml' from packaged jar. Filepath = {}", pomFilePath);
        try {
            return reader.read(
                    new InputStreamReader(ProjectProperty.class.getResourceAsStream(pomFilePath))
                              );
        } catch (IOException | XmlPullParserException e) {
            log.error("Error occurred when read pom.xml. Filepath: {}", pomFilePath, e);
        }
        return null;
    }
}
