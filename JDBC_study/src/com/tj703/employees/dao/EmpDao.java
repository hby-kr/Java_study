package com.tj703.employees.dao;

import com.tj703.employees.CRUD;
import com.tj703.employees.dto.EmployeesDTO;

import java.util.List;

public interface EmpDao extends CRUD<EmployeesDTO> {
    List<EmployeesDTO> findByFirstName () throws Exception;
    List<EmployeesDTO> findByLastName () throws Exception;
}
