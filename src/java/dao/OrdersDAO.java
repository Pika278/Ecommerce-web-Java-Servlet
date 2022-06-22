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
        String sql = "select * from Orders order by OrderID DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
//                int id = rs.getInt(1);
                list.add(new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<Orders> getOrdersByID(int id) throws ParseException {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders where AccountID = ? order by OrderID DESC";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
//                int oid = rs.getInt(1);
                list.add(new Orders(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public int add(int accountID, String name,  String phone, String address, int total) {
        String query = "INSERT INTO Orders(AccountID, Name, Phone, Address, Total, Date, Status) VALUES (?, ?, ?, ?, ?, GETDATE(), 'Waiting');";
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountID);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setInt(5, total);
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
    
    public int countOrder() {
        String query = "SELECT COUNT(*) FROM Orders";
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
    
    public int countTotal() {
        String query = "SELECT SUM(Total) FROM Orders";
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
    
    public void updateStatusDelivering(String orderID) {
        String query = "UPDATE Orders SET Status = 'Delivering' where OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateStatusDelivered(String orderID) {
        String query = "UPDATE Orders SET Status = 'Delivered' where OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cancleOrder(String orderID) {
        String query = "UPDATE Orders SET Status = 'Canceled' where OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, orderID);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
