package com.tj703.employees.dao;

import com.tj703.employees.CRUD;
import com.tj703.employees.EmployeesDB;
import com.tj703.employees.dto.DepartmentsDto;
import com.tj703.employees.dto.EmployeesDto;
import com.tj703.employees.dto.Order;
import com.tj703.employees.dto.SalariesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// DAO를 따로 클래스로 만드는 이유. 이를 통해 데이터 접근 로직과 비즈니스 로직을 분리하여 코드의 유지보수성과 재사용성을 향상시킬 수 있습니다.

// DAO가 데이터베이스와의 실제 통신을 담당한다면,
// DTO는 이 과정에서 데이터를 담아 전달하는 컨테이너 역할을 합니다.

// Connection(in EmployeesDB)-> DTO                        -> DAO 순으로 만들어야 한다.
// 접속할 정보를 적고           -> 접속해서 데이터받을 객체 만들고 -> 접속을 작업을 설계.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스


public class EmployeesDaoImp implements CRUD<EmployeesDto, Integer>, EmployeesDao {

    // 필드
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
//    ResultSet은 JDBC에서 SQL 쿼리 결과를 다룰 때 사용하는 객체로,
//    데이터베이스에서 가져온 행(row)을 반복하면서 각 컬럼의 값을 읽을 수 있는 메서드들을 제공합니다.
//    이 메서드들은 ResultSet 객체에서 결과를 조회하는 데 사용됩니다.


    // 이하 메서드
    public EmployeesDaoImp() throws Exception { // 생성자 만들면서 연결을 하게끔 하는 것.
        conn = EmployeesDB.getConnection();
    }


    @Override
    public List<EmployeesDto> findAll() throws Exception {

        List<EmployeesDto> empList = null;

        String sql = "select * from employees limit 100";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        empList = new ArrayList<EmployeesDto>();

        while (rs.next()) {
            EmployeesDto emp = new EmployeesDto();
            // dto에서 만들어 놓은 setter 써서 값 넣기
            emp.setEmpNo(rs.getInt("emp_no"));
            emp.setBirthDate(rs.getDate("birth_date"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setGender((char) rs.getByte("gender"));
            //        char 타입이 0부터 255까지의 정수 값을 문자로 표현할 수 있기 때문에 가능한 변환입니다.
            emp.setHireDate(rs.getDate("hire_date"));

            empList.add(emp);
        }
        return empList;
    }


    @Override
    public EmployeesDto findById(Integer id) throws Exception {

        EmployeesDto dto = null;

        String sql = "select * from employees where emp_no=?";
        Connection conn = EmployeesDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id); // 첫 번째 물음표에 매개변수 "id" 값을 설정
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            dto = new EmployeesDto();
            // dto에서 만들어 놓은 setter 써서 값 넣기
            dto.setEmpNo(rs.getInt("emp_no"));
            dto.setBirthDate(rs.getDate("birth_date"));
            dto.setFirstName(rs.getString("first_name"));
            dto.setLastName(rs.getString("last_name"));
            dto.setGender((char) rs.getByte("gender"));
            //char 1byte 짜리 문자표 번호, byte 1byte 숫자 ('a'==97)
            dto.setHireDate(rs.getDate("hire_date"));
        }
        return dto;
    }

    @Override
    public int create(EmployeesDto obj) throws Exception {
        return 0;
    }

    @Override
    public int update(EmployeesDto obj) throws Exception {
        return 0;
    }

