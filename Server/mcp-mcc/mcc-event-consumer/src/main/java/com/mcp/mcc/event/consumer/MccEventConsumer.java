package com.mcp.mcc.event.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:47 2022/12/31
 * @modified by:
 */
@SpringBootApplication
public class MccEventConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MccEventConsumer.class,args) ;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
