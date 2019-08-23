package com.jizheping.controller;

import com.jizheping.bean.City;
import com.jizheping.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/getCityByPid",method = RequestMethod.GET)
    public List<City> getCityByPid(Integer pid){

        return cityService.getCityByPid(pid);
    }

    @RequestMapping(value = "/getCityListByIds",method = RequestMethod.GET)
    public List<City> getCityListByIds(@RequestParam("ids") List<Integer> ids){

        return cityService.getCityListByIds(ids);
    }
}
