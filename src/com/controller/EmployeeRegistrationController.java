package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;
import com.service.EmployeeService;

/**
 * Servlet implementation class EmployeeRegistrationController
 */
public class EmployeeRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String eName = request.getParameter("txtEmployeeName");
		String ePassword = request.getParameter("pwdEmployeePassword");
		String eEmail = request.getParameter("txtEmployeeEmail");
		String age = request.getParameter("txtEmployeeAge");
		int eAge = 0;
		if (!age.equals("") || !age.equals(null)) {

			eAge = Integer.parseInt(age);
		}

		EmployeeBean employeeBean = new EmployeeBean();

		employeeBean.seteName(eName);
		employeeBean.seteEmail(eEmail);
		employeeBean.setePassword(ePassword);
		employeeBean.setEage(eAge);

		EmployeeService employeeService = new EmployeeDao();

		if (employeeService.addEmployee(employeeBean)) {

			response.sendRedirect("message.jsp");
		} else {

			response.sendRedirect("error.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
