package com.codegym.Service;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAll();
    void save(E e);
    E findById(int id);
    E findByName(String name);
    void update(int id, E e);
    void remove(int id);
}
