<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Employee List</span></div>
			<table class="table table-hover">
			<thead>
			<tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Date Of Birth</th>
            <th>Telephone</th>
            <th>Action</th>
 </tr>
 </thead>
 <tbody>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
 
                    <td>${employee.firstname}</td>
                    <td>${employee.lastname}</td>
                    <td>${employee.email}</td>
                    <td>${employee.dob}</td>
                    <td>${employee.telephone}</td>
                    <td><a href="editEmployee?id=${employee.id}">Edit</a>
                             <a href="deleteEmployee?id=${employee.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
</tbody>
        </table>
    </div>
   
		<h3>  New Employee</h3>
		<div class="well">
	 		<a href="newEmployee">Add New Employee</a>
	 	</div>
	 	</div>
</body>
</html>