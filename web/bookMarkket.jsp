<%-- 
    Document   : bookMarket
    Created on : Mar 15, 2020, 8:18:06 PM
    Author     : donglong
--%>

<%@page import="longdh.book.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="longdh.book.BookDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Book Store</h1>
        <form action="addbookToCart">
            <c:set var="result" value="${requestScope.LISTBOOK}"/>
            <c:if test="${not empty result}">  
                <table border="1">
                    <thead>
                        <tr>
                            <th>Book ID</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Action</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}">
                        <form action="addbookToCart">
                            <tr>
                                <td>
                                    ${dto.bookId}          
                                </td>
                                <td>
                                    ${dto.name}  
                                    <input type="hidden" name="cboBook" value="${dto.name}" />
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.quantity}
                                </td>
                                <td>
                                    <input type="submit" value="Add book to Your Cart"/>                                       
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>                         
            </c:if>

            <c:if test="${empty result}">
                <h2> 
                    Please add book!!!
                </h2>
            </c:if>    
        </form>
        <form action="viewCart">
            <input type="submit" value="View Cart" />    
        </form>
    </body>
</html>
