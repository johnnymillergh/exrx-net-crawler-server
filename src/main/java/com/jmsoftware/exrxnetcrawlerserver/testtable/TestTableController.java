package com.jmsoftware.exrxnetcrawlerserver.testtable;

import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.GetByIdPayload;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;
import com.jmsoftware.exrxnetcrawlerserver.testtable.service.TestTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * <h1>TestTableController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/13/20 9:58 AM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/test-table")
@Api(tags = {"Test Table Controller"})
public class TestTableController {
    private final TestTableService testTableService;

    @GetMapping("/get-by-id")
    @ApiOperation(value = "/get-by-id", notes = "Get by id")
    public ResponseBodyBean<TestTablePo> getById(@Valid GetByIdPayload payload) {
        return ResponseBodyBean.ofDataAndMessage(testTableService.getById(payload.getId()),
                                                 "Succeed to communicate with back-end server.");
    }

    @PostMapping("/test-upload")
    @ApiOperation(value = "/test-upload", notes = "Test upload")
    public ResponseBodyBean<Integer> testUpload(@RequestPart List<MultipartFile> muscleImageList) throws IOException {
        testTableService.testUpload(muscleImageList);
        return ResponseBodyBean.ofDataAndMessage(200,
                                                 "Succeeded to update file(s). File count: " + muscleImageList.size());
    }
}
