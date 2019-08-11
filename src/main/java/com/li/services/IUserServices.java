package com.li.services;

import com.li.domain.User;

import java.util.List;

/**
 * @Program: ssm_anno
 * @ClassName: IUserServices
 * @Description:
 * @Author: li
 * @Create: 2019-08-06 14:46
 */
public interface IUserServices {

    List<User> findAll();

    void insertUser(User user);
}
