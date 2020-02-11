package com.jmsoftware.exrxnetcrawlerserver.common.configuration;

import com.jmsoftware.exrxnetcrawlerserver.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * <h1>InitialDatabaseConfiguration</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 2/7/20 3:10 PM
 **/
@Slf4j
@Configuration
@RequiredArgsConstructor
public class InitialDatabaseConfiguration implements ApplicationRunner {
    @Value("classpath:mysql-script/mysqldump-structure-and-data.sql")
    private Resource mysqldumpStructureAndData;
    private final CommonService commonService;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Start to initial database…");
//        var initialDatabase = commonService.initialDatabase();
//        if (!initialDatabase) {
//            throw new BusinessException("Failed to initial database!");
//        }
//        log.info("mysqldumpStructureAndData: {}", mysqldumpStructureAndData);
    }
}
