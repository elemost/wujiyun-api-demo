package com.wuji.demo.model.request.workflow;

import lombok.Data;

@Data
public class WorkflowTaskReturnRequest {
    private String taskId;
    private String processInstanceId;
    private String comment;
    private String taskKey;
}
