package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.dept.DeptOpenCreateRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileApiClient {
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
}
