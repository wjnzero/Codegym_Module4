package com.codegym.cms.service;

import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    Iterable<T> findAll(Sort sort);
}
