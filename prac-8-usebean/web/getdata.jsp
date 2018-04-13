<%-- 
    Document   : getdata
    Created on : 13-Apr-2018, 13:38:33
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
        <jsp:setProperty property="name" name="u" /> 
        <jsp:setProperty property="accno" name="u" /> 
        <% float bal = u.getBalance(); 
            out.println(bal);
            bal = bal + Float.parseFloat(request.getParameter("balance"));
         %>
        <jsp:setProperty property="balance" name="u" value="<%=bal%>" />    
        
        <% response.sendRedirect("newjsp.jsp");%>     
    </body>
</html>
