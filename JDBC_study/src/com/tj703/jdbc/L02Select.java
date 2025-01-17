package com.tj703.jdbc;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class L02Select {

//    전체 흐름 요약
//      1. 데이터베이스 연결 정보 설정.
//      2. MySQL JDBC 드라이버 로드.
//      3. 데이터베이스와 연결을 설정.
//      4. SQL 쿼리를 작성하고 실행.
//      5. 결과 데이터를 읽어서 출력.
//      6. 예외 발생 시 오류를 출력.

    public static void main(String[] args) {

        // 1. 데이터베이스 접속 정보 설정
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "mysql";

        // 2. JDBC 객체 선언
        DriverManager driverManager = null;  // 얘는 쓸 필요 없음.
        Connection conn = null;
        Statement stmt = null; // 쿼리를 실행하는 객체
        ResultSet rs = null; // db에서 반환하는 table 데이터의 type
        // DriverManager는 JDBC 연결을 설정하는 역할만 하므로, 직접 객체로 선언할 필요 없이 getConnection() 메서드를 통해 간접적으로 사용됩니다.
        // DriverManager 역할: JDBC 드라이버를 로드하고, 데이터베이스에 연결을 제공하는 관리자.
        // Connection 객체는 데이터베이스와 연결을 관리하므로, 데이터베이스 연결을 설정한 후에는 Connection을 사용해야 합니다.
        // Connection 역할: 데이터베이스와의 연결을 나타내는 객체
        // Statement는 실제로 SQL 쿼리를 실행하는 역할을 하므로, Connection 객체에서 쿼리를 실행할 준비를 하기 위해 Statement 객체를 생성합니다.
        // Statement 역할: SQL 쿼리를 데이터베이스에 전달하고 실행하는 객체
        // ResultSet은 쿼리 결과를 저장하고 반환하는 역할을 하므로, SQL 실행 후에 그 결과를 받을 객체로 사용됩니다.

        // 3. SQL 쿼리 작성
        String sql = "select * from employees limit 100"; // 질의어 DQL => ResultSet을 반환
        // insert update delete 등은 DML => 몇개 성공했다는 정수를 반환

        // 4. 데이터베이스 접속 및 쿼리 실행
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC 드라이버를 메모리에 로드하는 코드입니다. MySQL에 접속하기 위해 MySQL JDBC 드라이버가 필요합니다.
            // Java 애플리케이션이 MySQL과 같은 데이터베이스에 접속하려면,
            // Java에서는 해당 데이터베이스를 다룰 수 있는 JDBC 드라이버가 필요합니다.
            // 이 드라이버는 Java 애플리케이션과 데이터베이스 간의 통신을 가능하게 해주는 중요한 역할을 합니다.

            // Class.forName()의 역할
            // **com.mysql.cj.jdbc.Driver**라는 클래스를 동적으로 로드하는 메서드입니다.

            // com.mysql.cj.jdbc.Driver는 MySQL의 JDBC 드라이버 클래스입니다.
            // 이 드라이버 클래스는 MySQL 데이터베이스와 연결할 수 있는 기능을 제공하며,
            // JDBC API를 통해 MySQL 데이터베이스에 연결할 수 있도록 도와줍니다.


            // DriverManager를 사용하여 데이터베이스에 실제로 접속합니다.
            // **DriverManager.getConnection()**은 데이터베이스에 연결할 수 있는 방법을 알려줍니다.
            // 접속에 성공하면 conn 객체가 데이터베이스 연결을 관리합니다.
            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement(); // 접속 객체에게 쿼리를 실행할 준비
            // conn 연결을 사용하여 SQL 쿼리를 실행할 준비를 하는 객체인 Statement를 생성합니다.
            // **Connection.createStatement()**는 이 연결을 통해 SQL 쿼리를 실행할 수 있는 방법을 제공합니다.

            rs= stmt.executeQuery(sql);
            // executeQuery는 데이터를 조회하는 쿼리(DQL)를 실행할 때 사용됩니다.
            // excute는 DML실행, executeQuery은 DQL실행
            // 결과는 rs라는 ResultSet 객체에 저장됩니다.
            // Statement.executeQuery()**는 매개변수로 들어간 실제 쿼리를 실행하고, 그 결과를 ResultSet 객체에 담습니다.

            System.out.println(rs); // com.mysql.cj.jdbc.result.ResultSetImpl@3590fc5b
            // 실행된다는 것은 db에 문제없이 접속했다는 뜻.

            /*
            DriverManager는 직접 사용되지 않고 간접적으로 사용됨
            DriverManager는 사실 직접 사용할 일이 거의 없습니다.
            대신, DriverManager.getConnection() 메서드를 통해 데이터베이스 연결을 생성할 때 사용됩니다.
            DriverManager는 데이터베이스 드라이버를 로드하고, 적절한 드라이버를 선택하여 연결을 제공합니다.

            conn = DriverManager.getConnection(url, user, password);
                Connection 객체는 실제로 데이터베이스와 연결된 객체입니다.
                데이터베이스와의 연결을 유지하면서 SQL 쿼리를 실행하고, 그 결과를 반환받는 등의 역할을 합니다.
                이 객체는 데이터베이스와 상호작용하는 핵심입니다.

                DriverManager.getConnection(url, user, password) 메서드는 이 Connection 객체를 반환하며,
                이후 Connection을 통해 SQL 쿼리를 실행하게 됩니다.

            stmt = conn.createStatement();
                Statement 객체는 실제로 SQL 쿼리를 실행하는 역할을 합니다.
                Statement는 SQL 쿼리를 서버에 전달하고, 그 결과를 받는 역할을 합니다.

                conn.createStatement() 메서드를 통해 Statement 객체를 생성합니다.
                Connection 객체에서 createStatement() 메서드를 호출하면,
                SQL 쿼리를 실행할 준비가 된 Statement 객체를 반환합니다.
                이 객체를 사용하여 SQL을 실행할 수 있습니다.

            rs = stmt.executeQuery(sql);
                ResultSet(=rs)은 SQL 쿼리 결과를 저장하는 객체입니다.
                stmt.executeQuery(sql) 메서드를 사용하여 SQL 쿼리를 실행하고,
                그 결과를 ResultSet 객체에 저장합니다.

                ResultSet 객체는 쿼리 결과로 나온 데이터를 순차적으로 읽을 수 있게 해줍니다.
                이 객체를 통해 데이터를 하나하나 읽어와서 처리할 수 있습니다.
            */



            // 5. 결과 출력
            while (rs.next()){
                // rs.next()는 ResultSet에서 한 행(row)을 읽어오는 함수입니다.
                // next()가 true를 반환하면 다음 데이터가 존재한다는 뜻이므로, while문이 반복됩니다.

                // 순서를 기억하고 있다면..
                // int emp_no = rs.getInt(1);
                // 경로를 명확하게 쓰는게 더 정확
                int emp_no = rs.getInt("emp_no");
                Date birth_date = rs.getDate("birth_date");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                Date hire_date = rs.getDate("hire_date");
                String str = emp_no + "|" + birth_date + "|" + first_name + "|" + last_name + "|" + gender + "|" + hire_date;

                System.out.println(str);

            }

        //6. 예외 처리
        } catch (Exception e) {
            e.printStackTrace();
            //try-catch 구문은 예외를 처리하는 코드입니다.
            // 데이터베이스 연결이나 SQL 실행 중에 오류가 발생하면, catch 블록에서 예외를 처리하고,
            // e.printStackTrace()를 통해 오류의 상세 정보를 출력합니다.
        }


/*
간단히 정리
DriverManager: JDBC 드라이버를 로드하고 데이터베이스 연결을 관리.
Connection: 데이터베이스와 연결된 세션을 나타내며, 쿼리 실행을 위한 객체.
Statement: SQL 쿼리를 실행하는 객체. 파라미터 없이 간단한 쿼리를 실행.
PreparedStatement: SQL 쿼리를 미리 준비하고, 파라미터화된 쿼리를 실행. 주로 보안과 성능을 개선.
CallableStatement: 데이터베이스에 저장된 저장 프로시저나 저장 함수를 호출하는 객체.
ResultSet: SQL 쿼리의 실행 결과로 반환된 데이터를 읽는 객체.
 */





    }
}
