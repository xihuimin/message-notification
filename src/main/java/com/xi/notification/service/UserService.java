package com.xi.notification.service;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
public interface UserService {

    /**
     * description
     *
     * @param accessToken 应用凭证
     * @param mobile 员工手机号
     * @return java.lang.String
     * @author xihuimin
     * @date 2020/12/1
    */
    String getUserId(String accessToken, String mobile);
}
