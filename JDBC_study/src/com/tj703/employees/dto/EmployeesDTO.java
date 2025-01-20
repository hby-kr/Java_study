package com.tj703.employees.dto;

// Connection(in EmployeesDB)  -> DTO -> DAO 순으로 만들어야 한다.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스

/*
DAO가 데이터베이스와의 실제 통신을 담당한다면,
DTO는 이 과정에서 데이터를 담아 전달하는 컨테이너 역할을 합니다.
이를 통해 데이터 접근 로직과 비즈니스 로직을 분리하여 코드의 유지보수성과 재사용성을 향상시킬 수 있습니다.
 */

import java.util.Date;

public class EmployeesDTO {
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


    // getter setter 만들기
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
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


    @Override
    public String toString() {
        return "{" +
                "empNo=" + empNo +
                ", birthDate:" + birthDate +
                ", firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", gender:" + gender +
                ", hireDate:" + hireDate +
                "}\n";
    }
}
