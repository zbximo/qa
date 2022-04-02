
 <h1 class="curproject-name"> zuccqa </h1> 



# UserController

## addUser
<a id=addUser> </a>

### 基本信息

**Path：** /user/add

**Method：** POST

**接口描述：**添加用户


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
|Content-Type|application/json|是|application/json||

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> name</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户姓名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户年龄</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> password</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户密码</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> position</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户身份(0:学生,1:教师,2:管理员)</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "id": "31901024",
  "name": "qij",
  "age": 21,
  "password": "31901024",
  "position": 0
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "31901024",
    "name": "qij",
    "age": 21,
    "password": "31901024",
    "position": 0
  }
}
```

## deleteUser

<a id=deleteUser> </a>
### 基本信息

**Path：** /user/delete

**Method：** DELETE

**接口描述：**删除用户


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |

**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  311900 |  用户ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```

## findById

<a id=findById> </a>

### 基本信息

**Path：** /user/findById

**Method：** GET

**接口描述：**通过用户id查询


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  31901025 |  用户ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "31901025",
    "name": "邵育华",
    "age": 21,
    "password": "Benjamin",
    "position": 0
  }
}
```

## findByName

<a id=findByName> </a>
### 基本信息

**Path：** /user/findByName

**Method：** GET

**接口描述：**通过用户名称查询


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| name | 是  |  syh |  用户姓名 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "id": "31901025",
      "name": "邵育华",
      "age": 21,
      "password": "Benjamin",
      "position": 0
    }
  ]
}
```

## getAll

<a id=getAll> </a>
### 基本信息

**Path：** /user/getAll

**Method：** GET

**接口描述：**获取用户列表


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "id": "31901025",
      "name": "邵育华",
      "age": 21,
      "password": "Benjamin",
      "position": 0
    },
    {
      "id": "311003",
      "name": "benben",
      "age": 42,
      "password": "123456",
      "position": 1
    },
    {
      "id": "31901024",
      "name": "qij",
      "age": 21,
      "password": "31901024",
      "position": 0
    }
  ]
}
```

## login

<a id=login> </a>
### 基本信息

**Path：** /user/login

**Method：** POST

**接口描述：**登录验证


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  31901025 |  用户ID |
| password | 是  |  123 |  用户密码 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "31901025",
    "name": "邵育华",
    "age": 21,
    "password": "123456",
    "position": 0
  }
}
```

## modifyPwd

<a id=modifyPwd> </a>
### 基本信息

**Path：** /user/modifyPwd

**Method：** POST

**接口描述：**修改密码


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  31901025 |  用户ID |
| oldPwd | 是  |  123 |  用户原密码 |
| newPwd | 是  |  123456 |  用户新密码 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "31901025",
    "name": "邵育华",
    "age": 21,
    "password": "123456",
    "position": 0
  }
}
```

## updateUser

<a id=updateUser> </a>
### 基本信息

**Path：** /user/update

**Method：** PUT

**接口描述：**修改用户个人信息


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> id</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> name</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户姓名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> age</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户年龄</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> password</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户密码</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> position</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">用户身份(0:学生,1:教师,2:管理员)</span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "id": "31901025",
  "name": "邵育华",
  "age": 21,
  "password": "Benjamin",
  "position": 0
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "31901025",
    "name": "邵育华",
    "age": 21,
    "password": "Benjamin",
    "position": 0
  }
}
```

# ModelController

## addModel
<a id=addModel> </a>
### 基本信息

**Path：** /model/add

**Method：** POST

