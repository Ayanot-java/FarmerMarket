
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%String title = "Daily report #4"; %>
<%@ include file = "header&menu.jsp"%>


<% List results = (List)request.getAttribute("reportData"); %>
<h2>Daily report #4</h2>
<table class = "table" border = "1">
<tr>
<th>Buyer</th>
<th>Product</th>
<th>Quantity</th>
<th>Price</th>
<th>Farmer</th>
<th>Pack</th>
</tr>
<% for (Object obj : results) {
	Map row = (Map)obj;%>
	<tr>
	<td>
	<%= row.get("buyerName") %>
	</td>
	<td>
	<%= row.get("productName") %>
	</td>
	<td>
	<%= row.get("qnt") %>
	</td>
	<td>
	<%= row.get("pPrice") %>
	</td>
	<td>
	<%= row.get("farmerName") %>
	</td>
	<td>
	<%= row.get("packName") %>
	</td>
	</tr>
<%}%>
</table>

<%@ include file = "footer.jsp"%>