package com.wuji.demo.model.request.post;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostSelectOpenRequest {
    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    @ApiModelProperty("返回条数")
    private Integer pageSize = 100;
}
