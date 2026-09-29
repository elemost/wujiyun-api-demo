# 组件类型对应的参数类型

| 组件名称  | 参数类型      | 说明                                           |
|-------|-----------|----------------------------------------------|
| 单行文本框 | string    |                                              |
| 多行文本框 | string    |                                              |
| 数字框   | number    |                                              |
| 日期时间  | timestamp |                                              |
| 单选下拉框 | string    |                                              |
| 复选下拉框 | array     | array为字符串列表                                  |
| 图片上传  | array     | array对象为字符串列表  对应上传文件后返回的文件id                |
| 文件上传  | array     | array对象为字符串列表  对应上传文件后返回的文件id                |
| 单选框   | string    |                                              |
| 复选框   | array     | array为字符串列表                                  |
| 子表单   | array     |                                              |
| 部门单选  | string    | 部门名称 系统中存在重名则默认选第一个部门                        |
| 部门多选  | array     | array为字符串列表                                  |
| 用户多选  | array     | array为字符串列表                                  |
| 用户单选  | string    | 用户手机号码                                       |
| 流水号   |           | 系统自动生成                                       |
| 地址组件  | json      | 参数分别为 province city district detailedAddress |

## 参数案例

```json
{
  "text_mcijz273": "单行文本",
  "textarea_mcijz273": "多行文本",
  "checkboxes_mcijz273": [
    "选项1",
    "选项2"
  ],
  "radios_mcijz274": "选项2",
  "date_mcijz273": 1751212800000,
  "select_mcijz273": "选项1",
  "tree_select_mcijz273": [
    "选项1",
    "选项2"
  ],
  "dept_single_mcijz272": "IT部",
  "user_single_mcijz273": "13500000000",
  "dept_multiple_mcijz273": [
    "人事部",
    "IT部"
  ],
  "user_multiple_mcijz273": [
    "13500000000",
    "13500000000"
  ],
  "image_mcijz273": [
    "6870d06d08cee551e422eae9",
    "6870d06d08cee551e422eae1"
  ],
  "file_mcijz273": [
    "6870d06d08cee551e422eae8",
    "6870d06d08cee551e422eae2"
  ],
  "table_mcijyrl0": [
    {
      "text_mcijyrl0": "子表单单行文本"
    }
  ],
  "address_selection_mei45skh": {
    "province": "北京市",
    "city": "北京市",
    "district": "东城区",
    "detailedAddress": ""
  }
}
```