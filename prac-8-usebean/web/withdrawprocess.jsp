<%-- 
    Document   : withdrawprocess
    Created on : 13-Apr-2018, 21:25:41
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
        <% float bal = u.getBalance(); 
            float newbal = Float.parseFloat(request.getParameter("balance"));
            if(bal > newbal){
                bal = bal - newbal;
                 %><jsp:setProperty property="balance" name="u" value="<%=bal%>" /> 
                   
          <%
                response.sendRedirect("error.jsp");     
            }
            else{
                out.println("Insufficent amount");
                %> <a href="index.jsp"><input type="submit" value = "Main Menu"></a><%}
         %> 
        
    </body>
</html>
