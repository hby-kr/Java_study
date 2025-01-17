package com.tj703.jdbc;

import javax.swing.*;
import java.sql.*;

class DeptEmpDao {
    // DAO, DB access object, db접근객체


    // jdbc 만들기 사전준비
    private String url = "jdbc:mysql://localhost:3306/employees";
    private String user = "root";
    private String password = "mysql";

    private Connection conn = null;
    // Statement stmt = null;   // Statement는 쿼리를 실행하는 객체
    private PreparedStatement ps = null;
    // PreparedStatement는 쿼리를 실행하기 위해 파라미터 준비를 도와주는 객체
    // 쿼리문을 실행할 때 실제 값을 나중에 넣을 수 있도록 자리 표시자 역할을 합니다.
    private ResultSet rs = null;

    private String driver = "com.mysql.cj.jdbc.Driver";


    // 메서드 만들기
    public String[][] findDeptEmp(int start, int size) throws Exception {

        String[][] findDeptEmp = null;
        //ex. { {"d007", 10001, "경민", "sales"}, {"d007", 10001, "경민", "sales"}} 이렇게 만들자.(2차원배열)

        findDeptEmp = new String[size][]; // 처음 길이만 정해주면 되니까 size가 매개변수로 들어갔고, 뒤는 쓸 때하면됨

        // String sql = "select * from dept_emp limit ?,?";  여기 물음표가 prepareStatement임.
        // int start, int size를 ?에 대입하는 것이 prepareStatement임
        // 왜 쓰는가? start, size가 sql의 쿼리로 들어가는 매개변수인데,
        // (보안측면에서 해커는) 그 자리에 다른 명령어를 써서 db를 망칠 수 있음
        // 그래서 prepareStatement라는 도구로 매개변수의 "타입을 규정"해서 다른 작업을 못하게 막는 기능을 함.
        // 다시말해 SQL 인젝션(SQL Injection)을 막기 위해.
        // SQL 인젝션(SQL Injection)란 공격자가 악의적인 SQL 코드를 사용자 입력값에 삽입하여 데이터베이스를 공격하는 기법


        String sql = "select *" +
                " from dept_emp de INNER JOIN departments d" +
                " on de.dept_no = d.dept_no " +
                // ORDER BY 쓰려면 여기에.
                "limit ?,?";


        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        ps = conn.prepareStatement(sql); // "타입을 규정"하는 것이 여기임
        ps.setInt(1, start); // 첫번째 물음표에 start 넣을거야
        ps.setInt(2, size); // 두번째 물음표에 size 넣을거야
        rs = ps.executeQuery();

        int i = 0;
        //rs는 한 행이므로 while 반복사용
        while (rs.next()) {
            int empNo = rs.getInt("emp_no");
            String deptNo = rs.getString("dept_no");
            String deptName = rs.getString("dept_name");

            // String [] arr = {deptNo, empNo+""}; // int를 string으로 바꾸기1
            String[] arr = {deptNo, deptName, Integer.toString(empNo)}; // int를 string으로 바꾸기2

            findDeptEmp[i++] = arr;
        }
        return findDeptEmp;
    }
}


public class L05PreparedStatement {
    public static void main(String[] args) {

        DeptEmpDao dao = new DeptEmpDao();

        try { // 클래스에서 오류위임 했으니 여기서 관리하기.
            String data[][] = dao.findDeptEmp(110, 50);

//            for(String d[] : data) {
//                for (String str : d) {
//                    System.out.println(str+",");
//                }
//                System.out.println();
//            }

            JFrame frame = new JFrame();
            JTable table = new JTable(data, new String[]{"부서번호", "부서이름", "사원번호"}); // 매개변수 넣는 방식은 약속임.
            JScrollPane jsp = new JScrollPane(table);
            JPanel panel = new JPanel();
            panel.add(jsp);
            frame.add(panel);
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
