package com.xm.bean;

/**
 * @author Ming
 * @create 2020-11-01 16:45
 *
 * 载体过渡使用
 */
public class CarrierPOJO {
    private Integer id;
    private Integer pBrandId;
    private String pImg;
    private String pNum;
    private String pPrice;
    private String pBrandDescribe;

    public CarrierPOJO() {
    }

    public CarrierPOJO(Integer id, Integer pBrandId, String pImg, String pNum, String pPrice, String pBrandDescribe) {
        this.id = id;
        this.pBrandId = pBrandId;
        this.pImg = pImg;
        this.pNum = pNum;
        this.pPrice = pPrice;
        this.pBrandDescribe = pBrandDescribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpBrandId() {
        return pBrandId;
    }

    public void setpBrandId(Integer pBrandId) {
        this.pBrandId = pBrandId;
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

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpBrandDescribe() {
        return pBrandDescribe;
    }

    public void setpBrandDescribe(String pBrandDescribe) {
        this.pBrandDescribe = pBrandDescribe;
    }

    @Override
    public String toString() {
        return "CarrierPOJO{" +
                "id=" + id +
                ", pBrandId=" + pBrandId +
                ", pImg='" + pImg + '\'' +
                ", pNum='" + pNum + '\'' +
                ", pPrice='" + pPrice + '\'' +
                ", pBrandDescribe='" + pBrandDescribe + '\'' +
                '}';
    }
}
