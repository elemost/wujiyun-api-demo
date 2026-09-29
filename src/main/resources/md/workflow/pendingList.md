# 待办任务列表查询接口
说明：分页查询待办任务列表  
接口地址：/develop/document/workflow/pendingList  
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
|pageNum|Integer|页码|默认1|
|pageSize|Integer|返回条数|默认100|
|applicationId|varchar|应用id|

## 返回参数

|参数名称        | 参数类型     | 参数说明              |
|------------|-----------|------------------|
| code     | varchar      | 当code等于0000表示接口请求成功，其他则为失败|
| message     | varchar      | 描述        |
|data|Object|返回的数据放在里面|
|data.page|Integer|页码|
|data.pageNum|Integer|当前页码|
|data.pageSize|Integer|每页条数|
|data.total|Integer|总条数|
|data.list|Array|待办任务列表|
|data.list[].taskId|varchar|任务编号|
|data.list[].taskName|varchar|任务名称|
|data.list[].taskDefKey|varchar|任务Key|
|data.list[].startUserId|varchar|流程发起人id|
|data.list[].startUserName|varchar|流程发起人名称|
|data.list[].procDefId|varchar|流程ID|
|data.list[].procDefKey|varchar|流程key|
|data.list[].procDefName|varchar|流程定义名称|
|data.list[].procDefVersion|int|流程定义内置使用版本|
|data.list[].deployId|varchar|流程部署编号|
|data.list[].procInsId|varchar|流程实例ID|
|data.list[].processInstanceId|varchar|流程实例ID|
|data.list[].createTime|Date|创建时间|
|data.otherData|Object|其他数据|
