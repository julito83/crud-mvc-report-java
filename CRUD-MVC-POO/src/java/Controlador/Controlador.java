package Controlador;

import Modelo.Persona;
import ModeloDAO.ModeloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    String delete = "vistas/listar.jsp";
    

    Persona p = new Persona();
    ModeloDAO dao = new ModeloDAO();
    int id_doc;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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

        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            id_doc = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String ap1 = request.getParameter("txtAp1");
            String ap2 = request.getParameter("txtAp2");

            p.setId_doc(id_doc);
            p.setNom(nom);
            p.setAp1(ap1);
            p.setAp2(ap2);
            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id_doc = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String ap1 = request.getParameter("txtAp1");
            String ap2 = request.getParameter("txtAp2");

            p.setId_doc(id_doc);
            p.setNom(nom);
            p.setAp1(ap1);
            p.setAp2(ap2);
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("delete")) {
            id_doc = Integer.parseInt(request.getParameter("id"));
            p.setId_doc(id_doc);
            dao.eliminar(id_doc);
            acceso = listar;
        } 
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
