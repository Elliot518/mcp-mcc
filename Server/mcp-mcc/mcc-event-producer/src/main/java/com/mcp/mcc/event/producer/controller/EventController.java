package com.mcp.mcc.event.producer.controller;

import com.alibaba.fastjson.JSON;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import com.mcp.infrastructure.common.domain.event.EventData;
import com.mcp.infrastructure.common.domain.event.IEventConst;
import com.mcp.infrastructure.common.domain.event.RpcRequest;
import com.mcp.infrastructure.common.util.json.FastJsonUtils;
import com.mcp.mcc.domain.constants.ITopic;
import com.mcp.mcc.domain.message.MsgLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:26 2023/1/1
 * @modified by:
 */
@Slf4j
@Api(tags = "Event API")
@RestController
@RequestMapping("/event")
@ResponseResult
public class EventController {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @ApiOperation(value = "Kafka Event Emit")
    @ResponseBody
    @PostMapping("/emit")
    public String emitEvent(@RequestBody EventData eventData) {
        String url = eventData.getUrl();
        String methodName = eventData.getMethodName();
        String payload = eventData.getPayload();

        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setUrl(url);
        rpcRequest.setMethodName(methodName);
        rpcRequest.setPayload(payload);
        String jsonPostReq = FastJsonUtils.objectToJson(rpcRequest);

        // 这里Topic如果不存在，会自动创建
        kafkaTemplate.send(IEventConst.EVENT_TOPIC, jsonPostReq);
        return jsonPostReq;
    }
}






