package com.jizheping.hobbyFeign;

import com.jizheping.bean.Hobby;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HobbyFeignFallback implements HobbyFeign{
    @Override
    public List<Hobby> getHobbyList() {
        System.out.println("hobbyFeign fall back");

        return null;
    }
}
