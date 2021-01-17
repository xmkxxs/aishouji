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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ming
 * @create 2020-09-06 11:54
 *
 * product页面多条件查询服务器
 *
 * 含有单条件查询 如用户只点击苹果这一品牌单条件
 * 或双条件，三条件，四条件
 */
@Controller
@RequestMapping("/conditionsQuery")
public class ConditionsQueryController {

    @Autowired
    private ProductService productService;

    //分类列表单条件查询
    @RequestMapping(value="/singleConditionQuery")
    @ResponseBody
    public PageInfo singleConditionQuery(@RequestParam(value = "condition")String condition){
        if(condition.equals("pingguo")){
            PageHelper.startPage(1,12);
            List<Product> appleList=productService.getApple();
            PageInfo page=new PageInfo(appleList,4);
            return page;
        }else if(condition.equals("sanxing")){
            PageHelper.startPage(1,12);
            List<Product> sansungList=productService.getSamsung();
            PageInfo page=new PageInfo(sansungList,4);
            return page;
        }else if(condition.equals("huawei")){
            PageHelper.startPage(1,12);
            List<Product> huaweiList=productService.getHuawei();
            PageInfo page=new PageInfo(huaweiList,4);
            return page;
        }else if(condition.equals("xiaomi")){
            PageHelper.startPage(1,12);
            List<Product> xiaomiList=productService.getXiaomi();
            PageInfo page=new PageInfo(xiaomiList,4);
            return page;
        }else if(condition.equals("oppo")){
            PageHelper.startPage(1,12);
            List<Product> oppoList=productService.getOppo();
            PageInfo page=new PageInfo(oppoList,4);
            return page;
        }else if(condition.equals("vivo")){
            PageHelper.startPage(1,12);
            List<Product> vivoList=productService.getVivo();
            PageInfo page=new PageInfo(vivoList,4);
            return page;
        }else if(condition.equals("buxian")){
            PageHelper.startPage(1,12);
            List<Product> brandUnlimitedList=productService.getBrandUnlimited();
            PageInfo page=new PageInfo(brandUnlimitedList,4);
            return page;
        }else if(condition.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> jiujiuList=productService.getjiujiu();
            PageInfo page=new PageInfo(jiujiuList,4);
            return page;
        }else if(condition.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> jiuwuList=productService.getjiuwu();
            PageInfo page=new PageInfo(jiuwuList,4);
            return page;
        }else if(condition.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> jiuList=productService.getjiu();
            PageInfo page=new PageInfo(jiuList,4);
            return page;
        }else if(condition.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> baList=productService.getba();
            PageInfo page=new PageInfo(baList,4);
            return page;
        }else if(condition.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> buxianchengseList=productService.getLevelUnlimited();
            PageInfo page=new PageInfo(buxianchengseList,4);
            return page;
        }else if(condition.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> wuyierList=productService.getwuyier();
            PageInfo page=new PageInfo(wuyierList,4);
            return page;
        }else if(condition.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> erwuliuList=productService.geterwuliu();
            PageInfo page=new PageInfo(erwuliuList,4);
            return page;
        }else if(condition.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> yierbaList=productService.getyierba();
            PageInfo page=new PageInfo(yierbaList,4);
            return page;
        }else if(condition.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> liusiList=productService.getliusi();
            PageInfo page=new PageInfo(liusiList,4);
            return page;
        }else if(condition.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> buxiancunchuList=productService.getSizeUnlimited();
            PageInfo page=new PageInfo(buxiancunchuList,4);
            return page;
        }else if(condition.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> lingdaoyisijiujiuList=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(lingdaoyisijiujiuList,4);
            return page;
        }else if(condition.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> yiwulinglingdaoyijiujiujiuList=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(yiwulinglingdaoyijiujiujiuList,4);
            return page;
        }else if(condition.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> erlinglinglingdaoerjiujiujiuList=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(erlinglinglingdaoerjiujiujiuList,4);
            return page;
        }else if(condition.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> sanlinglinglingdaosanjiujiujiuList=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(sanlinglinglingdaosanjiujiujiuList,4);
            return page;
        }else if(condition.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> dayusilinglinglingList=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(dayusilinglinglingList,4);
            return page;
        }else if(condition.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> buxianjiageList=productService.getPriceUnlimited();
            PageInfo page=new PageInfo(buxianjiageList,4);
            return page;
        }else {
            return null;
        }
    }//单条件查询方法结束


