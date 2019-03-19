package com.jxw.heihei1.domian;



import javax.persistence.*;

/**
 * User实体
 * 根据JPA来标示
 */
@Entity
@Table(name = "user")

public class User {

    @Id //主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) //生成策略：根据数据库自增
    private Long id;
    private String name;
    private String email;


    protected User(){  //无参构造器;设为protected 防止直接使用
    }
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
