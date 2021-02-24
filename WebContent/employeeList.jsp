<%@page import="com.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE EMAIL</th>
			<th>EMPLOYEE PASSWORD</th>
			<th>EMPLOYEE AGE</th>
			<th>ACTION</th>
		</tr>
		<tr>
			<%
				List<EmployeeBean> employees = (List<EmployeeBean>) request.getAttribute("employees");
				if (employees != null) {
					for (int i = 0; i < employees.size(); i++) {

						EmployeeBean employeeBean = employees.get(i);
			%>



			<td><%=employeeBean.geteId()%></td>
			<td><%=employeeBean.geteName()%></td>
			<td><%=employeeBean.geteEmail()%></td>
			<td><%=employeeBean.getePassword()%></td>
			<td><%=employeeBean.getEage()%></td>
			<td><a href="EmployeeDeleteController?eid=<%=employeeBean.geteId()%>">DELETE</a></td>
		</tr>


		<%
			}
			} else {
				out.println("no data found");
			}
		%>
	</table>

</body>
</html>