package com.aaa.wkn.status;

/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 21:22
 */
public enum UpdateStatus {
    UPDATE_DATA_SUCCESS("23001", "修改数据成功"),
    UPDATE_DATA_FAILED("13001", "修改数据失败"),
    UPDATE_DATA_EXIST("13002","该数据已存在，请修改后重试！"),
    UPDATE_DATA_NULL("13003","传入数据为空"),


    TEST("11111", "测试一下");


    UpdateStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
