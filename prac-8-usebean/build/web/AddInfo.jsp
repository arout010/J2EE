<%-- 
    Document   : AddInfo
    Created on : 13-Apr-2018, 13:29:26
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
        <form action="getdata.jsp" method = "get">
            Enter name: <input type = "text" name = "name" required="true">
            Enter Acc no: <input type = "text" name = "accno" required="true">
            Enter Balance: <input type = "number" name = "balance" required="true">
            <input type="submit" name = "submit" value = "submit">
        </form>
    </body>
</html>
