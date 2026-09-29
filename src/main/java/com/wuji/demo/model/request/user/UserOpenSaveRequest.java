package com.wuji.demo.model.request.user;

import lombok.Data;

import java.util.List;

@Data
public class UserOpenSaveRequest {

    private String phonenumber;

    private String nickName;

    private List<Long> deptIdList;
}
