
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Formatter" %>
<%@ page import="java.util.Locale" %>
<%String title = "Daily report #2"; %>
<%@ include file = "header&menu.jsp"%>

<% List results = (List)request.getAttribute("reportData"); %>
<h2>Daily report #2</h2>
<table class = "table" border = "1">
<tr>
<th>Sum of total prices</th>
</tr>
<% for (Object obj : results) {
	Map row = (Map)obj;
	StringBuilder sb = new StringBuilder();
	Formatter formatter = new Formatter(sb, Locale.US);
	if (row != null) {
		formatter.format("%.2f", row.get("sumTotalPrice"));
	} else {
		formatter.format("%.2f", 0.0f);
	}
	%>
	<tr>
	<td>
	<%= sb.toString() %>
	</td>
	</tr>
<%}%>
</table>

<%@ include file = "footer.jsp"%>