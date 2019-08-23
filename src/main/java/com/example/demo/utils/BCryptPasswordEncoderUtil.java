package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderUtil {

    public static BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
