package com.wuji.demo.model.request.workflow;

import lombok.Data;

@Data
public class WorkflowCommentOpenRequest {
    private String applicationId;

    private String formId;

    private String uuid;
}
