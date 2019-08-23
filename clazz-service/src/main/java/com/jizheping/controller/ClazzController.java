package com.jizheping.controller;

import com.jizheping.bean.Clazz;
import com.jizheping.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clazz/")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @RequestMapping("/getClazzList")
    public List<Clazz> getClazzList(){
        return clazzService.getClazzList();
    }
}
