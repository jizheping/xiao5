package com.jizheping.cityFeign;

import com.jizheping.bean.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CityFeignFallback implements CityFeign {
    @Override
    public List<City> getCityListByIds(List<Integer> ids) {
        System.out.println("fallback");

        return null;
    }
}
