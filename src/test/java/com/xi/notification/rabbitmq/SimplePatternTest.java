package com.xi.notification.rabbitmq;

import com.xi.notification.AbstractTest;
import com.xi.notification.model.User;
import com.xi.notification.service.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
public class SimplePatternTest extends AbstractTest {

    @Autowired
    private Producer producer;

    @Test
    public void testString(){
        producer.sendMsg("simpleQueue", "简单模式!!!");
    }

    @Test
    public void testObject(){
        User user = new User();
        user.setId(2020L);
        user.setName("test");
        producer.sendUser("simpleQueue", user);
    }

//    @Test
//    public void testObject2Json(){
//        User user = new User();
//        user.setId(2020L);
//        user.setName("test");
//        String msg = JSONObject.toJSONString(user);
//        producer.sendMsg("simpleQueue", msg);
//    }
}
