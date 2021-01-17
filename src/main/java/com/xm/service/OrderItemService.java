package com.xm.service;

import com.xm.bean.OrderItem;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Ming
 * @create 2020-11-02 9:05
 */
public interface OrderItemService {

    //根据用户名查询订单信息
    public List<OrderItem> getOrderInfoByUserName(@RequestParam("userName")String userName);

}
