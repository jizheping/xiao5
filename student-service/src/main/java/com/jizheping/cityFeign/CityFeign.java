package com.jizheping.cityFeign;

import com.jizheping.bean.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.reflect.FieldAccessor;

import java.util.List;
import java.util.Set;

@FeignClient(value = "city-service",fallback = CityFeignFallback.class)
public interface CityFeign{
    @RequestMapping("/city/getCityListByIds")
    public List<City> getCityListByIds(@RequestParam("ids") List<Integer> ids);
}
