package com.tj703.employees.dao;

import com.tj703.employees.CRUD;
import com.tj703.employees.dto.DepartmentsDto;
import com.tj703.employees.dto.DeptField;
import com.tj703.employees.dto.Order;

import java.util.List;

public interface DepartmentsDao extends CRUD<DepartmentsDto,String> {
    DepartmentsDto findByDeptName(String deptName) throws Exception;
    List<DepartmentsDto> findByDeptNameLike(String deptName) throws Exception;

    // enum 만들기
    List<DepartmentsDto> findAll(DeptField field, Order.Direct direct, int index, int size) throws Exception;

    void close();
}
