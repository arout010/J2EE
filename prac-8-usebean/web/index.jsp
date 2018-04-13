<%-- 
    Document   : index
    Created on : 13-Apr-2018, 13:24:45
    Author     : Akshaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AddInfo.jsp" method = "get">
            <input type = "submit"  value = "Add account Info">
        </form>
         <form action="Diposit.jsp" method = "get">
            <input type = "submit"  value="Diposit money">
        </form>
         <form action="Withdraw.jsp" method = "get">
            <input type = "submit"  value = "Withdraw money">
        </form>
         <form action="newjsp.jsp" method = "get">
            <input type = "submit"  name = "submit" value = "Show customer detail">
        </form>
        
    </body>
</html>
