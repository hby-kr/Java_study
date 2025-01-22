package com.tj703.employees.dao;

import com.tj703.employees.EmployeesDB;
import com.tj703.employees.dto.DepartmentsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDaoImp implements DepartmentsDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    //함수에서 매번 커넥션을 호출하는 것 보다 생성할때 한번 호출하는 것 이 더 좋다.
    public DepartmentsDaoImp() throws Exception {
        conn= EmployeesDB.getConnection();
    }

    @Override
    public DepartmentsDto findByDeptName(String deptName) throws Exception {
        DepartmentsDto dto=null;
        String sql="SELECT * FROM departments WHERE dept_name=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, deptName);
        rs = ps.executeQuery();
        if(rs.next()){
            dto=new DepartmentsDto();
            dto.setDeptNo(rs.getString("dept_no"));
            dto.setDeptName(rs.getString("dept_name"));
        }
        return dto;
    }

    @Override
    public List<DepartmentsDto> findByDeptNameLike(String deptName) throws Exception {
        List<DepartmentsDto> findByDeptNameLike=null;

        String sql="SELECT * FROM departments WHERE dept_name LIKE CONCAT('%',?,'%')";
        ps = conn.prepareStatement(sql);
        ps.setString(1, deptName);
        rs = ps.executeQuery();
        findByDeptNameLike=new ArrayList<>();
        while (rs.next()){
            DepartmentsDto dto=new DepartmentsDto();
            dto.setDeptNo(rs.getString("dept_no"));
            dto.setDeptName(rs.getString("dept_name"));
            findByDeptNameLike.add(dto);
        }
        return findByDeptNameLike;
    }

    @Override
    public List<DepartmentsDto> findAll() throws Exception {
        List<DepartmentsDto> findAll=null;
        String sql="select * from departments";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        findAll=new ArrayList<DepartmentsDto>();
        while(rs.next()){
            DepartmentsDto dto=new DepartmentsDto();
            dto.setDeptNo(rs.getString("dept_no"));
            dto.setDeptName(rs.getString("dept_name"));
            findAll.add(dto);
        }
        return findAll;
    }

    @Override
    public DepartmentsDto findById(String id) throws Exception {
        DepartmentsDto dto=null;
        String sql="SELECT * FROM departments WHERE dept_no=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            dto=new DepartmentsDto();
            dto.setDeptNo(rs.getString("dept_no"));
            dto.setDeptName(rs.getString("dept_name"));
        }
        return dto;
    }

    @Override
    public int create(DepartmentsDto obj) throws Exception {
        int create=0;
        String sql="INSERT INTO departments (dept_no,dept_name) VALUES(?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, obj.getDeptNo());
        ps.setString(2, obj.getDeptName());
        create=ps.executeUpdate();

        return create;
    }

    @Override
    public int update(DepartmentsDto obj) throws Exception {
        int update=0;
        String sql="UPDATE departments SET dept_name=? WHERE dept_no=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1, obj.getDeptName());
        ps.setString(2, obj.getDeptNo());
        update=ps.executeUpdate();
        return update;
    }

    @Override
    public int delete(String id) throws Exception {
        int delete=0;
        String sql="DELETE FROM departments WHERE dept_no=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        delete=ps.executeUpdate();
        return delete;
    }
    public void close(){
        try {
            if(rs!=null)rs.close();
            if(ps!=null)ps.close();
            if(conn!=null)conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DepartmentsDaoImp dao=null;
        try {
            dao=new DepartmentsDaoImp();
            System.out.println(dao.findAll());
            System.out.println(dao.findByDeptName("Human Resources"));
            System.out.println(dao.findByDeptNameLike("Re"));
            //등록 테스트
            DepartmentsDto dto=new DepartmentsDto();
            dto.setDeptName("경민 수업 부서");
            dto.setDeptNo("d111");
            System.out.println(dao.create(dto));
            System.out.println(dao.findById("d111"));

            //수정 테스트
            dto.setDeptName("경민 jdbc 수업");
            System.out.println(dao.update(dto));
            System.out.println(dao.findById("d111"));

            //삭제 테스트
            System.out.println(dao.delete("d111"));
            System.out.println(dao.findById("d111"));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            dao.close();
        }
    }

}
