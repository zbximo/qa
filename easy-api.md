# zuccqa

## TIPS: 操作成功时{"rspCode":200, "rspMsg":"操作成功", "data": 实体对象}，否则为{"rspCode":9999，"rspMsg":"操作失败","data":null}。

## FeedbackController


---
### addFeedback

> BASIC

**Path:** /feedback/add

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| feedbackId | string | 问卷ID |
| feedbackCourse | object | 问卷课程 |
| &ensp;&ensp;&#124;─courseId | string | 课程ID |
| &ensp;&ensp;&#124;─courseName | string | 课程名 |
| &ensp;&ensp;&#124;─stuList | array | 学生列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&#124;─teacher | object | 教师 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&#124;─courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| feedbackTitle | string | 问卷标题 |
| creatTime | string | 创建时间 |
| startTime | string | 开始时间 |
| endTime | string | 结束时间 |
| questionList | array | 问题列表 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 |
| &ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) |
| &ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "feedbackId": "",
  "feedbackCourse": {
    "courseId": "",
    "courseName": "",
    "stuList": [
      {
        "id": "",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      }
    ],
    "teacher": {
      "id": "",
      "name": "",
      "age": 0,
      "password": "",
      "position": 0
    },
    "courseDate": {
      "0": [
        0
      ]
    }
  },
  "feedbackTitle": "",
  "creatTime": "",
  "startTime": "",
  "endTime": "",
  "questionList": [
    {
      "questionTitle": "",
      "questionType": 0,
      "options": [
        ""
      ]
    }
  ]
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### deleteFeedback

> BASIC

**Path:** /feedback/delete

**Method:** DELETE

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 问卷ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "",
  "rspMsg": ""
}
```




---
### updateFeedback

> BASIC

**Path:** /feedback/update

**Method:** PUT

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| feedbackId | string | 问卷ID |
| feedbackCourse | object | 问卷课程 |
| &ensp;&ensp;&#124;─courseId | string | 课程ID |
| &ensp;&ensp;&#124;─courseName | string | 课程名 |
| &ensp;&ensp;&#124;─stuList | array | 学生列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&#124;─teacher | object | 教师 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&#124;─courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| feedbackTitle | string | 问卷标题 |
| creatTime | string | 创建时间 |
| startTime | string | 开始时间 |
| endTime | string | 结束时间 |
| questionList | array | 问题列表 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 |
| &ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) |
| &ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "feedbackId": "",
  "feedbackCourse": {
    "courseId": "",
    "courseName": "",
    "stuList": [
      {
        "id": "",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      }
    ],
    "teacher": {
      "id": "",
      "name": "",
      "age": 0,
      "password": "",
      "position": 0
    },
    "courseDate": {
      "0": [
        0
      ]
    }
  },
  "feedbackTitle": "",
  "creatTime": "",
  "startTime": "",
  "endTime": "",
  "questionList": [
    {
      "questionTitle": "",
      "questionType": 0,
      "options": [
        ""
      ]
    }
  ]
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findById

> BASIC

**Path:** /feedback/findById

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 问卷ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByCourseId

> BASIC

**Path:** /feedback/findByCourseId

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| courseId |  | YES | 课程ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### getAll

> BASIC

**Path:** /feedback/getAll

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```





## AnswerController


---
### addAnswer

> BASIC

**Path:** /answerSheet/add

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| answerId | string | 答案ID |
| user | object | 用户 |
| &ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| feedback | object | 问卷 |
| &ensp;&ensp;&#124;─feedbackId | string | 问卷ID |
| &ensp;&ensp;&#124;─feedbackCourse | object | 问卷课程 |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseId | string | 课程ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseName | string | 课程名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─stuList | array | 学生列表 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&ensp;&ensp;&#124;─teacher | object | 教师 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─feedbackTitle | string | 问卷标题 |
| &ensp;&ensp;&#124;─creatTime | string | 创建时间 |
| &ensp;&ensp;&#124;─startTime | string | 开始时间 |
| &ensp;&ensp;&#124;─endTime | string | 结束时间 |
| &ensp;&ensp;&#124;─questionList | array | 问题列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| answerSheet | array | 答案列表 |
| &ensp;&ensp;&#124;─ | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| date | string | 时间 |

**Request Demo:**

```json
{
  "answerId": "",
  "user": {
    "id": "",
    "name": "",
    "age": 0,
    "password": "",
    "position": 0
  },
  "feedback": {
    "feedbackId": "",
    "feedbackCourse": {
      "courseId": "",
      "courseName": "",
      "stuList": [
        {
          "id": "",
          "name": "",
          "age": 0,
          "password": "",
          "position": 0
        }
      ],
      "teacher": {
        "id": "",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      },
      "courseDate": {
        "0": [
          0
        ]
      }
    },
    "feedbackTitle": "",
    "creatTime": "",
    "startTime": "",
    "endTime": "",
    "questionList": [
      {
        "questionTitle": "",
        "questionType": 0,
        "options": [
          ""
        ]
      }
    ]
  },
  "answerSheet": [
    [
      ""
    ]
  ],
  "date": ""
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### deleteAnswer

> BASIC

**Path:** /answerSheet/delete

**Method:** DELETE

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 问卷填写表ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "",
  "rspMsg": ""
}
```




