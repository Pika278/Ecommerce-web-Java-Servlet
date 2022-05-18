/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author ASUS
 */
public class AccountDAO extends DBContext {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "SELECT * FROM Account WHERE Username = ? AND Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signUp(String user, String pass) {
        String query = "INSERT INTO Account VALUES (?, ?, 0);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteAccount(String id) {
        String query = "delete from Cart where AccountID = ?;\n"
                + "delete from Account where AccountID = ?;";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
//            ps.setString(3, id);
//            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return;
    }

    public void editAccount(String id, String user, String pass, String isAdmin) {
        String query = "UPDATE Account\n"
                + "SET Username = ?,\n"
                + "Password = ?,\n"
                + "isAdmin = ?\n"
                + "WHERE AccountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isAdmin);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Account getAccountByID(String id) {
        String query = "select * from Account where AccountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public int countAllAccount() {
        String query = "select count(*) from Account";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Account checkAccountExist(String user) {
        String query = "select * from Account where Username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
