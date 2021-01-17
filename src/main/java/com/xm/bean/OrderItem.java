package com.xm.bean;

/**
 * @author Ming
 * @create 2020-10-29 15:31
 */
public class OrderItem {
    private String orderId;
    private String userName;
    private int id;
    private String pPrice;
    private String pImg;
    private String pNum;
    private String userAddress;
    private String pBrandDescribe;

    public OrderItem() {
    }

    public OrderItem(String orderId, String userName, int id, String pPrice, String pImg, String pNum, String userAddress, String pBrandDescribe) {
        this.orderId = orderId;
        this.userName = userName;
        this.id = id;
        this.pPrice = pPrice;
        this.pImg = pImg;
        this.pNum = pNum;
        this.userAddress = userAddress;
        this.pBrandDescribe = pBrandDescribe;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getpBrandDescribe() {
        return pBrandDescribe;
    }

    public void setpBrandDescribe(String pBrandDescribe) {
        this.pBrandDescribe = pBrandDescribe;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + orderId + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", pPrice='" + pPrice + '\'' +
                ", pImg='" + pImg + '\'' +
                ", pNum='" + pNum + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", pBrandDescribe='" + pBrandDescribe + '\'' +
                '}';
    }
}
