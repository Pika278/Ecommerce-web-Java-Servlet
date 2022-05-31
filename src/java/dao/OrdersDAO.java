/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

/**
 *
 * @author ASUS
 */
public class OrdersDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Orders> getAllOrders() throws ParseException {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                list.add(new Orders(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<Orders> getOrdersByID(String id) throws ParseException {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders where AccountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int oid = rs.getInt(1);
                list.add(new Orders(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public int add(String accountID, String name,  String phone, String email, String address) {
        String query = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, accountID);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
       } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
    public void del(int orderID) {
        String query = "DELETE FROM Orders where OrderID = ?";
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
