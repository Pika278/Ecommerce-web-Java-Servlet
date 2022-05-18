/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Cookie arr[] = request.getCookies();
        if (arr != null) { 
            for (Cookie o : arr) {
            if(o.getName().equals("userC")) {
                request.setAttribute("username", o.getValue());
            }
            if(o.getName().equals("passC")) {
                request.setAttribute("password", o.getValue());
            }
        }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        //Code phần remember me
        String remember = request.getParameter("remember");
//        Lấy về username và password, nếu tồn tại thì đẩy về home
        AccountDAO dao = new AccountDAO();
        Account a = dao.login(username, password);
        if (a == null) {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            
//            Bắt đầu code ở đây
            //Lưu Account lên trên Cookie
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC", password);
            
            //Code Remember Me
            u.setMaxAge(60*60); 
            if (remember != null) {
                p.setMaxAge(60*60); //Nếu ng dùng Click Remember Me -> Lưu Password
            } else {
                p.setMaxAge(0); //Ko -> Lưu Username thôi
            }            
            //Xét thời gian tồn tại cho Cookie
            session.setMaxInactiveInterval(1000);
            //Lưu cookie lên trên trình duyệt: trg hợp này là Chrome
            response.addCookie(u);
            response.addCookie(p);
            
            if (a.getIsAdmin() == 1 || a.getIsAdmin() == 0) {
                response.sendRedirect("home");
            }
        }
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
