package com.mcp.mcc.event.consumer.controller;

import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:12 2022/4/7
 * @modified by:
 */
@Slf4j
@Api(tags = "Test API")
@RestController
@RequestMapping("/test")
@ResponseResult
public class TestController {
    @ApiOperation(value = "Test Boolean Response")
    @ResponseBody
    @PostMapping(value = "/bool")
    public Boolean testBool() {
        log.info("Test Boolean Response...");

        return true;
    }

    //@ApiOperation(value = "Test Throw Exception")
    //@ResponseBody
    //@PostMapping(value = "/exception")
    //public String testThrowException() {
    //    throw new BusinessException(BusinessResultCode.SAVE_BATCH_ANALYZED_CONTENTS_FAIL);
    //}
}