---
### updateAnswer

> BASIC

**Path:** /answerSheet/update

**Method:** PUT

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| answerId | string | 答案ID |
| user | object | 用户 |
| &ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| feedback | object | 问卷 |
| &ensp;&ensp;&#124;─feedbackId | string | 问卷ID |
| &ensp;&ensp;&#124;─feedbackCourse | object | 问卷课程 |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseId | string | 课程ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseName | string | 课程名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─stuList | array | 学生列表 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&ensp;&ensp;&#124;─teacher | object | 教师 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| &ensp;&ensp;&ensp;&ensp;&#124;─courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─feedbackTitle | string | 问卷标题 |
| &ensp;&ensp;&#124;─creatTime | string | 创建时间 |
| &ensp;&ensp;&#124;─startTime | string | 开始时间 |
| &ensp;&ensp;&#124;─endTime | string | 结束时间 |
| &ensp;&ensp;&#124;─questionList | array | 问题列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| answerSheet | array | 答案列表 |
| &ensp;&ensp;&#124;─ | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| date | string | 时间 |

**Request Demo:**

```json
{
  "answerId": "",
  "user": {
    "id": "",
    "name": "",
    "age": 0,
    "password": "",
    "position": 0
  },
  "feedback": {
    "feedbackId": "",
    "feedbackCourse": {
      "courseId": "",
      "courseName": "",
      "stuList": [
        {
          "id": "",
          "name": "",
          "age": 0,
          "password": "",
          "position": 0
        }
      ],
      "teacher": {
        "id": "",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      },
      "courseDate": {
        "0": [
          0
        ]
      }
    },
    "feedbackTitle": "",
    "creatTime": "",
    "startTime": "",
    "endTime": "",
    "questionList": [
      {
        "questionTitle": "",
        "questionType": 0,
        "options": [
          ""
        ]
      }
    ]
  },
  "answerSheet": [
    [
      ""
    ]
  ],
  "date": ""
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findById

> BASIC

**Path:** /answerSheet/findById

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 问卷填写表ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByUserAndFeedback

> BASIC

**Path:** /answerSheet/findByUserAndFeedback

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| userId |  | YES | 用户ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByFeedback

> BASIC

**Path:** /answerSheet/findByFeedback

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| feedbackId |  | YES | 问卷ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByUserAndFeedback

> BASIC

**Path:** /answerSheet/findByUserAndFeedback

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| userId |  | YES | 用户ID |
| feedbackId |  | YES | 问卷ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### getAll

> BASIC

**Path:** /answerSheet/getAll

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```





## CourseController


---
### addCourse

> BASIC

**Path:** /course/add

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| courseId | string | 课程ID |
| courseName | string | 课程名 |
| stuList | array | 学生列表 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| teacher | object | 教师 |
| &ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "courseId": "",
  "courseName": "",
  "stuList": [
    {
      "id": "",
      "name": "",
      "age": 0,
      "password": "",
      "position": 0
    }
  ],
  "teacher": {
    "id": "",
    "name": "",
    "age": 0,
    "password": "",
    "position": 0
  },
  "courseDate": {
    "0": [
      0
    ]
  }
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "courseId": "62404a855ef4a2465734a9fa",
    "courseName": "软件架构",
    "stuList": [
      {
        "id": "31901028",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      },
      {
        "id": "31901029",
        "name": "",
        "age": 0,
        "password": "",
        "position": 0
      }
    ],
    "teacher": {
      "id": "11",
      "name": "",
      "age": 0,
      "password": "",
      "position": 0
    },
    "courseDate": {
      "1": [
        6,
        7,
        8,
        9
      ]
    }
  }
}
```




---
### deleteCourse

> BASIC

**Path:** /course/delete

**Method:** DELETE

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 课程ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "",
  "rspMsg": ""
}
```




---
### updateCourse

> BASIC

**Path:** /course/update

**Method:** PUT

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| courseId | string | 课程ID |
| courseName | string | 课程名 |
| stuList | array | 学生列表 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| teacher | object | 教师 |
| &ensp;&ensp;&#124;─id | string | 用户ID |
| &ensp;&ensp;&#124;─name | string | 用户姓名 |
| &ensp;&ensp;&#124;─age | integer | 用户年龄 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─position | integer | 用户身份(0:学生,1:教师,2:管理员) |
| courseDate | object | 课程时间 {周几:[第几节课]} |
| &ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "courseId": "",
  "courseName": "",
  "stuList": [
    {
      "id": "",
      "name": "",
      "age": 0,
      "password": "",
      "position": 0
    }
  ],
  "teacher": {
    "id": "",
    "name": "",
    "age": 0,
    "password": "",
    "position": 0
  },
  "courseDate": {
    "0": [
      0
    ]
  }
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findById