**接口描述：**添加模板


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> modelID</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">模版ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> modelName</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">模版名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> questionList</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-2-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题标题</span></td><td key=5></td></tr><tr key=0-2-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionType</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题类型(0:单选题，1:多选题,2:主观题)</span></td><td key=5></td></tr><tr key=0-2-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> options</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项(列表长度:{0:主观题,1:单选题,2:多选题})</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-13><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "modelID": "1",
  "modelName": "模板1",
  "questionList": [
    {
      "questionTitle": "今天课程的难度怎么样",
      "questionType": 0,
      "options": [
        "难",
        "一般",
        "简单"
      ]
    },
    {
      "questionTitle": "你对课程有什么建议吗",
      "questionType": 2,
      "options": [
      ]
    }
  ]
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "modelID": "62426e2b5955a67245505276",
    "modelName": "模板1",
    "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

## deleteModel

<a id=deleteModel> </a>
### 基本信息

**Path：** /model/delete

**Method：** DELETE

**接口描述：**删除模板


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  模板ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```

## findById

<a id=findById> </a>
### 基本信息

**Path：** /model/find

**Method：** GET

**接口描述：**通过模板id查询模板信息


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  模板ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "modelID": "62426e2b5955a67245505276",
    "modelName": "模板1",
    "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

## findByName

<a id=findByName> </a>
### 基本信息

**Path：** /model/findByName

**Method：** GET

**接口描述：**通过模板名称查询模板信息


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| name | 是  |  model1 |  模板名称 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "modelID": "624271485955a67245505277",
      "modelName": "模板2",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 1,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    }
  ]
}
```

## getAll

<a id=getAll> </a>
### 基本信息

**Path：** /model/getAll

**Method：** GET

**接口描述：**查看所有模板列表中的模板


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "modelID": "62426e2b5955a67245505276",
      "modelName": "模板1",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 0,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    },
    {
      "modelID": "624271485955a67245505277",
      "modelName": "模板2",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 1,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    }
  ]
}
```

## updateModel

<a id=updateModel> </a>

### 基本信息

**Path：** /model/update

**Method：** PUT

**接口描述：**修改模板信息


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> modelID</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">模版ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> modelName</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">模版名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> questionList</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-2-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题标题</span></td><td key=5></td></tr><tr key=0-2-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionType</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题类型(0:单选题，1:多选题,2:主观题)</span></td><td key=5></td></tr><tr key=0-2-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> options</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项(列表长度:{0:主观题,1:单选题,2:多选题})</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-14><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "modelID": "62426e2b5955a67245505276",
  "modelName": "模板1",
  "questionList": [
    {
      "questionTitle": "今天课程的难度怎么样",
      "questionType": 0,
      "options": [
        "难",
        "一般",
        "简单"
      ]
    },
    {
      "questionTitle": "请问你的hadoop配置完了哪些选项",
      "questionType": 1,
      "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
      ]
    },
    {
      "questionTitle": "你对课程有什么建议吗",
      "questionType": 2,
      "options": [
      ]
    }
  ]
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "modelID": "62426e2b5955a67245505276",
    "modelName": "模板1",
    "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

# AnswerController

## addAnswer
<a id=addAnswer> </a>
### 基本信息

**Path：** /answer/add

**Method：** POST

**接口描述：**添加学生答题结果


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> answerSheetId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷表单ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> studentId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学生ID</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷ID</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> answers</span></td><td key=1><span>array []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">回答列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>array</span></p></td></tr><tr key=array-16><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=array-15><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> submitDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">提交时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "answerSheetId": "1",
  "studentId": "31901025",
  "feedbackId": "1",
  "answers": [
    [
      "难"
    ],
    [
      "作业太多辣！！！"
    ]
  ],
  "submitDate": "2022-03-29T23:17:54.000Z"
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427d38379bdf15b512c565",
    "studentId": "31901025",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "作业太多辣！！！"
      ]
    ],
    "submitDate": "2022-03-29T23:17:54.000+00:00"
  }
}
```

## deleteAnswer

<a id=deleteAnswer> </a>
### 基本信息

**Path：** /answer/delete

**Method：** DELETE

