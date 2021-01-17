package com.xm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xm.bean.*;
import com.xm.service.ProductService;
import com.xm.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Ming
 * @create 2020-09-27 14:43
 */
@Controller
@RequestMapping("/cart")
public class UserCartController {

    @Autowired
    UserCartService userCartService;
    @Autowired
    ProductService productService;

    //用户点击商品详情页面的加入购物车
    @RequestMapping(value="/addToCart",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addToCart(@RequestBody String jsonStr, HttpSession session){
        //将发送过来的json字符串转换成json对象
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        //获取当前商品id
        Integer id= (Integer) jsonObject.get("id");
        //获取购买数量
        Integer num= (Integer) jsonObject.get("num");
        //获取配送地址
        String address= (String) jsonObject.get("address");
        //根据此商品id，查询此商品的图片名，口号以及单价
        Product product=productService.getProductById(id);
        System.out.println(product+"        ........product");
        String pImg=product.getpImg();//图片名
        Integer pBrandId=product.getpBrandId();
        String pPrice=product.getpPrice();//单价
        String pBrandDescribe=productService.getProductDescribeById(pBrandId);//商品口号（描述）
        System.out.println(pImg+"]]]]"+pPrice+"]]]]"+pBrandDescribe);

        //从session中获取用户名
        User user=(User)session.getAttribute("user");
        String userName=user.getUserName();
        System.out.println(id+"id");
        System.out.println(num+"num");
        System.out.println(address+"address");
        System.out.println(userName+"userName");
        //先查询xxx的购物车中是否存在此id的商品
        //如果存在，查询此商品数量，如果用户即将要加入的数量加上购物车中的数量>5，提示用户最多还能加几个,如果相加小于等于5，直接更新
        //如果不存在，直接插入
        Integer numOfIdByUserName=userCartService.existProductIdByUserName(userName,id);//查询此用户购物车是否存在此id商品,有数据返回1，代表存在1行，否则0
        System.out.println("存在此商品吗？"+numOfIdByUserName);
        if(numOfIdByUserName==1){//如果用户购物车中就存在此商品
            //查询此商品在数据库中的数量
            Integer productNum=userCartService.productNum(userName,id);
            if(productNum>=5){//如果此商品数量已经是5了，提示用户无法添加了
                //ajax的success判断如果返回full，提示购物车最多添加5个同一商品！
                return "full";
            }else if(productNum+num>5){//如果用户即将想加入购物车的数量加上购物车中已存在的数量>5，提示用户最多还能加几个。
                int also=5-productNum;
                System.out.println("最多还能添加"+also+"个此商品");
                return "最多还能添加"+also+"个此商品";
            }else if(productNum+num<=5){//用户即将想加入购物车的数量加上购物车中已存在的数量<=5，更新购物车中的数量
                userCartService.updateProductNum(userName,id,productNum+num);
                return "success";
            }
        }else {//如果没有此商品的话直接添加此商品进入用户的购物车
            userCartService.addCart(userName,id,num,address,pImg,pBrandDescribe,pPrice);
            return "success";
        }
        return null;
    }

    //根据用户名查询此用户购物车
    @RequestMapping(value="/queryTheShoppingCartOfThisUserAccordingToTheUserName",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryTheShoppingCartOfThisUserAccordingToTheUserName(@RequestParam(value="userName")String userName,HttpSession session){
        System.out.println(" 进来了查询购物车");
        System.out.println(userName);
        List<UserCart> userCart= userCartService.queryTheShoppingCartOfThisUserAccordingToTheUserName(userName);
        System.out.println(userCart);
        if(userCart == null || userCart.size() ==0 ){ //如果用户购物车为空
            //如果用户购物车为空，设置一个session，在购物车页面根据session来设置页面是空的效果还是展示购物车
            session.removeAttribute("cartShowSomething");
            session.setAttribute("cartShowSomething","null");
        }else {
            session.removeAttribute("cartShowSomething");
            session.setAttribute("cartShowSomething","notEmpty");
        }
        String jsonString = JSON.toJSONString(userCart);//将list转换成json文本进行传输
        return jsonString;
    }

    //购物车中单个物品删除
    @RequestMapping(value="/singleDelete")
    @ResponseBody
    public String singleDelete(@RequestParam(value="id")Integer id,HttpSession session){
        //从session中获取用户名
        User user=(User)session.getAttribute("user");
        String userName=user.getUserName();
        //调用删除方法
        userCartService.singleDelete(userName,id);
        return null;
    }

    //购物车中被勾选的商品或被勾选的多个商品的删除
    @RequestMapping(value="/selectDelete")
    @ResponseBody
    public String selectDelete(@RequestBody String jsonProductIdList, HttpSession session){
        //将发送过来的json字符串转换成json对象
        JSONObject ProductIdList = JSONObject.parseObject(jsonProductIdList);
        //创建list，将json对象中存放的的id值遍历到list中
        List list=new ArrayList();
        for (int i=0;i<ProductIdList.size();i++){
            //按key取值,放入list
            list.add(ProductIdList.get("id"+i));
        }

        //从session中获取用户名
        User user=(User)session.getAttribute("user");
        String userName=user.getUserName();

        //调用删除方法
        userCartService.selectDelete(userName,list);

        return "success";
    }

    //用户点击结算按钮，将结算的商品数据传到确认信息页面
    @RequestMapping(value="/infoConfirmation")
    @ResponseBody
    public String infoConfirmation(@RequestBody String jsonStr,HttpSession session){
        //将信息传入session中便于结算页面取值
        session.setAttribute("checkoutProductData",jsonStr);
        return jsonStr;
    }

    //跳转到结算页面
    @RequestMapping(value="/checkout")
    public String checkout(HttpSession session){
        System.out.println("进入跳转服务器");
        System.out.println(session.getAttribute("checkoutProductData"));
        return "WEB-INF/views/checkout";
    }

    //结算页面首先加载的ajax请求,将结算页面需要的数据传递过去
    @RequestMapping(value="/CheckoutOrderData")
    @ResponseBody
    public String CheckoutOrderData(@RequestBody String jsonStr){
        System.out.println("进入确认订单服务器CheckoutOrderData");
        System.out.println(jsonStr);
        //传递过来的是一个json字符串数组，这个字符串数据需要在js中自己定义成这种格式
        //如[{"id":32,"pNum":1,"pPrice":"1200","pImg":"huaweinova7se.png"},{"id":31,"pNum":1,"pPrice":"2700","pImg":"huaweip40.png"},{"id":21,"pNum":1,"pPrice":"5700","pImg":"samsungnote20ultra.png"}]
        //将json字符串数组转换成list对象集合
        List<Product> productList = JSON.parseArray(jsonStr, Product.class);
        /**转换出结果如
         [
         Product{id=32, pName='null', pLevel='null', pPrice='1200', pImg='huaweinova7se.png', pNum='1', pBrandId=0, pSize='null', pRam='null'},
         Product{id=31, pName='null', pLevel='null', pPrice='2700', pImg='huaweip40.png', pNum='1', pBrandId=0, pSize='null', pRam='null'},
         Product{id=21, pName='null', pLevel='null', pPrice='5700', pImg='samsungnote20ultra.png', pNum='1', pBrandId=0, pSize='null', pRam='null'}
         ]
        **/
        System.out.println(productList);
        //把list转换出json字符串便于传递
        String jsonString = JSON.toJSONString(productList);

        return jsonString;
    }

    //结算,生成订单号,删除购物车
    @RequestMapping(value="/checkoutSuccess")
    @ResponseBody
    public String checkoutSuccess(@RequestBody String jsonStr,HttpSession session){
        System.out.println("进入结算成功");
        System.out.println(jsonStr+"this is json str++++++++++++++++++++++++++++++++++$$$$$$$$$$$$$$$$$$");
        //将jsonStr先放入session，里面有需要用到的每个商品的描述
        session.setAttribute("includeMiaoShu",jsonStr);
        //将json字符串数组转换成list对象集合
        List<Product> productList = JSON.parseArray(jsonStr, Product.class);
        System.out.println(productList);
        //设计订单编号
        String order1="asj";
        //格式化当前时间
        SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String strDate = sfDate.format(new Date());
        //得到17位时间如：20170411094039080
        System.out.println("时间17位：" + strDate);
        //为了防止高并发重复,再获取3个随机数
        String random = getRandom620(3);

        //最后得到20位订单编号+"asj"。
        String orderNumber=order1+strDate+random;
        System.out.println("订单号asj20位：" + orderNumber);

        /**
         *
         * 将用户购买的物品放入订单表以及订单号，以及数据库中减去用户买的物品个数
         *
         * **/

        //创建两个空list，分别 “对应” 位置存放要从数据库中删除商品id以及此id商品的个数
        //如32  1
        //  31  4
        //  21  2       id和删除数对应
        List<Integer> listId=new ArrayList();
        List<Integer> listNum=new ArrayList();
        for(int i=0;i<productList.size();i++) {//逐一取出productList,将id和数量对应存放进list
            System.out.print(productList.get(i).getId()+"  ");
            System.out.println(productList.get(i).getpNum()+"  ");
            listId.add(productList.get(i).getId());
            listNum.add(Integer.parseInt(productList.get(i).getpNum()));
        }
        System.out.println("----------------------------");
        /*  测试id和num是否对应
        for(int i=0;i<listId.size();i++) {
            System.out.print(listId.get(i)+",");
        }
        System.out.println();
        for(int i=0;i<listNum.size();i++) {
            System.out.print(listNum.get(i)+",");
        }
        */
        for(int i=0;i<listId.size();i++){
            userCartService.selectProductDeleteNumById(listId.get(i),listNum.get(i));
        }

        //根据id将此商品从购物车删除
        //从session中获取用户名
        User user=(User)session.getAttribute("user");
        String userName=user.getUserName();
        for(int i=0;i<listId.size();i++){
            userCartService.singleDelete(userName,listId.get(i));
        }

        //再把信息加入到订单表中，由于信息中包含了地址，地址当时没有放到json中，我们在success回调函数中再发一次ajax用于传输地址
        //把信息放入session
        session.setAttribute("insertOrderInfo",productList);
        //订单号放入session
        session.setAttribute("orderId",orderNumber);


        return null;
    }

    //将订单信息放入订单表
    @RequestMapping(value="/checkoutEnd")
    @ResponseBody
    public String checkoutEnd(@RequestParam(value = "address")Object address,HttpSession session){
        System.out.println("进入最后成功页面");
        System.out.println("地址"+address);
        //获取订单号
        String orderId= (String) session.getAttribute("orderId");
        System.out.println(orderId);
        //获取需要加入到orderitem表的商品信息
        List<Product> productList = (List<Product>) session.getAttribute("insertOrderInfo");
        System.out.println(productList);
        //获取用户名
        User user=(User)session.getAttribute("user");
        String userName=user.getUserName();

        //获取含有描述商品的json数据
        String includeMiaoShuJson = (String) session.getAttribute("includeMiaoShu");
        System.out.println(includeMiaoShuJson);
        //将json字符串数组转换成list对象集合,为了取出pBrandDescribe商品描述属性
        List<CarrierPOJO> carrierPOJOList = JSON.parseArray(includeMiaoShuJson, CarrierPOJO.class);
        System.out.println(carrierPOJOList);

        //接下做的所有数据取出整合到此List中
        List<OrderItem> orderItemList=new ArrayList<>();

        /*for(int i=0;i<productList.size();i++) {//逐一取出productList,将id和数量对应存放进list
            System.out.print(productList.get(i).getId()+"  ");
            System.out.print(productList.get(i).getpPrice()+"  ");
            System.out.print(productList.get(i).getpImg()+"  ");
            System.out.println(productList.get(i).getpNum()+"  ");
        }*/
        for(int i=0;i<productList.size();i++) {
            OrderItem orderItem=new OrderItem();
            orderItem.setId(productList.get(i).getId());
            orderItem.setOrderId(orderId);
            orderItem.setpImg(productList.get(i).getpImg());
            orderItem.setpNum(productList.get(i).getpNum());
            orderItem.setpPrice(productList.get(i).getpPrice());
            orderItem.setUserName(userName);
            orderItem.setUserAddress((String)address);

            for (int j=0;j<carrierPOJOList.size();j++){
                if(productList.get(i).getId()==carrierPOJOList.get(j).getId()){
                    orderItem.setpBrandDescribe(carrierPOJOList.get(j).getpBrandDescribe());
                }
            }
            orderItemList.add(orderItem);
        }
        System.out.println("++++++++++++++++++++++++");
        System.out.println(orderItemList);
        //将orderItemList内容存放到数据库
        userCartService.insertOrderInfo(orderItemList);
        System.out.println("是否能走到这步？？？？？？？？？？？？？？？");

        return orderId;
    }

    /**
     * 作为方法被调用
     * 获取6-10 的随机位数数字
     * @param length	想要生成的长度
     * @return result
     */
    public static String getRandom620(Integer length) {
        String result = "";
        Random rand = new Random();
        int n = 20;
        if (null != length && length > 0) {
            n = length;
        }
        int randInt = 0;
        for (int i = 0; i < n; i++) {
            randInt = rand.nextInt(10);
            result += randInt;
        }
        return result;
    }


}
