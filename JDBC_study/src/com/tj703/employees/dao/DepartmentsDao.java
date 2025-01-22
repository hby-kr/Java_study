package com.tj703.employees.dao;

import com.tj703.employees.CRUD;
import com.tj703.employees.dto.DepartmentsDto;

import java.util.List;

public interface DepartmentsDao extends CRUD<DepartmentsDto,String> {
    DepartmentsDto findByDeptName(String deptName) throws Exception;
    List<DepartmentsDto> findByDeptNameLike(String deptName) throws Exception;
    void close();
}
