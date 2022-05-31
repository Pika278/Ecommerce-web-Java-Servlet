/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cart;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CartDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Cart> getCart(int id) {
        List<Cart> list = new ArrayList<>();
//        String query = "select AccountID, Product.ProductID, CategoryID, Product.ProductName, Product.BuyingPrice, Product.SellingPrice, Product.Quantity, Product.image"
//                + ",Product.Description, Cart.Quantity"
//                + "from Cart inner join Product"
//                + "on Cart.ProductID = Product.ProductID"
//                + "where Cart.AccountID = ?";
            String query = "select AccountID, Cart.ProductID, Product.ProductName, image, SellingPrice, "
                    + "Cart.Quantity from Cart inner join Product on Cart.ProductID = Product.ProductID where Cart.AccountID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                System.out.println("ahihi");
//                int accountID = rs.getInt(1);
//                Product product = new Product(rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));
//                int quantity = rs.getInt(10);
                list.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int countCart(int id) {
        int count = 0;
        String query = "select count(*)\n"
                + "from Cart inner join Product \n"
                + "on Cart.ProductID = Product.ProductID\n"
                + "where Cart.AccountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return count;
    }

    public int countAllCart() {
        int count = 0;
        String query = "select count(*)\n"
                + "from Cart group by AccountID";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return count;
    }

    public boolean addToCart(int accountID, int productID, int quantity) {
        CartDAO dao = new CartDAO();
        if (countQuantityProduct(productID) <= 0) {
            return false;
        } else {
            List<Cart> list = dao.getCart(accountID);
            if(list.isEmpty()) {
                 String query = "INSERT INTO Cart VALUES (?, ?, ?);";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, accountID);
                    ps.setInt(2, productID);
                    ps.setInt(3, quantity);
                    ps.executeUpdate();
                } catch (Exception e) {
                }
                return true;
            }
            else {
                for (Cart cart : list) {
                    if (cart.getProductID() == productID) {
                        String query = "update Cart set Cart.Quantity = ? where AccountID = ? and ProductID = ?";
                        try {
                            ps = connection.prepareStatement(query);
                            int x = cart.getQuantity() + quantity;
                            ps.setInt(1, x);
                            ps.setInt(2, accountID);
                            ps.setInt(3, productID);
                            ps.executeUpdate();
                        } catch (Exception e) {
                        }
                        return true;
                    }
                }
                String query = "INSERT INTO Cart VALUES (?, ?, ?);";
                try {
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, accountID);
                    ps.setInt(2, productID);
                    ps.setInt(3, quantity);
                    ps.executeUpdate();
                } catch (Exception e) {
                }
                return true;
                }
           
        }
    }

    public int countQuantityProduct(int ProductID) {
        String query = "select Quantity\n"
                + "from Product\n"
                + "where ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ProductID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countNumCart(int userID) {
        String query = "select sum(Quantity) from Cart where AccountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void deleteCart(int UserID) {
        String query = "delete from Cart where AccountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, UserID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProductCart(int UserID, int ProductID) {
        String query = "delete from Cart where AccountID = ? and ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, UserID);
            ps.setInt(2, ProductID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        CartDAO c = new CartDAO();
        System.out.println(c.countCart(1));
        List<Cart> list = c.getCart(1);
        System.out.println(list.isEmpty());
        for(Cart cart: list) {
            System.out.println(cart);
        }
        System.out.println(list.get(0).getQuantity());
    }
    
}
