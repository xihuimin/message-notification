package com.xi.notification.enums;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
public enum DingMsgTypeEnum {

    TEXT("text"),
    IMAGE("image"),
    FILE("file"),
    MARKDOWN("markdown"),
    OA("oa"),
    ACTION_CARD("action_card"),
    ;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    DingMsgTypeEnum(String type){
        this.type = type;
    }

}
