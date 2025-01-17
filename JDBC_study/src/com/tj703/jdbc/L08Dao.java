package com.tj703.jdbc;
// DAO (Data Access Object)는 DB와 애플리케이션 간의 데이터 상호작용을 관리하는 클래스를
// 어떻게 디자인할 것인가하는 전형적인 패턴를 부르는 명칭.
// DAO를 통해서 DB상호작용 작업을 캡슐화하고, 애플리케이션 로직과 데이터 액세스 로직을 분리하여
// 코드가 깔끔하고 유지보수하기 쉽게 만드는 것.

/*
DAO의 기본 구조
    1. DAO 인터페이스 (인터페이스): 데이터를 조회하거나 저장하는 메서드의 형태만 정의하고, 실제 로직은 나중에 구현
    2. DAO 구현 클래스 (클래스): DAO 인터페이스에서 정의한 메서드를 실제로 구현하는 클래스
    3. DTO (Data Transfer Object): 데이터베이스에서 가져온 결과 데이터를 담는 객체
        예를 들어, 데이터베이스에서 "사람" 정보를 가져온다면,
        이 정보를 담을 Person이라는 클래스를 만들 수 있습니다.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 여기서는 클래스를 직접만드는 것부터 시작.
class DepartmentDao {

    private static String url = "jdbc:mysql://localhost:3306/employees";
    private static String user = "root";
    private static String password = "mysql";

    private static Connection conn; //  데이터베이스 연결 객체 만들어 놓기
        // static은 메모리를 분석하는 과정에서 객체로 만들게 됨
        // static: 메소드 메모리 영역에 저장되어서 사용하지 않는 객체도 정리하지 않고 유지됨.
        // non static : 힙메모리 영역에 저장되어 사용 안할 경우 가비지 컬랙션이 정리해버림.

    // 데이터베이스와 연결하는 메서드
    public static Connection getConnection() throws Exception {
        if (conn != null && !conn.isClosed()) { // null이 아니고, close상태가 아니면, 연결되어 있다는 말.
            // 그러니 그냥 conn을 반환하면 되지.
            return conn;
        }
        // 또는 접속 안된 상태면 접속 시켜라.
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }


    // DB에 접속에서 하는 일은 주로 4가지. CRUD; CREATE READ UPDATE DALETE
    // DTO 만들어라. = 데이터베이스에서 가져온 데이터를 저장할 객체

    static class DepartmentDto {
        // 하나의 레코드나 여러 레코드를 Java 객체로 표현합니다.
        // mysql에 저장된 데이터 타입과 유사한 java type을 골라서 정의한다. (ResultSet에서 형변환 후 대입)
        // char, varchar => String
        // mysql date => java.util.date

        // 각 부서 정보는 dept_no와 dept_name 속성을 가집니다
        private String deptNo;
        private String deptName;


        // Constructor, Getters, and Setters  // 막아놓고 구멍 열어놓는 것 => 캡슐화
        public String getDeptNo() {
            return this.deptNo;
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

        // 부서 정보 출력 메서드 (오버라이드된 toString 메서드)
        @Override
        public String toString() {
            return "DepartmentDto{" +
                    "deptNo='" + deptNo + '\'' +
                    ", deptName='" + deptName + '\'' +
                    '}';
        }
    }

    // PreparedStatement와 ResultSet 객체 선언
    PreparedStatement pst = null;
    ResultSet rs = null;

    // 모든 부서 정보를 조회하는 메서드
    public List<DepartmentDto> findAll() throws Exception {

        // 부서 정보를 저장할 리스트 선언
        List<DepartmentDto> findAll = null;

        String sql = "select * from departments";
        conn = getConnection(); // 데이터베이스 연결
        pst = conn.prepareStatement(sql); // SQL 쿼리 준비
        rs = pst.executeQuery(); // 쿼리 실행하여 결과를 가져옴 번호 설정

        findAll = new ArrayList<>(); // 부서 정보를 담을 리스트 초기화

        while (rs.next()) {
            DepartmentDto dto = new DepartmentDto(); // 새로운 DTO 객체 생성
            // DTO 객체는 데이터베이스에서 하나의 행을 의미
            dto.setDeptNo(rs.getString("dept_no"));
            dto.setDeptName(rs.getString("dept_name"));
            // String deptName = rs.getString("deptName");  / 이렇게 안하고 위처럼 함.
            findAll.add(dto); // 전체 리스트에 DTO 인스턴스 객체 추가
            // 이거랑 l05 PreparedStatment와 비교하면 됨.
        }
        return findAll;
        // findAll 메서드는 여러 개의 DTO 객체들이 모여 있는 리스트를 반환
    //findAll 메서드에서 ResultSet을 순차적으로 읽으면서 각 행을 DepartmentDto 객체로 변환하고,
    // 이를 List<DepartmentDto> 형태로 반환하는 구조입니다.
    }

    // 부서 정보를 추가하는 메서드 (아직 구현되지 않음)
    public int create(DepartmentDto departmentDto) throws Exception {
        return 0;
    }
    // 부서 정보를 수정하는 메서드 (아직 구현되지 않음)
    public int update(DepartmentDto departmentDto) throws Exception {
        return 0;
    }
    // 부서 정보를 삭제하는 메서드 (아직 구현되지 않음)
    public int delete(int dept_no) throws Exception {
        return 0;
    }

}

/*
DepartmentDao 클래스 안에 정의된 속성, 내장 클래스, 메서드를 간략히 묶어서 나열
1. 속성 (필드):
    private static String url: 데이터베이스 연결 URL.
    private static String user: 데이터베이스 사용자명.
    private static String password: 데이터베이스 비밀번호.
    private static Connection conn: 데이터베이스 연결 객체.
2. 내장 클래스 (DepartmentDto):
    private String deptNo: 부서 번호.
    private String deptName: 부서 이름.
    2-2 메서드:
        getDeptNo(): 부서 번호를 반환.
        setDeptNo(String deptNo): 부서 번호를 설정.
        getDeptName(): 부서 이름을 반환.
        setDeptName(String deptName): 부서 이름을 설정.
        toString(): 부서 정보를 문자열로 반환 (부서 번호와 이름 포함).
3. 메서드 (함수):
    public static Connection getConnection() throws Exception: 데이터베이스 연결을 반환하는 메서드.
    public List<DepartmentDto> findAll() throws Exception: 모든 부서 정보를 조회하여 List<DepartmentDto>로 반환.
    public int create(DepartmentDto departmentDto) throws Exception: 부서를 추가하는 메서드 (미구현).
    public int update(DepartmentDto departmentDto) throws Exception: 부서를 수정하는 메서드 (미구현).
    public int delete(int dept_no) throws Exception: 부서를 삭제하는 메서드 (미구현)

 */



public class L08Dao {
    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao(); // DepartmentDao 객체 생성

        try {
            // findAll() 메서드를 호출하여 부서 정보를 조회하고 출력
            System.out.println(dao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