> BASIC

**Path:** /course/findById

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 课程ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByName

> BASIC

**Path:** /course/findByName

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 课程名称 |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### getAll

> BASIC

**Path:** /course/getAll

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```

## ModelController


---
### addModel

> BASIC

**Path:** /model/add

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| modelID | string | 模版ID | 
| modelName | string | 模版名 | 
| questionList | array | 问题列表 | 
| &ensp;&ensp;&#124;─ | object |  | 
| &ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 | 
| &ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) | 
| &ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) | 
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  | 

**Request Demo:**

```json
{
  "modelID": "",
  "modelName": "",
  "questionList": [
    {
      "questionTitle": "",
      "questionType": 0,
      "options": [
        ""
      ]
    }
  ]
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### deleteModel

> BASIC

**Path:** /model/delete

**Method:** DELETE

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 模板ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "",
  "rspMsg": ""
}
```




---
### updateModel

> BASIC

**Path:** /model/update

**Method:** PUT

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| modelID | string | 模版ID | 
| modelName | string | 模版名 | 
| questionList | array | 问题列表 | 
| &ensp;&ensp;&#124;─ | object |  | 
| &ensp;&ensp;&ensp;&ensp;&#124;─questionTitle | string | 问题标题 | 
| &ensp;&ensp;&ensp;&ensp;&#124;─questionType | integer | 问题类型(0:单选题，1:多选题,2:主观题) | 
| &ensp;&ensp;&ensp;&ensp;&#124;─options | array | 选项(列表长度:{0:主观题,1:单选题,2:多选题}) | 
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  | 

**Request Demo:**

```json
{
  "modelID": "",
  "modelName": "",
  "questionList": [
    {
      "questionTitle": "",
      "questionType": 0,
      "options": [
        ""
      ]
    }
  ]
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findById

> BASIC

**Path:** /model/find

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 模板ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### findByName

> BASIC

**Path:** /model/findByName

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 模板名称 |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### getAll

> BASIC

**Path:** /model/getAll

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```





## UserController


---
### addUser

> BASIC

**Path:** /user/add

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | string | 用户ID | 
| name | string | 用户姓名 | 
| age | integer | 用户年龄 | 
| password | string | 用户密码 | 
| position | integer | 用户身份(0:学生,1:教师,2:管理员) | 

**Request Demo:**

```json
{ 
    "id": "JG001", 
    "name": "jj", 
    "age": 55, 
    "password": "JG001", 
    "position": 1 
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "JG001",
    "name": "jj",
    "age": 55,
    "password": "JG001",
    "position": 1
  }
}
```




---
### updateUser

> BASIC

**Path:** /user/update

**Method:** PUT

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | string | 用户ID | 
| name | string | 用户姓名 | 
| age | integer | 用户年龄 | 
| password | string | 用户密码 | 
| position | integer | 用户身份(0:学生,1:教师,2:管理员) | 

**Request Demo:**

```json
{ 
    "id": "JG001", 
    "name": "XXXX", 
    "age": 33, 
    "password": "132", 
    "position": 1 
}
```



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "JG001",
    "name": "XXXX",
    "age": 33,
    "password": "132",
    "position": 1
  }
}
```




---
### deleteStudent

> BASIC

**Path:** /user/delete

**Method:** DELETE

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 用户ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功"
}
```




---
### getById

> BASIC

**Path:** /user/find

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 用户ID |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "11",
    "name": "11",
    "age": 0,
    "password": "11",
    "position": 0
  }
}
```




---
### findByName

> BASIC

**Path:** /user/findByName

**Method:** GET

> REQUEST

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 用户姓名 |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "200",
  "rspMsg": "操作成功",
  "data": {
    "id": "11",
    "name": "11",
    "age": 0,
    "password": "11",
    "position": 0
  }
}
```




---
### getAll

> BASIC

**Path:** /user/getAll

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| data | object |  | 
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "data": {},
  "rspCode": "",
  "rspMsg": ""
}
```




---
### login

> BASIC

**Path:** /user/login

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 用户ID |
| password |  | YES | 用户密码 |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "99999",
  "rspMsg": "操作失败",
  "data": "用户不存在"
}
```




---
### modifyPwd

> BASIC

**Path:** /user/modifyPwd

**Method:** POST

> REQUEST

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name  |  value  |  required | desc  |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | 用户ID |
| oldPwd |  | YES | 用户原密码 |
| newPwd |  | YES | 用户新密码 |



> RESPONSE

**Headers:**

| name  |  value  |  required  | desc  |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |   |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| rspCode | string |  | 
| rspMsg | string |  | 

**Response Demo:**

```json
{
  "rspCode": "99999",
  "rspMsg": "操作失败",
  "data": "旧密码错误"
}
```





