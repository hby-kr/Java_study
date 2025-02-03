package com.tj703.employees;

import java.util.List;

public interface CRUD<T,E> {
    List<T> findAll() throws Exception;
    T findById(E id) throws Exception;

    int create(T obj) throws Exception;
    int update(T obj) throws Exception;
    int delete(E id) throws Exception;
}
