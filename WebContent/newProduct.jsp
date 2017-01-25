<%@ page import="market.bean.FarmerType" %>
<%@ page import="market.dao.FarmerTypeDAOImpl" %>
<%@ page import="market.dao.FarmerTypeDAO" %><%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 24.01.2017
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% String title = "New Product";%>
<%@include file="header&menu.jsp"%>
<div class="row">
    <div class="col-lg-6">

        <form role="form">

            <div class="form-group">
                <label>Name</label>
                <input class="form-control">
            </div>
            <div class="form-group">
                <label>Select type</label>
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="form-group">
                <label>Select a picture</label>
                <input type="file">
            </div>
            <button type="submit" class="btn btn-default">Add product</button>
        </form>

    </div>
</div>
<%@include file="footer.jsp"%>
