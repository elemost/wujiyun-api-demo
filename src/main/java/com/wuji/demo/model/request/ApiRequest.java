package com.wuji.demo.model.request;


import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.enums.ContentTypeEnum;
import com.wuji.demo.enums.MethodEnum;
import lombok.Data;

@Data
public class ApiRequest {

    /**
     * 请求header
     */
    private JSONObject headerJson;

    /**
     * 请求query
     */
    private JSONObject queryJson;

    /**
     * 请求体
     */
    private JSONObject requestJsonBody;

    /**
     * 请求字符串 raw 和 xml 类型请求会用到
     */
    private String requestStringBody;

    /**
     * body类型
     *
     * @see ContentTypeEnum
     */
    private ContentTypeEnum contentTypeEnum;

    /**
     * 请求方式
     *
     * @see MethodEnum
     */
    private MethodEnum method;

    private String url;
    /**
     * 使用jsonpath提取数据
     * 为空不提取 反之提取
     */
    private String jsonpath;

    private ApiBasicAuthRequest basicAuth;

    public ApiRequest(String url) {
        this.url = Constants.URL + url;
    }

    public void putHeader(String key, Object value) {
        if (headerJson == null) {
            headerJson = new JSONObject();
        }
        headerJson.put(key, value);
    }

    public void putQueryJson(String key, Object value) {
        if (queryJson == null) {
            queryJson = new JSONObject();
        }
        queryJson.put(key, value);
    }

}
