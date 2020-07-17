package com.aaa.wkn.status;

/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 21:22
 */
public enum SelectStatus {
    SELECT_DATA_SUCCESS("24001", "查询数据成功"),
    SELECT_DATA_FAILED("14001", "查询数据失败"),
    SELECT_DATA_NOT_EXIST("14002","数据不存在！"),
    SELECT_DATA_BY_ID_SUCCESS("24002","根据ID查询数据成功！"),
    SELECT_DATA_BY_ID_FAILED("14003","根据ID查询数据失败！"),


    TEST("11111", "测试一下");

    SelectStatus(String code, String msg) {
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
