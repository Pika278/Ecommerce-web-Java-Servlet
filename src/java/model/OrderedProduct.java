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
//    private int orderedproductID;
    private int orderID;
    private int productID;
    private int quantity;
    private String productName;
    private String productImage;
    private int productPrice;
    public OrderedProduct() {
    }

    public OrderedProduct(String productName, String productImage, int productPrice,int quantity) {
        this.quantity = quantity;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public OrderedProduct( int orderID, int productID, int quantity) {
//        this.orderedproductID = orderedproductID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

//    public int getOrderedproductID() {
//        return orderedproductID;
//    }
//
//    public void setOrderedproductID(int orderedproductID) {
//        this.orderedproductID = orderedproductID;
//    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

   

    
    
}
