package com.bosssoft.myenum;

/**
 * @author 吴志鸿
 * @date 2020/7/29
 * @description
 */
public enum ResultType {
    SUCCESS(200, "操作成功"),
    NOTFOUND(404, "操作失败"),
    FORBIDDEN(403, "操作失败"),
    EXCEPTION(500, "程序出现异常"),
    RELOGIN(201, "登录失效"),
    LOGINFAILED(203, "登录失败"),
    DUPLICATE_RECORD(202, "重复记录");

    private Integer code;

    private String msg;

    ResultType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getDescByValue(String code) {
        for (ResultType enums : ResultType.values()) {
            if (enums.getCode().equals(code)) {
                return enums.getMsg();
            }
        }
        return null;
    }
}
