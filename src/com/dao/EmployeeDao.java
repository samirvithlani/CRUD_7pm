package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				if (res > 0) {

					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public List<EmployeeBean> getAllEmployees() {

		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String selectSQL = "select * from employee";

			try {
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery(selectSQL);
				while (rs.next()) {

					EmployeeBean employeeBean = new EmployeeBean(); // 1 -> 0th
																	// //2 1
					employeeBean.seteId(rs.getInt("eid"));
					employeeBean.seteName(rs.getString("ename"));
					employeeBean.seteEmail(rs.getString("eemail"));
					employeeBean.setePassword(rs.getString("epassword"));
					employeeBean.setEage(rs.getInt("eage"));
					employees.add(employeeBean);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return employees;
	}

	public boolean deleteEmployee(int eId) {

		boolean flag = false;
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String deleteSQL = "delete from employee where eid =?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, eId);
				int res = pstmt.executeUpdate();
				if (res > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public EmployeeBean getEmployeeById(int eId) {

		conn = DBConnection.getDBConnection();
		EmployeeBean employeeBean = null;
		if (conn != null) {

			String selectSQL = "select * from employee where eid =?";

			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, eId);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {

					employeeBean = new EmployeeBean();
					employeeBean.seteId(rs.getInt(1));
					employeeBean.seteName(rs.getString(2));
					employeeBean.seteEmail(rs.getString(3));
					employeeBean.setePassword(rs.getString(4));
					employeeBean.setEage(rs.getInt(5));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return employeeBean;
	}

	public boolean updateEmployee(EmployeeBean employeeBean) {

		conn = DBConnection.getDBConnection();
		boolean flag = false;
		if (conn != null) {

			String updateSQL = "update employee set eName = ?,eemail =?,epassword =?,eage =? where eid =?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, employeeBean.geteName());
				pstmt.setString(2, employeeBean.geteEmail());
				pstmt.setString(3, employeeBean.getePassword());
				pstmt.setInt(4, employeeBean.getEage());
				pstmt.setInt(5, employeeBean.geteId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;
	}

}
