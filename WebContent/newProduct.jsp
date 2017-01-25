<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 24.01.2017
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String title = "New Product";%>
<%@include file="header&menu.jsp" %>
<div class="row">
    <div class="col-lg-6">

        <form role="form" method="post" action="ProductController">

            <div class="form-group">
                <label>Name</label>
                <input class="form-control" name="productName">
            </div>
            <div class="form-group">
                <label>Select type</label>
                <select class="form-control" name="productType">
                    <c:forEach items="${listOfProducts}" var="option">
                        <option><c:out value="${option.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Select a picture</label>
                <input type="file" name="imageFile">
            </div>
            <button type="submit" class="btn btn-default">Add product</button>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
