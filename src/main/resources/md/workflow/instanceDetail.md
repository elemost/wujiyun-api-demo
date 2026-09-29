# 流程实例详情查询接口
说明：查询流程实例详情  
接口地址：/develop/document/workflow/instance/detail  
请求类型：post
## 请求参数
| 参数名称       | 参数类型     | 参数说明         |备注              |
|-----------|-----------|------------------|------------------|
|appKey|varchar|密钥key|
|nonce     |varchar|随机加密字符串|
|timestamp|varchar|时间戳 精确到秒|
|msgEncrypt|varchar|加密后参数（json字符串）|流程参数加密后得到的字符串|
|msgSignature|varchar|签名|
|dataCreator|varchar|数据创建人（对应创建人的手机号）|

### msgEncrypt 加密前参数
| 参数名称       | 参数类型     | 参数说明         |备注              |
|-----------|-----------|------------------|------------------|
|processInstanceId|varchar|流程实例id|

## 返回参数

|参数名称        | 参数类型     | 参数说明              |
|------------|-----------|------------------|
| code     | varchar      | 当code等于0000表示接口请求成功，其他则为失败|
| message     | varchar      | 描述        |
|data|Object|返回的数据放在里面|
|data.processInstanceId|varchar|流程实例id|
|data.taskId|varchar|当前任务id|
|data.taskName|varchar|当前任务名称|
|data.procDefName|varchar|流程定义名称|
|data.startUserId|varchar|流程发起人id|
|data.startUserName|varchar|流程发起人名称|
|data.createTime|Date|创建时间|
