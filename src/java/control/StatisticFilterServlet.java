/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import dao.OrderedProductDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "StatisticFilterServlet", urlPatterns = {"/statisticfilter"})
public class StatisticFilterServlet extends HttpServlet {

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
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        ProductDAO productDAO = new ProductDAO();
        int totalProduct = productDAO.countProduct();
        OrdersDAO ordersDAO = new OrdersDAO();
        OrderedProductDAO orderedDAO = new OrderedProductDAO();
        int totalOrder;
        int totalQuantityProduct;
        int totalImportPrice;
        int total;
        int profit;
        if(year.isEmpty()) {
            year = null;
        }
        if(month.isEmpty()) {
            month = null;
        }
        if(day.isEmpty()) {
            day = null;
        }
            totalOrder = ordersDAO.countOrderByDate(year,month,day);
            totalQuantityProduct = orderedDAO.countOrderedProductByDate(year,month,day);
            totalImportPrice = orderedDAO.countImportPriceByDate(year, month,day);
            total = ordersDAO.countTotalByDate(year, month,day);
//        }
        profit = total - totalImportPrice;
        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalQuantityProduct", totalQuantityProduct);
        request.setAttribute("total", total);
        request.setAttribute("profit", profit);
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("day", day);
        
        request.getRequestDispatcher("statistic.jsp").forward(request, response);
        
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
