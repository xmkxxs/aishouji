package com.xm.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.bean.Product;
import com.xm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Collections;

/**
 * @author Ming
 * @create 2020-09-03 1:12
 *
 * 商品分页处理servlet
 */
@Controller
@RequestMapping("/page")
public class PagingController {

    @Autowired
    private ProductService productService;

    //分配器
    @RequestMapping(value="/distributor")
    public String distributor(@RequestBody String str, HttpServletRequest request){
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String tiaojian01 = (String) object.get("tiaojian01");//pin pai
        String level = (String) object.get("tiaojian02");//cheng se
        String size = (String) object.get("tiaojian03");//cun chu
        String price = (String) object.get("tiaojian04");//jia ge
        Integer pageNum = (Integer) object.get("tiaojian05");//di ji ye
        int sum=0;

        if(!tiaojian01.equals("default")){
            sum+=1;
        }
        if(!level.equals("default")){
            sum+=1;
        }
        if(!size.equals("default")){
            sum+=1;
        }
        if(!price.equals("default")){
            sum+=1;
        }

        //如果品牌成色存储价格都是default，说明用户未点击任何条件
        if(sum==0){
            request.setAttribute("pageNum",pageNum);
            return "forward:/page/defaultConditions";
        }
        else if(sum==1){//如果sum=1，说明用户点击了一个条件，具体是品牌还是成色还是啥的，进入另外的方法判断
            request.setAttribute("pageNum",pageNum);
            request.setAttribute("tiaojian01",tiaojian01);
            request.setAttribute("level",level);
            request.setAttribute("size",size);
            request.setAttribute("price",price);
            return "forward:/page/singleCondition";
        }
        else if(sum==2){
            request.setAttribute("pageNum",pageNum);
            request.setAttribute("tiaojian01",tiaojian01);
            request.setAttribute("level",level);
            request.setAttribute("size",size);
            request.setAttribute("price",price);
            return "forward:/page/twoCondition";
        }
        else if(sum==3){
            request.setAttribute("pageNum",pageNum);
            request.setAttribute("tiaojian01",tiaojian01);
            request.setAttribute("level",level);
            request.setAttribute("size",size);
            request.setAttribute("price",price);
            return "forward:/page/threeCondition";
        }
        else {
            return null;
        }
    }

    //当用户无任何点击的商品页面分页
    @RequestMapping(value="/defaultConditions")
    @ResponseBody
    public PageInfo defaultConditions(HttpServletRequest request){
        Integer pageNum=(Integer)request.getAttribute("pageNum");
        PageHelper.startPage(pageNum, 12);
        List<Product> list = productService.getData();
        PageInfo page = new PageInfo(list, 4);
        return page;
    }



