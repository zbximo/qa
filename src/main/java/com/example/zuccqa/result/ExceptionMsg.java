package com.example.zuccqa.result;


/**
 * @author: ximo
 * @date: 2022/3/22 10:25
 * @description:
 */
public enum ExceptionMsg {
    CREATE_SUCCESS("200", "添加成功"),
    UPDATE_SUCCESS("200", "更新成功"),
    DELETE_SUCCESS("200", "删除成功"),
    QUERY_SUCCESS("200", "查询成功"),
    SUCCESS("200", "操作成功"),
    FAILED("99999","操作失败"),
    QUERY_EMPTY("000000","查询结果为空"),
    ParamError("000001", "参数错误！"),
    FileEmpty("000400","上传文件为空"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'")
    ;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
