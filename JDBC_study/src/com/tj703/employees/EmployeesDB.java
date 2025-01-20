package com.tj703.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import com.mysql.cj.jdbc.Driver; 이거 안하고 동적로딩 한거임

// Connection(in EmployeesDB)  -> DTO -> DAO 순으로 만들어야 한다.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스
public class EmployeesDB {
    private static final String URL = "jdbc:mysql://localhost:3306/employees";
    // url이 바뀌지 않게 final. 상수는 대문자로만 쓴다.
    // 밑에 메서드도 static이므로 거기서 참조할 필드들도 static으로 선언해줘야 한다.
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // 동적로딩

    private static Connection connection = null;
    // 싱글톤 패턴에선 접속을 계속 유지하는 connection pool에 적합한 클래스가 아니..지만 (이건 추후에 설명)

    public static Connection getConnecttion () throws Exception {
        if(connection != null && !connection.isClosed() ) { return connection;} // return하면 여기서 함수 종료.
        // 위는 싱글톤 패턴에서 꼭 구현해야 하는 코드
        Class.forName(DRIVER_CLASS);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception { // 여기가 tdd니까 try-catch 안하고 그냥 진행하는 것.
        // test를 하면서 개발을 진행하는 것을 TDD; Test Driven Development라 부른다.
        // test main :  TDD를 도와주는 도구없이 main에서 진행

        Connection conn = EmployeesDB.getConnecttion();
        System.out.println(conn); // Connection test 하는 것.


    }
}
