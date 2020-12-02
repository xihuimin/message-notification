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
public class GroupMessageImplTest extends AbstractTest {

    @Autowired
    private NotifyMessageImpl notifyMessage;

    /**
     *
     * @throws ApiException
     */
    @Test
    public void sendText() throws ApiException{
        notifyMessage.sendGroupMessage("chat4e8382fba23acab3cdb6d97e8163c523",  DingMsgTypeEnum.TEXT, "hello xiaoluo!");
    }

}