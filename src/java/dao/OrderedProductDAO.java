/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class OrderedProductDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void add(int orderID, int productID, int quantity) {
        String query = "INSERT INTO OrderedProduct(orderID, productID, quantity) VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,orderID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
