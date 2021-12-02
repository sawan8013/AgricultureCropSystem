<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:errors path="customer1.*" />
	<h2>Add Payment Details</h2>
	<form action="result.html" method = "post">
		<table>
			<tr>
				<td>Name  </td> <td> <input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Phone Number </td> <td> <input type= "text" name = "phonenumber" /></td>
			</tr>
			<tr>
				<td>Email </td> <td>  <input type= "text" name = "email" /></td>
			</tr>
			<tr>
				<td>Payment Method  </td> <td> <input type= "text" name = "paymentmethod" /></td>
			</tr>
			<tr>
				<td>Amount  </td> <td> <input type= "text" name = "amount" /></td>
			</tr>
			<tr><td><input type="submit"  value= "Next"/></td></tr>
			
		</table>
</body>
</html>