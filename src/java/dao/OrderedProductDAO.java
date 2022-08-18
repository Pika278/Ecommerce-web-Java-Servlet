/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.OrderedProduct;
import model.Orders;

/**
 *
 * @author ASUS
 */
public class OrderedProductDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    public boolean add(int orderID, int productID, int quantity) {
        CartDAO cartDAO = new CartDAO();
        if(cartDAO.countQuantityProduct(productID) < quantity) {
            return false;
        }
        else {
            String query = "INSERT INTO OrderedProduct(orderID, productID, quantity) VALUES (?, ?, ?);\n"
                    + "UPDATE Product set Product.Quantity = Product.Quantity - ? where ProductID = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1,orderID);
                ps.setInt(2, productID);
                ps.setInt(3, quantity);
                ps.setInt(4,quantity);
                ps.setInt(5, productID);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;

        }
    }
    public void del(int orderID) {
        String query = "DELETE FROM OrderedPRoduct where OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, orderID);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<OrderedProduct> getOrderedProduct(int orderID) throws ParseException {
        List<OrderedProduct> list = new ArrayList<>();
        String sql = "select Product.ProductName, Product.image, Product.SellingPrice, OrderedProduct.Quantity from OrderedProduct join Product "
                + "on Product.ProductID = OrderedProduct.ProductID\n" +
                "where OrderedProduct.OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new OrderedProduct(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<OrderedProduct> getOrderedProductByUser(int orderID, int userID) throws ParseException {
        List<OrderedProduct> list = new ArrayList<>();
        String sql = "select Product.ProductName, Product.image, Product.SellingPrice, OrderedProduct.Quantity from OrderedProduct join Product "
                + "on Product.ProductID = OrderedProduct.ProductID join Orders on Orders.OrderID = OrderedProduct.OrderID "
                + "where OrderedProduct.OrderID = ? and Orders.AccountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new OrderedProduct(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public int countOrderedProduct() {
        String query = "SELECT SUM (Quantity) FROM OrderedProduct join Orders on Orders.OrderID = OrderedProduct.OrderID where Status = 'Delivered'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
//    public int countOrderedProductByYear(String year) {
//        String query = "SELECT SUM (Quantity) FROM OrderedProduct join Orders on Orders.OrderID = OrderedProduct.OrderID where Status = 'Delivered' and YEAR(Orders.Date) = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, year);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//        }
//        return 0;
//    }
//    
    public int countOrderedProductByDate(String year, String month, String day) {
        String query = "SELECT SUM (Quantity) FROM OrderedProduct join Orders on Orders.OrderID = OrderedProduct.OrderID where Status = 'Delivered' and YEAR(Date) = ISNULL(?,YEAR(Date)) and MONTH(Date) = ISNULL(?,MONTH(Date))\n" +
"and DAY(Date) = ISNULL(?,DAY(Date))";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, year);
            ps.setString(2, month);
            ps.setString(3, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int countImportPrice() {
        String query = "SELECT SUM(Product.BuyingPrice * OrderedProduct.Quantity) FROM Product join OrderedProduct on Product.ProductID = OrderedProduct.ProductID "
                + "join Orders on Orders.OrderID = OrderedProduct.OrderID where Orders.Status = 'Delivered' ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
//    public int countImportPriceByYear(String year) {
//        String query = "SELECT SUM(Product.BuyingPrice * OrderedProduct.Quantity) FROM Product join OrderedProduct on Product.ProductID = OrderedProduct.ProductID "
//                + "join Orders on Orders.OrderID = OrderedProduct.OrderID where Orders.Status = 'Delivered' and YEAR(Orders.Date) = ?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, year);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//        }
//        return 0;
//    }
    
    public int countImportPriceByDate(String year, String month, String day) {
        String query = "SELECT SUM(Product.BuyingPrice * OrderedProduct.Quantity) FROM Product join OrderedProduct on Product.ProductID = OrderedProduct.ProductID "
                + "join Orders on Orders.OrderID = OrderedProduct.OrderID where Orders.Status = 'Delivered' and YEAR(Date) = ISNULL(?,YEAR(Date)) and MONTH(Date) = ISNULL(?,MONTH(Date))\n" +
"and DAY(Date) = ISNULL(?,DAY(Date))";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, year);
            ps.setString(2, month);
            ps.setString(3, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
