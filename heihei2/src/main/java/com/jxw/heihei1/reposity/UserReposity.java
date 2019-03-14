package com.jxw.heihei1.reposity;

import com.jxw.heihei1.domian.User;

import java.util.List;

/**
 * User Reposity 接口
 */
public interface UserReposity {
    /**
     * 创建或者修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询用户
     */
    User getUserById(String id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();
}

