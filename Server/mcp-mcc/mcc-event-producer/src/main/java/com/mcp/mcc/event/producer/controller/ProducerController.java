package com.mcp.mcc.event.producer.controller;

import com.alibaba.fastjson.JSON;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import com.mcp.mcc.domain.constants.ITopic;
import com.mcp.mcc.domain.message.MsgLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: KG
 * @description:
 * @date: Created in 19:50 2022/5/14
 * @modified by:
 */
@Slf4j
@Api(tags = "Producer API")
@RestController
@RequestMapping("/producer")
@ResponseResult
public class ProducerController {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @ApiOperation(value = "Kafka Producer Send")
    @ResponseBody
    @PostMapping("/send")
    public String sendMsg() {
        MsgLog msgLog = new MsgLog(1, "消息生成",
                1, "消息日志", LocalDateTime.now());
        String msg = JSON.toJSONString(msgLog);
        // 这里Topic如果不存在，会自动创建
        kafkaTemplate.send(ITopic.KG_DEMO_TOPIC, msg);
        return msg;
    }
}