**接口描述：**删除一个回答记录


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  问卷填写表ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```

## findByFeedbackId

<a id=findByFeedbackId> </a>
### 基本信息

**Path：** /answer/findByFeedbackId

**Method：** GET

**接口描述：**通过问卷id查询回答记录


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| feedbackId | 是  |  1 |  问卷ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427d38379bdf15b512c565",
    "studentId": "31901025",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "作业太多辣！！！"
      ]
    ],
    "submitDate": "2022-03-29T23:17:54.000+00:00"
  }
}
```

## findById

<a id=findById> </a>
### 基本信息

**Path：** /answer/findById

**Method：** GET

**接口描述：**通过回答结果id查询回答内容


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  问卷填写表ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427d38379bdf15b512c565",
    "studentId": "31901025",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "作业太多辣！！！"
      ]
    ],
    "submitDate": "2022-03-29T23:17:54.000+00:00"
  }
}
```

## findByUserId

<a id=findByUserId> </a>
### 基本信息

**Path：** /answer/findByUserId

**Method：** GET

**接口描述：**通过答题用户的id查询回答内容


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| userId | 是  |  31901025 |  用户ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427d38379bdf15b512c565",
    "studentId": "31901025",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "作业太多辣！！！"
      ]
    ],
    "submitDate": "2022-03-29T23:17:54.000+00:00"
  }
}
```

## findByUserIdAndFeedbackId

<a id=findByUserIdAndFeedbackId> </a>
### 基本信息

**Path：** /answer/findByUserAndFeedback

**Method：** GET

**接口描述：**通过填写问卷的用户id和问卷id一起查询


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| userId | 是  |  31901025 |  用户ID |
| feedbackId | 是  |  1 |  问卷ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427d38379bdf15b512c565",
    "studentId": "31901025",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "作业太多辣！！！"
      ]
    ],
    "submitDate": "2022-03-29T23:17:54.000+00:00"
  }
}
```

## getAll

<a id=getAll> </a>
### 基本信息

**Path：** /answer/getAll

**Method：** GET

**接口描述：**查询所有问答记录


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "answerSheetId": "62427d38379bdf15b512c565",
      "studentId": "31901025",
      "feedbackId": "1",
      "answers": [
        [
          "难"
        ],
        [
          "作业太多辣！！！"
        ]
      ],
      "submitDate": "2022-03-29T23:17:54.000+00:00"
    },
    {
      "answerSheetId": "62427f86379bdf15b512c566",
      "studentId": "consequat ad amet mollit",
      "feedbackId": "mollit eu Lorem non",
      "answers": [
        [
          "aliqua Duis quis laboris sint"
        ],
        [
          "commodo minim"
        ],
        [
          "ex ut ad",
          "eiusmod magna ut",
          "exercitation voluptate",
          "fugiat proident labore",
          "in fugiat"
        ],
        [
          "dolore velit ex Lorem",
          "pariatur cupidatat dolor fugiat"
        ]
      ],
      "submitDate": "1974-08-09T21:34:31.000+00:00"
    }
  ]
}
```

## updateAnswer

<a id=updateAnswer> </a>
### 基本信息

**Path：** /answer/update

**Method：** PUT

