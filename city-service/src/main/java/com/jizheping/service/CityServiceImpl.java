package com.jizheping.service;

import com.jizheping.bean.City;
import com.jizheping.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> getCityByPid(Integer pid) {
        List<City> list = cityDao.getCityByPid(pid);

        return list;
    }

    @Override
    public List<City> getCityListByIds(List<Integer> ids) {
        return cityDao.findAllById(ids);
    }
}
