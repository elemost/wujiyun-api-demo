package com.wuji.demo.model.request.aplication;

import lombok.Data;


@Data
public class ApplicationOpenRequest {

    private Integer pageNum = 1;

    private Integer pageSize = 100;

}
