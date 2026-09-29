package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.dept.DeptOpenCreateRequest;
import com.wuji.demo.model.request.dept.DeptOpenDeleteRequest;
import com.wuji.demo.model.request.dept.DeptOpenUpdateRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeptApiClient {

    @Test
    @DisplayName("test deptTree")
    public void deptTree() {
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest("");
        NewParamUtils.queryResult("develop/document/dept/tree", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test createDept")
    public void createDept() {
        DeptOpenCreateRequest deptOpenCreateRequest = new DeptOpenCreateRequest();
        deptOpenCreateRequest.setParentId(0L);
        deptOpenCreateRequest.setDeptName("测试部门");
        deptOpenCreateRequest.setOrderNum(1);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(deptOpenCreateRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/dept/create", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test updateDept")
    public void updateDept() {
        DeptOpenUpdateRequest deptOpenUpdateRequest = new DeptOpenUpdateRequest();
        deptOpenUpdateRequest.setParentId(0L);
        deptOpenUpdateRequest.setDeptName("测试部门111");
        deptOpenUpdateRequest.setOrderNum(1);
        deptOpenUpdateRequest.setDeptId(867L);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(deptOpenUpdateRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/dept/update", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test deleteDept")
    public void deleteDept() {
        DeptOpenDeleteRequest deptOpenDeleteRequest = new DeptOpenDeleteRequest();
        deptOpenDeleteRequest.setDeptId(867L);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(deptOpenDeleteRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/dept/delete", formOpenCommonRequest);
    }
}
