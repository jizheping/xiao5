package com.jizheping.clazzFeign;

import com.jizheping.bean.Clazz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClazzFeignFallback implements ClazzFeign{
    @Override
    public List<Clazz> getClazzList() {
        System.out.println("fallback");

        return null;
    }
}
