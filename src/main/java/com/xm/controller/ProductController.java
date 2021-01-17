package com.xm.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.bean.Product;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ming
 * @create 2020-08-21 16:12
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //进入商品页面后，就会发送ajax请求，此请求会获取默认商品（品牌成色存储价格都不限）页面的数据，来到第一页数据
    @RequestMapping(value="/getData")
    @ResponseBody
    public PageInfo getData(){
        //用到PageHelper分页插件
        /**
         * new PageInfo能获取下面数据等等
         * pageNum：当前页码
         * pages：总页码
         * total：总数据
         * list：能在视图层运用遍历取出数据库表中每一行(每一行就是一个list)的具体数据
         * **/
        //传入要查询的页码以及当前页面想展示几个数据
        //这个12的意思是点击第一页就显示12个数据，点击第二页才显示接下来的12个数据
        PageHelper.startPage(1,12);//这段代码下面紧跟着的查询就是被认作是分页查询
        //查询所有数据，这些数据遍历后只能看到12个，因为分页规定了12个为一页，遍历只能有12个不是代表数据没有查全，而是其他数据被放到了其他页数中
        //当我们再次请求这个方法时，将形参pn也就是页数赋值为其他页，比如第二页，那这12个数据就是存在第二页中的12个数据
        List<Product> productData=productService.getData();
        //将查询的数据封装给PageInfo，4代表分页栏每次显示4页,如1，2，3，4，只有这4页能点击，点击到第4页再出来第5页以后页数
        PageInfo page=new PageInfo(productData,4);

        return page;
    }


    /**
     * 用户在主页的我要买板块点击要买的品牌，进入此方法
     * 此方法会接收用户点击的是哪个品牌，然后存放在session中，
     * 在product.jsp中，获得这些session，哪个有值，说明用户点的是哪个品牌，然后
     * document.getElementById("").click();自动点击product页面的此品牌点击事件，商品就展示出来了
     * **/
    @RequestMapping(value="/wantToBuy")
    @ResponseBody
    public String wantToBuy(@RequestParam(value="brand")String brand, HttpSession session){
        if(brand.equals("pingguo")){
            System.out.println("进入苹果");
            session.setAttribute("pingguo","pingguo");
            return "product";
        }else if(brand.equals("sanxing")){
            System.out.println("进入三星");
            session.setAttribute("sanxing","sanxing");
            return "product";
        }else if(brand.equals("huawei")){
            System.out.println("进入华为");
            session.setAttribute("huawei","huawei");
            return "product";
        }else if(brand.equals("xiaomi")){
            System.out.println("进入小米");
            session.setAttribute("xiaomi","xiaomi");
            return "product";
        }else if(brand.equals("oppo")){
            System.out.println("进入oppo");
            session.setAttribute("oppo","oppo");
            return "product";
        }else if(brand.equals("vivo")){
            System.out.println("进入vivo");
            session.setAttribute("vivo","vivo");
            return "product";
        }
        return null;
    }

    //用户点击具体商品进入具体商品视图界面
    //produces = "text/plain;charset=utf-8"    是springmvc相应给ajax的内容不出现乱码
    @RequestMapping(value="/productDetails",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String productDetails(@RequestParam(value="id")Integer id, Model model) throws UnsupportedEncodingException {
        System.out.println("请求进来了");
        System.out.println(id);
        //根据id查询商品的具体信息
        Product product=productService.getProductById(id);
        //获取此商品的品牌id
        Integer p_id=product.getpBrandId();
        //根据品牌id查询商品的描述
        String describe=productService.getProductDescribeById(p_id);

        //将商品具体信息和品牌的描述放入map
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("product",product);
        map.put("describe",describe);

        //将map转成json字符串到jsp，jsp将map转换成json格式对象便于取值
        String jsonString = JSON.toJSONString(map);

        return jsonString;
    }



}
