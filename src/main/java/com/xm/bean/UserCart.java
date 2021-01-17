package com.xm.bean;

/**
 * @author Ming
 * @create 2020-09-30 16:36
 */
public class UserCart {

    private String userName;
    private int pId;
    private int pNum;
    private String userAddress;
    private String pImg;
    private String pBrandDescribe;
    private String pPrice;

    public UserCart() {
    }

    public UserCart(String userName, int pId, int pNum, String userAddress, String pImg, String pBrandDescribe, String pPrice) {
        this.userName = userName;
        this.pId = pId;
        this.pNum = pNum;
        this.userAddress = userAddress;
        this.pImg = pImg;
        this.pBrandDescribe = pBrandDescribe;
        this.pPrice = pPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public String getpBrandDescribe() {
        return pBrandDescribe;
    }

    public void setpBrandDescribe(String pBrandDescribe) {
        this.pBrandDescribe = pBrandDescribe;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "UserCart{" +
                "userName='" + userName + '\'' +
                ", pId=" + pId +
                ", pNum=" + pNum +
                ", userAddress='" + userAddress + '\'' +
                ", pImg='" + pImg + '\'' +
                ", pBrandDescribe='" + pBrandDescribe + '\'' +
                ", pPrice='" + pPrice + '\'' +
                '}';
    }
}
