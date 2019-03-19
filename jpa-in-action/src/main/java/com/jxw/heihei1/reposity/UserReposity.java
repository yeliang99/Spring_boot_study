package com.jxw.heihei1.reposity;

import com.jxw.heihei1.domian.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User Reposity 接口
 */
public interface UserReposity extends CrudRepository<User,Long> {
//    /**
//     * 创建或者修改用户
//     * @param user
//     * @return
//     */
//    User saveOrUpdateUser(User user);
//
//    /**
//     * 删除用户
//     * @param id
//     */
//    void deleteUser(Long id);
//
//    /**
//     * 根据id查询用户
//     */
//    User getUserById(Long id);
//
//    /**
//     * 获取用户列表
//     * @return
//     */
//    List<User> listUsers();
}

