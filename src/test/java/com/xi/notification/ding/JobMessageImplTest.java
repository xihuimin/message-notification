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
public class JobMessageImplTest extends AbstractTest {

    @Autowired
    private NotifyMessageImpl notifyMessage;

    @Test
    public void sendText() throws ApiException {
        notifyMessage.sendJobMessage("manager2174", DingMsgTypeEnum.TEXT, "hello！");
    }

    @Test
    public void sendMarkdown() throws ApiException {
        String content = "# 向天再借五百年" +
                "## 借你五万年" +
                "![alt 啊](https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png)";
        notifyMessage.sendJobMessage("manager2174", DingMsgTypeEnum.MARKDOWN, content);
    }

}