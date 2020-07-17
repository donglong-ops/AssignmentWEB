<%-- 
    Document   : viewCarts
    Created on : Mar 22, 2020, 11:56:15 PM
    Author     : donglong
--%>

<%@page import="java.util.Map"%>
<%@page import="longdh.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Book Cart</title>
    </head>
    <body>
        <h1>View Your Cart</h1>
        <form action="removeBook">
            <c:set var="items" value="${sessionScope.CART.items}" />
            <c:if test="${not empty items}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Book Name</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="result" items="${items}" varStatus="counter">   
                        <form action="removeBook">
                            <tr>
                                <td>
                                    ${counter.count}
                                    .</td>
                                <td>
                                    ${result.key}        
                                </td>
                                <td>
                                    ${result.value}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkItem" value="${result.key}"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    <td colspan="3">
                        <a href="bookMarket">Add more Books to Your Cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove Selected Books" />
                    </td>
                    </tbody>
                </table>
                Name <input type="text" name="Name" value="" />
                Address <input type="text" name="Address" value="" />
                <form action="checkOut" method="GET">
                    <input type="submit" value="Checkout" />
                </form>
            </c:if>
            <c:if test="${empty items}">
                <h2> 
                    No Cart is existed!!!
                </h2>
            </c:if>  
        </form>

    </body>
</html>
