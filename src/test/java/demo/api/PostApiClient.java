package demo.api;

import com.alibaba.fastjson.JSONObject;
import com.wuji.demo.constants.Constants;
import com.wuji.demo.model.request.FormOpenCommonRequest;
import com.wuji.demo.model.request.post.PostCreateOpenRequest;
import com.wuji.demo.model.request.post.PostDeleteOpenRequest;
import com.wuji.demo.model.request.post.PostSelectOpenRequest;
import com.wuji.demo.model.request.post.PostUpdateOpenRequest;
import com.wuji.demo.utils.AESUtils;
import com.wuji.demo.utils.NewParamUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostApiClient {

    @Test
    @DisplayName("test deptTree")
    public void addPost() {
        PostCreateOpenRequest postCreateOpenRequest = new PostCreateOpenRequest();
        postCreateOpenRequest.setPostName("测试职位");
        postCreateOpenRequest.setPostSort(1);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(postCreateOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        NewParamUtils.queryResult("develop/document/post/add", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test updatePost")
    public void updatePost() {
        PostUpdateOpenRequest postUpdateOpenRequest = new PostUpdateOpenRequest();
        postUpdateOpenRequest.setPostName("测试职位");
        postUpdateOpenRequest.setPostSort(1);
        postUpdateOpenRequest.setPostId(1L);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(postUpdateOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/post/update", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test postList")
    public void postList() {
        PostSelectOpenRequest postSelectOpenRequest = new PostSelectOpenRequest();
        postSelectOpenRequest.setPageNum(1);
        postSelectOpenRequest.setPageSize(10);
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(postSelectOpenRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/post/list", formOpenCommonRequest);
    }

    @Test
    @DisplayName("test deletePost")
    public void deletePost() {
        PostDeleteOpenRequest deptOpenDeleteRequest = new PostDeleteOpenRequest();
        deptOpenDeleteRequest.setPostCode("11111");
        String encrypt = AESUtils.encrypt(Constants.API_SECRET, JSONObject.toJSONString(deptOpenDeleteRequest));
        FormOpenCommonRequest formOpenCommonRequest = NewParamUtils.buildRequest(encrypt);
        String result = NewParamUtils.queryResult("develop/document/post/delete", formOpenCommonRequest);
    }
}
