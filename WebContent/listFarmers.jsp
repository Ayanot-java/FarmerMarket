<%--
  Created by IntelliJ IDEA.
  User: hp comp
  Date: 23.01.2017
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html charset=utf-8"
         pageEncoding="UTF-8" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String title = "ListFarmers";%>
<%@include file="header&menu.jsp" %>
<div class="container-fluid">
    <div class="col-lg-12 col-md-12 text-center">
        <ul class="pager">
            <li class="active"><a href="/FarmerController">Farmers</a></li>
            <li><a href="#">Change farmer</a></li>
        </ul>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <!-- Table -->

        <table class="table">
            <tr>
                <th class="col-lg-1 col-md-1">ID</th>
                <th class="col-lg-3 col-md-3">Name</th>
                <th class="col-lg-3 col-md-3">Address</th>
                <th class="col-lg-3 col-md-3">Phone</th>
                <th class="col-lg-2 col-md-2">Update</th>
            </tr>
            <c:forEach items="${Farmers}" var="farmer">
                <tr>
                    <form>
                        <td><input type="hidden" value="${farmer.id}" id="id" name="id"><c:out
                                value="${farmer.id}"></c:out></td>
                        <td><c:out value="${farmer.name}"></c:out></td>
                        <td><c:out value="${farmer.address}"></c:out></td>
                        <td><c:out value="${farmer.phone}"></c:out></td>
                        <td><input type="submit" formmethod="post" value="Update"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>
