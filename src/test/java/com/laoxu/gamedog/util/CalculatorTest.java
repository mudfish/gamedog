package com.laoxu.gamedog.util;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * 计算器测试类
 * @author xusucheng
 * @create 2018-12-13
 **/
@RunWith(Parameterized.class)
public class CalculatorTest {
    private int expected;
    private int p1;
    private int p2;

    public CalculatorTest(int expected,int p1,int p2){
        this.expected=expected;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Parameterized.Parameters
    public static Collection addNumbers(){
        return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 5, 2, 3 },
                { 7, 3, 4 }, { 9, 4, 5 }, });
    }

    @Test
    public void sum() {
        Calculator calculator = new Calculator();
        System.out.println("Addition with parameters : " + p1 + " and "
                + p2);
        assertEquals(expected, calculator.sum(p1, p2));
    }

}
