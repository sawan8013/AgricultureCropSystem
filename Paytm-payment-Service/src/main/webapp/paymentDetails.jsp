<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<body>
	<h2>Add Payment Details</h2>
	<form action="/pgredirect" method = "post">
		<table>
			<tr>
				<td>Name  </td> <td> <input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Phone Number </td> <td> <input type= "text" name = "phonenumber" /></td>
			</tr>
			<tr>
				<td>Bank Acc Number</td> <td>  <input type= "text" name = "bankAccNumber" /></td>
			</tr>
			<tr>
				<td>IFSC Code  </td> <td> <input type= "text" name = "ifsc" /></td>
			</tr>
			<tr>
				<td>Payment Method </td> <td> <input type= "text" name = "paymentMethod" /></td>
			</tr>
			<tr>
				<td>Customer Id </td><td> <input type="text" class="form-control" placeholder="Customer ID" value=""
                                           name="CUST_ID"/></td>
			</tr>
			<tr>
				<td>Industry Id</td><td>  <input type="text" class="form-control" placeholder="INDUSTRY_TYPE_ID" value=""
                                           name="INDUSTRY_TYPE_ID"/></td>
			</tr>
			<tr>
				<td>Order ID </td><td> <input id="ORDER_ID" tabindex="1" maxlength="20" size="20"
                                           name="ORDER_ID" autocomplete="off" class="form-control" ></td>
			</tr>
			<tr>
				<td>Amount</td><td> <input type="text" class="form-control" placeholder="Amount" value=""
                                           name="TXN_AMOUNT"/></td>
			</tr>
		
			<tr><td><input type="submit" class="btnRegister" value= "Next"/></td></tr>
			
		</table>
</body>
</html>