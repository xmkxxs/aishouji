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
            height: 50px;
            text-align:center;
            float: left;
            overflow: hidden;
        }
        .input_div{
            float: right;
            /*padding-top: 2px;*/
            top:35px;
            padding-left: 522px;
            position: absolute;/*绝*/
            overflow: hidden;
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
            //存放购物车信息，循环获取里面商品的宣传语
            var s;


            //用于查询此用户的购物车信息（只为了获取此用户的收货地址和宣传语）
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
                    //再次发送ajax请求，查询用户的购物车信息，只是要地址和宣传语，地址放在了购物车表中
                    //根据用户名查询此用户购物车
                    $.ajax({
                        type:"get",
                        url:"<%=request.getContextPath() %>/cart/queryTheShoppingCartOfThisUserAccordingToTheUserName",
                        data:"userName="+userName,
                        async : false,
                        success:function (response) {
                            console.log(response)
                            //eval("("+response+")");//转换成json对象
                            //从用户购物车中随机获取一个用户地址
                            home=eval("("+response+")")[0].userAddress;
                            //获取user购物车信息，遍历获取出当前页面需要用到的宣传语
                            s=eval("("+response+")");
                            console.log(home)
                        }
                    });//ajax end;
                },
            });//ajax end

            //循环取出购物车数据中商品id与当前结算页面商品id相同的话，取出购物车信息中的宣传语给datas中当前商品当作新的属性，便于展示
            for(var i=0;i<s.length;i++){
                for(var j=0;j<data.length;j++){
                    if(data[j].id==s[i].pId){
                        data[j].pBrandDescribe=s[i].pBrandDescribe
                    }
                }
            }


            //创建vue
            var vm=new Vue({
                el:'#vue_div',
                data:{
                    datas:data,
                    url:'../static/img/product/',
                    address:home,
                    cartInfo:s,
                    //allPrice:0,
                },
                /*mounted:function(){ //生命周期，加载vue时调用
                    //计算所有商品价格
                    this.getAllPrice();
                },*/
                methods:{
                    //计算所有商品价格,插值表达式直接调用这个方法接收到return allPrice的值
                    getAllPrice:function(){
                        var allPrice=0;
                        for(var i=0;i<this.datas.length;i++){
                            allPrice+=this.datas[i].pNum*parseInt(this.datas[i].pPrice);
                        }
                        return allPrice;
                    },//getAllPrice end

                    //确认结算按钮
                    buy_btn:function () {
                        //判断配送地址input是否为空
                        var address=$("#address").val();
                        if(address==""){
                            alert("请输入配送地址！");
                            return null;
                        }else {
                            console.log(this.datas)
                            //将json对象转换成json字符串便于传输
                            var jsonStr = JSON.stringify(this.datas);
                            //发送ajax请求将数据传输到服务器
                            $.ajax({
                                type:"post",
                                data:jsonStr,
                                contentType:"application/json; charset=utf-8",
                                url:"<%=request.getContextPath() %>/cart/checkoutSuccess",
                                sync:false,
                                success:function () {
                                    //再次发送ajax将地址传入并做最后成功购买，跳转到订单页面
                                    $.ajax({
                                        type:"post",
                                        data:"address="+address,
                                        url:"<%=request.getContextPath() %>/cart/checkoutEnd",
                                        sync:false,
                                        success:function (response) {
                                            alert("下单成功！订单号："+response);
                                            window.location="../order.jsp";
                                        },
                                    });//ajax end
                                },
                            });//ajax end
                        }
                    },//buy_btn end

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
                    <div class="column t-checkbox" style="padding-left: 65px">
                        商品
                    </div>
                    <div class="column t-goods">&nbsp;&nbsp;</div>
                    <div class="column t-props"></div>
                    <div class="column t-price">单价</div>
                    <div class="column t-quantity">数量</div>
                    <div class="column t-sum">小计</div>
                    <div class="column t-action"></div>
                </div>
            </div>


            <!--product list-->
            <div class="product_list" v-for="item in datas">
                <div class="d">
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
                            </div>

                            <div class="product_all_price">
                                <span>￥{{item.pNum*parseInt(item.pPrice)}}</span>
                            </div>


                        </div>

                    </div>
                    <HR align=center width=1140 color=#987cb9 SIZE=1>   <!--分割线-->
                </div>

            </div>

            <div class="cart-main cart-main-new">
                <div class="cart-thead"   style="background-color: white;border-top:1px solid gainsboro;border-bottom:1px solid gainsboro">
                    <div class="column t-checkbox"  style="padding-left: 65px">
                        商品
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                    <div class="column t-goods" style="color: red;padding-left: 0px">
                        <a href="javascript:void(0);" v-on:click="select_delete">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </div>
                    <div class="column t-props"></div>
                    <div class="column t-price">&nbsp;</div>
                    <div class="column t-quantity">共计 {{this.datas.length}} 件商品</div>
                    <div class="column t-sum">总价{{getAllPrice()}}</div>
                    <div class="column t-action end_buy">
                        <a href="javascript:void(0);" class="buy_btn" v-on:click="buy_btn">确认结算</a>
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
