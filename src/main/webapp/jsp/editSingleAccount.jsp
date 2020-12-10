<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dnyanesh Edit Single Account</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="singleAccount" action="registerProcess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="account_name">Account Name</form:label></td>
				<td><form:input path="account_name" name="account_name" id="account_name" /></td>
			</tr>

			<tr>
				<td><form:label path="account_ad_ft1">Account Address 1</form:label></td>
				<td><form:input path="account_ad_ft1" name="account_ad_ft1" id="account_ad_ft1" /></td>
			</tr>
			<tr>
				<td><form:label path="account_ad_ft2">Account Address 2</form:label></td>
				<td><form:input path="account_ad_ft2" name="account_ad_ft2" id="account_ad_ft2" /></td>
			</tr>
			<tr>
				<td><form:label path="account_city">Account City</form:label></td>
				<td><form:input path="account_city" name="account_city" id="account_city" /></td>
			</tr>
			<tr>
				<td><form:label path="account_state">Account State</form:label></td>
				<td><form:input path="account_state" name="account_state" id="account_state" /></td>
			</tr>



			<tr>
				<td></td>
				<td><form:button id="register" name="register">Save The Account</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>