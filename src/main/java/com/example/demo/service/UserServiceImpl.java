package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.utils.BCryptPasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public String encode(String password) {
        BCryptPasswordEncoder encoder = BCryptPasswordEncoderUtil.getEncoder();
        return encoder.encode(password);
    }

    @PostConstruct
    public void init() {
        BCryptPasswordEncoder encoder = BCryptPasswordEncoderUtil.getEncoder();
        String password1 = encoder.encode("test");
        String password2 = encoder.encode("test2");
        userDao.save(new User("test", password1));
        userDao.save(new User("test2", password2));
    }
}
