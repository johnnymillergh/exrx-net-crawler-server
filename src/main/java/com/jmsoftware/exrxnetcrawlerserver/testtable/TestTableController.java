package com.jmsoftware.exrxnetcrawlerserver.testtable;

import cn.hutool.core.collection.CollectionUtil;
import com.jmsoftware.exrxnetcrawlerserver.common.ResponseBodyBean;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.GetByIdPayload;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.PictureFile;
import com.jmsoftware.exrxnetcrawlerserver.testtable.domain.TestTablePo;
import com.jmsoftware.exrxnetcrawlerserver.testtable.service.PictureFileContentStoreService;
import com.jmsoftware.exrxnetcrawlerserver.testtable.service.TestTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.util.MimeType;
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
    private final PictureFileContentStoreService pictureFileContentStoreService;
    private final ResourceLoader resourceLoader;
    private final static long CHUNK_SIZE = 1000000L;

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

    @PostMapping("/test-spring-content")
    @ApiOperation(value = "/test-spring-content", notes = "Test spring content")
    public ResponseBodyBean<PictureFile> testSpringContent(@RequestPart MultipartFile multipartFile) throws IOException {
        var pictureFile = new PictureFile();
        pictureFile.setMimeType(multipartFile.getContentType());
        pictureFile = pictureFileContentStoreService.setContent(pictureFile, multipartFile.getInputStream());
        return ResponseBodyBean.ofData(pictureFile);
    }

    @GetMapping("/test-videos/{sid}")
    public ResponseEntity<ResourceRegion> getVideo(@PathVariable String sid, @RequestHeader HttpHeaders headers) throws IOException {
        var video = pictureFileContentStoreService.getResource(sid);
        var region = resourceRegion(video, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.asMediaType(MimeType.valueOf(
                        "video/mp4"))))
                .body(region);
    }

    @GetMapping("/demo-video")
    public ResponseEntity<ResourceRegion> demoVideo(@RequestHeader HttpHeaders headers) throws IOException {
        var video = resourceLoader.getResource("classpath:/static/video/fish.mp4");
        var region = resourceRegion(video, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.asMediaType(MimeType.valueOf(
                        "video/mp4"))))
                .body(region);
    }

    private ResourceRegion resourceRegion(Resource video, HttpHeaders headers) throws IOException {
        var contentLength = video.contentLength();
        var range = headers.getRange();
        if (CollectionUtil.isNotEmpty(range)) {
            var firstRange = range.get(0);
            var start = firstRange.getRangeStart(contentLength);
            var end = firstRange.getRangeEnd(contentLength);
            var rangeLength = Long.min(CHUNK_SIZE, end - start + 1);
            return new ResourceRegion(video, start, rangeLength);
        }
        var rangeLength = Long.min(CHUNK_SIZE, contentLength);
        return new ResourceRegion(video, 0, rangeLength);
    }
}
