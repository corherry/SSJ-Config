package com.oocl.admin.enums;

public enum AuditResultEnum {

    AUDIT_PENDING(0, "待审核"),

    AGREE(1, "同意"),

    DISAGREE(2, "不同意"),

    UPDATE(3, "驳回修改");

    private int value;

    private String msg;

    private AuditResultEnum(int value, String msg) {
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
