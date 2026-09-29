# 修改部门接口

说明：修改部门数据  
接口地址：/develop/document/dept/update  
请求类型：post

## 请求参数

| 参数名称         | 参数类型    | 参数说明             | 备注            |
|--------------|---------|------------------|---------------|
| appKey       | varchar | 密钥key            |
| nonce        | varchar | 随机加密字符串          |
| timestamp    | varchar | 时间戳 精确到秒         |
| msgEncrypt   | varchar | 加密后参数（json字符串）   | 部门参数加密后得到的字符串 |
| msgSignature | varchar | 签名               |
| dataCreator  | varchar | 数据创建人（对应创建人的手机号） |

### msgEncrypt 加密前参数

| 参数名称     | 参数类型    | 参数说明  | 备注     |
|----------|---------|-------|--------|
| deptId   | Long    | 部门id  |
| parentId | Long    | 父部门id | 顶级部门传0 |
| deptName | varchar | 部门名称  |
| orderNum | Integer | 排序号   |

## 返回参数

| 参数名称    | 参数类型    | 参数说明                       |
|---------|---------|----------------------------|
| code    | varchar | 当code等于0000表示接口请求成功，其他则为失败 |
| message | varchar | 描述                         |
| data    | Object  | 返回的数据放在里面                  |
