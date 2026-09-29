package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.workflow.WorkflowCommentOpenRequest;
import com.wuji.demo.model.request.workflow.WorkflowCopyListRequest;
import com.wuji.demo.model.request.workflow.WorkflowInstanceDetailOpenRequest;
import com.wuji.demo.model.request.workflow.WorkflowPendingListRequest;
import com.wuji.demo.model.request.workflow.WorkflowTaskCloseOpenRequest;
import com.wuji.demo.model.request.workflow.WorkflowTaskCompleteRequest;
import com.wuji.demo.model.request.workflow.WorkflowTaskDelegateRequest;
import com.wuji.demo.model.request.workflow.WorkflowTaskReturnRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormWorkflowApiClient {

    @Test
    @DisplayName("test formWorkflow")
    public void comment() {
        WorkflowCommentOpenRequest workflowCommentOpenRequest = new WorkflowCommentOpenRequest();
        workflowCommentOpenRequest.setApplicationId(Constants.APPLICATION_ID);
        workflowCommentOpenRequest.setFormId(Constants.FORM_ID);
        workflowCommentOpenRequest.setUuid("6aa7b72b869cc5fea55fc5d9");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowCommentOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/comment", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test instanceDetail")
    public void instanceDetail() {
        WorkflowInstanceDetailOpenRequest workflowInstanceDetailOpenRequest = new WorkflowInstanceDetailOpenRequest();
        workflowInstanceDetailOpenRequest.setProcessInstanceId("6e77d060b01a11f18acee23e0b282cb9");
        String encrypt =
                AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowInstanceDetailOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/instance/detail", formOpenCommonRequest);
    }


    @Test
    @DisplayName("test taskClose")
    public void taskClose() {
        WorkflowTaskCloseOpenRequest workflowTaskCloseOpenRequest = new WorkflowTaskCloseOpenRequest();
        workflowTaskCloseOpenRequest.setProcessInstanceId("6e77d060b01a11f18acee23e0b282cb9");
        workflowTaskCloseOpenRequest.setTaskId("6f12d80fb01a11f18acee23e0b282cb9");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowTaskCloseOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/taskClose", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test pendingList")
    public void pendingList() {
        WorkflowPendingListRequest workflowPendingListRequest = new WorkflowPendingListRequest();
        workflowPendingListRequest.setPageNum(1);
        workflowPendingListRequest.setPageSize(100);
        workflowPendingListRequest.setApplicationId(Constants.APPLICATION_ID);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowPendingListRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/pendingList", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test taskComplete")
    public void taskComplete() {
        WorkflowTaskCompleteRequest workflowTaskCompleteRequest = new WorkflowTaskCompleteRequest();
        workflowTaskCompleteRequest.setTaskId("");
        workflowTaskCompleteRequest.setProcessInstanceId("");
        workflowTaskCompleteRequest.setComment("");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowTaskCompleteRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/taskComplete", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test taskReturn")
    public void taskReturn() {
        WorkflowTaskReturnRequest workflowTaskReturnRequest = new WorkflowTaskReturnRequest();
        workflowTaskReturnRequest.setTaskId("");
        workflowTaskReturnRequest.setProcessInstanceId("");
        workflowTaskReturnRequest.setComment("");
        workflowTaskReturnRequest.setTaskKey("");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowTaskReturnRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/taskReturn", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test taskDelegate")
    public void taskDelegate() {
        WorkflowTaskDelegateRequest workflowTaskDelegateRequest = new WorkflowTaskDelegateRequest();
        workflowTaskDelegateRequest.setTaskId("");
        workflowTaskDelegateRequest.setProcessInstanceId("");
        workflowTaskDelegateRequest.setComment("");
        workflowTaskDelegateRequest.setUserId(12345L);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowTaskDelegateRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/taskDelegate", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test copyList")
    public void copyList() {
        WorkflowCopyListRequest workflowCopyListRequest = new WorkflowCopyListRequest();
        workflowCopyListRequest.setPageNum(1);
        workflowCopyListRequest.setPageSize(100);
        workflowCopyListRequest.setApplicationId(Constants.APPLICATION_ID);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(workflowCopyListRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/workflow/copyList", formOpenCommonRequest);
    }

}
