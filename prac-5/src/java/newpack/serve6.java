
package newpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class serve6 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession(false); 
            
            String n=(String)session.getAttribute("uname"); 
            String dept=(String)session.getAttribute("dept"); 
            int id =  (int) session.getAttribute("id");
            
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            int n3 = Integer.parseInt(request.getParameter("n3"));
            int n4 = Integer.parseInt(request.getParameter("n4"));
            int n5 = Integer.parseInt(request.getParameter("n5"));
            int n6 = Integer.parseInt(request.getParameter("n6"));
            out.println("Id : "+id);
            out.println("Name : "+n);
            out.println("Department: "+dept);
            out.println("Marks1:"+n1);
            out.println("Marks1:"+n2);
            out.println("Marks1:"+n3);
            out.println("Marks1:"+n4);
            out.println("Marks1:"+n5);
            out.println("Marks1:"+n6);
            out.println("Avarage is :"+(n1+n2+n3+n4+n5+n6)/6);
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
