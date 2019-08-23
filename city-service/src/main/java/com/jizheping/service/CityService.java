package com.jizheping.service;

import com.jizheping.bean.City;

import java.util.List;
import java.util.Set;

public interface CityService {
    List<City> getCityByPid(Integer pid);

    List<City> getCityListByIds(List<Integer> ids);
}
