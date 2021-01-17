<%@ page import="com.xm.bean.Product" %>
<%@ page import="com.xm.bean.User" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>爱手机 · 商品详情</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/login.css">
    <script src="static/js/vue.js"></script>

    <style>
        .w {
            width: 990px;
            margin: 0 auto;
            width: 1210px;
            margin-bottom: 117px;
        }
        .product-intro{
            position: relative;
            *z-index: 1;
            margin-bottom: 10px;
            padding-top: 50px;
        }
        .clearfix{
            *zoom: 1;
        }
        .preview-wrap{
            width: 352px;
            float: left;
        }
        .preview {
            position: relative;
        }
        .main-img {
            border: 1px solid #eee;
            width: 405px;
            height: 300px;
        }
        img {
            border: 0;
            vertical-align: middle;
            width: 400px;
            height: 295px;
        }
        .itemInfo-wrap{
            width: 590px;
            float: left;
            margin-left: 80px;
        }
        .sku-name{
            font: 700 16px Arial,"microsoft yahei";
            color: #666;
            padding-top: 10px;
            line-height: 28px;
            margin-bottom: 5px;
        }
        .p_name{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .p_level{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .p_num{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .p_size{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .p_ram{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .p_price{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            background: #f3f3f3;
        }
        .RMB_symbol{
            font-family: "microsoft yahei";
            font-size: 16px;
            color: #e4393c;
        }
        .RMB_price{
            font-family: "microsoft yahei";
            color: #e4393c;
            font-size: 22px;
        }
        .p_name span{
            font-size: large;
            padding-left: 10px;
            font-family: "Lucida Sans Unicode";
            color: #0f0f0f;
        }
        .p_level span{
            font-size: large;
            padding-left: 10px;
            font-family: "Lucida Sans Unicode";
            color: #0f0f0f;
        }
        .p_num span{
            font-size: large;
            padding-left: 10px;
            font-family: "Lucida Sans Unicode";
            color: #0f0f0f;
        }
        .p_size span{
            font-size: large;
            padding-left: 10px;
            font-family: "Lucida Sans Unicode";
            color: #0f0f0f;
        }
        .p_ram span{
            font-size: large;
            padding-left: 10px;
            font-family: "Lucida Sans Unicode";
            color: #0f0f0f;
        }
        .address{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            margin-top: 10px;
        }

        .input_num_css{
            -web-kit-appearance:none;
            -moz-appearance: none;
            font-size:1.0em;
            height:2.7em;

            border:1px solid #c8cccf;
            color:#6a6f77;
            outline:0;
            width: 40px;
            height: 23px;
            text-align:center;
            float: left;
        }
        .btn_add p{
            border:1px solid #c8cccf;
            border-left: 0px;
            color:#6a6f77;
            height: 23px;
            width: 30px;
            float: left;
            text-align: center;
            line-height: 23px;
        }
        .btn_reduce p{
            border:1px solid #c8cccf;
            border-left: 0px;
            color:#6a6f77;
            height: 23px;
            width: 30px;
            float: left;
            text-align: center;
        }
        .p_buy_num{
            float: left;
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            line-height: 25px;
        }
        .btn_s_cart{
            height: 23px;
            width: 90px;
            font-family: "microsoft yahei";
            text-align: center;
            line-height: 22px;
            font-weight: 700;
            float: right;
            background-color: #df3033;
            color: #fff;
            /*margin-right: 10px;*/
        }
        .btn_buy{
            height: 23px;
            width: 90px;
            font-family: "microsoft yahei";
            text-align: center;
            line-height: 22px;
            font-weight: 700;
            float: right;
            background-color: #66CCCC;
            color: #fff;
        }
        a:hover{
            text-decoration:none;
        }

        /*解决Vue插值表达式闪烁问题*/
        [v-cloak]{
            display: none;
        }


    </style>

    <script>
        $(function(){
            //获取用户点击某一具体商品传过来的此商品id，根据此id查询具体商品信息
            var id=<%= request.getParameter("productInfoById")%>;
            //进入此页面后，清除导航栏所有灰色背景，active是所包含jsp的class名
            $("li").removeClass("active");
            //为购买手机添加灰色背景,从视觉上代表已经停留到此页
            $("#li_buy").addClass("active");

            //创建一个数据，接收ajax返回数据，将语句交给vue做试图渲染
            var data;

            <!--获取存在session中的用户数据，用来判断用户是否登录。未登录index顶部显示登录注册等，登录显示用户名，退出，查看购物车等-->
            <!--此数据是在用户登录时服务器存在session中的-->
            <%User user=(User)session.getAttribute("user"); %>

            //发送ajax请求，根据id查询当前商品的具体信息，将信息渲染到商品详情页
            $.ajax({
                type:"get",
                url:"<%=request.getContextPath() %>/product/productDetails",
                async : false,
                data:"id="+id,
                success:function (response) {
                    //将传递过来的map的json格式字符串转换成json格式对象，便于取值
                    data=JSON.parse(response);
                    console.log(data)
                }
            });//ajax end;

            document.onselectstart = function (event){//ping bi bei xuan zhong
                if(window.event){
                    event = window.event;
                }try{
                    var the = event.srcElement;
                    if (!((the.tagName == "INPUT" && the.type.toLowerCase() == "text") || the.tagName == "TEXTAREA")){
                        return false;
                    }
                    return true;
                } catch (e) {
                    return false;
                }
            }

/*            document.onkeydown = function(){ //禁止F12

                if(window.event && window.event.keyCode == 123) {
                    alert("F12被禁用");
                    event.keyCode=0;
                    event.returnValue=false;
                }
                if(window.event && window.event.keyCode == 13) {
                    window.event.keyCode = 505;
                }
                if(window.event && window.event.keyCode == 8) {
                    alert(str+"\n请使用Del键进行字符的删除操作！");
                    window.event.returnValue=false;
                }

            }*/

            document.oncontextmenu = function (event){ //屏蔽右键菜单
                if(window.event){
                    event = window.event;
                }try{
                    var the = event.srcElement;
                    if (!((the.tagName == "INPUT" && the.type.toLowerCase() == "text") || the.tagName == "TEXTAREA")){
                        return false;
                    }
                    return true;
                }catch (e){
                    return false;
                }
            }

            //创建vue
            var vm=new Vue({
                el:'#vue_div',
                data:{
                    datas:data,

                    url:'static/img/product/',
                },
                methods:{
                    //用户点击数量的+
                    btn_add:function () {
                        //获取当前用户想购买的数量
                        var num=parseInt($(".input_num_css").val());
                        //购买数量的累加
                        $('.input_num_css').attr('value',num+=1)
                        if (num==6){
                            alert("超出购买数量");
                            $('.input_num_css').attr('value',num-=1)
                        }else if(num>6){
                            alert("超出购买数量");
                            $('.input_num_css').attr('value',"5")
                        }
                    },

                    //用户点击数量的-
                    btn_reduce:function () {
                        //获取当前用户想购买的数量
                        var num=parseInt($(".input_num_css").val());
                        //判断为了数量不能为0或小于0
                        if(num==1 ){
                            return false;
                        }else {
                            $('.input_num_css').attr('value',num-=1)
                        }
                    },

                    //用户点击加入购物车
                    add_shopping_cart:function () {
                        //判断用户是否登录
                        <% if(user==null) {%>
                            //判断是否当前商品有货
                            var num=data.product.pNum;
                            //如果库存，提示库存为0，不可加入购物车
                            if(num==0){
                                alert("当前商品库存为0，请持续关注我们留意官网信息。")
                            }else {
                                alert("登录后加入购物车！")
                            }
                        <% } else{%>
                            //判断是否当前商品有货
                            var num=data.product.pNum;
                            //如果为0没货了
                            if(num==0){
                                alert("当前商品库存为0，请持续关注我们留意官网信息。")
                            }else {
                                //有货，获取配送地址，数量//
                                //获取地址值
                                var address=$("#address").val()
                                if($("#address").val()==""){
                                    alert("请输入配送地址！")
                                }else {
                                    //获取数量值
                                    var num=parseInt($(".input_num_css").val());
                                    //发送ajax请求到服务器
                                    //数据包含商品id，配送地址以及购买数量
                                    //创建json对象
                                    var json={"id":data.product.id,"num":num,"address":address}
                                    //将json对象转换成json字符串
                                    var jsonStr=JSON.stringify(json)
                                    $.ajax({
                                        type:"POST",
                                        contentType:"application/json; charset=utf-8",
                                        url:"<%=request.getContextPath() %>/cart/addToCart",
                                        data:jsonStr,
                                        success:function (response) {
                                            if(response=="full"){
                                                alert("无法继续添加，购物车最多添加5个同一商品！");
                                            }else if(response.includes("最多还能添加")){//如果return过来的字符串中包含最多还能添加这一段字符串
                                                alert(response);
                                            }else if(response=="success"){
                                                alert("成功加入购物车！")
                                            }
                                        }
                                    });//ajax end;
                                }
                            }
                        <% } %>
                    },//method end


                },//methods end;
            });//vue end;



        });

    </script>
</head>
<body>

    <% if(user==null) {%>   <!------------------------如果用户未登录，显示未登录的样式导航条-->
    <jsp:include page="WEB-INF/views/userNotLoginNAV.jsp"></jsp:include>
    <% } else{%>        <!------------------------------------------如果用户登录了，显示登陆后的样式导航条-->
    <jsp:include page="WEB-INF/views/userLoginNAV.jsp"></jsp:include>
    <% } %>

    <div class="w" id="vue_div">
        <div class="product-intro clearfix">
            <!--左侧图片-->
            <div class="preview-wrap">
                <div class="preview">
                    <div class="jqzoom main-img">
                        <img :src="url+datas.product.pImg">
                    </div>
                </div>
            </div>
            <!--商品描述-->
            <div class="itemInfo-wrap" v-cloak>
                <div class="sku-name">
                    商 品 描 述：{{datas.describe}}
                </div>
                <div class="p_name">
                    名 称：<span>{{datas.product.pName}}</span>
                </div>
                <div class="p_level">
                    成 色：<span>{{datas.product.pLevel}} 新</span>
                </div>
                <div class="p_num">
                    库 存：<span>{{datas.product.pNum}}</span>
                </div>
                <div class="p_size">
                    储 存：<span>{{datas.product.pSize}} G</span>
                </div>
                <div class="p_ram">
                    内 存：<span>{{datas.product.pRam}} RAM</span>
                </div>

                <div class="p_price">
                    爱 手 机 价 格：<span class="RMB_symbol">￥</span><span class="RMB_price">{{datas.product.pPrice}}</span>
                </div>

                <div class="address">
                    <p style="float: left">配 送 至：</p>
                    <div class="input-group input-group-sm" style="float: left;width: 420px">
                        <input type="text" id="address" class="form-control" placeholder="输入您的收获地址" aria-describedby="basic-addon2">
                    </div>
                    <div>
                        <p v-if="datas.product.pNum>0">&nbsp;有货</p>
                        <p v-else="datas.product.pNum>0">&nbsp;无货</p>
                    </div>

                </div>

                <div>
                    <p class="p_buy_num">数量：</p>
                    <input type="text" class="input_num_css" value="1" disabled="disabled" data-max="5">
                    <a href="javascript:;" class="btn_add" v-on:click="btn_add"><p>+</p></a>
                    <a href="javascript:;" class="btn_reduce" v-on:click="btn_reduce"><p>-</p></a>
                </div>

                <div>
                    <!--<a href="javascript:;" class="btn_buy" v-on:click="buy">购买</a>-->
                    <a href="javascript:;" class="btn_s_cart" v-on:click="add_shopping_cart">加入购物车</a>
                </div>

            </div>
        </div>
    </div>


    <!--页面最底部-->
    <jsp:include page="WEB-INF/views/bottom.jsp"></jsp:include>



</body>
</html>