**接口描述：**修改回答记录


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> answerSheetId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷表单ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> studentId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学生ID</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷ID</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> answers</span></td><td key=1><span>array []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">回答列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>array</span></p></td></tr><tr key=array-18><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=array-17><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> submitDate</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">提交时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
      "answerSheetId": "62427f86379bdf15b512c566",
      "studentId": "31901001",
      "feedbackId": "1",
      "answers": [
        [
          "难"
        ],
        [
          "Hadoop+Hdfs"
        ],
        [
          "太难啦"
        ]
      ],
      "submitDate": "2022-03-29T10:00:00.000+00:00"
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "answerSheetId": "62427f86379bdf15b512c566",
    "studentId": "31901001",
    "feedbackId": "1",
    "answers": [
      [
        "难"
      ],
      [
        "Hadoop+Hdfs"
      ],
      [
        "太难啦"
      ]
    ],
    "submitDate": "2022-03-29T10:00:00.000+00:00"
  }
}
```

# CourseController

## addCourse
<a id=addCourse> </a>
### 基本信息

**Path：** /course/add

**Method：** POST

**接口描述：**添加课程


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseName</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> studentIdList</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学号列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-19><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> teacherId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">教师</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseDate</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程时间{周几:[第几节课]}</span></td><td key=5></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> 0</span></td><td key=1><span>integer []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>integer</span></p></td></tr><tr key=array-20><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "courseId": "1",
  "courseName": "大数据计算技术",
  "studentIdList": [
    "31901025",
    "31901028",
    "31901022"
  ],
  "teacherId": "311003",
  "courseDate": {
    "1": [
      5,6
    ]
  }
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "courseId": "62425ea55955a67245505273",
    "courseName": "大数据计算技术",
    "studentIdList": [
      "31901025",
      "31901028",
      "31901022"
    ],
    "teacherId": "311003",
    "courseDate": {
      "1": [
        5,
        6
      ]
    }
  }
}
```

## deleteCourse

<a id=deleteCourse> </a>
### 基本信息

**Path：** /course/delete

**Method：** DELETE

**接口描述：**删除课程


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  课程ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```

## findById

<a id=findById> </a>
### 基本信息

**Path：** /course/findById

**Method：** GET

**接口描述：**通过课程id查询课程信息 


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  课程ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "courseId": "624266105955a67245505275",
    "courseName": "大数据计算技术",
    "studentIdList": [
      "31901025",
      "31901028",
      "31901022"
    ],
    "teacherId": "311003",
    "courseDate": {
      "3": [
        5,
        6
      ]
    }
  }
}
```

## findByName

<a id=findByName> </a>

### 基本信息

**Path：** /course/findByName

**Method：** GET

**接口描述：**通过课程名称查询课程信息


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| name | 是  |  JAVA |  课程名称 |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "courseId": "1",
      "courseName": "大数据计算技术",
      "studentIdList": [
        "31901025",
        "31901028",
        "31901022",
        "31901001",
        "31901024"
      ],
      "teacherId": "311003",
      "courseDate": {
        "1": [
          5,
          6,
          7
        ]
      }
    },
    {
      "courseId": "624266105955a67245505275",
      "courseName": "大数据计算技术",
      "studentIdList": [
        "31901025",
        "31901028",
        "31901022"
      ],
      "teacherId": "311003",
      "courseDate": {
        "3": [
          5,
          6
        ]
      }
    }
  ]
}
```

## getAll

<a id=getAll> </a>

### 基本信息

**Path：** /course/getAll

**Method：** GET

**接口描述：**查看课程列表，所有课程


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "courseId": "62425ea55955a67245505273",
      "courseName": "大数据计算技术",
      "studentIdList": [
        "31901025",
        "31901028",
        "31901022"
      ],
      "teacherId": "311003",
      "courseDate": {
        "1": [
          5,
          6
        ]
      }
    },
    {
      "courseId": "62425fe85955a67245505274",
      "courseName": "软件工程",
      "studentIdList": [
        "31901025",
        "31901028",
        "31901022"
      ],
      "teacherId": "311900",
      "courseDate": {
        "3": [
          5,
          6,
          7
        ]
      }
    }
  ]
}
```

## updateCourse

<a id=updateCourse> </a>
### 基本信息

**Path：** /course/update

**Method：** PUT