    //分类列表多条件查询的双条件查询
    //如用户点击了苹果，又点击了成色
    @RequestMapping(value="/doubleConditionsQuery")
    @ResponseBody
    public PageInfo doubleConditionsQuery(@RequestBody String str){
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object= JSONObject.parseObject(str);
        String firstTiaoJian= (String) object.get("tiaojian01");
        String secondTiaoJian= (String) object.get("tiaojian02");
        System.out.println(secondTiaoJian);
        if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1000");//价格只要在0-1499之间就行，判断会在mybatis进行
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"5000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1000");//写一个0-1499之间的价格即可，mybatis进行判断
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","3555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1000");//写一个0-1499之间的价格即可，mybatis进行判断
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","3555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1000");//写一个0-1499之间的价格即可，mybatis进行判断
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","3555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1000");//写一个0-1499之间的价格即可，mybatis进行判断
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","3555");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","2988");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","3100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("wuyier") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","2988");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","3100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("erwuliu") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","2988");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","3100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("yierba") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1600");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","2988");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","3100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("liusi") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxiancunchu") && secondTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else {
            return null;
        }
    }//双条件结束


    //分类列表多条件查询的三条件查询
    //如用户点击了品牌，又点击了成色，又点击了存储
    @RequestMapping(value="/threeConditionsQuery")
    @ResponseBody
    public PageInfo threeConditionsQuery(@RequestBody String str) {
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String firstTiaoJian = (String) object.get("tiaojian01");
        String secondTiaoJian = (String) object.get("tiaojian02");
        String thirdTiaoJian = (String) object.get("tiaojian03");
        if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(1,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(2,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(3,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(4,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(5,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndSize(6,"8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }


        else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(1,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(1,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(2,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(2,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(3,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(3,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(4,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(4,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(5,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(5,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"99");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"95");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"9");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevelAndPrice(6,"8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndLevel(6,"8");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","3100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","3500");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","2100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }


        else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(1,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(1,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(1,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getApple();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(2,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(2,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(2,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSamsung();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(3,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(3,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(3,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getHuawei();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(4,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(4,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(4,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getXiaomi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(5,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(5,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(5,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getOppo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSizeAndPrice(6,"64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndSize(6,"64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getBrandAndPrice(6,"4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getVivo();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }


        else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("99","64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("99","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("99","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiujiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("95","64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("95","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("95","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiuwu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiuwu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("9","64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("9","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("9","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("jiu") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getjiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","512");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","256");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","128");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSizeAndPrice("8","64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndSize("8","64");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getLevelAndPrice("8","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("ba") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }

        else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("512","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("wuyier") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getwuyier();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("256","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("erwuliu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterwuliu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("128","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("yierba") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyierba();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1000");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","1888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","2888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","3888");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getSizeAndPrice("64","4100");
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("liusi") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getliusi();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("lingdaoyisijiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getlingdaoyisijiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("yiwulinglingdaoyijiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("erlinglinglingdaoerjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("dayusilinglingling")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getdayusilinglingling();
            PageInfo page=new PageInfo(list,4);
            return page;
        }else if(firstTiaoJian.equals("buxianchengse") && secondTiaoJian.equals("buxiancunchu") && thirdTiaoJian.equals("buxianjiage")){
            PageHelper.startPage(1,12);
            List<Product> list=productService.getData();
            PageInfo page=new PageInfo(list,4);
            return page;
        }
        else {
            return null;
        }
    }//三条件结束


    //分类列表多条件查询的四条件查询 第一个方法
    //如用户点击了品牌，又点击了成色，又点击了存储，又点击了价格
    //此方法只查询 条件中含有苹果，三星，华为 的组合,其他条件在第二个方法
    @RequestMapping(value = "/fourConditionsQueryOne")
    @ResponseBody
    public PageInfo fourConditionsQueryOne(@RequestBody String str) {
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String firstTiaoJian = (String) object.get("tiaojian01");
        String secondTiaoJian = (String) object.get("tiaojian02");
        String thirdTiaoJian = (String) object.get("tiaojian03");
        String fourthTiaoJian = (String) object.get("tiaojian04");
        //99
        if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(1, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //95
        else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(1, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //9
        else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(1, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //8
        else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(1, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(1, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(1, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(1, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //buxianchengse
        else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(1, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(1, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(1, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(1, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(1, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(1, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(1, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(1, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(1, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(1, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("pingguo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getApple();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(2, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //95
        else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(2, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //9
        else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(2, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //8
        else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(2, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(2, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(2, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(2, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
        //buxianchengse
        else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(2, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(2, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(2, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(2, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(2, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(2, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(2, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(2, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(2, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(2, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("sanxing") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSamsung();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(3, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "95", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(3, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "9", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(3, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(3, "8", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(3, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(3, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(3, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(3, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(3, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(3, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(3, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(3, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(3, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(3, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(3, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(3, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(3, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else if (firstTiaoJian.equals("huawei") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getHuawei();
            PageInfo page = new PageInfo(list, 4);
            return page;
        } else {
            return null;
        }
    }//四条件第一个查询方法结束


    //分类列表多条件查询的四条件查询 第二次查询
    //如用户点击了品牌，又点击了成色，又点击了存储，又点击了价格
    //此方法只 查询 条件中含有小米，oppo，vivo，品牌不限 的组合，其他组合在第一次查询
    @RequestMapping(value="/fourConditionsQueryTwo")
    @ResponseBody
    public PageInfo fourConditionsQueryTwo(@RequestBody String str) {
        //将传递过来的json字符串转换成json数组用以取值
        JSONObject object = JSONObject.parseObject(str);
        String firstTiaoJian = (String) object.get("tiaojian01");
        String secondTiaoJian = (String) object.get("tiaojian02");
        String thirdTiaoJian = (String) object.get("tiaojian03");
        String fourthTiaoJian = (String) object.get("tiaojian04");
        //99
        if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(4, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(4, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(4, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(4, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(4, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(4, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(4, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(4, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(4, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(4, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(4, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(4, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(4, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(4, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(4, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(4, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(4, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("xiaomi") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getXiaomi();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(5, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(5, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(5, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(5, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(5, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(5, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(5, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(5, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(5, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(5, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(5, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(5, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(5, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(5, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(5, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(5, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(5, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("oppo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getOppo();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "99", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(6, "99");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(6, "95");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(6, "9");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSizeAndPrice(6, "8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndSize(6, "8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevelAndPrice(6, "8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndLevel(6, "8");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(6, "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(6, "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(6, "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSizeAndPrice(6, "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndSize(6, "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(6, "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(6, "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(6, "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(6, "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getBrandAndPrice(6, "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("vivo") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getVivo();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }


        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("99", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("99", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("99", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("99", "64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("99", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("99", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("99", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("99", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("99", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("99", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiujiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getjiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//95
        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("95", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("95", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("95", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("95", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("95", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("95", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("95", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("95", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("95", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("95", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiuwu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getjiuwu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//9
        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("9", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("9", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("9", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("9", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("9", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("9", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("9", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("9", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("9", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("9", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("jiu") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getjiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//8
        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "512","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("8", "512");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "256","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("8", "256");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "128","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("8", "128");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSizeAndPrice("8", "64","4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndSize("8", "64");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("8", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("8", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("8", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("8", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getLevelAndPrice("8", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("ba") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getba();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }
//buxianchengse
        else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("512", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("512", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("512", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("512", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("512", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("wuyier") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getwuyier();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("256", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("256", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("256", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("256", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("256", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("erwuliu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.geterwuliu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("128", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("128", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("128", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("128", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("128", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("yierba") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getyierba();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("64", "1000");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("64", "1888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("64", "2888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("64", "3888");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getSizeAndPrice("64", "4100");
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("liusi") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getliusi();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("lingdaoyisijiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getlingdaoyisijiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("yiwulinglingdaoyijiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getyiwulinglingdaoyijiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("erlinglinglingdaoerjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.geterlinglinglingdaoerjiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("sanlinglinglingdaosanjiujiujiu")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getsanlinglinglingdaosanjiujiujiu();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("dayusilinglingling")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getdayusilinglingling();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }else if (firstTiaoJian.equals("buxian") && secondTiaoJian.equals("buxianchengse") && thirdTiaoJian.equals("buxiancunchu") && fourthTiaoJian.equals("buxianjiage")) {
            PageHelper.startPage(1, 12);
            List<Product> list = productService.getData();
            PageInfo page = new PageInfo(list, 4);
            return page;
        }

        else {
            return null;
        }

    }//四条件第二组查询方法结束


}//class end
