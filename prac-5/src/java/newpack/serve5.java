/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Akshaya
 */
public class serve5 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
           String dept = request.getParameter("dept");
           int id = Integer.parseInt(request.getParameter("id"));
           //out.println(name+"  "+dept+"  "+id);
           HttpSession session=request.getSession();  
            session.setAttribute("uname",name);
            session.setAttribute("id", id);
            session.setAttribute("dept", dept);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet serve5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action = \"serve6\" method =\"get\">\n" +
"            Enter marks1: <input type=\"number\" name=\"n1\"></br>\n" +
"            Enter marks2: <input type=\"number\" name=\"n2\"></br>\n" +
"            Enter marks3: <input type=\"number\" name=\"n3\"></br>\n" +
"            Enter marks4: <input type=\"number\" name=\"n4\"></br>\n" +
"            Enter marks5: <input type=\"number\" name=\"n5\"></br>\n" +
"            Enter marks6: <input type=\"number\" name=\"n6\"></br>\n" +
"            <input type=\"submit\" name=\"submit\" value =\"submit\" >\n" +
"        </form>");
            out.println("</body>");
            out.println("</html>");
            
            
        
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
