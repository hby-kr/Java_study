package com.tj703.employees;

import com.tj703.employees.dao.EmployeesDaoImp;
import com.tj703.employees.dto.EmployeesDto;

import java.util.ArrayList;
import java.util.List;

public class M06StreamEx {
    public static void main(String[] args) throws Exception {
        // 매번 sql문법 쿼리로 데이터를 불러오는게 아니고, 한번에 크게 불러와서
        // jdbc쪽에서 한번더 필터링 작업을 해서 사용하는 법.

        EmployeesDaoImp empDao = new EmployeesDaoImp();
        List<EmployeesDto> empList = empDao.findAll();
        System.out.println(empList);

        // int empNoArr = [] // 길이를 알 수 없으므로, 배열 못함
        List<Integer> empNoList = new ArrayList<>();
        for (EmployeesDto emp : empList) {
            if(emp.getGender() == 'M'){
                empNoList.add(emp.getEmpNo());
            };
        };
        System.out.println(empNoList.size());
        System.out.println(empNoList);

        empList.stream()
                .filter( emp -> emp.getGender() == 'M')
                .map(emp -> emp.getEmpNo())
                .forEach(emp -> System.out.println(emp));








    }
}
