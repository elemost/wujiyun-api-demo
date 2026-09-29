# 对接说明

五极云API交互需要对接口做签名，提交参数做加密处理。

为此，五极云开放平台提供API Key&Secret管理功能，用户可以自己创建API Key&Secret。
![开放平台密钥管理](https://cos.elemost.com/elemost/openplat-app-secret.jpg)

## 参数处理

### 参数名映射

用户需要在五极「云开放平台」-「参数管理」中，对指定应用下的指定表单配置字段别名。

该配置用于企业第三方系统数据与五极云表单数据建立映射关系，在需要与企业第三方系统数据同步场景下，**必须**
配置这些信息。否则，五极云将无法正常数据同步。
![开放平台参数设置](https://cos.elemost.com/elemost/openplat-param-set.jpg)

### 参数加密

为保障用户数据安全，五极云开放平台与用户之间的接口参数均做加密处理。

加密字段名: `msgEncrypt `

加密方法: 对请求内容（json）字符串进行aes加密

加密密钥: 「云开放平台」-「密钥管理」中的API Secret

可参考 [**附录2**](#附录2) 中代码实现范例

### 签名校验

参与签名包含 `msgEncrypt`, `appSecret`, `timestamp`,`nonce`四个参数。

`msgEncrypt`: 加密参数全文

`appSecret`: 「云开放平台」-「密钥管理」中的API Secret

`timestamp`: 时间戳

`nonce`: 随机字符串

签名方法：将`msgEncrypt`, `appSecret`, `timestamp`,`nonce`四个参数按照字典序排序，拼接生成一个字符串，并对该字符串进行sha1计算而得到

签名结果用字段`msgSignature`表示

可参考 [**附录1**](#附录1) 中代码实现范例

## 相关域名

| 场景                | 域名                            |
|-------------------|-------------------------------|
| 企业第三方系统数据同步至五极云   | https://cloud.elemost.com/api |
| 五极云应用数据同步至企业第三方系统 | 五极云产品内触发功能里配置                 |

# 附录1

## 签名生成的代码案例

```Java
public static String getSHA1(String token, String timestamp, String nonce, String encrypt) {
    try {
        String[] array = new String[]{token, timestamp, nonce, encrypt};
        StringBuilder sb = new StringBuilder();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < 4; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes());
        byte[] digest = md.digest();

        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    } catch (Exception e) {
        log.info("sha-1加密失败", e);
        throw new BizException(ResultCode.SHA_ERROR);
    }
}
```

# 附录2

## 参数加密方法案例

```Java
public static String encrypt(String json, String APISecret) {
    try {
        SecretKeySpec secretKey = new SecretKeySpec(json.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedPassword = cipher.doFinal(APISecret.getBytes());
        return Base64.getEncoder().encodeToString(encryptedPassword);
    } catch (Exception e) {
        log.error("加密失败", e);
    }
    return "";
}
```

# 附录3

## 请求参数全文案例

```json
{
  "appKey": "6dc2b5d4a0b94e33bd9172f2fa7d6108",
  "msgEncrypt": "0w3amVfs6Fnc+oIc+lX/fzvkWhcm9G7dCp8rFeKBoKp3QNjLqh7n00vd2NfXJcHlyUPRiPaunhPJEyOS1+WFXpDqucwY7KDoog053I4eelD4kUdqfnCigIQOf8EZ+18D",
  "msgSignature": "715e5d8d4ebf455ff0ae93d6e7b8c8e1b121d435",
  "nonce": "321123",
  "timestamp": "1755569964"
}
```






