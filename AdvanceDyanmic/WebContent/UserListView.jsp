<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;
		List nextList = (List) request.getAttribute("nextList");
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<center><%@ include file="Header.jsp"%>
		<form action="UserListCtl" method="post">
	</center>

	<table style="width:  30%">
		<tr>
			<td><input type="text" name="fname" placeholder=" Enter Fname"></td>
			
			<td><input type="submit" name="operation" value="delete"></td>
		</tr>
		<td><input type="submit" name="operation" value="search"></td>
		<tr></tr>
		<tr></tr>
		<tr></tr>
	</table>

	<table border="2" style="width: 100%; border: groove;">
		<tr style="background-color: #e1e6f1e3">
			<th width="5%">select</th>
			<th width="5%">s.no</th>
			<th width="13%">Fname</th>
			<th width="13%">Lname</th>
			<th width="13%">Loginid</th>
			<th width="8%">Address</th>
			<th width="8%">Password</th>
			<th width="5%">edit</th>

		</tr>

		<%
			while (it.hasNext()) {
				UserBean bean = (UserBean) it.next();
		%>

		<tr>
			<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
			<td><%=index++%></td>
			<td><%=bean.getFname()%></td>
			<td><%=bean.getLname()%></td>
			<td><%=bean.getLoginid()%></td>
			<td><%=bean.getPassword()%></td>
			<td><%=bean.getAddress()%></td>
			<td><a href="UserCtl?id=<%=bean.getId()%>">Edit</a></td>

		</tr>
		<%
			}
		%>


		<tr>
			<td><input type="submit" name="operation" value="previous"
				<%=(pageNo != 1) ? "" : "disabled"%>></td>

			<td><input type="submit" name="operation" value="next"
				<%=(nextList.size() != 0) ? "" : "disabled"%>></td>
		</tr>
	</table>
	<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
</body>
<%@ include file="Footer.jsp"%>
</html>