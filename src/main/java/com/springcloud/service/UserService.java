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
        StringBuffer sql = new StringBuffer("SELECT u.id,u.phone,u.name,u.sex,u.age,u.address FROM user_info u where 1=1 ");
        if (!StringUtils.isEmpty(userInfo.getName())) {
            sql.append(" and u.name like %" + userInfo.getName() + "%");
        }

        List<UserInfo> userInfos = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(UserInfo.class));

        return new PageBase<>(userInfos);
    }

    public void addUser(UserInfo userInfo) {
        jdbcTemplate.update("insert into user_info (phone,name,sex,age,address) values (?,?,?,?,?)",
                new Object[]{userInfo.getPhone(), userInfo.getName(), userInfo.getSex(), userInfo.getAge(), userInfo.getAddress()});
    }

    public void updateUser(UserInfo userInfo) {
        jdbcTemplate.update("update user_info set phone=?,name=?,sex=?,age=?,address=? where id=?",
                new Object[]{userInfo.getPhone(),userInfo.getName(),userInfo.getSex(),userInfo.getAge(),userInfo.getAddress(),userInfo.getId()});
    }


    public void deleteUser(String id) {
        jdbcTemplate.update("delete from user_info where id=? ",new Object[]{id});
    }
}
