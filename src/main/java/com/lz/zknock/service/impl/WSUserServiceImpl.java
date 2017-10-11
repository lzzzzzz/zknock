package com.lz.zknock.service.impl;

import com.lz.zknock.dao.WSUserDao;
import com.lz.zknock.entity.WSUser;
import com.lz.zknock.service.WSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WSUserServiceImpl implements WSUserService {

    @Autowired
    private WSUserDao WSUserDao;

    @Override
    public WSUser getById(int id) {
        return null;
    }

    @Override
    public List<WSUser> getUsersByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<WSUser> getAllUser() {
        System.out.println(null== WSUserDao ?"wsjsUserDao is null":"wsjsUserDao is not null");
       return null;
    }

    @Override
    public void insertWSJSUser(WSUser user) {

    }

    @Override
    public void updateUser(WSUser user) {

    }

    @Override
    public void delUserById(int id) {

    }
}
