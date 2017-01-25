
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%String title = "Daily report #3"; %>
<%@ include file = "header&menu.jsp"%>


<% List results = (List)request.getAttribute("reportData"); %>
<h2>Daily report #3</h2>
<table class = "table" border = "1">
<tr>
<th>Product</th>
<th>Farmer</th>
<th>Quantity</th>
<th>Price</th>
<th>Date</th>
</tr>
<% for (Object obj : results) {
	Map row = (Map)obj;%>
	<tr>
	<td>
	<%= row.get("productName") %>
	</td>
	<td>
	<%= row.get("farmerName") %>
	</td>
	<td>
	<%= row.get("qnt") %>
	</td>
	<td>
	<%= row.get("sPrice") %>
	</td>
	<td>
	<%= row.get("sDate") %>
	</td>
	</tr>
<%}%>
</table>

<%@ include file = "footer.jsp"%>