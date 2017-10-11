package com.lz.zknock.dao;

import com.lz.zknock.entity.WSUser;

import java.util.List;

/**js用户*/
public interface WSUserDao {

    public WSUser getById(int id);

    public List<WSUser> getUsersByIds(List<Integer> ids);

    public List<WSUser> getAllUser();

    public void insertWSJSUser(WSUser user);

    public void updateUser(WSUser user);

    public void delUserById(int id);

}
