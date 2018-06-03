package com.cdy.datasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * todo
 * Created by 陈东一
 * 2018/6/3 10:17
 */
@Repository
public class UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 不指定数据源使用默认数据源
     */
    public List<User> getList(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User demo = new User();
            demo.setId(rs.getInt("id"));
            demo.setSex(rs.getInt("sex"));
            demo.setUsername(rs.getString("username"));;
            return demo;
        });
    }
    
    
    public void insert(){
        String sql = "insert into user values(null,'abc',1)";
        jdbcTemplate.execute(sql);
    }
}
