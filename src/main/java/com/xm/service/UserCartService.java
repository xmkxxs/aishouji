package com.xm.service;

import com.xm.bean.OrderItem;
import com.xm.bean.UserCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ming
 * @create 2020-09-30 16.56
 */
public interface UserCartService {

    //商品添加到用户购物车
    public int addCart(@Param("userName")String userName,@Param("pId")Integer pId,@Param("pNum")Integer pNum,@Param("userAddress")String userAddress,@Param("pImg")String pImg,@Param("pBrandDescribe")String pBrandDescribe,@Param("pPrice")String pPrice);

    //按商品id查询某用户购物车中是否存在此商品
    public int existProductIdByUserName(@Param("userName")String userName,@Param("pId")Integer pId);

    //查询用户购物车中某一id商品的数量
    public int productNum(@Param("userName")String userName,@Param("pId")Integer pId);

    //更新某一商品的数量
    public int updateProductNum(@Param("userName")String userName,@Param("pId")Integer pId,@Param("pNum")Integer pNum);

    //根据用户名查询此用户购物车
    public List<UserCart> queryTheShoppingCartOfThisUserAccordingToTheUserName(@Param("userName")String userName);

    //删除购物车中单个商品根据用户名和此商品id
    public int singleDelete(@Param("userName")String userName,@Param("pId")Integer pId);

    //删除购物车中多个商品根据用户名和此商品的id
    public int selectDelete(@Param("userName")String userName,@Param("pIds")List pIds);

    //product表中根据id删除此id的数量
    public int selectProductDeleteNumById(@Param("id")Integer id,@Param("nums")Integer nums);

    //订单信息存放到订单表
    public int insertOrderInfo(@Param("orderItemList")List<OrderItem> orderItemList);

}
