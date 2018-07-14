package com.springcloud.service;

import com.springcloud.model.PageBase;
import com.springcloud.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wanghonglan on 2018/6/29.
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PageBase<UserInfo> queryUserList(UserInfo userInfo) {
        StringBuffer sql=new StringBuffer("SELECT u.id,u.phone,u.name FROM user_info u where 1=1 ");
        if (!StringUtils.isEmpty(userInfo.getName())) {
            sql.append(" and u.name like %"+userInfo.getName()+"%");
        }

        List<UserInfo> userInfos = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<>(UserInfo.class));

        return new PageBase<>(userInfos);
    }
}
