<%-- 
    Document   : search
    Created on : Feb 26, 2020, 3:28:21 PM
    Author     : donglong
--%>

<%@page import="longdh.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%-- tglb --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font color="red">
        Welcome , ${sessionScope.USERNAME}
        </font><br/>
        <a href="bookMarket">Click here to buy book</a><br/>


        <h1>Search page</h1>
        <form action="logout">
            <input type="submit" value="LogOut" /><br/>
        </form>
        <form action="searchLastname">
            Search Value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /></br>
            <input type="submit" value="Search" />
        </form><br/>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}"> 
            <c:set var="result" value="${requestScope.SEARCHRESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="updatePassRole">
                            <tr>
                                <td>
                                    ${counter.count}
                                    .</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" 
                                           value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" 
                                           value="${dto.password}" />
                                </td>
                                <td> 
                                    ${dto.lastname}
                                </td>
                                <td>
                                    ${dto.role}
                                    <input type="checkbox" name="chkAdmin" value="ON" 
                                           <c:if test="${dto.role}"> 
                                               checked="checked"
                                           </c:if> />
                                </td>
                                <td>
                                    <c:url var="urlRewringting" value="deleteAccount">
                                        <c:param name="btAction" value="delete"/>
                                        <c:param name="username" value="${dto.username}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}"/>
                                    </c:url>
                                    <a href="${urlRewringting}">Delete</a>
                                </td>
                                <td>
                                    <c:url var="url" value="edit">
                                        <c:param name="username" value="${dto.username}"/>
                                        <c:param name="password" value="${dto.password}"/>
                                        <c:param name="lastname" value="${dto.lastname}"/>
                                        <c:param name="role" value="${dto.role}"/>
                                    </c:url>
                                    <a href="${url}">Edit</a>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            <h2>
                <font color="red">
                No record is matched!!    
                </font>
            </h2>
        </c:if>
    </c:if>
</body>
</html>
