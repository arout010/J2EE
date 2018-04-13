<%-- 
    Document   : Withdraw
    Created on : 13-Apr-2018, 13:30:08
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
        <form action="withdrawprocess.jsp" method="get">
        Withdraw amount: <input type = "number" name="balance" required="true">
        <input type="submit" name="submit" value="Withdraw">
        </form>
    </body>
</html>
