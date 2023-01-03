package com.mcp.mcc.event.consumer.service;

import com.alibaba.fastjson.JSONObject;
import com.mcp.infrastructure.common.domain.event.RpcRequest;
import com.mcp.infrastructure.common.util.json.FastJsonUtils;

/**
 * @author: KG
 * @description:
 * @date: Created in 20:36 2023/1/1
 * @modified by:
 */
public abstract class AbstractEventProcessor {
    private RpcRequest parseEventMessage(String msg) {
        return FastJsonUtils.jsonStringToObject(msg, RpcRequest.class);
    }

    protected abstract JSONObject doPost(RpcRequest req);

    public JSONObject invokeRemote(String msg) {
        RpcRequest req = parseEventMessage(msg);

        return doPost(req);
    }
}
