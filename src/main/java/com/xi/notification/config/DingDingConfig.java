package com.xi.notification.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
@Component
@Data
public class DingDingConfig {

    /**
     * 应用id
     */
    @Value("${application.dingding.microapp.agentId}")
    private Long agentId;

    /**
     * 应用的唯一标识key
     */
    @Value("${application.dingding.microapp.appKey}")
    private String appKey;

    /**
     * 应用密匙
     */
    @Value("${application.dingding.microapp.appSecret}")
    private String appSecret;

    /**
     * 企业的corpid，可在开发者后台首页查看
     */
    @Value("${application.dingding.microapp.corpId}")
    private String corpId;
}
