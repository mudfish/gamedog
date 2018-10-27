package com.laoxu.gamedog.config;

import com.laoxu.gamedog.framework.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Security配置
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AdminConfig adminConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser(adminConfig.getUsername()).password((adminConfig.getPassword())).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/images/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/admin")
                .and().logout().permitAll()
                ;


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略
        web.ignoring().antMatchers("/wd/**");
    }
}
