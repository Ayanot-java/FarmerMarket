<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reports</title>
</head>
<body>
<a href = "${pageContext.request.contextPath}/ReportController?report=report0">report0</a>
<br>
<a href = "${pageContext.request.contextPath}/ReportController?report=report1">report1</a>
<br>
<a href = "${pageContext.request.contextPath}/ReportController?report=report2">report2</a>
<br>
<a href = "${pageContext.request.contextPath}/ReportController?report=report3">report3</a>
<br>
<a href = "${pageContext.request.contextPath}/ReportController?report=report4">report4</a>
</body>
</html>