package com.wuji.demo.model.request.workflow;

import lombok.Data;

@Data
public class WorkflowTaskCompleteRequest {
    private String taskId;

    private String processInstanceId;

    private String comment;
}
