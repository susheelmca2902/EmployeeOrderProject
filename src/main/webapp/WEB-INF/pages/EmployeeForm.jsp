<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"><span class="lead"><center><h3>New/Edit Employee</h3></center></span></div>
			<form:errors path="employee.*"/>
			<form:form action="saveEmployee" method="post" modelAttribute="employee">
				<table class="table table-hover" align="center">
					<form:hidden path="id" />
					<tr>
						<td>First Name: *</td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td>Last Name: </td>
						<td><form:input path="lastname" /> Not Mandatory</td>
					</tr>
					<tr>
						<td>Email: *</td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td>Date Of Birth: *</td>
						<td><form:input  path="dob" />(dd/mm/yyyy)</td>
					</tr>
					<tr>
						<td>Telephone: *</td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
		</div>
</body>
</html>