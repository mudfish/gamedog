package com.laoxu.gamedog;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

/**
 * 数据库连接测试类
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ConnectionTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void getAccountList(){
        String sql="select account from account limit 1,10";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
        }

        for(Map<String,Object> map:list){
            System.out.println("account="+map.get("account"));
        }
    }
}
