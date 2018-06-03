package com.cdy.datasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * todo
 * Created by 陈东一
 * 2018/6/3 10:32
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    
    @RequestMapping("/list")
    public List test(){
        List<User> list = userService.getList();
        return list;
    }
    
    @RequestMapping("/insert")
    public String test2(){
        userService.insert();
        return "ok";
    }
}
