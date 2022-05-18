/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author ASUS
 */
public class ProductDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select Product.ProductID, Category.CategoryID, Product.ProductName, Product.BuyingPrice, Product.SellingPrice, Product.Quantity, Product.image,"
                + " Product.Description from Product inner join Category on Category.CategoryID = Product.CategoryID";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    public void edit(String ID, String categoryID, String name,  String buyingPrice, String sellingPrice, String quantity, String image, String description) {
        String query = "UPDATE Product SET CategoryID = ?, ProductName = ?, BuyingPrice = ?, SellingPrice = ?, Quantity = ?, image = ?, Description = ? WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, categoryID);
            ps.setString(2, name);
            ps.setString(3, buyingPrice);
            ps.setString(4, sellingPrice);
            ps.setString(5, quantity);
            ps.setString(6, image);
            ps.setString(7, description);
            ps.setString(8,ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void delete(String id) {
        String query = "DELETE FROM Cart WHERE ProductID = ?;\n"
                + "DELETE FROM Product WHERE ProductID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(String categoryID, String name,  String buyingPrice, String sellingPrice, String quantity, String image, String description) {
        String query = "INSERT INTO Product VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, categoryID);
            ps.setString(2, name);
            ps.setString(3, buyingPrice);
            ps.setString(4, sellingPrice);
            ps.setString(5, quantity);
            ps.setString(6, image);
            ps.setString(7, description);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int countProduct() {
        String query = "SELECT COUNT(*) FROM Product";
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

    public int countProductByCategory(int CategoryID) {
        if (CategoryID == 0) {
            return countProduct();
        } else {
            String query = "SELECT COUNT(*) FROM Product WHERE CategoryID = ?";
            try {
            PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, CategoryID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public Product getProductByID(String ID) { //Phải để kiểu int vì khi lưu lên Session thì nó vẫn là kiểu int
        String query = "SELECT * FROM Product WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Product> getProductByCate(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where CategoryID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        ProductDAO p = new ProductDAO();
//        List<Product> list = p.getAllProduct();
//        System.out.println(list.get(0).getPriceWithDot());
//    }
//    
}
