package com.xi.notification.enums;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
public enum  DingApiUrlEnum {

    URL_GET_TOKKEN("https://oapi.dingtalk.com/gettoken"),

    URL_GET_USERID("https://oapi.dingtalk.com/topapi/v2/user/getbymobile"),

    URL_SEND_JOB_MESSAGE("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2"),

    URL_SEND_GROUP_MESSAGE("https://oapi.dingtalk.com/chat/send"),

    URL_SEND_ORDINARY_MESSAGE("https://oapi.dingtalk.com/message/send_to_conversation"),
    ;

    private String url;

    DingApiUrlEnum(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
