package com.tj703.employees;

import java.util.List;

public interface CRUD<T> {
    // 인터페이스는 클래스의 뼈대임
    // T는 제네릭을 매개변수로 설정함
    List<T> findAll () throws Exception;;
    T findById(int id) throws Exception;
    int create(T obj) throws Exception;
    int update(T obj) throws Exception;
    int delete(int id) throws Exception;

}
