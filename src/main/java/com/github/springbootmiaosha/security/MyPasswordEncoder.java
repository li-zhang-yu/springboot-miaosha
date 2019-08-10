package com.github.springbootmiaosha.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * PasswordEncorder的实例
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
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
