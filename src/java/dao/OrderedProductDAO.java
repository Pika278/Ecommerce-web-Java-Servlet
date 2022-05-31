/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
