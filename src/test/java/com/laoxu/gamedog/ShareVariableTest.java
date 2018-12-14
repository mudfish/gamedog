package com.laoxu.gamedog;

import org.junit.Test;

/**
 * @author xusucheng
 * @create 2018-12-14
 **/
public class ShareVariableTest {
    private static int id=0;

    @Test
    public void test1(){
        id=1;
        System.out.println("test1:"+id);
    }

    @Test
    public void test2(){
        System.out.println("test2:"+id);
    }

    @Test
    public void test3(){
        System.out.println("test3:"+id);
    }
}
