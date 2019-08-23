package com.jizheping.service;

import com.jizheping.bean.Hobby;
import com.jizheping.dao.HobbyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService{
    @Autowired
    private HobbyDao hobbyDao;

    @Override
    public List<Hobby> getHobbyList() {
        return hobbyDao.findAll();
    }
}
