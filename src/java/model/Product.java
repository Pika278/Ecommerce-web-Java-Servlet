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
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String Description;

    public Product() {
    }

    public Product(int ProductID, int CategoryID, String ProductName, int BuyingPrice, int SellingPrice, int Quantity, String image1, String image2, String image3, String image4, String image5, String Description) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.BuyingPrice = BuyingPrice;
        this.SellingPrice = SellingPrice;
        this.Quantity = Quantity;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
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

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
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
