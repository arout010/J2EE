
package com.servelet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akshaya
 */
public class serve extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
            {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int id  = Integer.parseInt(request.getParameter("id"));
            int mob  = Integer.parseInt(request.getParameter("mob"));
            String name = request.getParameter("name");
            String email  = request.getParameter("email");       
            out.println("Id: "+id);
            out.println("name: "+name);
            out.println("Email: "+email);
            out.println("MOb No: "+mob);
            
            try
            {
                Connection con = null;
                PreparedStatement pstmt  = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "");
                String query ="insert into prac3 values(?,?,?,?)";
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setInt(3, mob);
                pstmt.setString(4,email);
                int i =  pstmt.executeUpdate();
                
               con.close();
            }catch(Exception e){}
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
