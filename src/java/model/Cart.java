/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.registry.infomodel.User;

/**
 *
 * @author ASUS
 */
public class Cart {
    private int accountID;
    private int productID;
    private String productName;
    private String image;
    private int sellingPrice;
    private int quantity;
    
    public Cart() {
    }

    public Cart(int accountID, int productID, String productName, String image, int sellingPrice, int quantity) {
        this.accountID = accountID;
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getPriceWithDot() {
        String priceDot = "" + sellingPrice;
        int i = priceDot.length() - 3;
        while (i > 0) {
            priceDot = priceDot.substring(0, i) + "." + priceDot.substring(i, priceDot.length());
            i -= 3;
        }
    return priceDot;
    }
}