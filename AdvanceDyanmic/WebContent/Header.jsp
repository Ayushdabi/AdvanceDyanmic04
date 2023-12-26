
<%@page import="in.co.rays.bean.UserBean"%>
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
		UserBean user = (UserBean) session.getAttribute("users");
	%>
	<table width="100%" border="0">
		<tr>
			<td width="90%"><a href="WelcomeCtl"><b>WELCOME</b></a>||<%
				if (user != null) {
			%> <a href="LoginCtl?operation=logout"><b>Logout</b></a> <%
 	} else {
 %><a href="Login.jsp"><b>Login</b></a> <%
 	}
 %></td>
			<td rowspan="10">
				<h1 align="Right">
					<img
						src="https://lh4.googleusercontent.com/l-iGmZIPVOXdAtlFEd3P4RC3FXfBfyG4a6YwHebFR4Je4yO8NBBbe-BZOCyXlHF1XJdge2F8qYmmcDxiPnr6hJc=w16383"
						width="318" height="90">
				</h1>
			</td>
		</tr>


		<%
			if (user != null) {
		%>

		<h1>
			HELLO,<%=user.getFname()%></h1>
		<a href="UserCtl"><b>AddUser</b></a> |
		<a href="UserListCtl"> UserList</a> 

		<%
			} else {
		%>
		<h3><%="Hii,Guest"%></h3>
		<%
			}
		%>


	</table>
	<hr>
</body>
</html>