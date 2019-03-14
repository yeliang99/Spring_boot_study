package com.jxw.heihei1.reposity;

import com.jxw.heihei1.domian.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository   //注解表示该资源库最终是一个bean
public class UserReposityImpl implements UserReposity {

    //用于计数，每增加一个用户，加一
    private static AtomicLong counter = new AtomicLong();
    //用于存储用户
    private final ConcurrentMap<String,User> userMap = new ConcurrentHashMap<>();
    @Override
    public User saveOrUpdateUser(User user) {
        System.out.println("进入创建");
        String id = user.getId();
        if( id == null || id==""){//新建
            Long X = counter.incrementAndGet();
            id = X.toString();
            user.setId(id);
            System.out.println(user.getName());

        }
        this.userMap.put(id,user); //将用户放到资源库中
        return user;
    }

    @Override
    public void deleteUser(String id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(String id) {

        return this.userMap.get(id);
    }

    @Override
    public List<User> listUsers() {

        return new ArrayList<User>(this.userMap.values());
    }
}
