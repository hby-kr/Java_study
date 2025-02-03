package com.tj703.employees;

import com.tj703.employees.dao.EmployeesDao;
import com.tj703.employees.dao.EmployeesDaoImp;
import com.tj703.employees.dto.EmployeesDto;
import com.tj703.employees.dto.SalariesDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class M07StreamEx2 {
    public static void main(String[] args) throws Exception {

        List<EmployeesDto> empList = null;  // dto가 담겨있는 리스트
        EmployeesDao empDao = new EmployeesDaoImp(); // Dao객체의 메서드 쓰기 위해 객체 생성

        empList = empDao.findwithSalaries(0,10); // 불러오기
        System.out.println(empList);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");


        // 1번 문제 : empList -> List<List<SalariesDto>> 이걸로 변경
        // 2번 문제 : List<List<Integer>> 위의 데이터로 변경
        // 3번 문제 : 전체 급여의 합을 구하라. (reduce)

        List<List<SalariesDto>> sals = empList.stream()
                  .map((emp) -> emp.getSalariesList())
                  .collect(Collectors.toList());
        System.out.println(sals);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");



        List<List<Integer>> salList2 = empList.stream()
                .map((emp) -> emp.getSalariesList())
                .map((salList) -> {
                    List<Integer> s = salList.stream()
                            .map((sal) -> sal.getSalary())
                            .collect(Collectors.toList());
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println(salList2);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");



        //[ 10001010,201010,444444 ..]
        List<Integer> sums = salList2.stream()
                .map((salList) -> {
                    Optional<Integer> sumOpt = salList.stream()
                            .reduce((n1, n2) -> n1 + n2);
                    return sumOpt.get();
                })
                .collect(Collectors.toList());
        System.out.println(sums);


    }
}
