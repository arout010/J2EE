<%-- 
    Document   : newjsp
    Created on : 06-Apr-2018, 20:36:17
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
    <jsp:useBean id="u" class="mypack.javabean" scope = "session"></jsp:useBean>
        
            <table>
                <tr>
                    <td>Name</td>
                    <td><jsp:getProperty property="name" name="u" /></td>>
                </tr>
                <tr>
                    <td>Acc no</td>
                    <td><jsp:getProperty property="accno" name="u" /></td>>
                </tr>
                <tr>
                    <td>Balance</td>
                    <td><jsp:getProperty property="balance" name="u"/></td>>
                </tr>
            </table>
            <a href="index.jsp"><input type="submit" value = "Main Menu"></a> 
    </body>
</html>
