package com.mcp.mcc.event.producer.advice;

import com.mcp.infrastructure.common.domain.api.Result;
import com.mcp.prototype.web.advice.BaseExceptionControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


/**
 * @author: KG
 * @description: 全局异常处理器
 * @date: Created in 5:56 下午 2020/8/5
 * @modified by: KG 2020/8/11
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseExceptionControllerAdvice {
    @Override
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> constraintExceptionHandler(ConstraintViolationException e) {
        return super.constraintExceptionHandler(e);
    }

    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return super.methodArgumentNotValidExceptionHandler(e);
    }

    @Override
    @ExceptionHandler(Exception.class)
    public Result<String> apiExceptionHandler(Exception e) {
        return super.apiExceptionHandler(e);
    }

}

