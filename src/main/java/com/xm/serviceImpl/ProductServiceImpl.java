package com.xm.serviceImpl;

import com.xm.bean.Product;
import com.xm.dao.ProductMapper;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2020-08-21 16:13
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    //查询所有商品信息
    @Override
    public List<Product> getData() {
        return productMapper.getData();
    }

    //条件查询苹果商品
    @Override
    public List<Product> getApple() {
        return productMapper.getApple();
    }

    //条件查询三星商品
    @Override
    public List<Product> getSamsung() {
        return productMapper.getSamsung();
    }

    //条件查询华为商品
    @Override
    public List<Product> getHuawei() {
        return productMapper.getHuawei();
    }

    //条件查询小米商品
    @Override
    public List<Product> getXiaomi() {
        return productMapper.getXiaomi();
    }

    //条件查询OPPO商品
    @Override
    public List<Product> getOppo() {
        return productMapper.getOppo();
    }

    //条件查询ViVO商品
    @Override
    public List<Product> getVivo() {
        return productMapper.getVivo();
    }

    //条件查询品牌的不限
    @Override
    public List<Product> getBrandUnlimited() {
        return productMapper.getBrandUnlimited();
    }

    //条件查询成色99新
    @Override
    public List<Product> getjiujiu() {
        return productMapper.getjiujiu();
    }

    //条件查询成色95新
    @Override
    public List<Product> getjiuwu() {
        return productMapper.getjiuwu();
    }

    //条件查询成色9新
    @Override
    public List<Product> getjiu() {
        return productMapper.getjiu();
    }

    //条件查询成色8新
    @Override
    public List<Product> getba() {
        return productMapper.getba();
    }

    //条件查询成色不限
    @Override
    public List<Product> getLevelUnlimited() {
        return productMapper.getLevelUnlimited();
    }

    //条件查询储存512G
    @Override
    public List<Product> getwuyier() {
        return productMapper.getwuyier();
    }

    //条件查询储存256G
    @Override
    public List<Product> geterwuliu() {
        return productMapper.geterwuliu();
    }

    //条件查询储存128G
    @Override
    public List<Product> getyierba() {
        return productMapper.getyierba();
    }

    //条件查询储存64G
    @Override
    public List<Product> getliusi() {
        return productMapper.getliusi();
    }

    //条件查询存储不限
    @Override
    public List<Product> getSizeUnlimited() {
        return productMapper.getSizeUnlimited();
    }

    //条件查询价格0-1499
    @Override
    public List<Product> getlingdaoyisijiujiu() {
        return productMapper.getlingdaoyisijiujiu();
    }

    //条件查询价格1500-1999
    @Override
    public List<Product> getyiwulinglingdaoyijiujiujiu() {
        return productMapper.getyiwulinglingdaoyijiujiujiu();
    }

    //条件查询价格2000-2999
    @Override
    public List<Product> geterlinglinglingdaoerjiujiujiu() {
        return productMapper.geterlinglinglingdaoerjiujiujiu();
    }

    //条件查询价格3000-3999
    @Override
    public List<Product> getsanlinglinglingdaosanjiujiujiu() {
        return productMapper.getsanlinglinglingdaosanjiujiujiu();
    }

    //条件查询价格>4000
    @Override
    public List<Product> getdayusilinglingling() {
        return productMapper.getdayusilinglingling();
    }

    //条件查询价格不限
    @Override
    public List<Product> getPriceUnlimited() {
        return productMapper.getPriceUnlimited();
    }

    //组合条件查询品牌和成色
    @Override
    public List<Product> getBrandAndLevel(Integer pBrandId, String pLevel) {
        return productMapper.getBrandAndLevel(pBrandId,pLevel);
    }

    //组合条件查询品牌和存储
    @Override
    public List<Product> getBrandAndSize(Integer pBrandId, String pSize) {
        return productMapper.getBrandAndSize(pBrandId,pSize);
    }

    //组合条件查询品牌和价格
    @Override
    public List<Product> getBrandAndPrice(Integer pBrandId, String pPrice) {
        return productMapper.getBrandAndPrice(pBrandId,pPrice);
    }

    //组合条件查询成色和存储
    @Override
    public List<Product> getLevelAndSize(String pLevel, String pSize) {
        return productMapper.getLevelAndSize(pLevel,pSize);
    }

    //组合条件查询成色和价格
    @Override
    public List<Product> getLevelAndPrice(String pLevel, String pPrice) {
        return productMapper.getLevelAndPrice(pLevel,pPrice);
    }

    //组合条件查询存储和价格
    @Override
    public List<Product> getSizeAndPrice(String pSize, String pPrice) {
        return productMapper.getSizeAndPrice(pSize,pPrice);
    }

    //三条件查询 品牌 成色和存储
    @Override
    public List<Product> getBrandAndLevelAndSize(Integer pBrandId, String pLevel, String pSize) {
        return productMapper.getBrandAndLevelAndSize(pBrandId,pLevel,pSize);
    }

    //三条件查询 品牌 成色和价格
    @Override
    public List<Product> getBrandAndLevelAndPrice(Integer pBrandId, String pLevel, String pPrice) {
        return productMapper.getBrandAndLevelAndPrice(pBrandId,pLevel,pPrice);
    }

    //三条件查询 品牌 存储和价格
    @Override
    public List<Product> getBrandAndSizeAndPrice(Integer pBrandId, String pSize, String pPrice) {
        return productMapper.getBrandAndSizeAndPrice(pBrandId, pSize,pPrice);
    }

    //三条件查询 成色 存储和价格
    @Override
    public List<Product> getLevelAndSizeAndPrice(String pLevel, String pSize, String pPrice) {
        return productMapper.getLevelAndSizeAndPrice(pLevel,pSize,pPrice );
    }

    @Override
    public List<Product> getBrandAndLevelAndSizeAndPrice(Integer pBrandId, String pLevel, String pSize, String pPrice) {
        return productMapper.getBrandAndLevelAndSizeAndPrice(pBrandId,pLevel,pSize,pPrice);
    }

    //根据id查询此id商品具体信息
    @Override
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    //根据品牌id查询此品牌id商品的描述
    @Override
    public String getProductDescribeById(Integer id) {
        return productMapper.getProductDescribeById(id);
    }


}
