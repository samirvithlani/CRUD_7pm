<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeUpdateController">
		<input type="hidden" value="${employeeBean.eId }" name="eId">
		<table border="2px">

			<tr>
				<td>Employee Name:-</td>
				<td><input type="text" name="txtEmployeeName"
					value="${employeeBean.eName}"></td>
			</tr>
			<tr>
				<td>Employee Email:-</td>
				<td><input type="text" name="txtEmployeeEmail"
					value="${employeeBean.eEmail}"></td>
			</tr>
			<tr>
				<td>Employee Password-</td>
				<td><input type="password" name="pwdEmployeePassword"
					value="${employeeBean.ePassword }"></td>
			</tr>
			<tr>
				<td>Employee Age:-</td>
				<td><input type="text" name="txtEmployeeAge"
					value="${employeeBean.eage }"></td>
			</tr>
			<tr>

				<td><input type="submit" value="SUBMIT"></td>
				<td><input type="reset" value="RESET"></td>
			</tr>

		</table>
	</form>
</body>
</html>