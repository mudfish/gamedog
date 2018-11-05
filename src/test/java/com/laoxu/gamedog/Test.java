package com.laoxu.gamedog;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.SafeFile;
import org.owasp.esapi.errors.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xusucheng
 * @create 2018-10-24
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        String str1 = "aaa";
        list1.add("a");

        List<String> list2 = str1!=null||list1==null?null:list1;

        System.out.println(list2);

    }
}
