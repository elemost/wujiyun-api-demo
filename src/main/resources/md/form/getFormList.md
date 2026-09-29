# 应用下表单列表查询接口

说明：查询指定应用下的表单列表  
接口地址：/develop/document/app/form/queryList  
请求类型：post

## 请求参数

| 参数名称         | 参数类型    | 参数说明             | 备注            |
|--------------|---------|------------------|---------------|
| appKey       | varchar | 密钥key            |
| nonce        | varchar | 随机加密字符串          |
| timestamp    | varchar | 时间戳 精确到秒         |
| msgEncrypt   | varchar | 加密后参数（json字符串）   | 应用id加密后得到的字符串 |
| msgSignature | varchar | 签名               |
| dataCreator  | varchar | 数据创建人（对应创建人的手机号） |

### msgEncrypt 加密前参数

| 参数名称          | 参数类型    | 参数说明 | 备注         |
|---------------|---------|------|------------|
| applicationId | varchar | 应用id | 创建应用后会自动生成 |

## 返回参数

| 参数名称                      | 参数类型    | 参数说明                       |
|---------------------------|---------|----------------------------|
| code                      | varchar | 当code等于0000表示接口请求成功，其他则为失败 |
| message                   | varchar | 描述                         |
| data                      | Object  | 返回的数据放在里面                  |
| data.list                 | Array   | 表单列表                       |
| data.list[].id            | varchar | 表单id                       |
| data.list[].formName      | varchar | 表单名称                       |
| data.list[].formType      | varchar | 表单类型                       |
| data.list[].applicationId | varchar | 所属应用id                     |
