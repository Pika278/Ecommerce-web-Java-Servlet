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
import model.Category;

/**
 *
 * @author ASUS
 */
public class CategoryDAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                list.add(new Category(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public String getCateNameByID(int id) {
        String query = "select CategoryName from Category\n"
                + "where CategoryID = ?"; 
        try {
            ps = connection.prepareStatement(query); 
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> li = c.getAllCategory();
        System.out.println(li.get(1).getName());
    }
}
