package com.tj703.employees;

import com.tj703.employees.dao.EmployeesDao;
import com.tj703.employees.dao.EmployeesDaoImp;
import com.tj703.employees.dto.EmployeesDto;

import java.util.List;

public class M07StreamEx2 {
    public static void main(String[] args) throws Exception {
        List<EmployeesDto> empList = null;  // dto가 담겨있는 리스트
        EmployeesDao empDao = new EmployeesDaoImp(); // Dao객체의 메서드 쓰기 위해 객체 생성

        empList = empDao.findwithSelaries(0,100); // 불러오기
        System.out.println(empList);
        // 1번 문제 : empList -> List<List<SalariesDto>> 이걸로 변경
        // 2번 문제 : List<List<Integer>> 위의 데이터로 변경
        // 3번 문제 : 전체 급여의 합을 구하라. (reduce)
    }


}
