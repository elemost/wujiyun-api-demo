package com.wuji.demo.model.request.workflow;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WorkflowCopyListRequest {
    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    @ApiModelProperty("返回条数")
    private Integer pageSize = 100;

    private Boolean userView;

    private String applicationId;
}
