# 新增数据接口

说明：新增对应表单数据  
接口地址：/develop/document/form/data/insert  
请求类型：post

## 请求参数

| 参数名称         | 参数类型    | 参数说明             | 备注            |
|--------------|---------|------------------|---------------|
| appKey       | varchar | 密钥key            |               |
| nonce        | varchar | 随机加密字符串          |               |
| timestamp    | varchar | 时间戳 精确到秒         |               |
| msgEncrypt   | varchar | 加密后参数（json字符串）   | 业务参数加密后得到的字符串 |
| msgSignature | varchar | 签名               |               |
| dataCreator  | varchar | 数据创建人（对应创建人的手机号） |               |

### msgEncrypt 加密前参数

| 参数名称          | 参数类型       | 参数说明              | 备注         |
|---------------|------------|-------------------|------------|
| applicationId | varchar    | 应用id              | 创建应用后会自动生成 |
| formId        | varchar    | 表单id              | 创建表单后会自动生成 |
| instValue     | JSONObject | 表单字段数据（key-value） |            |
| uuid          | varchar    | 表单数据uuid          | 新增时可不传     |
| transactionId | varchar    | 事务id              |            |
| startWorkflow | boolean    | 是否开启流程引擎          | 默认true     |
| startTrigger  | boolean    | 是否触发智能助手          | 默认true     |

## 返回参数

| 参数名称      | 参数类型    | 参数说明                       |
|-----------|---------|----------------------------|
| code      | varchar | 当code等于0000表示接口请求成功，其他则为失败 |
| message   | varchar | 描述                         |
| data      | Object  | 返回的数据放在里面                  |
| data.uuid | varchar | 当前数据的uuid                  |
