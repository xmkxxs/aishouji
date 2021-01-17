<%@ page import="com.xm.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单 · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/password_reset.css">
    <script src="static/js/vue.js"></script>
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
            width: 330px;
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
            width: 100px;
            padding-left: 40px;
            margin-left: 30px;
            color: #666;
        }
        .product_list{
            margin-top: 50px;
        }
        .d{
            position: relative;
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
        .e{
            background: linear-gradient(to right, rgb(19, 122, 74) , rgb(174, 179, 109));
            /*width: 210px;*/
            margin-bottom: 20px;
            color: white;
            font-size: 17px;
        }
    </style>
    <script>
        $(function () {
            //进入此页面后，清除导航栏所有灰色背景，active是所包含jsp的class名
            $("li").removeClass("active");

            /**
             回到顶部按钮code
             **/
            $(window).scroll(function(){  //只要窗口滚动,就触发下面代码
                var scrollt = document.documentElement.scrollTop + document.body.scrollTop; //获取滚动后的高度
                if( scrollt >200 ){  //判断滚动后高度超过200px,就显示
                    $("#back_top").fadeIn(400); //淡入
                }else{
                    $("#back_top").stop().fadeOut(400); //如果返回或者没有超过,就淡出.必须加上stop()停止之前动画,否则会出现闪动
                }
            });
            $("#back_top").click(function(){ //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
                $("html,body").animate({scrollTop:"0px"},200);
            });

            //如果用户输入URL直接进入此页面，判断用户是否登录
            <%User user=(User)session.getAttribute("user"); %>
            <% if(user==null) {%>
                alert("请先登录！")
                window.location.href="login.jsp"
            <% } else{%>
                //用于查询此用户的订单信息
                var userName="<%= user.getUserName() %>"

                //创建一个数据，接收ajax返回数据，将语句交给vue做试图渲染
                var data;
                //接收总价
                var ap=0;

                //根据用户名查询此用户订单
                $.ajax({
                    type:"get",
                    url:"<%=request.getContextPath() %>/order/userOrderInfo",
                    data:"userName="+userName,
                    async : false,
                    success:function (response) {
                        console.log(response);
                        data=eval("("+response+")");//转换成json对象，便于取值展示
                        console.log(data);
                        //计算总价
                        for(let key  in data){
                            for(let k in data[key]){
                                console.log(data[key][k].pPrice);
                                ap+=data[key][k].pNum*parseInt(data[key][k].pPrice);
                            }
                        }
                    }
                });//ajax end;

                //创建vue
                var vm=new Vue({
                    el:'#vue_div',
                    data:{
                        datas:data,
                        ap:ap,
                        url:'static/img/product/',
                    },
                    methods:{

                    },//methods end
                });//vue end

            <% } %>
        });
    </script>
</head>
<body>

    <% if(user==null) {%>   <!------------------------如果用户未登录，显示未登录的样式导航条-->
        <jsp:include page="WEB-INF/views/userNotLoginNAV.jsp"></jsp:include>
    <% } else{%>        <!------------------------------------------如果用户登录了，显示登陆后的样式导航条-->
        <jsp:include page="WEB-INF/views/userLoginNAV.jsp"></jsp:include>
    <% } %>

    <div id="vue_div">  <!--vue 范围开始处-->
        <div v-cloak v-if="Object.keys(datas).length==0">    <!--如果用户购物车数据为0，代表订单为空-->
            <jsp:include page="WEB-INF/views/userCartShowNull.jsp"></jsp:include>
        </div>
        <div v-cloak v-else-if="Object.keys(datas).length>0">
            <div  v-cloak style="margin-bottom: 40px">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4"><p class="all_products">订单列表</p></div>
                    </div>


                    <div class="cart-main cart-main-new">
                        <div class="cart-thead">
                            <div class="column t-goods">订单号 & 商品信息</div>
                            <div class="column t-props"></div>
                            <div class="column t-price">单价</div>
                            <div class="column t-quantity">数量</div>
                            <div class="column t-sum">小计</div>
                            <div class="column t-action">订单总额</div>
                        </div>
                    </div>


                    <!--product list-->
                    <div class="product_list" v-for="item in datas">
                        <div class="d" v-for="(i,key,index) in item"><%--双重v-for循环--%>
                            <div class="e" v-if="key==0"><%-- key=0意思是0代表一组下标数据的开始，如果这个订单号只有一个元素，就只显示
                             一次订单号和这一个元素，如果这个订单号有多个元素，那么下标就是0，1，2....,那也只会显示
                             一次订单号和多个元素，不会造成一个元素头顶显示一个订单号--%>
                                <div>{{i.orderId}}</div>
                            </div>
                            <div v-else>
                                <div></div>
                            </div>

                            <div class="product_img">
                                <img :src="url+i.pImg">

                                <div class="div_item">
                                    <div class="div_product_describe">
                                        <div>
                                            <span class="product_describe">{{i.pBrandDescribe}}</span>
                                        </div>
                                    </div>

                                    <div class="div_product_price">
                                        <div>
                                            <span class="product_price">￥{{i.pPrice}}</span>
                                        </div>
                                    </div>

                                    <div class="input_div">
                                        <input type="text" class="input_num_css" v-model="i.pNum" disabled="disabled" data-max="5">
                                    </div>

                                    <div class="product_all_price">
                                        <span>￥{{i.pNum*parseInt(i.pPrice)}}</span>
                                    </div>

                                </div>

                            </div>
                            <HR align=center width=1140 color=#987cb9 SIZE=1>   <!--分割线-->
                        </div>
                    </div>

                    <div style="float: right">
                        总额：{{this.ap}}
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
    <div style="padding-top: 68px">
        <jsp:include page="WEB-INF/views/bottom.jsp"></jsp:include>
    </div>

</body>
</html>