package com.tj703.jdbc;

import java.sql.*;

public class L07AutoClose {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "mysql";
        String driver = "com.mysql.cj.jdbc.Driver";

        String sql = "select * from employees";

        // 자바에서 만들어준 편한 기능이 AutoClose.
        // try-with-resources 구문이라고 하는데,
        // try에 소괄호를 써서 넣는 것.
        // 소괄호 () 안에서 접속 객체를 생성한다.
        // 그러면 자동으로 finally 위치에서 close해준다.
        try (
                Connection conn1 = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn1.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                // 여기서 만들어지는 객체는 모두 close 메서드를 가지고 있어야 한다.
                // String  str = "경민"  / 이런 객체는 여기에 들어갈 수 없음.
        ) {
            Class.forName(driver);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

         /*
         AutoCloseable은 Java 7에서 도입된 인터페이스로, 자원 해제를 자동으로 처리하기 위한 기능을 제공

        try-with-resources 구문
        try-with-resources는 AutoCloseable을 구현한 객체들을 자동으로 닫을 수 있는 try 구문입니다
        try 구문 내에서 AutoCloseable 객체들을 선언하고,
        try 블록이 끝날 때 자동으로 close() 메서드가 호출되어 자원이 안전하게 해제됩니다.
        예외가 발생하더라도 close()가 호출되므로 자원 해제에 문제가 발생하지 않습니다.

        connection pool close()는 접속을 완전히 종료하지 않고, 접속 객체만 반환

        */


    }
}
