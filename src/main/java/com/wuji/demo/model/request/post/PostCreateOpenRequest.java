package com.wuji.demo.model.request.post;

import com.wuji.demo.model.request.FormOpenCommonRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class PostCreateOpenRequest {
    private String postName;

    @ApiModelProperty("显示顺序")
    private Integer postSort = 0;
}
