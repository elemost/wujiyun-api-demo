package com.wuji.demo.model.request.workflow;

import lombok.Data;

@Data
public class WorkflowTaskDelegateRequest {
    private String processInstanceId;

    private String taskId;

    private String comment;

    private Long userId;
}
