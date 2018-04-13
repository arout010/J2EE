
<%@page import="java.util.Scanner"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String username;// = "akshaya";//request.getParameter("username") ;
            String password;// = "kumar";//request.getParameter("password");
            Scanner sc = new Scanner(System.in);
            out.print("Enter Username:");
            username = sc.next();
            out.print("Enter Password:");
            password = sc.next();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/login1", "root", "");
                Statement stmt = con.createStatement();
                String Query = "select * from user where username = '"+username+"'and password = '"+password+"'";
                ResultSet rs = stmt.executeQuery(Query);
                if(rs.next())
                    out.print("Sccess...");
                else
                    out.print("failed...");
            }
            catch(Exception e){System.out.print(e);
            }
           
        %>
         
    </body>
</html>