    //当用户只点击一个条件的商品页面的分页
    @RequestMapping(value="/singleCondition")
    @ResponseBody
    public PageInfo singleCondition(HttpServletRequest request){
        Integer pageNum=(Integer)request.getAttribute("pageNum");
        String tiaojian01=(String)request.getAttribute("tiaojian01");
        String level=(String)request.getAttribute("level");
        String size=(String)request.getAttribute("size");
        String price=(String)request.getAttribute("price");
        if(!tiaojian01.equals("default") && level.equals("default") && size.equals("default") && price.equals("default")){
            //如果用户只点击了品牌
            if(tiaojian01.equals("pingguo")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }
        else if(tiaojian01.equals("default") && !level.equals("default") && size.equals("default") && price.equals("default")){
            //如果用户只点击了成色
            if (level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

        }
        else if(tiaojian01.equals("default") && level.equals("default") && !size.equals("default") && price.equals("default")){
            //如果用户只点击了存储
            if(size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

        }
        else if(tiaojian01.equals("default") && level.equals("default") && size.equals("default") && !price.equals("default")){
            //如果用户只点击了价格
            if(price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }
        return null;//不加这句就报编译错误
    }

    //当用户只点击二个条件的商品页面的分页
    @RequestMapping(value="/twoCondition")
    @ResponseBody
    public PageInfo twoCondition(HttpServletRequest request) {
        Integer pageNum = (Integer) request.getAttribute("pageNum");
        String tiaojian01 = (String) request.getAttribute("tiaojian01");
        String level = (String) request.getAttribute("level");
        String size = (String) request.getAttribute("size");
        String price = (String) request.getAttribute("price");

        if(!tiaojian01.equals("default") && !level.equals("default") && size.equals("default") && price.equals("default")){
            //如果用户点了品牌和成色
            if(tiaojian01.equals("pingguo") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }else if(!tiaojian01.equals("default") && level.equals("default") && !size.equals("default") && price.equals("default")){
            //如果用户点了品牌和存储
            if(tiaojian01.equals("pingguo") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }else if(!tiaojian01.equals("default") && level.equals("default") && size.equals("default") && !price.equals("default")){
            //如果用户点了品牌和价格
            if (tiaojian01.equals("pingguo") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("pingguo") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("pingguo") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("pingguo") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("pingguo") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("pingguo") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("sanxing") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("huawei") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("xiaomi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("oppo") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("vivo") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (tiaojian01.equals("buxian") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }else if(tiaojian01.equals("default") && !level.equals("default") && !size.equals("default") && price.equals("default")){
            //如果用户点了成色和存储
            if(level.equals("jiujiu") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }else if(tiaojian01.equals("default") && !level.equals("default") && size.equals("default") && !price.equals("default")){
            //如果用户点了成色和价格
            if(level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }else if(tiaojian01.equals("default") && level.equals("default") && !size.equals("default") && !price.equals("default")){
            //如果用户点了存储和价格
            if (size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if (size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
        }
            return null;
    }

    //当用户只点击三个条件的商品页面的分页
    @RequestMapping(value="/threeCondition")
    @ResponseBody
    public PageInfo threeCondition(HttpServletRequest request) {
        Integer pageNum = (Integer) request.getAttribute("pageNum");
        String tiaojian01 = (String) request.getAttribute("tiaojian01");
        String level = (String) request.getAttribute("level");
        String size = (String) request.getAttribute("size");
        String price = (String) request.getAttribute("price");

        if(!tiaojian01.equals("default") && !level.equals("default") && !size.equals("default") && price.equals("default")){
            //如果用户点击了品牌成色存储
            if(tiaojian01.equals("pingguo")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(1,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(1,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(1,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(1,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(1,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(1,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(1,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(1,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(1,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getApple();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("sanxing")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(2,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(2,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(2,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(2,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(2,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(2,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(2,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(2,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(2,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getSamsung();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("huawei")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(3,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(3,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(3,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(3,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(3,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(3,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(3,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(3,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(3,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getHuawei();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("xiaomi")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(4,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(4,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(4,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(4,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(4,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(4,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(4,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(4,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(4,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getXiaomi();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("oppo")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(5,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(5,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(5,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(5,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(5,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(5,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(5,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(5,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(5,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getOppo();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("vivo")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(6,"99");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(6,"95");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(6,"9");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevelAndSize(6,"8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndLevel(6,"8");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(6,"512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(6,"256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(6,"128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getBrandAndSize(6,"64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getVivo();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
            else if(tiaojian01.equals("buxian")){
                if(level.equals("jiujiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("99","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("99","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("99","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("99","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getjiujiu();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiuwu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("95","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("95","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("95","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("95","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getjiuwu();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("jiu")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("9","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("9","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("9","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("9","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getjiu();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("ba")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("8","512");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("8","256");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("8","128");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getLevelAndSize("8","64");
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getba();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }else if(level.equals("buxianchengse")){
                    if(size.equals("wuyier")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getwuyier();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("erwuliu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.geterwuliu();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("yierba")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getyierba();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("liusi")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getliusi();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }else if(size.equals("buxiancunchu")){
                        PageHelper.startPage(pageNum,12);
                        List<Product> list=productService.getData();
                        PageInfo page=new PageInfo(list,4);
                        return page;
                    }
                }
            }
        }else if(!tiaojian01.equals("default") && !level.equals("default") && size.equals("default") && !price.equals("default")){
            //如果用户点击了品牌成色价格
            if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(1,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(2,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(3,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(4,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(5,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"99");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"95");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"9");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndLevel(6,"8");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","3100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiujiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiuwu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","3500");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("jiu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","2100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("ba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && level.equals("buxianchengse") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

        }else if(!tiaojian01.equals("default") && level.equals("default") && !size.equals("default") && !price.equals("default")){
            //如果用户点击了品牌存储价格
            if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(1,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(1,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("pingguo") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getApple();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(2,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(2,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("sanxing") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSamsung();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(3,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(3,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("huawei") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getHuawei();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(4,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(4,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("xiaomi") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getXiaomi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(5,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(5,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("oppo") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getOppo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndSize(6,"64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getBrandAndPrice(6,"4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("vivo") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getVivo();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(tiaojian01.equals("buxian") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

        }else if(tiaojian01.equals("default") && !level.equals("default") && !size.equals("default") && !price.equals("default")){
            //如果用户点击了成色存储价格
            if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("99","64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("99","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("99","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("95","64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("95","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("95","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiuwu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("9","64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("9","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("9","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getjiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","512");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","256");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","128");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSizeAndPrice("8","64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndSize("8","64");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getLevelAndPrice("8","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }

            else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("512","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getwuyier();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("256","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterwuliu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("128","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyierba();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1000");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","1888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","2888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","3888");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getSizeAndPrice("64","4100");
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getliusi();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getlingdaoyisijiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getdayusilinglingling();
                PageInfo page=new PageInfo(list,4);
                return page;
            }else if(level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")){
                PageHelper.startPage(pageNum,12);
                List<Product> list=productService.getData();
                PageInfo page=new PageInfo(list,4);
                return page;
            }
            else {
                return null;
            }
        }
        return null;
    }

    //四条件分页查询，只要用户点击了苹果三星华为其中一个就会进入这个方法,含有其他品牌的进入另外方法
    //四条件的方法不会走分配方法，在js进行判断会直接进入四条件方法
    @RequestMapping(value="/fourOne")
    @ResponseBody
    public PageInfo fourOne(@RequestBody String str) {
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String tiaojian01 = (String) object.get("tiaojian01");//pin pai
        String level = (String) object.get("tiaojian02");//cheng se
        String size = (String) object.get("tiaojian03");//cun chu
        String price = (String) object.get("tiaojian04");//jia ge
        Integer pageNum = (Integer) object.get("tiaojian05");//di ji ye

        //99
        if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(1, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //95
        else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(1, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //9
        else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(1, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //8
        else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(1, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //buxianchengse
        else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(1, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(1, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(1, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(1, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(1, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(1, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(1, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(1, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(1, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("pingguo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getApple();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(2, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //95
        else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(2, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //9
        else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(2, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //8
        else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(2, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //buxianchengse
        else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(2, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(2, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(2, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(2, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(2, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(2, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(2, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(2, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(2, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("sanxing") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSamsung();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(3, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(3, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(3, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(3, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(3, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(3, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(3, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(3, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(3, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(3, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(3, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(3, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(3, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (tiaojian01.equals("huawei") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getHuawei();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else {
            return null;
        }
    }

    //四条件分页查询，只要用户点击了小米oppo vivo和不限 其中一个就会进入这个方法
    @RequestMapping(value="/fourTwo")
    @ResponseBody
    public PageInfo fourTwo(@RequestBody String str) {
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String tiaojian01 = (String) object.get("tiaojian01");//pin pai
        String level = (String) object.get("tiaojian02");//cheng se
        String size = (String) object.get("tiaojian03");//cun chu
        String price = (String) object.get("tiaojian04");//jia ge
        Integer pageNum = (Integer) object.get("tiaojian05");//di ji ye

        //99
        if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(4, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(4, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(4, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(4, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(4, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(4, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(4, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(4, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(4, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(4, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(4, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(4, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(4, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("xiaomi") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getXiaomi();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(5, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(5, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(5, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(5, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(5, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(5, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(5, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(5, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(5, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(5, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(5, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(5, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(5, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("oppo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getOppo();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(6, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(6, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(6, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndLevel(6, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(6, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(6, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(6, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndSize(6, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(6, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(6, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(6, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(6, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getBrandAndPrice(6, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("vivo") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getVivo();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiujiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getjiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiuwu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getjiuwu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("jiu") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getjiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndSize("8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getLevelAndPrice("8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("ba") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getba();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("wuyier") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getwuyier();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("erwuliu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.geterwuliu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("yierba") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getyierba();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getSizeAndPrice("64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("liusi") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getliusi();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getlingdaoyisijiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("dayusilinglingling")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getdayusilinglingling();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (tiaojian01.equals("buxian") && level.equals("buxianchengse") && size.equals("buxiancunchu") && price.equals("buxianjiage")) {
            PageHelper.startPage(pageNum, 12);
            List<Product> list = productService.getData();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        else {
            return null;
        }
    }

}
