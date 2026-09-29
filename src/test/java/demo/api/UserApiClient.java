package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.user.UserDeleteOpenRequest;
import com.wuji.demo.model.request.user.UserInfoRequest;
import com.wuji.demo.model.request.user.UserOpenSaveRequest;
import com.wuji.demo.model.request.user.UserOpenUpdateRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserApiClient {

    @Test
    @DisplayName("test userInfo")
    public void userInfo() {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.setPhonenumber("13800000000");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(userInfoRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/user/info", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test userCreate")
    public void userCreate() {
        UserOpenSaveRequest userOpenSaveRequest = new UserOpenSaveRequest();
        userOpenSaveRequest.setPhonenumber("13800000000");
        userOpenSaveRequest.setNickName("test");
        userOpenSaveRequest.setDeptIdList(new ArrayList<>());
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(userOpenSaveRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/user/create", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test userUpdate")
    public void userUpdate() {
        UserOpenUpdateRequest userOpenUpdateRequest = new UserOpenUpdateRequest();
        userOpenUpdateRequest.setPhonenumber("13800000000");
        userOpenUpdateRequest.setNickName("test");
        userOpenUpdateRequest.setDeptIdList(new ArrayList<>());
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(userOpenUpdateRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/user/update", formOpenCommonRequest);
    }


    @Test
    @DisplayName("test userDelete")
    public void userDelete() {
        UserDeleteOpenRequest userOpenUpdateRequest = new UserDeleteOpenRequest();
        userOpenUpdateRequest.setPhonenumber("13800000000");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(userOpenUpdateRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/user/delete", formOpenCommonRequest);
    }

}
