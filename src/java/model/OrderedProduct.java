/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class OrderedProduct {
    private Orders OrderID;
    private Product ProductID;
    private int Quantity;

    public OrderedProduct() {
    }

    public OrderedProduct(Orders OrderID, Product ProductID, int Quantity) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
    }

    public Orders getOrderID() {
        return OrderID;
    }

    public void setOrderID(Orders OrderID) {
        this.OrderID = OrderID;
    }

    public Product getProductID() {
        return ProductID;
    }

    public void setProductID(Product ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    
    
}
