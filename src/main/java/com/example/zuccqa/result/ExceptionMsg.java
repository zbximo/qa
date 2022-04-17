package com.example.zuccqa.result;


/**
 * @author: ximo
 * @date: 2022/3/22 10:25
 * @description:
 */
public enum ExceptionMsg {
    SUCCESS("200", "操作成功"),
    FAILED("99999","操作失败"),
    QueryEmpty("000000","查询结果为空"),
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
