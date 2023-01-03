package com.mcp.mcc.event.consumer.config;

import com.mcp.infrastructure.common.domain.config.AbstractSwaggerConfig;
import com.mcp.infrastructure.common.domain.config.SwaggerApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:16 下午 2020/11/2
 * @modified by:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {
    @Override
    protected SwaggerApiInfo getApiInfo() {
        SwaggerApiInfo swaggerApiInfo = new SwaggerApiInfo();
        swaggerApiInfo.setBasePackage("com.mcp.mcc.event.consumer.controller");
        swaggerApiInfo.setTitle("mcc-event-consumer API");
        swaggerApiInfo.setDescription("swagger-ui API for mcc-event-consumer");
        swaggerApiInfo.setServiceUrl("http://www.microcomponent.net");
        swaggerApiInfo.setVersion("1.0");
        //swaggerApiInfo.setTokenHead(SwaggerConstant.TOKEN_HEAD);
        return swaggerApiInfo;
    }

    @Bean
    @Override
    public Docket createRestApi() {
        return super.createRestApi();
    }
}
