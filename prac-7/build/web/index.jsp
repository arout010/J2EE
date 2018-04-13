
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="hello">  
    <s:textfield name="id" label="Product Id"></s:textfield>  
    <s:textfield name="name" label="Product Name"></s:textfield>  
    <s:textfield name="price" label="Product Price"></s:textfield>  
    <s:submit value="save"></s:submit>  
    </s:form> 
    </body>
</html>