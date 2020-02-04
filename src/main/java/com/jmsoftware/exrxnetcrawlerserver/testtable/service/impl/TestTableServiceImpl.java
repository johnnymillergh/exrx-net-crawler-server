package com.jmsoftware.exrxnetcrawlerserver.testtable.service.impl;

import com.jmsoftware.exrxnetcrawlerserver.common.sftp.SftpService;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;
import com.jmsoftware.exrxnetcrawlerserver.testtable.mapper.TestTableMapper;
import com.jmsoftware.exrxnetcrawlerserver.testtable.service.TestTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <h1>TestTableServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 1/13/20 9:59 AM
 **/
@Service
@RequiredArgsConstructor
public class TestTableServiceImpl implements TestTableService {
    private final TestTableMapper testTableMapper;
    private final SftpService sftpService;

    @Override
    public TestTablePo getById(Long id) {
        return testTableMapper.selectById(id);
    }

    @Override
    public void testUpload(List<MultipartFile> multipartFileList) throws IOException {
        for (MultipartFile multipartFile : multipartFileList) {
            sftpService.upload(multipartFile, "/test", FileExistsMode.REPLACE, false);
        }
    }
}
