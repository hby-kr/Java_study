package com.tj703.employees.dao;


import com.tj703.employees.CRUD;
import com.tj703.employees.EmployeesDB;
import com.tj703.employees.dto.EmployeesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

// Connection(in EmployeesDB)  -> DTO -> DAO 순으로 만들어야 한다.
// EmployeesDB는 연결을 위한 정보들을 적어놓는 클래스
// EmployeesDTO는 DAO하는 중에 DB값을 java방식으로 받아올 객체를 만들어 놓는 클래스
// EmployeesDAO는 어플리케이션과 DB, 중간자 역할로 데이터 불러오는 메서드를 만드는 클래스

public class EmployeesDAO implements CRUD<EmployeesDTO> {

    @Override
    public List<EmployeesDTO> findAll() throws Exception {
        return List.of();
    }

    @Override
    public EmployeesDTO findById(int id) throws Exception { // EmployeesDTO 타입을 만들어내는 메서드를 만들거다
        // findById의 id가 emp_no고, 예가 PK이므로, 얘로
        EmployeesDTO dto = null;
        String sql = "select * from employees where emp_no = ?";
        Connection conn = EmployeesDB.getConnecttion();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            dto = new EmployeesDTO();
            dto.setEmpNo(rs.getInt("emp_no"));
            dto.setBirthDate(rs.getDate("birth_date"));
            dto.setFirstName(rs.getString("first_name"));
            dto.setLastName(rs.getString("last_name"));
            dto.setGender((char) rs.getByte("gender"));
            // char 1byte짜리 문자표 번호, byte 1byte 숫자이므로.
            dto.setHireDate(rs.getDate("hire_date"));
        }
        return dto;
    }

    @Override
    public int create(EmployeesDTO obj) throws Exception {
        return 0;
    }

    @Override
    public int update(EmployeesDTO obj) throws Exception {
        return 0;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }



    public static void main(String[] args) throws Exception {
        //jdbc
        CRUD dao=new EmployeesDAO();
        System.out.println(dao.findById(10002));

    }
}
