package com.jmsoftware.exrxnetcrawlerserver.common;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.core.ResolvableType;
import org.springframework.core.codec.ResourceRegionEncoder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <h1>ResourceRegionHttpMessageWriter</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/22/20 1:11 PM
 **/
@Slf4j
public class ResourceRegionHttpMessageWriter implements HttpMessageWriter<ResourceRegion> {
    private final ResourceRegionEncoder resourceRegionEncoder = new ResourceRegionEncoder();
    private final List<MediaType> mediaTypeList = MediaType.asMediaTypes(resourceRegionEncoder.getEncodableMimeTypes());
    public final ResolvableType REGION_TYPE = ResolvableType.forClass(ResourceRegion.class);

    @NonNull
    @Override
    public List<MediaType> getWritableMediaTypes() {
        log.info("Getting writable media types: {}", mediaTypeList);
        return mediaTypeList;
    }

    @Override
    public boolean canWrite(@NonNull ResolvableType elementType, MediaType mediaType) {
        var canEncode = resourceRegionEncoder.canEncode(elementType, mediaType);
        log.info("Determine whether can write: {}. mediaType: {}", canEncode, mediaType);
        return canEncode;
    }

    @NonNull
    @Override
    public Mono<Void> write(@NonNull Publisher<? extends ResourceRegion> inputStream,
                            @NonNull ResolvableType elementType,
                            MediaType mediaType,
                            @NonNull ReactiveHttpOutputMessage message,
                            @NonNull Map<String, Object> hints) {
        log.info("Writing data...");
        var headers = message.getHeaders();
        headers.set(HttpHeaders.ACCEPT_RANGES, "bytes");
        return Mono.from(inputStream).flatMap(resourceRegion -> {
            ((ServerHttpResponse) message).setStatusCode(HttpStatus.PARTIAL_CONTENT);
            var resourceMediaType = getResourceMediaType(mediaType, resourceRegion.getResource());
            long contentLength = 0;
            try {
                // noinspection BlockingMethodInNonBlockingContext
                contentLength = resourceRegion.getResource().contentLength();
            } catch (IOException e) {
                e.printStackTrace();
            }
            var start = resourceRegion.getPosition();
            var end = Math.min(start + resourceRegion.getCount() - 1, contentLength - 1);
            headers.add("Content-Range", String.format("bytes %s-%s/%s", start, end, contentLength));
            headers.setContentLength(end - start + 1);
            log.info("Response headers: {}", headers);
            return zeroCopy(resourceRegion.getResource(), resourceRegion, message).orElseGet(() -> {
                var input = Mono.just(resourceRegion);
                var body = this.resourceRegionEncoder.encode(input, message.bufferFactory(), REGION_TYPE,
                                                             resourceMediaType, new HashMap<>(8));
                return message.writeWith(body);
            });
        });
    }

//    @NonNull
//    @Override
//    public Mono<Void> write(@NonNull Publisher<? extends ResourceRegion> inputStream,
//                            ResolvableType actualType,
//                            @NonNull ResolvableType elementType,
//                            MediaType mediaType,
//                            ServerHttpRequest request,
//                            @NonNull ServerHttpResponse response,
//                            @NonNull Map<String, Object> hints) {
//        var headers = response.getHeaders();
//        headers.set(HttpHeaders.ACCEPT_RANGES, "bytes");
//        return Mono.from(inputStream).flatMap(resourceRegion -> {
//            response.setStatusCode(HttpStatus.PARTIAL_CONTENT);
//            var resourceMediaType = getResourceMediaType(mediaType, resourceRegion.getResource());
//            long contentLength = 0;
//            try {
//                // noinspection BlockingMethodInNonBlockingContext
//                contentLength = resourceRegion.getResource().contentLength();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            var start = resourceRegion.getPosition();
//            var end = Math.min(start + resourceRegion.getCount() - 1, contentLength - 1);
//            // "bytes $start-$end/$contentLength"
//            headers.add("Content-Range", String.format("bytes %s-%s/%s", start, end, contentLength));
//            headers.setContentLength(end - start + 1);
//            return zeroCopy(resourceRegion.getResource(), resourceRegion, response).orElseGet(() -> {
//                var input = Mono.just(resourceRegion);
//                var body = this.resourceRegionEncoder.encode(input, response.bufferFactory(), REGION_TYPE,
//                                                             resourceMediaType, new HashMap<>(8));
//                return response.writeWith(body);
//            });
//        });
//    }

    private Optional<Mono<Void>> zeroCopy(Resource resource,
                                          ResourceRegion resourceRegion,
                                          ReactiveHttpOutputMessage response) {
        if (response instanceof ZeroCopyHttpOutputMessage && resource.isFile()) {
            try {
                var file = resource.getFile();
                var pos = resourceRegion.getPosition();
                var count = resourceRegion.getCount();
                return Optional.of(((ZeroCopyHttpOutputMessage) response).writeWith(file, pos, count));
            } catch (IOException ex) {
                // Should not happen
            }
        }
        return Optional.empty();
    }

    private MediaType getResourceMediaType(MediaType mediaType, Resource resource) {
        if (mediaType != null && mediaType.isConcrete() && mediaType != MediaType.APPLICATION_OCTET_STREAM) {
            return mediaType;
        }
        return MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM);
    }
}
