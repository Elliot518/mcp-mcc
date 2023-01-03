package com.mcp.mcc.event.consumer.service;

import com.alibaba.fastjson.JSONObject;
import com.mcp.infrastructure.common.domain.event.IEventConst;
import com.mcp.infrastructure.common.domain.event.RpcRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author: KG
 * @description:
 * @date: Created in 20:42 2023/1/1
 * @modified by:
 */
@Service
@Slf4j
public class RestEventProcessor extends AbstractEventProcessor {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected JSONObject doPost(RpcRequest req) {
        // 设置请求头，请求类型为json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 设置请求参数
        HashMap<String, Object> map = new HashMap<>();
        map.put(IEventConst.URL, req.getUrl());
        map.put(IEventConst.METHOD_NAME, req.getMethodName());
        map.put(IEventConst.PAYLOAD, req.getPayload());

        //用HttpEntity封装整个请求报文
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(map, headers);

        // 开始调用
        // 参数1：目标请求地址
        // 参数2：请求体
        // 参数3：目标请求接口的返回值类型（execute接口的返回值类型）
        return restTemplate.postForObject(req.getUrl(), request, JSONObject.class);
    }
}









