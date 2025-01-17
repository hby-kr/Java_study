package com.tj703.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Study01DeptSelect {
    // employees.departments 를 출력하기 실습
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "mysql";

        DriverManager driverManager = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select * from departments";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(rs);  // 작동하나 확인 / com.mysql.cj.jdbc.result.ResultSetImpl@7b98f307

            while (rs.next()) {

                String dept_no = rs.getString("dept_no");
                String dept_name = rs.getString("dept_name");

                String str = dept_no + "\t" + dept_name;
                System.out.println(str);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
