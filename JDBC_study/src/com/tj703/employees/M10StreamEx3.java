package com.tj703.employees;

import com.tj703.employees.dao.EmployeesDaoImp;
import com.tj703.employees.dto.EmployeesDto;
import com.tj703.employees.dto.Order;

import java.util.List;
import java.util.Optional;

public class M10StreamEx3 {

    static int sum = 0;

    public static void main(String[] args) throws Exception {

        EmployeesDaoImp empDao = new EmployeesDaoImp();
        List<EmployeesDto> empList = empDao.findwithSalary(0, 10, Order.Colunm.emp_no, Order.Direct.ASC);
        System.out.println(empList);

        // salary 총합. stream으로 만들기
        empList.stream()
                .forEach((emp) -> {
                    sum += emp.getSalaries().getSalary();
                    // 이 함수가 외부의 필드를 공유하고 있으면, 재사용이 힘들다.
                });
        System.out.println(sum);

        // 같은 기능인데 stream 메서드 사용하기
        //empList.stream().reduce((emp1, emp2)-> { // reduce 매개변수와 반환값의 타입이 같아야 한다.
        Optional<Integer> optSum = empList.stream()
                                        .map(emp -> emp.getSalaries().getSalary())
                                        // .forEach(System.out::println);
                                        .reduce((sal1, sal2) -> sal1 + sal2);
        if (optSum.isPresent()) { // null이 아니면
            System.out.println(optSum.get());
        }


        // filter 사용해서, 사원의 성별이 여성인 사람의 급여의 합을 구하시오.


        // System.out::println
        // = System.out의 메서드인 println를 실행할건데,
        // 콜백함수에서 쓰는 매개변수를 곧장 받아서 다시 메서드에 넣을 때만 사용가능.
        // = (emp) -> { System.out.println(emp) } 과 같은 의미 

    }
}
