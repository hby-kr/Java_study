package com.tj703.jdbc;

import java.sql.*;

public class L06Close {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "mysql";
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        /* 서버에 자바가 접속을 하면, 서버 안에는 자바의 접속 내역을 객체로 만들어서 유지하고 있음.
        conneciton pool : 접속을 매번 새롭게 만들면 느려질 수 있으니, 접속을 유지하게 하는 것.
        그런데 mysql의 동시접속에 제한이 있음. 그럼 db에 접속하지 못하는 사람이 발생.

        자바가 db에 접속해서 필요한 데이터를 호출해서 가져오고 나서
        => 자동으로 서버와 자바에서 접속을 끊고 객체를 삭제..하지 않음.
        => 자동으로 하지 않기에 직접 작성해야 한다.
        => 그것이 close.

        */
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from employees";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // 여기다 쓰기 보다 아래에서 finally로 씀
            //            rs.close();
            //            ps.close();
            //            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // try-catch 이후 무조건 실행하는 블럭.
            try {
                rs.close();  // 작은 순서대로 끈다.
                ps.close();
                conn.close();
                // 일반적으로 ResultSet -> Statement -> Connection 순서로 닫습니다
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }






    }
}
