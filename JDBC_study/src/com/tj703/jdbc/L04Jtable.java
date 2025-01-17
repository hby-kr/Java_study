package com.tj703.jdbc;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;

public class L04Jtable {
    // jdbc: 자바로 db서버에 접속하는 도구
    // 수업은 내 컴퓨터에 설치한 mysql db 서버에 접속
    // (다른 서버 컴퓨터에 접속하는 수업을 하려면 방화벽 + 계정 권한을 해결해야 함)
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "mysql";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select * from departments";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager : url에 작성된 db에 접속하기 위해서 필요한 드라이버를 동적로딩 하는 jdbc클래스
            // 동적로딩이란 사용자(DriverManager)가 필요할 때 클래스를 불러와서 객체를 생성하는데 쓰는 것.
            conn = DriverManager.getConnection(url, user, password);
            // my sql 서버 프로그램에 접속하면 쿼리를 실행할 수 있는 객체를 따로 생성해야 함
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // ResultSet은 iterator를 이용해서 자료를 반복 순회해야한다.
            // hasNext() (이 다음 자료가 있어?),  Next() (포인터를 이동해서 자료를 출력)
            // ResultSet.next() : 이 다음에 자료가 있으면 true, 그리고 포인터 이동 후 자료출력
            // ResultSet.next() : 이 다음에 자료가 없으면 false, 그리고 포인터 이동x
            // Set : 중복을 허용하지 않는 자료 객체.
            // 따라서 ResultSet은 열에 중복을 받지 않음.

            List<String[]> data = new ArrayList();

            while (rs.next()) {
                String deptNo = rs.getString("dept_no");
                String deptName = rs.getString("dept_name");
                System.out.println("deptNo = " + deptNo + " | " + "deptName = " + deptName);

                String [] rowdata = {deptNo, deptName};
                data.add(rowdata);
            }


            // ㅡㅡㅡㅡㅡㅡㅡㅡ  j테이블로 출력하기
            String [][] data2 = data.toArray(new String[0][0]);
            String [] columns = {"dept_no", "dept_name"};
            JFrame frame = new JFrame("부서 리스트");
            JTable table = new JTable(data2, columns);
            JScrollPane jsp = new JScrollPane(table);
            JPanel p = new JPanel();
            p.add(jsp);
            frame.add(p);

            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
