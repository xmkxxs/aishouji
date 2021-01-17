<%@ page import="com.xm.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>结算页面 · 爱手机</title>
    <script src="../static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="../static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../static/js/vue.js"></script>
    <style>
        /*回到顶部按钮相关css*/
        .arrow{
            border: 9px solid transparent;
            border-bottom-color: #00CC99;
            width: 0px;
            height: 0px;
            top:0px
        }
        .stick{
            width: 8px;
            height: 14px;
            border-radius: 1px;
            background-color: #00CC99;
            top:15px;
        }
        #back_top div{
            position: absolute;
            margin: auto;
            right: 0px;
            left: 0px;
        }
        #back_top{
            background-color: #dddddd;
            height: 38px;
            width: 38px;
            border-radius: 3px;
            display: block;
            cursor: pointer;
            position: fixed;
            right: 50px;
            bottom: 100px;
            display: none;
        }
        /*-----------------------------*/
        .all_products{
            margin-top: 50px;
            font-style: normal;
            color: #009966;
            font-weight: 700;
            font-size: 16px;
        }
        .cart-main .cart-thead {
            display: inline-block;
            display: block;
            height: 40px;
            line-height: 33px;
            /* margin: 0 0 10px; */
            padding: 5px 0;
            background: #f3f3f3;
            border: 1px solid #e9e9e9;
            border-top: 0;
            position: relative;

        }
        .cart-main .cart-thead .t-checkbox {
            height: 18px;
            line-height: 18px;
            padding-top: 7px;
            width: 122px;
            padding-left: 11px;
            color: #666;
        }
        .cart-checkbox {
            position: relative;
            z-index: 3;
            float: left;
            margin-right: 5px;
        }
        .cart-main .asjcheckbox, .cart-main .jdradio {
            float: none;
            position: relative;
            z-index: 5;
            vertical-align: middle;
            _vertical-align: -1px;
            margin: 2px 3px 0 0;
            padding: 0;
            *left: -3px;
        }
        .cart-main-new .cart-thead .t-goods {
            width: 208px;
            color: #666;
            padding-left: 60px;
        }
        .cart-main .cart-thead .column {
            float: left;
        }
        .cart-main-new .cart-thead .t-props {
            width: 140px;
            color: #666;
        }
        .cart-main .cart-thead .t-props {
            height: 32px;
            padding: 0 10px 0 40px;
            color: #666;
        }
        .cart-main .cart-thead .t-price {
            width: 180px;
            padding-right: 10px;
            text-align: right;
            color: #666;
        }
        .cart-main .cart-thead .t-quantity {/*数量*/
            width: 170px;
            text-align: center;
            color: #666;
        }
        .cart-main .cart-thead .t-sum {/*小计*/
            width: 160px;
            padding-right: 10px;
            text-align: right;
            color: #666;
        }
        .cart-main .cart-thead .t-action {/*操作*/
            width: 75px;
            padding-left: 46px;
            color: #666;
        }
        .address{
            line-height: 30px;
            padding-left: 10px;
            font-family: simsun;
            color: #999;
            float: right;
            margin-top: 40px;
            margin-right: 15px;
        }
        .product_list{
            margin-top: 50px;
        }
        .d{
            position: relative;
        }
        .product_checkbox{
            margin-left: 12px;
            float: left;
            position: absolute;
        }
        img{
            height: 120px;
            width: 180px;
        }
        .div_product_describe{
            float: right;
            padding-top: 2px;
            padding-left: 0px;
            position: absolute;/*绝*/
        }
        .div_product_price{
            float: right;
            padding-top: 2px;
            padding-left: 12px;
            position: absolute;/*绝*/
        }
        .product_price{
            float: right;
            padding-top: 2px;
            padding-left: 405px;
            position: absolute;/*绝*/
        }
        .div_item{
            float: right;
            padding-top: 47px;
            padding-right: 955px;
            position: relative;/*相*/
        }
        .input_num_css{
            -web-kit-appearance:none;
            -moz-appearance: none;
            font-size:1.0em;
            height:2.7em;
            border:1px solid #c8cccf;
            color:#6a6f77;
            outline:0;
            width: 60px;
            height: 23px;
            text-align:center;
            float: left;
            overflow: hidden;
            border-bottom: 0px;
        }
        .input_div{
            float: right;
            /*padding-top: 2px;*/
            top:35px;
            padding-left: 522px;
            position: absolute;/*绝*/
            overflow: hidden;
        }
        .btn_add p{
            border:1px solid #c8cccf;
            /*border-left: 0px;*/
            color:#6a6f77;
            height: 23px;
            width: 30px;
            float: left;
            text-align: center;
            line-height: 23px;
            clear:both;
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
        .product_all_price{
            float: right;
            padding-top: 2px;
            padding-left: 748px;
            position: absolute;/*绝*/
        }
        .product_delete{
            float: right;
            padding-top: 2px;
            padding-left: 825px;
            position: absolute;/*绝*/

        }
        a:hover{
            text-decoration: none;
            color: red;
        }
        a{
            color: #666;
        }
        a:visited {
            color: #666;
            text-decoration: none;
        }

        /*解决Vue插值表达式闪烁问题*/
        [v-cloak]{
            display: none;
        }

        .end_buy{
            position: absolute;
            top: -1px;
            z-index: 999;
            margin-left: 1013px;
        }
        .buy_btn{
            height: 40px;
            width: 80px;
            background: linear-gradient(to right, rgb(19, 122, 74) , rgb(174, 179, 109));
            display: block;
            color: #fff;
            text-align: center;
            font-size: 18px;
            font-family: "Microsoft YaHei";
            line-height: 40px;
        }
    </style>
    <script>
        $(function () {
            //进入此页面后，清除导航栏所有灰色背景，active是所包含jsp的class名
            $("li").removeClass("active");

            //如果用户输入URL直接进入此页面，判断用户是否登录
            <%User user=(User)session.getAttribute("user"); %>
            <% if(user==null) {%>
            alert("请先登录！")
            window.location.href="../login.jsp"
            <% } else{%>
            /*获取session key为checkoutProductData*/
            var jsonData=[];
            jsonData=<%= session.getAttribute("checkoutProductData") %>
            //将json对象转换成json字符串便于传输
            var jsonStr = JSON.stringify(jsonData);

            <%--<% session.removeAttribute("checkoutProductData"); %>--%>

            //定义数据存放ajax回调函数返回值，用于vue数据展示
            var data;
            //存放用户收货地址
            var home;

            //用于查询此用户的购物车信息（只为了获取此用户的收货地址）
            var userName="<%= user.getUserName() %>"

            //获取用户确认订单需要的数据，如图片img，商品id，单价，数量
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/cart/CheckoutOrderData",
                data:jsonStr,
                contentType:"application/json; charset=utf-8",
                async : false,
                success:function (response) {
                    console.log(response)
                    data=eval("("+response+")");//转换成json对象
                    console.log(data)
                    //再次发送ajax请求，查询用户的购物车信息，只是要地址，地址放在了购物车表中
                    //根据用户名查询此用户购物车
                    $.ajax({
                        type:"get",
                        url:"<%=request.getContextPath() %>/cart/queryTheShoppingCartOfThisUserAccordingToTheUserName",
                        data:"userName="+userName,
                        async : false,
                        success:function (response) {
                            console.log(response)
                            //eval("("+response+")");//转换成json对象
                            //随机获取一个用户地址
                            home=eval("("+response+")")[0].userAddress;
                            console.log(home)
                        }
                    });//ajax end;
                },
            });//ajax end

            //创建vue
            var vm=new Vue({
                el:'#vue_div',
                data:{
                    datas:data,
                    url:'../static/img/product/',
                    address:home,
                },
                methods:{

                },//methods end
            });//vue end

            <% } %>
        });//入口函数 end
    </script>
