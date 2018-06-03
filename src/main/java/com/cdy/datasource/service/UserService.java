package com.cdy.datasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo
 * Created by 陈东一
 * 2018/6/3 10:27
 */
@Service
public class UserService {
    
    
    @Autowired
    private UserDao userDao;
    
    @TargetDataSource("ds1")
    public List<User> getList(){
        return userDao.getList();
    }
    
    @TargetDataSource
    public void insert(){
        userDao.insert();
    }
}
