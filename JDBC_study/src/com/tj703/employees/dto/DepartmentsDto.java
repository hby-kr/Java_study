package com.tj703.employees.dto;

public class DepartmentsDto {
    String deptNo;
    String deptName;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "{" +
                "\"deptNo\" : \"" + deptNo + '\"' +
                ", \"deptName\" : \"" + deptName + '\"' +
                "}\n";
    }
}
