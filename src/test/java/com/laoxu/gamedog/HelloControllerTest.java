package com.laoxu.gamedog;

import com.laoxu.gamedog.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 * @author xusucheng
 * @create 2018-12-14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
    @Autowired
    private HelloController helloController;

    @Test
    public void testHello(){
        String result = helloController.sayHello("Jack");
        assertEquals("Hello Jack!",result);
    }
}
