package com.tj703.employees.dto;

// DAO를 따로 클래스로 만드는 이유. 이를 통해 데이터 접근 로직과 비즈니스 로직을 분리하여 코드의 유지보수성과 재사용성을 향상시킬 수 있습니다.

//DAO가 데이터베이스와의 실제 통신을 담당한다면,
//DTO는 이 과정에서 데이터를 담아 전달하는 컨테이너 역할을 합니다.

// Connection(in EmployeesDB)-> DTO                        -> DAO 순으로 만들어야 한다.
// 접속할 정보를 적고           -> 접속해서 데이터받을 객체 만들고 -> 접속을 작업을 설계.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스

import java.util.Date;
import java.util.List;

public class EmployeesDto {
    /* employees db의 열 복붙
    employees.employees.emp_no
    employees.employees.birth_date
    employees.employees.first_name
    employees.employees.last_name
    employees.employees.gender
    employees.employees.hire_date
     */
    // 똑같이 만들기. db로 받을 값을 java 객체로 받을 수 있게, 클래스의 필드를 만드는 것
    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private char gender;
    private Date hireDate;

    // getter setter 만들기 (자동화)
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
        // 여기 this 왜 씀? 매개변수의 이름과 현재 클래스의 필드이름이 같기 때문.
        // 잘 보면 set일 때만, 매개변수가 필요하고, 그때마다 필드명과 같기 때문에
        // 필드에게 this를 붙여서 "this.empNo"랑 매개변수 "empNo"랑 다른 애야.라고 말하는 것.
        // 즉, this는 필드와 매개변수가 같은 이름을 가질 때만 필요
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // SalariesDto 따로 만들었고, 그것을 employee 안에 넣으려고 하기 있으므로,
    // dto에 SalariesDto가 들어갈 수 있는 자리를 만들어주기

    // emp : sal = 1 : n   join 임
    // 사원이 복수의 급여정보를 가지고 있다.

    // 필드 선언
    //1:n인데 1:1인거처럼 출력
    private SalariesDto salaries;
    private List<SalariesDto> salariesList;
    // 하나의 사람 정보에, 여러 봉급값을 넣을려고 하는 것. list 안에 다시 list 넣는 것.

    // 매서드 구현
    public SalariesDto getSalaries() {
        return salaries;
    }
    public void setSalaries(SalariesDto salaries) {
        this.salaries = salaries;
    }

    public List<SalariesDto> getSalariesList() {
        return salariesList;
    }
    public void setSalariesList(List<SalariesDto> salariesList) {
        this.salariesList = salariesList;
    }

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // N : 1
    private DepartmentsDto departments;

    public DepartmentsDto getDepartments() {
        return departments;
    }
    public void setDepartments(DepartmentsDto departments) {
        this.departments = departments;
    }



    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @Override
    public String toString() {
        return "{" +
                "empNo: " + empNo +
                ", birthDate: " + birthDate +
                ", firstName: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", gender: " + gender +
                ", hireDate: " + hireDate +
                ", salariesList: " + salariesList +
                ", salaries: " + salaries +
                ", departments: " + departments +
                "}\n";
    }
}
