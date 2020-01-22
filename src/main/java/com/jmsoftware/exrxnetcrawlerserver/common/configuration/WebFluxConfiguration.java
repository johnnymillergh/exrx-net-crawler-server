package com.jmsoftware.exrxnetcrawlerserver.common.configuration;

import com.jmsoftware.exrxnetcrawlerserver.common.ResourceRegionHttpMessageWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * <h1>WebFluxConfiguration</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (锺俊), email: johnnysviva@outlook.com
 * @date 1/22/20 3:29 PM
 **/
@Configuration
public class WebFluxConfiguration implements WebFluxConfigurer {
    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.customCodecs().writer(new ResourceRegionHttpMessageWriter());
    }
}
