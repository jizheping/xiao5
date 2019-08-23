package com.jizheping.dao;

import com.jizheping.bean.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CityDao extends CrudRepository<City,Integer> {
    @Query(value = "select * from city where pid = ?1",nativeQuery = true)
    List<City> getCityByPid(Integer pid);

    @Override
    <S extends City> S save(S s);

    @Override
    <S extends City> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<City> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<City> findAll();

    @Override
    List<City> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(City city);

    @Override
    void deleteAll(Iterable<? extends City> iterable);

    @Override
    void deleteAll();
}
