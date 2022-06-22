/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CartDAO;
import dao.OrderedProductDAO;
import dao.OrdersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String add = request.getParameter("add");
        //Add data to Database
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        CartDAO CartDAO = new CartDAO();
        List<Cart> list = CartDAO.getCart(a.getId()); //Truyền vào id của account
        int total = 0;
        for (Cart cart : list) {
            total += cart.getSellingPrice() * cart.getQuantity();
        }
        OrdersDAO ordersDAO = new OrdersDAO();
        int orderID = ordersDAO.add(id,name,number,add,total);
        CartDAO cartDAO = new CartDAO();
        List<Cart> cart = cartDAO.getCart(a.getId());
        int flag = 1;
        for(Cart cartItem: cart) {
            int quantity = cartItem.getQuantity();
            int productID = cartItem.getProductID();
            OrderedProductDAO orderProductDAO = new OrderedProductDAO();
            boolean addOrderedProduct = orderProductDAO.add(orderID, productID, quantity);
            if (addOrderedProduct == false) {
                ordersDAO.del(orderID);
                orderProductDAO.del(orderID);
                PrintWriter out = response.getWriter();
//                out.println("Can't place an order because the quantity in stock is not enough");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Can not place an order because the quantity in stock is not enough');");
                    out.println("location='cart';");
                    out.println("</script>");
                flag = 0;
                break;
            }
        }
        if(flag == 1) {
            cartDAO.deleteCart(id);
            response.sendRedirect("home");
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
