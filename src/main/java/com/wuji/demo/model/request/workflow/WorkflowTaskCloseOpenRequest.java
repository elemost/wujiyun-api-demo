package com.wuji.demo.model.request.workflow;

import lombok.Data;

@Data
public class WorkflowTaskCloseOpenRequest {
    private String taskId;

    private String processInstanceId;
}