    @Override
    public int delete(Integer id) throws Exception {
        return 0;
    }



    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // emp : sal = 1 : n   join 임
    // 사원이 복수의 급여정보를 가지고 있다.
    @Override
    public List<EmployeesDto> findwithSalaries(int start, int size) throws Exception {

        List<EmployeesDto> empList = null;  // EmployeesDto 객체를 여러개 받을 리스트 생성. 얘로 반환할거임

        String sql = "select * from employees e " +
                        "inner join salaries s " +
                        "on e.emp_no = s.emp_no " +
                        "limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, size);
        rs = ps.executeQuery();

        empList = new ArrayList<>(); // null이었던 변수에게 실제 인스턴스 만들어주기

        while (rs.next()) {

            // ResultSet(rs)에서 emp_no 컬럼의 값을 가져와 empNo 변수에 저장
            int empNo = rs.getInt("emp_no"); // 사원번호 확인해봐 10001, ...,  10002, ..., 10003하겠지

            boolean exist = false; // 초기값 설정
            EmployeesDto emp = null; // 초기 변수 선언

            for (EmployeesDto dto : empList) { // 첫 행, 두째 행, 각 행이 들어올 때마다(while) 이 반복문을 진행할건데,

                // 첫번째는 없겠지만, 두번째부터는 있을 것
                // 왜냐 1:n이므로 한 명의 사원이 여러번 받은 월급 리스트가 두번재부터 뜰거니까.
                if (dto.getEmpNo() == empNo) {
                    // empList에 들어있는 dto에서 getter로 가져온 EmpNo 값과 새로 가져온 empNo값이 같으면 실행
                    // 다르면(즉 없으면) 안 실행
                    emp = dto; // 그 DTO객체를 만든 emp에 참조시켜
                    exist = true; // 존재하지까 true로 바뀜
                    break; //반복문을 종료
                }
            }

            List<SalariesDto> salList = null;

        // 한 사원의 정보가 맨 처음 없으면 만들고, 있으면 초기작업은 넘기고 그 다음부터 하자.
            if (!exist) { // exist가 false면 실행 = 일치하는게 없으면 새로 만들어서 넣음
                emp = new EmployeesDto(); // 새 dto 객체를 만들고,

                // 새 값을 넣는 첫 작업을 진행함
                emp.setEmpNo(empNo);
                emp.setBirthDate(rs.getDate("birth_date"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setGender((char) rs.getByte("gender"));
                emp.setHireDate(rs.getDate("hire_date"));

                salList = new ArrayList<>();
                emp.setSalariesList(salList);
                empList.add(emp);

            } else { // null이 아닐 때, 기존에 사원정보가 있으면
                salList = emp.getSalariesList(); // List를 getter로 불러와 그냥 참조시킨다.
            }

        // 리스트 안 객체로 또하나의 봉급 리스트를 만드는 작업
            SalariesDto sal = new SalariesDto(); // 봉급 dto 객체 하나 만들고.
            // 초기 작업
            sal.setEmpNo(rs.getInt("emp_no"));
            sal.setSalary(rs.getInt("salary"));
            sal.setFromDate(rs.getDate("from_date"));
            sal.setToDate(rs.getDate("to_date"));

            salList.add(sal);
        }

        return empList;
    }

    
    
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ enum 사용하는것 연습 메서드
    @Override
    public List<EmployeesDto> findwithDept(int start, int size, Order.Colunm colunm, Order.Direct direct) throws Exception {
        List<EmployeesDto> empList = null;

        String sql = "SELECT e.*, d.* FROM employees e" +
                "Natural join dept_emp de" +
                "Natural join departments d" +
                " order by " + colunm +  " "+ direct +
                " limit ?,?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, size);
        rs = ps.executeQuery();

        empList = new ArrayList<>();

        while (rs.next()) {
            EmployeesDto emp = new EmployeesDto();

            emp.setEmpNo(rs.getInt("emp_no"));
            emp.setBirthDate(rs.getDate("birth_date"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setGender((char) rs.getByte("gender"));
            emp.setHireDate(rs.getDate("hire_date"));

            DepartmentsDto dept = new DepartmentsDto();
            dept.setDeptNo(rs.getString("dept_no"));
            dept.setDeptName(rs.getString("dept_name"));
            emp.setDepartments(dept);
            empList.add(emp);
        }
        return empList;
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ enum 사용하는것 연습 메서드
    @Override
    public List<EmployeesDto> findwithSalary(int start, int size, Order.Colunm colunm, Order.Direct direct) throws Exception {

        List<EmployeesDto> empList = null;

        String sql = "SELECT * FROM employees " +
                    "Natural join salaries " +
                    " order by " + colunm +  " "+ direct +
                    " limit ?,?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, size);
        rs = ps.executeQuery();

        empList = new ArrayList<>();

        while (rs.next()) {
            EmployeesDto emp = new EmployeesDto();
            emp.setEmpNo(rs.getInt("emp_no"));
            emp.setBirthDate(rs.getDate("birth_date"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setGender((char) rs.getByte("gender"));
            emp.setHireDate(rs.getDate("hire_date"));

            SalariesDto sal = new SalariesDto();
            sal.setEmpNo(rs.getInt("emp_no"));
            sal.setSalary(rs.getInt("salary"));
            sal.setFromDate(rs.getDate("from_date"));
            sal.setToDate(rs.getDate("to_date"));

            emp.setSalaries(sal);
            empList.add(emp);
        }
        return empList;
    }



    @Override
    public List<EmployeesDto> findwithDeptandSalary(int start, int size, Order.Colunm colunm, Order.Direct direct) {
        List<EmployeesDto> empList = null;

        return empList;
    }


    public static void main(String[] args) throws Exception {
        //jdbc
        // 테스트 하는 메인 메서드

        // EmployeesDaoImp dao = new EmployeesDaoImp();

        // System.out.println(dao.findById(10002));
        // dao.findAll();
        // System.out.println(dao.findwithSelaries(0, 50));
        // System.out.println(dao.findwithSalary(1, 10, Order.Colunm.first_name , Order.Direct.ASC));


    }
}
