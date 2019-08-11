package com.li.services.impl;

import com.li.domain.User;
import com.li.mapper.UserMapper;
import com.li.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Program: ssm_anno
 * @ClassName: UserServicesImpl
 * @Description:
 * @Author: li
 * @Create: 2019-08-06 14:47
 */
@Service("userServices")
//设置增删改
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class UserServicesImpl implements IUserServices {

    @Autowired
    private UserMapper mapper;


    @Override
    //查询 只读
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public void insertUser(User user) {
        mapper.insertSelective(user);
    }
}
