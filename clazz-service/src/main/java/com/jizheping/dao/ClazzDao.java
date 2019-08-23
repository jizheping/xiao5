package com.jizheping.dao;

import com.jizheping.bean.Clazz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClazzDao extends CrudRepository<Clazz,Integer> {
    @Override
    <S extends Clazz> S save(S s);

    @Override
    <S extends Clazz> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Clazz> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    List<Clazz> findAll();

    @Override
    Iterable<Clazz> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Clazz clazz);

    @Override
    void deleteAll(Iterable<? extends Clazz> iterable);

    @Override
    void deleteAll();
}
