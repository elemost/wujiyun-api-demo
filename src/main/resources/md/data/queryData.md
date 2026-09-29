# 数据列表查询接口

说明：分页查询表单数据列表  
接口地址：/develop/document/form/queryList  
请求类型：post

## 请求参数

| 参数名称         | 参数类型    | 参数说明             | 备注            |
|--------------|---------|------------------|---------------|
| appKey       | varchar | 密钥key            |               |
| nonce        | varchar | 随机加密字符串          |               |
| timestamp    | varchar | 时间戳 精确到秒         |               |
| msgEncrypt   | varchar | 加密后参数（json字符串）   | 查询条件加密后得到的字符串 |
| msgSignature | varchar | 签名               |               |
| dataCreator  | varchar | 数据创建人（对应创建人的手机号） |               |

### msgEncrypt 加密前参数

| 参数名称          | 参数类型    | 参数说明 | 备注         |
|---------------|---------|------|------------|
| applicationId | varchar | 应用id | 创建应用后会自动生成 |
| formId        | varchar | 表单id | 创建表单后会自动生成 |
| pageNum       | Integer | 页码   | 默认1        |
| pageSize      | Integer | 返回条数 | 默认100      |

## 返回参数

| 参数名称                  | 参数类型       | 参数说明                       |
|-----------------------|------------|----------------------------|
| code                  | varchar    | 当code等于0000表示接口请求成功，其他则为失败 |
| message               | varchar    | 描述                         |
| data                  | Object     | 返回的数据放在里面                  |
| data.page             | Integer    | 页码                         |
| data.pageNum          | Integer    | 当前页码                       |
| data.pageSize         | Integer    | 每页条数                       |
| data.total            | Integer    | 总条数                        |
| data.list             | Array      | 表单数据列表                     |
| data.list[].uuid      | varchar    | 数据uuid                     |
| data.list[].instValue | JSONObject | 表单字段数据（key-value）          |
| data.otherData        | Object     | 其他数据                       |