**接口描述：**修改课程信息


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseName</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程名</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> studentIdList</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">学号列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-21><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> teacherId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">教师</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> courseDate</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">课程时间{周几:[第几节课]}</span></td><td key=5></td></tr><tr key=0-4-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> 0</span></td><td key=1><span>integer []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>integer</span></p></td></tr><tr key=array-22><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "courseId": "62425ea55955a67245505273",
  "courseName": "大数据计算技术",
  "studentIdList": [
    "31901025",
    "31901028",
    "31901022",
    "31901001",
    "31901024"
  ],
  "teacherId": "311003",
  "courseDate": {
    "1": [
      5,6,7
    ]
  }
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "courseId": "62425ea55955a67245505273",
    "courseName": "大数据计算技术",
    "studentIdList": [
      "31901025",
      "31901028",
      "31901022",
      "31901001",
      "31901024"
    ],
    "teacherId": "311003",
    "courseDate": {
      "1": [
        5,
        6,
        7
      ]
    }
  }
}
```

# FeedbackController

## addFeedback
<a id=addFeedback> </a>
### 基本信息

**Path：** /feedback/add

**Method：** POST

**接口描述：**发布问卷 添加


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |

**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackCourseId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷课程ID</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷标题</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> creatTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">创建时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> questionList</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-6-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题标题</span></td><td key=5></td></tr><tr key=0-6-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionType</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题类型(0:单选题，1:多选题,2:主观题)</span></td><td key=5></td></tr><tr key=0-6-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> options</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项(列表长度:{0:主观题,1:单选题,2:多选题})</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-23><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**请求示例**

```json
{
  "feedbackId": "1",
  "feedbackCourseId": "1",
  "feedbackTitle": "课程问卷",
  "creatTime": "1969-12-31T23:59:59.000Z",
  "startTime": "1969-12-31T23:59:59.000Z",
  "endTime": "1969-12-31T23:59:59.000Z",
  "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "feedbackId": "624277165955a67245505278",
    "feedbackCourseId": "1",
    "feedbackTitle": "课程问卷",
    "creatTime": "1969-12-31T23:59:59.000+00:00",
    "startTime": "1969-12-31T23:59:59.000+00:00",
    "endTime": "1969-12-31T23:59:59.000+00:00",
    "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

## deleteFeedback

<a id=deleteFeedback> </a>
### 基本信息

**Path：** /feedback/delete

**Method：** DELETE

**接口描述：**删除问卷


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |  application/x-www-form-urlencoded |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  问卷ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```

## findByCourseId

<a id=findByCourseId> </a>
### 基本信息

**Path：** /feedback/findByCourseId

**Method：** GET

**接口描述：**通过发布问卷的课程id查询问卷发布详情


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| courseId | 是  |  1 |  课程ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "feedbackId": "6242775d5955a67245505279",
      "feedbackCourseId": "624266105955a67245505275",
      "feedbackTitle": "JAVA课程问卷",
      "creatTime": "1969-12-31T23:59:59.000+00:00",
      "startTime": "1969-12-31T23:59:59.000+00:00",
      "endTime": "1969-12-31T23:59:59.000+00:00",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 0,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "请问你的hadoop配置完了哪些选项",
          "questionType": 1,
          "options": [
            "Hadoop+Hdfs",
            "Hadoop+Hbase",
            "Hadoop+Hbase+MongDB"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    }
  ]
}
```

## findById

<a id=findById> </a>
### 基本信息

**Path：** /feedback/findById

**Method：** GET

**接口描述：**通过发布问卷的id查询问卷详情


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  问卷ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "feedbackId": "624277165955a67245505278",
    "feedbackCourseId": "1",
    "feedbackTitle": "课程问卷",
    "creatTime": "1969-12-31T23:59:59.000+00:00",
    "startTime": "1969-12-31T23:59:59.000+00:00",
    "endTime": "1969-12-31T23:59:59.000+00:00",
    "questionList": [
      {
        "questionTitle": "今天课程的难度怎么样",
        "questionType": 0,
        "options": [
          "难",
          "一般",
          "简单"
        ]
      },
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

## getAll

<a id=getAll> </a>
### 基本信息

**Path：** /feedback/getAll

**Method：** GET

**接口描述：**查看所有发布的问卷


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": [
    {
      "feedbackId": "624277165955a67245505278",
      "feedbackCourseId": "1",
      "feedbackTitle": "课程问卷",
      "creatTime": "1969-12-31T23:59:59.000+00:00",
      "startTime": "1969-12-31T23:59:59.000+00:00",
      "endTime": "1969-12-31T23:59:59.000+00:00",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 0,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "请问你的hadoop配置完了哪些选项",
          "questionType": 1,
          "options": [
            "Hadoop+Hdfs",
            "Hadoop+Hbase",
            "Hadoop+Hbase+MongDB"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    },
    {
      "feedbackId": "6242775d5955a67245505279",
      "feedbackCourseId": "1",
      "feedbackTitle": "课程问卷",
      "creatTime": "1969-12-31T23:59:59.000+00:00",
      "startTime": "1969-12-31T23:59:59.000+00:00",
      "endTime": "1969-12-31T23:59:59.000+00:00",
      "questionList": [
        {
          "questionTitle": "今天课程的难度怎么样",
          "questionType": 0,
          "options": [
            "难",
            "一般",
            "简单"
          ]
        },
        {
          "questionTitle": "请问你的hadoop配置完了哪些选项",
          "questionType": 1,
          "options": [
            "Hadoop+Hdfs",
            "Hadoop+Hbase",
            "Hadoop+Hbase+MongDB"
          ]
        },
        {
          "questionTitle": "你对课程有什么建议吗",
          "questionType": 2,
          "options": []
        }
      ]
    }
  ]
}
```

## updateFeedback

<a id=updateFeedback> </a>

### 基本信息

**Path：** /feedback/update

**Method：** PUT

**接口描述：**修改问卷发布详情


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackCourseId</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷课程ID</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> feedbackTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问卷标题</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> creatTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">创建时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endTime</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束时间</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>@datetime</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> questionList</span></td><td key=1><span>object []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题列表</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>object</span></p></td></tr><tr key=0-6-0><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionTitle</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题标题</span></td><td key=5></td></tr><tr key=0-6-1><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> questionType</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">问题类型(0:单选题，1:多选题,2:主观题)</span></td><td key=5></td></tr><tr key=0-6-2><td key=0><span style="padding-left: 20px"><span style="color: #8c8a8a">├─</span> options</span></td><td key=1><span>string []</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">选项(列表长度:{0:主观题,1:单选题,2:多选题})</span></td><td key=5><p key=3><span style="font-weight: '700'">item 类型: </span><span>string</span></p></td></tr><tr key=array-24><td key=0><span style="padding-left: 40px"><span style="color: #8c8a8a">├─</span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> data</span></td><td key=1><span>object</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspCode</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>200</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> rspMsg</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3>操作成功</td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
 **请求示例**

```json
{
  "feedbackId": "624277165955a67245505278",
  "feedbackCourseId": "1",
  "feedbackTitle": "课程问卷",
  "creatTime": "2022-03-29T23:59:59.000Z",
  "startTime": "2022-03-29T23:59:59.000Z",
  "endTime": "2022-03-29T23:59:59.000Z",
  "questionList": [
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
}
```

**返回示例**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "feedbackId": "624277165955a67245505278",
    "feedbackCourseId": "1",
    "feedbackTitle": "课程问卷",
    "creatTime": "2022-03-29T23:59:59.000+00:00",
    "startTime": "2022-03-29T23:59:59.000+00:00",
    "endTime": "2022-03-29T23:59:59.000+00:00",
    "questionList": [
      {
        "questionTitle": "请问你的hadoop配置完了哪些选项",
        "questionType": 1,
        "options": [
          "Hadoop+Hdfs",
          "Hadoop+Hbase",
          "Hadoop+Hbase+MongDB"
        ]
      },
      {
        "questionTitle": "你对课程有什么建议吗",
        "questionType": 2,
        "options": []
      }
    ]
  }
}
```

