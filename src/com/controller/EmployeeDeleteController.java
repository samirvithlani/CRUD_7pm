package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.service.EmployeeService;

/**
 * Servlet implementation class EmployeeDeleteController
 */
public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String empid = request.getParameter("eid");
		int eId = 0;
		if (!empid.equals(null) || !empid.equals("")) {

			eId = Integer.parseInt(empid);
		}
		EmployeeService employeeService = new EmployeeDao();
		if (employeeService.deleteEmployee(eId)) {

			response.sendRedirect("EmployeeListController");
		} else {

			response.sendRedirect("EmployeeListController");
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
