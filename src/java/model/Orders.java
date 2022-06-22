/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class Orders {
    private int orderID;
    private int accountID;
    private String name;
    private String phone;
    private String address;
    private int total;
    private String date;
    private String status;
    public Orders() {
    }

    public Orders(int accountID, String name, String phone, String address, int total, String date, String status) {
        this.accountID = accountID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    public Orders(int orderID, int accountID, String name, String phone, String address, int total, String date, String status) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
