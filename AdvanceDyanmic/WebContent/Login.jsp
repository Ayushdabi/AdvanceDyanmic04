<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%@include file="Header.jsp"%>
	<form action="LoginCtl" method="post">
      <h3 align="center">
		<font size="20px" color="red">WELCOME TO RAYS </font>
	</h3>
<table>

		<%
			String msg = (String) request.getAttribute("msg");
		%>
		

			<tr>
				<%
					if (msg != null) {
				%>

				<%=msg%>

				<%
					}
				%>
			</tr>

			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>

				<td>
					<button>submit</button>

				</td>
			</tr>
		</table>
	</form>
</body>
<%@ include file="Footer.jsp"%>
</html>