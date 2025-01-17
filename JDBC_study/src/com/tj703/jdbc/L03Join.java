package com.tj703.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

class DeptEmp {

    private String url = "jdbc:mysql://localhost:3306/employees";
    private String user = "root";
    private String password = "mysql";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    // DQL => find로 많이 명명함
    public String findAll() throws Exception {
        // throws Exception : 예외위임. 이 함수를 사용하는 쪽에서 try-catch 예외처리하라.

        String findAll = null; // 오류가 뜨면 null이 반환되라고, null로 잡는게 좋은 선택
        String sql = "select * from dept_emp limit 10";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        System.out.println(rs); // 실행된다는 것은 db에 문제없이 접속했다는 뜻.

        findAll = "";
        while (rs.next()) {
            int empNo = rs.getInt("emp_no");
            String deptNo = rs.getString("dept_no");
            Date fromDate = rs.getDate("from_date");
            Date toDate = rs.getDate("to_date");

            findAll += empNo + "," + deptNo + "," + fromDate + "," + toDate + "\n";
            // 문자열 더하기는 메모리를 많이 씀
        }
        return findAll;
    };


    public String findDept(int limit) throws Exception {
        String findDept = null;
        String sql = "select * from dept_emp NATURAL JOIN departments limit 0," + limit;

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int empNo = rs.getInt("emp_no");
            String deptNo = rs.getString("dept_no");
            Date fromDate = rs.getDate("from_date");
            Date toDate = rs.getDate("to_date");
            String deptName = rs.getString("dept_name");

            findDept += empNo + "," + deptNo + "," + deptName + "," + fromDate + "," + toDate + "\n";
        }
        return findDept;
    }

}

public class L03Join {
    public static void main(String[] args) {

        DeptEmp detpemp = new DeptEmp();
        try {
            System.out.println(detpemp.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DeptEmp detpemp1 = new DeptEmp();
        try {
            System.out.println(detpemp1.findDept(20));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
