package tj703.advanced;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//     java.sql.*  ; JDBC패키지, java에서 제공하는 DB접속 클래스 제공

public class M09JDBCEnum {

    enum EmployeeField {
        EMP_NO, FIRST_NAME, LAST_NAME, BIRTH_DATE, HIRE_DATE, GENDER;
        //    public static final String empNo = "EMP_NO";  // 상수
        //    public static final String firstName = "FIRST_NAME";
        //    public static final String lastName = "LAST_NAME";
        //    public static final String birthDate = "BIRTH_DATE";
        //    public static final String hireDate = "HIRE_DATE";
        //    public static final String gender = "GENDER";
        //    public(누구나) static(처음 만들어져서 메모리에 저장) final(불변)
        //    static, JVM이 클래스를 메모리에 로드할 때 static 멤버가 생성
        //            프로그램 실행 중 단 한 번만 생성되며, 프로그램이 종료될 때까지 메모리에 유지
        //    라고 하는 것과 같음

        // 상수의 문제점은 그 타입을 숫자나 문자열로 하는데, 타입으로는 한정영역을 제한하기 너무 큰 제한이라는 것
        // enum에 값을 열거하고, 그 enum자체를 하나의 타입으로 취급하여 그 안의 값을 쓴다.
    }
    enum Direct { // 방향을 정할 enum
            DESC, ASC
    }


    public static void enumTest (EmployeeField field) {
        System.out.println(field.name());
    }

    public static List<String> findEmpbyGender(String gender, EmployeeField order, Direct direct) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/employees"; // jdbc임 mysql이고, 내컴퓨터고, 호스트3306이고, DB는 employees다
        String user = "root";
        String password = "mysql";

        DriverManager driverManager = null; // 동적로딩 방식; 필요할 때만 드라이버를 가져와쓴다.
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from employees WHERE gender= ? ORDER BY " + order +" "+ direct +" limit 0, 30";
        // ORDER BY 다음은 ?로 매개변수로 받을 수 없더라..
        // 왜냐. 그 자리가 칼럼명이라서. 칼럼명을 문자열로 표현하면 칼럼명이 아니라고 인식.
        // 때문에 PreparedStatement를 사용할 수 없다. 그래서 그냥 매개변수를 받게 해놓으면, 다시 sql injection에 위험이 있다.
        // => 해결하는 방법은 enum을 이용하면 더 안전하게 사용가능하다.

        List<String> emplist = new ArrayList<>();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password); // 접속을 하고 나면 쿼리를 실행할 객체를 만들어줌
            // stmt = conn.createStatement();  // 쿼리를 실행할건데 준비해
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gender);
            rs = stmt.executeQuery(sql); // 준비된 쿼리를 실행해서 얻어와

            while (rs.next()) {
                int empNo = rs.getInt("emp_no");
                java.util.Date birthDate = rs.getDate("birth_date");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                // String gender = rs.getString("gender");
                Date hireDate = rs.getDate("hire_date");
                String str = empNo + "|" + birthDate + "|" + firstName + "|" + lastName + "|" + gender + "|" + hireDate;
                // 이 작업을 다른 클래스 작업하고 객체를 만들어서 받는 방식잉 DTO, Data Transfer Object

                emplist.add(str);
            }
            ;
            System.out.println(emplist);


        } catch (Exception e) {
            e.printStackTrace(); // 빨간 글씨로 뜸.
            System.out.println(e.getMessage()); // 그냥 뜸.
        }

        return emplist;
    }

    public static void main(String[] args) {
        System.out.println(findEmpbyGender("M", EmployeeField.FIRST_NAME, Direct.DESC));

        enumTest(EmployeeField.FIRST_NAME);
    }
}
