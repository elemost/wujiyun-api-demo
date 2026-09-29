# 退回任务接口
说明：将流程任务退回到指定节点  
接口地址：/develop/document/workflow/taskReturn  
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
|taskId|varchar|任务id|
|processInstanceId|varchar|流程实例id|
|comment|varchar|退回意见|
|taskKey|varchar|退回的目标节点key|

## 返回参数

|参数名称        | 参数类型     | 参数说明              |
|------------|-----------|------------------|
| code     | varchar      | 当code等于0000表示接口请求成功，其他则为失败|
| message     | varchar      | 描述        |
|data|Object|返回的数据放在里面|
