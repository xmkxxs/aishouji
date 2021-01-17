package com.xm.serviceImpl;

import com.xm.bean.OrderItem;
import com.xm.dao.OrderItemMapper;
import com.xm.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2020-11-2 9:06
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    //根据用户名查询订单信息
    @Override
    public List<OrderItem> getOrderInfoByUserName(String userName) {
        return orderItemMapper.getOrderInfoByUserName(userName);
    }
}
