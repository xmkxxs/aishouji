package com.xm.serviceImpl;

import com.xm.bean.OrderItem;
import com.xm.bean.UserCart;
import com.xm.dao.UserCartMapper;
import com.xm.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2020-09-30 16.56
 */
@Service
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    UserCartMapper userCartMapper;

    //商品添加到用户购物车
    @Override
    public int addCart(String userName, Integer pId, Integer pNum, String userAddress, String pImg, String pBrandDescribe, String pPrice) {
        return userCartMapper.addCart(userName,pId,pNum,userAddress,pImg,pBrandDescribe,pPrice);
    }

    //按商品id查询某用户购物车中是否存在此商品
    @Override
    public int existProductIdByUserName(String userName, Integer pId) {
        return userCartMapper.existProductIdByUserName(userName,pId);
    }

    //查询用户购物车中某一id商品的数量
    @Override
    public int productNum(String userName, Integer pId) {
        return userCartMapper.productNum(userName,pId);
    }

    //更新某一商品的数量
    @Override
    public int updateProductNum(String userName, Integer pId, Integer pNum) {
        return userCartMapper.updateProductNum(userName,pId,pNum);
    }

    //根据用户名查询此用户购物车
    @Override
    public List<UserCart> queryTheShoppingCartOfThisUserAccordingToTheUserName(String userName) {
        return userCartMapper.queryTheShoppingCartOfThisUserAccordingToTheUserName(userName);
    }

    //删除购物车中单个商品根据用户名和此商品id
    @Override
    public int singleDelete(String userName, Integer pId) {
        return userCartMapper.singleDelete(userName,pId);
    }

    //删除购物车中多个商品根据用户名和此商品的id
    @Override
    public int selectDelete(String userName, List pIds) {
        return userCartMapper.selectDelete(userName,pIds);
    }

    //product表中根据id删除此id的数量
    @Override
    public int selectProductDeleteNumById(Integer id, Integer nums) {
        return userCartMapper.selectProductDeleteNumById(id,nums);
    }

    //订单信息存放到订单表
    @Override
    public int insertOrderInfo(List<OrderItem> orderItemList) {
        return userCartMapper.insertOrderInfo(orderItemList);
    }


}
