package com.jizheping.hobbyFeign;

import com.jizheping.bean.Hobby;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "hobby-service",fallback = HobbyFeignFallback.class)
public interface HobbyFeign {
    @RequestMapping("/hobby/getHobbyList")
    public List<Hobby> getHobbyList();
}
