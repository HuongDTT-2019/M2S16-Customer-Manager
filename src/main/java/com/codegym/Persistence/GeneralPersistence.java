package com.codegym.Persistence;

import java.util.List;

public interface GeneralPersistence<E> {
    List<E> findAll();
    void save(E e);
    E findById(int id);
    E findByName(String name);
    void update(int id, E e);
    void remove(int id);
}
