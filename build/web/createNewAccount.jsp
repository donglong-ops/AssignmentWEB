<%-- 
    Document   : createNewAccount
    Created on : Mar 10, 2020, 9:53:34 PM
    Author     : donglong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1> Create New Account </h1>
        <form action="createNewAccount" method = "POST">
            <c:set var="error" value="${requestScope.CREATEERROR}" />
            Username* <input type="text" name ="txtUsername" value="${param.txtUsername}" />(6 - 30 chars) <br/>
            <c:if test="${not empty error.usernameLengthError}">
                <font color="red">
                ${error.usernameLengthError}
                </font> <br/>
            </c:if>
            Password* <input type="password" name ="txtPassword" value="" />(6 - 20 chars) <br/>
            <c:if test="${not empty error.passwordLengthError}">
                <font color="red">
                ${error.passwordLengthError}
                </font> <br/>
            </c:if>
            Confirm* <input type="password" name ="txtConfirm" value="" /> <br/>
            <c:if test="${not empty error.confirmNotMatched}">
                <font color="red">
                ${error.confirmNotMatched}
                </font> <br/>
            </c:if>
                Full name* <input type="text" name ="txtFullname" value="${param.txtFullname}" />(2 - 50 chars) <br/>
            <c:if test="${not empty error.fullnameLengthError}">
                <font color="red">
                ${error.fullnameLengthError}
                </font> <br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form><br/>
        <c:if test="${not empty error.usernameIsExisted}">
            <font color="red">
            ${error.usernameIsExisted}
            </font> <br/>
        </c:if>
    </body>
</html>
