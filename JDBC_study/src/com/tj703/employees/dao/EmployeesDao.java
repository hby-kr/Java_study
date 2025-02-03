package com.tj703.employees.dao;

import com.tj703.employees.dto.EmployeesDto;
import com.tj703.employees.dto.Order;

import java.util.List;

public interface EmployeesDao {

    // 1:n  ==  one to many  // 한사람이 여러번 봉급을 받은 경우  /  1개의 Employee 와 복수의 Selaries 매칭하는 join 문법
    List<EmployeesDto> findwithSalaries(int start, int size) throws Exception;


    // findwithDepartment는 반대로 N:1, mamy to one  /   복수의 Employees 와 하나의 부서
    List<EmployeesDto> findwithDept (int start, int size, Order.Colunm colunm, Order.Direct direct) throws Exception;


    // 1:1  one to one  /  1개의 table을 2개로 분리한 경우.. 거의없음.
    // 각 사람은 하나의 여권을 가지고 있고, 여권은 한 사람에게만 속합니다.
    List<EmployeesDto> findwithDeptandSalary (int start, int size, Order.Colunm colunm, Order.Direct direct ) throws Exception;


    // 1:N이지만 1:1인 것처럼 출력.
    List<EmployeesDto> findwithSalary(int start, int size, Order.Colunm colunm, Order.Direct direct) throws Exception;


    // N : N  many to many
    // 한 명의 학생이 여러 과목을 수강할 수 있고, 하나의 과목에 여러 학생이 수강할 수 있습니다.





}
