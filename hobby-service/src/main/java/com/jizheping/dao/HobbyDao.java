package com.jizheping.dao;

import com.jizheping.bean.Hobby;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HobbyDao extends CrudRepository<Hobby,Integer> {
    @Override
    List<Hobby> findAll();
}
