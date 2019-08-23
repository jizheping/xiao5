package com.jizheping.controller;

import com.jizheping.bean.Hobby;
import com.jizheping.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;

    @RequestMapping("/getHobbyList")
    public List<Hobby> getHobbyList(){
        return hobbyService.getHobbyList();
    }
}
