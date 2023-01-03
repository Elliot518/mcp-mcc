package com.mcp.mcc.event.producer.advice;

import com.mcp.prototype.web.advice.BaseResponseResultAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:48 上午 2020/11/3
 * @modified by:
 */

@Slf4j
@RestControllerAdvice
public class ResponseResultAdvice extends BaseResponseResultAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return super.supports(returnType, converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return super.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
    }
}