</head>
<body>

<jsp:include page="checkoutLoginNAV.jsp"></jsp:include>

<div id="vue_div">  <!--vue 范围开始处-->

    <div  v-cloak style="margin-bottom: 40px">

        <div class="container">
            <div class="row">
                <div class="col-md-4"><p class="all_products">结算商品 {{datas.length}}个</p></div>

                <div class="address">
                    <p style="float: left">配 送 至：</p>
                    <div class="input-group input-group-sm" style="float: left;width: 420px">
                        <input type="text" id="address" v-model="address" class="form-control" placeholder="输入您的收获地址" aria-describedby="basic-addon2">
                    </div>
                </div>

            </div>


            <div class="cart-main cart-main-new">
                <div class="cart-thead">
                    <div class="column t-checkbox">
                        <div class="cart-checkbox">
                            <input type="checkbox" class="asjcheckbox" id="select_all_top_id" v-on:click="select_all_top">
                        </div>
                        商品
                    </div>
                    <div class="column t-goods">商品</div>
                    <div class="column t-props"></div>
                    <div class="column t-price">单价</div>
                    <div class="column t-quantity">数量</div>
                    <div class="column t-sum">小计</div>
                    <div class="column t-action">操作</div>
                </div>
            </div>


            <!--product list-->
            <div class="product_list" v-for="item in datas">
                <div class="d">
                    <div class="product_checkbox">
                        <input type="checkbox" class="asjcheckbox" name="items" v-on:click="select_product_list()">
                    </div>
                    <div class="product_img">
                        <img :src="url+item.pImg">

                        <div class="div_item">
                            <div class="div_product_describe">
                                <div>
                                    <span class="product_describe">{{item.pBrandDescribe}}</span>
                                </div>
                            </div>

                            <div class="div_product_price">
                                <div>
                                    <span class="product_price">￥{{item.pPrice}}</span>
                                </div>
                            </div>

                            <div class="input_div">
                                <input type="text" class="input_num_css" v-model="item.pNum" disabled="disabled" data-max="5">
                                <a href="javascript:;" class="btn_add" v-on:click="btn_add(item.pId,item.pNum)"><p>+</p></a>
                                <a href="javascript:;" class="btn_reduce" v-on:click="btn_reduce(item.pId,item.pNum)"><p>-</p></a>
                            </div>

                            <div class="product_all_price">
                                <span>￥{{item.pNum*parseInt(item.pPrice)}}</span>
                            </div>

                            <div class="product_delete">
                                <a href="javascript:void(0);" v-on:click="single_delete(item.pId)">删除此商品</a>
                            </div>

                        </div>

                    </div>
                    <HR align=center width=1140 color=#987cb9 SIZE=1>   <!--分割线-->
                </div>

            </div>


            <div class="cart-main cart-main-new">
                <div class="cart-thead"   style="background-color: white;border-top:1px solid gainsboro;border-bottom:1px solid gainsboro">
                    <div class="column t-checkbox">
                        <div class="cart-checkbox">
                            <input type="checkbox" class="asjcheckbox" id="select_all_bottom_id" v-on:click="select_all_bottom">
                        </div>
                        全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-
                    </div>
                    <div class="column t-goods" style="color: red;padding-left: 0px">
                        <a href="javascript:void(0);" v-on:click="select_delete">删除选中商品</a>
                    </div>
                    <div class="column t-props"></div>
                    <div class="column t-price">&nbsp;</div>
                    <div class="column t-quantity">已选择 {{checkedNum}} 件商品</div>
                    <div class="column t-sum">总价{{allPrice}}</div>
                    <div class="column t-action end_buy">
                        <a href="javascript:void(0);" class="buy_btn" v-on:click="buy_btn">结算</a>
                    </div>
                </div>
            </div>

        </div>
    </div>


</div> <!--vue 范围结束处-->

<!--回到顶部按钮-->
<div id="article"></div>
<div id="back_top">
    <div class="arrow"></div>
    <div class="stick"></div>
</div>

<!--页面最底部-->
<div style="padding-top: 65px">
    <jsp:include page="bottom.jsp"></jsp:include>
</div>



</body>
</html>
