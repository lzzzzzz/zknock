package com.lz.zknock.service;

import com.lz.zknock.entity.WSUser;

import java.util.List;

public interface WSUserService {

    public WSUser getById(int id);

    public List<WSUser> getUsersByIds(List<Integer> ids);

    public List<WSUser> getAllUser();

    public void insertWSJSUser(WSUser user);

    public void updateUser(WSUser user);

    public void delUserById(int id);
}
