package com.wuji.demo.model.request.workflow;

import lombok.Data;


@Data
public class WorkflowPendingListRequest {

    private Integer pageNum = 1;

    private Integer pageSize = 100;

    private String applicationId;
}
