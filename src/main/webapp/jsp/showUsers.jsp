<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body onload="console.log('${userList}'.length); ">
	
	
	
	<table style="border: 1px solid black;; width:50%">
  <tr style="border: 1px solid black;">
    <th style="border: 1px solid black;">Firstname</th>
    <th style="border: 1px solid black;">Lastname</th>
    <th style="border: 1px solid black;">User ID</th>
  </tr>
  
  

  
 <c:forEach items="${userList}" var="par">

		  <tr style="border: 1px solid black;">
		    <td style="border: 1px solid black;">${par.firstname}</td>
		    <td style="border: 1px solid black;">${par.lastname}</td>
		    <td style="border: 1px solid black;">${par.username}</td>
		  </tr>            

    </c:forEach>



</table>
            
</body>
</html>







