package com.jizheping.service;

import com.jizheping.bean.Clazz;
import com.jizheping.dao.ClazzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<Clazz> getClazzList() {
        return clazzDao.findAll();
    }
}
