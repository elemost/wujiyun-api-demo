package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.data.FormDataQueryRequest;
import com.wuji.demo.model.request.data.FormSyncOpenRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormDataApiClient {

    @Test
    @DisplayName("test fromDataInsert")
    public void fromDataInsert() {
        FormSyncOpenRequest formSyncOpenRequest = new FormSyncOpenRequest();
        formSyncOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        formSyncOpenRequest.setFormId(Constants.FORM_ID);
        JSONObject instValue = new JSONObject();
        instValue.put("name", "test");
        instValue.put("age", 18);
        formSyncOpenRequest.setInstValue(instValue);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(formSyncOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/form/data/insert", formOpenCommonRequest);
    }


    @Test
    @DisplayName("test fromDataUpdate")
    public void fromDataUpdate() {
        FormSyncOpenRequest formSyncOpenRequest = new FormSyncOpenRequest();
        formSyncOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        formSyncOpenRequest.setFormId(Constants.FORM_ID);
        formSyncOpenRequest.setUuid(Constants.DATA_CREATOR);
        JSONObject instValue = new JSONObject();
        instValue.put("name", "test");
        instValue.put("age", 18);
        formSyncOpenRequest.setInstValue(instValue);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(formSyncOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/form/data/update", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test fromDataDelete")
    public void fromDataDelete() {
        FormSyncOpenRequest formSyncOpenRequest = new FormSyncOpenRequest();
        formSyncOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        formSyncOpenRequest.setFormId(Constants.FORM_ID);
        formSyncOpenRequest.setUuid(Constants.DATA_CREATOR);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(formSyncOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/form/data/delete", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test fromDataQuery")
    public void fromDataQuery() {
        FormDataQueryRequest formSyncOpenRequest = new FormDataQueryRequest();
        formSyncOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        formSyncOpenRequest.setFormId(Constants.FORM_ID);
        formSyncOpenRequest.setPageNum(1);
        formSyncOpenRequest.setPageSize(100);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(formSyncOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/form/queryList", formOpenCommonRequest);
    }

}
