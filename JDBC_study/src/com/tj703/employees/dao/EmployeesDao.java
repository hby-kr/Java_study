package com.tj703.employees.dao;

import com.tj703.employees.CRUD;
import com.tj703.employees.EmployeesDB;
import com.tj703.employees.dto.EmployeesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

// DAO를 따로 클래스로 만드는 이유. 이를 통해 데이터 접근 로직과 비즈니스 로직을 분리하여 코드의 유지보수성과 재사용성을 향상시킬 수 있습니다.

//DAO가 데이터베이스와의 실제 통신을 담당한다면,
//DTO는 이 과정에서 데이터를 담아 전달하는 컨테이너 역할을 합니다.

// Connection(in EmployeesDB)-> DTO                        -> DAO 순으로 만들어야 한다.
// 접속할 정보를 적고           -> 접속해서 데이터받을 객체 만들고 -> 접속을 작업을 설계.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스

public class EmployeesDao implements CRUD<EmployeesDto, Integer> {

    @Override
    public List<EmployeesDto> findAll() throws Exception {
        return List.of();
    }

    @Override
    public EmployeesDto findById(Integer id) throws Exception {
        EmployeesDto dto=null;
        String sql="select * from employees where emp_no=?";
        Connection conn= EmployeesDB.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            dto=new EmployeesDto();
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



    public static void main(String[] args) throws Exception {
        //jdbc
        CRUD dao=new EmployeesDao();
        System.out.println(dao.findById(10002));

    }
}
