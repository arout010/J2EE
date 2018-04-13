<%-- 
    Document   : error
    Created on : 13-Apr-2018, 21:30:03
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
        <h1>
            <jsp:useBean id="u" class="mypack.javabean" scope="session"></jsp:useBean>
            Available balance is : <jsp:getProperty property="balance" name = "u"/> <br>
            <a href="index.jsp"><input type="submit" value = "Main Menu"></a>
                
        </h1>
    </body>
</html>
