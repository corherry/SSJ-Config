package com.oocl.admin.enums;

public enum MerchantStatusEnum {

    NORMAL(0, "正常"),

    BLACKLISTED(1, "被拉黑");


    private int value;

    private String msg;

    private MerchantStatusEnum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}