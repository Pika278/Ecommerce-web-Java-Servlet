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
public class Product {
    private int ProductID;
    private int CategoryID;
    private String ProductName;
    private int BuyingPrice;
    private int SellingPrice;
    private int Quantity;
    private String image;
    private String Description;

    public Product() {
    }


    public Product(int ProductID, int CategoryID, String ProductName, int BuyingPrice, int SellingPrice, int Quantity, String image, String Description) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.BuyingPrice = BuyingPrice;
        this.SellingPrice = SellingPrice;
        this.Quantity = Quantity;
        this.image = image;
        this.Description = Description;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getBuyingPrice() {
        return BuyingPrice;
    }

    public void setBuyingPrice(int BuyingPrice) {
        this.BuyingPrice = BuyingPrice;
    }

    public int getSellingPrice() {
        return SellingPrice;
    }

    public void setSellingPrice(int SellingPrice) {
        this.SellingPrice = SellingPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    
    
    public String getPriceWithDot() {
        String priceDot = "" + SellingPrice;
        int i = priceDot.length() - 3;
        while (i > 0) {
            priceDot = priceDot.substring(0, i) + "." + priceDot.substring(i, priceDot.length());
            i -= 3;
        }
    return priceDot;
    }
}
