package com.lz.zknock.entity;

/**js端用户*/
public class WSUser {

    private int id;
    private String internal_key;
    private String user_token;
    private String user_name;
    private int type;//账户类型:1：个人账户 2：群账户 3：群临时账户 4：公众号
    private String create_time;
    private String update_time;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInternal_key() {
        return internal_key;
    }

    public void setInternal_key(String internal_key) {
        this.internal_key = internal_key;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
