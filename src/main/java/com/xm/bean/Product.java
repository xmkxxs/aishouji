package com.xm.bean;

/**
 * @author Ming
 * @create 2020-08-21 16:08
 */
public class Product {
    private int id;
    private String pName;
    private String pLevel;
    private String pPrice;
    private String pImg;
    private String pNum;
    private int pBrandId;
    private String pSize;
    private String pRam;

    public Product() {
    }

    public Product(int id, String pName, String pLevel, String pPrice, String pImg, String pNum, int pBrandId, String pSize, String pRam) {
        this.id = id;
        this.pName = pName;
        this.pLevel = pLevel;
        this.pPrice = pPrice;
        this.pImg = pImg;
        this.pNum = pNum;
        this.pBrandId = pBrandId;
        this.pSize = pSize;
        this.pRam = pRam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpLevel() {
        return pLevel;
    }

    public void setpLevel(String pLevel) {
        this.pLevel = pLevel;
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

    public int getpBrandId() {
        return pBrandId;
    }

    public void setpBrandId(int pBrandId) {
        this.pBrandId = pBrandId;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public String getpRam() {
        return pRam;
    }

    public void setpRam(String pRam) {
        this.pRam = pRam;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pLevel='" + pLevel + '\'' +
                ", pPrice='" + pPrice + '\'' +
                ", pImg='" + pImg + '\'' +
                ", pNum='" + pNum + '\'' +
                ", pBrandId=" + pBrandId +
                ", pSize='" + pSize + '\'' +
                ", pRam='" + pRam + '\'' +
                '}';
    }
}
