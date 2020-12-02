package com.xi.notification.ding;

import com.taobao.api.ApiException;
import com.xi.notification.AbstractTest;
import com.xi.notification.enums.DingMsgTypeEnum;
import com.xi.notification.service.impl.NotifyMessageImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/1
 */
public class OrdinaryMessageImplTest extends AbstractTest {

    @Autowired
    private NotifyMessageImpl notifyMessage;

    /**
     * 一个cid只能使用一次
     * @throws ApiException
     */
    @Test
    public void sendOrdinary() throws ApiException{
        notifyMessage.sendOrdinaryMessage("fcf51fa0d3913b7ba74181d0894b25fd", "manager2174", DingMsgTypeEnum.TEXT, "hello xiaoxi!");
    }

}