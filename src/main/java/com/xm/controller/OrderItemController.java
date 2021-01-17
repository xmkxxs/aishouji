package com.xm.controller;

import com.alibaba.fastjson.JSON;
import com.xm.bean.OrderItem;
import com.xm.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ming
 * @create 2020-11-2 9:34
 */
@Controller
@RequestMapping("/order")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;


    //produces = "text/plain;charset=utf-8" 传递过去的字符串不会乱码
    //进入用户订单页面后，查询用户所有订单并到前端展示
    @RequestMapping(value = "userOrderInfo",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String userOrderInfo(@RequestParam("userName")String userName){
        System.out.println("进去查询订单service");
        System.out.println(userName);

        //根据用户名查询用户订单信息
        List<OrderItem> orderItemList=new ArrayList<>();
        orderItemList=orderItemService.getOrderInfoByUserName(userName);

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        //将orderItemList按OrderId分组
        Map<String,List<OrderItem>> listMap = orderItemList.stream().collect(Collectors.groupingBy(OrderItem::getOrderId));
        //System.out.println(listMap);
        //输出测试；
        Set<Map.Entry<String,List<OrderItem>>> set =  listMap.entrySet();
        Iterator<Map.Entry<String,List<OrderItem>>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println("key:"+entry.getKey()+" val:"+entry.getValue());
        }
        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");

        System.out.println(listMap.size());
        System.out.println(listMap.isEmpty());

        //Map转换成JSON字符串
        String jsonStringMap = JSON.toJSONString(listMap);
        System.out.println(jsonStringMap);

        //将List转换出JSON字符串
        //String jsonString = JSON.toJSONString(orderItemList);
        //System.out.println(orderItemList);

        return jsonStringMap;
    }

}
