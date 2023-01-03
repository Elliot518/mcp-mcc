package com.mcp.mcc.event.consumer.component;

import com.mcp.infrastructure.common.domain.event.IEventConst;
import com.mcp.mcc.domain.constants.ITopic;
import com.mcp.mcc.event.consumer.service.AbstractEventProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: KG
 * @description:
 * @date: Created in 20:30 2022/5/14
 * @modified by:
 */
@Slf4j
@Component
public class MsgConsumer {

    @Autowired
    private AbstractEventProcessor eventProcessor;

    @KafkaListener(topics = IEventConst.EVENT_TOPIC)
    public void listenMsg (ConsumerRecord<?,String> record) {
        String value = record.value();
        log.info("########## Msg Consume: {}", value);
        eventProcessor.invokeRemote(value);
    }
}

