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

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public EmployeesDaoImp() throws Exception {
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
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setGender((char) rs.getByte("gender"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmpNo(rs.getInt("emp_no"));
            emp.setBirthDate(rs.getDate("birth_date"));
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
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            dto = new EmployeesDto();
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
    public List<EmployeesDto> findwithSelaries(int start, int size) throws Exception {

        List<EmployeesDto> empList = null;  // EmployeesDto 객체를 여러개 받을 리스트 생성. 얘로 반환할거임
        String sql =
                "select * from employees e " +
                        "inner join salaries s " +
                        "on e.emp_no = s.emp_no " +
                        "limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, size);
        rs = ps.executeQuery();

        empList = new ArrayList<>(); // null이었던 변수에게 실제 인스턴스 만들어주기

        while (rs.next()) {

            int empNo = rs.getInt("emp_no"); // 사원번호 확인

            List<EmployeesDto> emps = empList.stream()
                    .filter(emp -> emp.getEmpNo() == empNo)
                    .collect(Collectors.toList());

            int length = emps.size();

            EmployeesDto emp = emps.get(0); // 없으면 null, 있으면 출력
            List<SalariesDto> salList = null;

            if (length == 0) { // 일치하는게 없으면 새로 만들어서 넣음
                emp = new EmployeesDto();
                emp.setHireDate(rs.getDate("hire_date"));
                emp.setGender((char) rs.getByte("gender"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmpNo(rs.getInt("emp_no"));
                emp.setBirthDate(rs.getDate("birth_date"));

                salList = new ArrayList<>();
                empList.add(emp);

            } else { // null이 아닐 때
                salList = emp.getSalariesList();
            }

            SalariesDto sal = new SalariesDto();
            sal.setEmpNo(rs.getInt("emp_no"));
            sal.setSalary(rs.getInt("salary"));
            sal.setFromDate(rs.getDate("from_date"));
            sal.setToDate(rs.getDate("to_date"));

            salList.add(sal);
            emps.get(0).setSalariesList(salList);


        }

        return empList;
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

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


    @Override
    public List<EmployeesDto> findwithSelary(int start, int size, Order.Colunm colunm, Order.Direct direct) throws Exception {
        List<EmployeesDto> empList = null;

        String sql = "SELECT * FROM employees Natural join salaries " +
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
        EmployeesDaoImp dao = new EmployeesDaoImp();
//        System.out.println(dao.findById(10002));

//        dao.findAll();
//        System.out.println(dao.findwithSelaries(0, 50));

        System.out.println(dao.findwithSelary(1, 10, Order.Colunm.first_name , Order.Direct.ASC));

    }

}
