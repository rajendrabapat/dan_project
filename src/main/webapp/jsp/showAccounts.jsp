<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts List</title>
</head>
<body onload="console.log( '${pageContext.request.contextPath}'   ); ">
	
	
	
	<table style="border: 1px solid black;; width:50%">
  <tr style="border: 1px solid black;">
    <th style="border: 1px solid black;">Account Name</th>
    <th style="border: 1px solid black;">City</th>
    <th style="border: 1px solid black;">State</th>
  </tr>
  
  

  
 <c:forEach items="${accountList}" var="par">

		  <tr style="border: 1px solid black;">
		  
		  <!-- This Command helps in making Account Name as HyperLink -->
		  
		    <td style="border: 1px solid black;"><a href='record?name=${par.account_name}' >${par.account_name}</a></td>
		    <td style="border: 1px solid black;">${par.account_city}</td>
		    <td style="border: 1px solid black;">${par.account_state}</td>
		  </tr>            

    </c:forEach>



</table>
            
</body>
</html>