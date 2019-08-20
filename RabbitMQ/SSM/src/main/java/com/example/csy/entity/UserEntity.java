package com.example.csy.entity;

/**
 * @author jay.zhou
 * @date 2019/4/24
 * @time 17:34
 */
public class UserEntity {

    private Long id;

    private String username;

    private int age;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
