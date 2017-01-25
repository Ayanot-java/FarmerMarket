<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user list</title>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td>username</td>
			<td>password</td>
			<td>user type</td>
		</tr>
		<c:forEach items="${requestScope.users}" var="user">
			<c:set var=id value="${user.id}" />
			<c:set var=username value="${user.username}" />
			<c:set var=password value="${user.pass}" />
			<c:set var=type value="${user.utype}" />
			<tr>
				<td>"${id}"</td>
				<td>"${username}"</td>
				<td>"${password}"</td>
				<td>"${type}"</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>