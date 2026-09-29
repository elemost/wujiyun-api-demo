package com.wuji.demo.model.request;

import lombok.Data;

@Data
public class ApiBasicAuthRequest {

    private String username;


    private String password;

    public static ApiBasicAuthRequest build(String password, String username) {
        ApiBasicAuthRequest apiBasicAuthRequest = new ApiBasicAuthRequest();
        apiBasicAuthRequest.setPassword(password);
        apiBasicAuthRequest.setUsername(username);
        return apiBasicAuthRequest;
    }
}
