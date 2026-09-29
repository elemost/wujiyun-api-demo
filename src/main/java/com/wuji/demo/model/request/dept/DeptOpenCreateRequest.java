package com.wuji.demo.model.request.dept;

import lombok.Data;

@Data
public class DeptOpenCreateRequest {

    private Long parentId;

    private String deptName;

    private Integer orderNum;
}
