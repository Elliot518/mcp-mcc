package com.mcp.mcc.domain.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgLog {
    private Integer id;
    private String model;
    private Integer type;
    private String typeMsg;
    private LocalDateTime createTime;
}
