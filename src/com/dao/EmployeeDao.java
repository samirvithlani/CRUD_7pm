package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bean.EmployeeBean;
import com.service.EmployeeService;
import com.util.DBConnection;

public class EmployeeDao implements EmployeeService {

	Connection conn;
	PreparedStatement pstmt;

	public boolean addEmployee(EmployeeBean employeeBean) {

		boolean flag = false;
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			
			String insertSQL = "insert into employee(ename,eemail,epassword,eage)values(?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, employeeBean.geteName());
				pstmt.setString(2, employeeBean.geteEmail());
				pstmt.setString(3, employeeBean.getePassword());
				pstmt.setInt(4, employeeBean.getEage());
				
				int res = pstmt.executeUpdate();
				if(res>0){
					
					flag= true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}

		return flag;
	}

	public List<EmployeeBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteEmployee(int eId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
