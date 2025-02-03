package com.tj703.employees.dto;

import java.util.Date;

public class SalariesDto {

    // 1. 필드_속성 선언
    //    employees.salaries.emp_no
    //    employees.salaries.salary
    //    employees.salaries.from_date
    //    employees.salaries.to_date
    private int empNo;
    private int Salary;
    private Date fromDate;
    private Date toDate;


    // 2. getter setter 만들기
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getSalary() {
        return Salary;
    }
    public void setSalary(int salary) {
        Salary = salary;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


    // 3. toString 만들기
    @Override
    public String toString() {
        return "{" +
                "empNo: " + empNo +
                ", Salary: " + Salary +
                ", fromDate: " + fromDate +
                ", toDate: " + toDate + '}';
    }
}
