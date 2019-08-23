package com.jizheping.clazzFeign;

import com.jizheping.bean.Clazz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "clazz-service",fallback = ClazzFeignFallback.class)
public interface ClazzFeign {
    @RequestMapping("/clazz/getClazzList")
    public List<Clazz> getClazzList();
}
