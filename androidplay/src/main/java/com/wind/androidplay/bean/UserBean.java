package com.wind.androidplay.bean;

import java.util.List;

/**
 * @author : guo
 * @package : com.wind.androidplay.bean
 * @descrip :
 */
public class UserBean  {

    private String email,icon,password,username;
    private long id,type;
    private List<Integer> collectIds;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", type=" + type +
                ", collectIds=" + collectIds +
                '}';
    }
}
