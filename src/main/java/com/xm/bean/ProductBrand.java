package com.xm.bean;

/**
 * @author Ming
 * @create 2020-09-23 18:48
 */
public class ProductBrand {

    private int pBrandId;
    private String pBrandName;
    private String pBrandDescribe;

    public ProductBrand(int pBrandId, String pBrandName, String pBrandDescribe) {
        this.pBrandId = pBrandId;
        this.pBrandName = pBrandName;
        this.pBrandDescribe = pBrandDescribe;
    }

    public ProductBrand() {

    }

    public int getpBrandId() {
        return pBrandId;
    }

    public void setpBrandId(int pBrandId) {
        this.pBrandId = pBrandId;
    }

    public String getpBrandName() {
        return pBrandName;
    }

    public void setpBrandName(String pBrandName) {
        this.pBrandName = pBrandName;
    }

    public String getpBrandDescribe() {
        return pBrandDescribe;
    }

    public void setpBrandDescribe(String pBrandDescribe) {
        this.pBrandDescribe = pBrandDescribe;
    }

    @Override
    public String toString() {
        return "ProductBrand{" +
                "pBrandId=" + pBrandId +
                ", pBrandName='" + pBrandName + '\'' +
                ", pBrandDescribe='" + pBrandDescribe + '\'' +
                '}';
    }
}
