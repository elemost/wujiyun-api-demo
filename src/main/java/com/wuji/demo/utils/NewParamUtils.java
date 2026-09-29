package com.wuji.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.enums.ContentTypeEnum;
import com.wuji.demo.enums.MethodEnum;
import com.wuji.demo.model.request.ApiRequest;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class NewParamUtils {
    public static FormOpenCommonRequest buildRequest(String msgEncrypt) {
        FormOpenCommonRequest applicationOpenRequest = new FormOpenCommonRequest();
        applicationOpenRequest.setMsgEncrypt(msgEncrypt);
        applicationOpenRequest.setAppKey(Constants.API_KEY);
        applicationOpenRequest.setDataCreator(Constants.DATA_CREATOR);
        String randNum = GuidUtils.getRandNum();
        applicationOpenRequest.setNonce(randNum);
        applicationOpenRequest.setTimestamp((new Date().getTime() / 1000) + "");
        String sha1 = SHA1.getSHA1(Constants.API_SECRET, applicationOpenRequest.getTimestamp(),
                applicationOpenRequest.getNonce(), applicationOpenRequest.getMsgEncrypt());
        applicationOpenRequest.setMsgSignature(sha1);
        return applicationOpenRequest;
    }

    public static String queryResult(String url, FormOpenCommonRequest formOpenCommonRequest) {
        ApiRequest apiRequest = new ApiRequest(url);
        apiRequest.setMethod(MethodEnum.POST);
        apiRequest.setRequestJsonBody(JSONObject.parseObject(JSONObject.toJSONString(formOpenCommonRequest)));
        apiRequest.setContentTypeEnum(ContentTypeEnum.JSON);
        String result = HttpUtils.apiRequest(apiRequest);
        System.out.println("result" + JSONObject.toJSONString(result));
        return result;
    }
}
