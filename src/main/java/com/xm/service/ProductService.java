package com.xm.service;

import com.xm.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ming
 * @create 2020-08-21 16:12
 */
public interface ProductService {

    //查询所有商品信息
    public List<Product> getData();

    //条件查询苹果商品
    public List<Product> getApple();

    //条件查询三星商品
    public List<Product> getSamsung();

    //条件查询华为商品
    public List<Product> getHuawei();

    //条件查询小米商品
    public List<Product> getXiaomi();

    //条件查询OPPO商品
    public List<Product> getOppo();

    //条件查询ViVO商品
    public List<Product> getVivo();

    //条件查询品牌的不限
    public List<Product> getBrandUnlimited();

    //条件查询成色99新
    public List<Product> getjiujiu();

    //条件查询成色95新
    public List<Product> getjiuwu();

    //条件查询成色9新
    public List<Product> getjiu();

    //条件查询成色8新
    public List<Product> getba();

    //条件查询成色不限
    public List<Product> getLevelUnlimited();

    //条件查询储存512G
    public List<Product> getwuyier();

    //条件查询储存256G
    public List<Product> geterwuliu();

    //条件查询储存128G
    public List<Product> getyierba();

    //条件查询储存64G
    public List<Product> getliusi();

    //条件查询存储不限
    public List<Product> getSizeUnlimited();

    //条件查询价格0-1499
    public List<Product> getlingdaoyisijiujiu();

    //条件查询价格1500-1999
    public List<Product> getyiwulinglingdaoyijiujiujiu();

    //条件查询价格2000-2999
    public List<Product> geterlinglinglingdaoerjiujiujiu();

    //条件查询价格3000-3999
    public List<Product> getsanlinglinglingdaosanjiujiujiu();

    //条件查询价格>4000
    public List<Product> getdayusilinglingling();

    //条件查询价格不限
    public List<Product> getPriceUnlimited();

    //组合条件查询品牌和成色
    public List<Product> getBrandAndLevel(Integer pBrandId,String pLevel);

    //组合条件查询品牌和存储
    public List<Product> getBrandAndSize(@Param("pBrandId")Integer pBrandId, @Param("pSize")String pSize);

    //组合条件查询品牌和价格
    public List<Product> getBrandAndPrice(@Param("pBrandId")Integer pBrandId, @Param("pPrice")String pPrice);

    //组合条件查询成色和存储
    public List<Product> getLevelAndSize(@Param("pLevel")String pLevel, @Param("pSize")String pSize);

    //组合条件查询成色和价格
    public List<Product> getLevelAndPrice(@Param("pLevel")String pLevel, @Param("pPrice")String pPrice);

    //组合条件查询存储和价格
    public List<Product> getSizeAndPrice(@Param("pSize")String pSize, @Param("pPrice")String pPrice);

    //三条件查询 品牌 成色和存储
    public List<Product> getBrandAndLevelAndSize(@Param("pBrandId")Integer pBrandId,@Param("pLevel")String pLevel,@Param("pSize")String pSize);

    //三条件查询 品牌 成色和价格
    public List<Product> getBrandAndLevelAndPrice(@Param("pBrandId")Integer pBrandId,@Param("pLevel")String pLevel,@Param("pPrice")String pPrice);

    //三条件查询 品牌 存储和价格
    public List<Product> getBrandAndSizeAndPrice(@Param("pBrandId")Integer pBrandId,@Param("pSize")String pSize,@Param("pPrice")String pPrice);

    //三条件查询 成色 存储和价格
    public List<Product> getLevelAndSizeAndPrice(@Param("pLevel")String pLevel,@Param("pSize")String pSize,@Param("pPrice")String pPrice);

    //四条件查询 品牌，成色，存储，价格
    public List<Product> getBrandAndLevelAndSizeAndPrice(@Param("pBrandId")Integer pBrandId,@Param("pLevel")String pLevel,@Param("pSize")String pSize,@Param("pPrice")String pPrice);

    //根据id查询此id商品具体信息
    public Product getProductById(@Param("id")Integer id);

    //根据品牌id查询此品牌id商品的描述
    public String getProductDescribeById(@Param("id")Integer id);

}
