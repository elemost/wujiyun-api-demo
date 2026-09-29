package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.aplication.ApplicationFormOpenRequest;
import com.wuji.demo.model.request.aplication.ApplicationOpenRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationApiClient {
    @Test
    @DisplayName("test getApplication")
    public void getApplication() {
        ApplicationOpenRequest applicationOpenRequest = new ApplicationOpenRequest();
        applicationOpenRequest.setPageNum(1);
        applicationOpenRequest.setPageSize(100);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(applicationOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/app/queryList", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test getFormList")
    public void getFormList() {
        ApplicationFormOpenRequest applicationFormOpenRequest = new ApplicationFormOpenRequest();
        applicationFormOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(applicationFormOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/app/form/queryList", formOpenCommonRequest);
    }


}
