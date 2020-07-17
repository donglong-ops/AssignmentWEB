<%-- 
    Document   : edit
    Created on : Apr 6, 2020, 5:08:39 PM
    Author     : donglong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Page</h1>
        <form action="editServlet" method="POST">
            Username : <input type="text" name="txtUsername" value="${param.username}" /><br/>
            Password : <input type="text" name="txtPassword" value="${param.password}" /><br/>
            Lastname : <input type="text" name="txtLastname" value="${param.lastname}" /><br/>
            IsAdmin : <input type="checkbox" name="checkAdmin" value="${param.role}"
            <c:if test="${param.role}"> 
                checked="checked"
                
            </c:if> /><br/>
            <input type="submit" value="Edit" />
        </form>
    </body>
</html>
