/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hpt
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    final private String homePage = "index.jsp";
    final private String adminPage = "show.jsp";
    
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
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("btAction");
            if(action.equals("login")){
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPass");
                loginbean login = new loginbean();
                boolean result = login.checklogin(username, password);
                String url = homePage;
                if (result) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", username);
                    url = adminPage;
                } 
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("Add")) {
                String name = request.getParameter("txtTensp");
                String price = request.getParameter("txtGia");
                String Image = request.getParameter("txtImage");
                loginbean login = new loginbean();
                boolean result = login.insert(name, price, Image);
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            }
            else if(action.equals("Delete")){
                String name = request.getParameter("txtTensp");
                loginbean login = new loginbean();
                boolean result = login.checkDelete(name);
                String url ="Controller?btAction=Delete&txtTensp="+name;
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            }else if(action.equals("Update")){
                String id = request.getParameter("txtId");
                String ten = request.getParameter("txtTensp");
                String gia = request.getParameter("txtGia");
                String img = request.getParameter("txtImage");
                loginbean login = new loginbean();
                boolean result = login.checkUpload(ten, gia, img, id);
                String url ="Controller?txtId="+id+"&txtTensp="+ten+"&txtImage="+img+"txtGia="+gia+"&btAction";
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
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
