<%-- 
    Document   : Diposit
    Created on : 13-Apr-2018, 13:29:43
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
        <jsp:useBean id="u" class="mypack.javabean" scope="session"></jsp:useBean>
        <form action="getdata.jsp" method="get">
        Diposit Amount: <input type = "number" name="balance" required="true">
        <input type="submit" name="submit" value="diposit">
        </form>
    </body>
</html>
