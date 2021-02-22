<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeRegistrationController">
		<table border="2px">
			<tr>
				<td>Employee Name:-</td>
				<td><input type="text" name="txtEmployeeName"></td>
			</tr>
			<tr>
				<td>Employee Email:-</td>
				<td><input type="text" name="txtEmployeeEmail"></td>
			</tr>
			<tr>
				<td>Employee Password-</td>
				<td><input type="password" name="pwdEmployeePassword"></td>
			</tr>
			<tr>
				<td>Employee Age:-</td>
				<td><input type="text" name="txtEmployeeAge"></td>
			</tr>
			<tr>

				<td><input type="submit" value="SUBMIT"></td>
			</tr>

		</table>
	</form>
</body>
</html>