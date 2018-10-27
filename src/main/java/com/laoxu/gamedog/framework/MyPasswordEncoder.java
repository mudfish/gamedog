package com.laoxu.gamedog.framework;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xusucheng
 * @create 2018-10-27
 **/
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
