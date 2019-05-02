/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import techsessionbean.TechSessionBeanLocal;

/**
 *
 * @author User-PC
 */
@WebServlet(name = "TechServlet", urlPatterns = {"/TechServlet"})
public class TechServlet extends HttpServlet {

    @EJB
    private TechSessionBeanLocal techSessionBean;

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
            String price1 = request.getParameter("price1");
            String price2 = request.getParameter("price2");
            if (price1 != null && price2 != null) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Диапазон</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>ДИАПАЗОН</p>");
                String diap = techSessionBean.findPrice(price1, price2);
                out.println("<p>Результат:  " + diap + "</p>");
            } else {
            }
            String idString = request.getParameter("id");
            if (idString != null) {
                int id = Integer.parseInt(idString);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Поиск</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>ПОИСК</p>");
                String deleteId = techSessionBean.deleteTech(id);
                out.println("<p>Результат удаления:   " + deleteId + "</p>");
            }
            else {
            }

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
