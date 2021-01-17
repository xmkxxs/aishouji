<%@ page import="com.xm.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车 · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="static/js/vue.js"></script>
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
            //用于查询此用户的购物车信息
            var userName="<%= user.getUserName() %>"

            //创建一个数据，接收ajax返回数据，将语句交给vue做试图渲染
            var data;


            //根据用户名查询此用户购物车
            $.ajax({
                type:"get",
                url:"<%=request.getContextPath() %>/cart/queryTheShoppingCartOfThisUserAccordingToTheUserName",
                data:"userName="+userName,
                async : false,
                success:function (response) {
                    console.log(response)
                    data=eval("("+response+")");//转换成json对象
                    console.log(data)
                }
            });//ajax end;


            //创建vue
            var vm=new Vue({
                el:'#vue_div',
                data:{
                    datas:data,
                    url:'static/img/product/',
                    allPrice:0,
                    checkedNum:0,
                },
                mounted:function(){ //生命周期，加载vue时调用
                    //计算所有商品价格
                    this.getAllPrice();
                    //进入页面后就将所有商品选中
                    this.select_all();
                    //进入页面后获取所有商品选中数
                    this.get_check_box_num();
                },
                methods:{
                    //计算所有商品价格
                    getAllPrice:function(){
                        var allPrice=0;
                        for(var i=0;i<this.datas.length;i++){
                            allPrice+=this.datas[i].pNum*parseInt(this.datas[i].pPrice);
                        }
                        this.allPrice=allPrice;
                    },//getAllPrice endgetAllPrice

                    //用户点击+、-按钮时用到的价格计算
                    getAllPrice2:function(){
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        var allPrice=0;
                        for(var i=0;i<this.datas.length;i++){
                            if (items[i].checked==true){
                                allPrice+=this.datas[i].pNum*parseInt(this.datas[i].pPrice);
                            }
                        }
                        this.allPrice=allPrice;
                    },//getAllPrice2 end

                    //用户点击数量的+
                    btn_add:function (id,num) {
                        //id是当前购物车中商品的id，num是此id商品在购物车中的数量
                        var newVal=num+1;
                        var allPrice=0;
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        console.log(newVal)
                        for(var i=0;i<this.datas.length;i++){
                            //找到用户点击哪个商品
                            if(this.datas[i].pId==id){
                                //只要用户点击了+，那么此商品的选中框就得被选中
                                items[i].checked=true;
                                //判断用户点击当前商品后是否构成全选条件
                                this.select_product_list();
                                this.datas[i].pNum=newVal;
                                if(newVal==6){
                                    alert("单个商品最多购买5件！");
                                    this.datas[i].pNum=newVal-=1;
                                }else if(num>6){
                                    alert("单个商品最多购买5件！");
                                    this.datas[i].pNum=5;
                                }
                                console.log(this.datas)
                            }
                        }
                        //重新总价赋值
                        this.getAllPrice2();
                    },//btn_add end*/

                    //用户点击数量的-
                    btn_reduce:function (id,num) {
                        var allPrice=0;
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //判断为了数量不能为0或小于0
                        if(num==1 ){
                            return false;
                        }else {
                            for(var i=0;i<this.datas.length;i++){
                                if(this.datas[i].pId==id){
                                    //只要用户点击了-，那么此商品的选中框就得被选中
                                    items[i].checked=true;
                                    //判断用户点击当前商品后是否构成全选条件
                                    this.select_product_list();
                                    this.datas[i].pNum=num-=1;
                                }
                            }
                        }
                        //重新总价赋值
                        this.getAllPrice2();
                    },//btn_reduce end

                    //获取checkbox被选中数，除去两个全选input
                    get_check_box_num:function(){
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        var num=0;
                        for (var i=0;i<items.length;i++){
                            if(items[i].checked){
                                num+=1;
                            }
                        }
                        this.checkedNum=num;
                    },//get_check_box_num end

                    //进入页面后调用此方法，将所有的checkbox勾上
                    select_all:function(){
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        ////获取上方的checkbox
                        var select_all_top_id=document.getElementById("select_all_top_id");
                        //获取下方的checkbox
                        var select_all_bottom_id=document.getElementById("select_all_bottom_id");
                        //设置两个全选被选中
                        select_all_bottom_id.checked=true;
                        select_all_top_id.checked=true;
                        //设置items全被选中
                        for (var i=0;i<items.length;i++){
                            items[i].checked=true;
                        }
                    },

                    //点击页面上方的全选按钮
                    select_all_top:function () {
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        ////获取上方的checkbox
                        var select_all_top_id=document.getElementById("select_all_top_id");
                        //获取下方的checkbox
                        var select_all_bottom_id=document.getElementById("select_all_bottom_id");
                        //设置下方的checkbox是否被选中
                        if (select_all_bottom_id.checked==false){
                            //让底面的checkbox被选中，代表用户当前选择了所有商品，那么就计算所有商品价格
                            select_all_bottom_id.checked=true;
                            //计算所有商品价格
                            this.getAllPrice();
                        }else {
                            //代表用户取消了所有商品的选中，也就是选中数为0，则总价设置为0
                            select_all_bottom_id.checked=false;
                            this.allPrice=0;
                        }
                        //设置product list的checkbox是否被选中
                        for (var i=0;i<items.length;i++){
                            //让所有product list选中状态与当前select_all_top_id选中状态同步
                            items[i].checked=select_all_top_id.checked;
                        }
                        //调用获取checkbox被选中数
                        this.get_check_box_num();
                    },//select_all end

                    //点击页面下方的全选按钮
                    select_all_bottom:function () {
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //获取上方的checkbox
                        var select_all_top_id=document.getElementById("select_all_top_id");
                        //获取下方的checkbox
                        var select_all_bottom_id=document.getElementById("select_all_bottom_id");
                        //设置上方的checkbox是否被选中
                        if (select_all_top_id.checked==false){
                            //让上面的checkbox被选中，代表用户当前选择了所有商品，那么就计算所有商品价格
                            select_all_top_id.checked=true;
                            //计算所有商品价格
                            this.getAllPrice();
                        }else {
                            //代表用户取消了所有商品的选中，也就是选中数为0，则总价设置为0
                            select_all_top_id.checked=false;
                            this.allPrice=0;
                        }
                        //设置product list的checkbox是否被选中
                        for (var i=0;i<items.length;i++){
                            //让所有product list选中状态与当前select_all_bottom_id选中状态同步
                            items[i].checked=select_all_bottom_id.checked;
                        }
                        //调用获取checkbox被选中数
                        this.get_check_box_num();
                    },//select_all_bottom end

                    //点击每个product list中的checkbox
                    select_product_list:function () {
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //获取上方的checkbox
                        var select_all_top_id=document.getElementById("select_all_top_id");
                        //获取下方的checkbox
                        var select_all_bottom_id=document.getElementById("select_all_bottom_id");
                        //计算哪些被选中了的总价
                        this.select_product_price();

                        //先将上下方的checkbox设置为true
                        select_all_top_id.checked=true;
                        select_all_bottom_id.checked=true;
                        //循环每个product list的checkbox，只要有f，就将上下方的checkbox设置为f
                        for (var i=0;i<items.length;i++){
                            if (!items[i].checked){//false，代表没有达到全选
                                select_all_top_id.checked=false;
                                select_all_bottom_id.checked=false;
                            }
                        }
                        //调用获取checkbox被选中数
                        this.get_check_box_num();
                    },//select_product_list end

                    //计算被选中商品的总价
                    select_product_price:function () {
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //
                        var allPrice=0;
                        for (var i=0;i<items.length;i++){
                            if (items[i].checked){
                                allPrice+=this.datas[i].pNum*parseInt(this.datas[i].pPrice);
                            }
                        }
                        this.allPrice=allPrice;
                    },//select_product_price end

                    //点击product list的单个商品删除按钮
                    single_delete:function (id) {
                        $.ajax({
                            type:"POST",
                            url:"<%=request.getContextPath() %>/cart/singleDelete",
                            data:"id="+id+"&_method=DELETE",
                            sync:false,
                            success:function (response) {
                                alert("删除成功！");
                                window.location.href="http://localhost:8080/aishouji-ssm/user_carts.jsp";
                            },
                        });//ajax end
                    },//single_delete end

                    //点击删除选择多个的商品
                    select_delete:function () {
                        //首先判断是否有被选中的商品
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //用于判断是否有商品被选择
                        var checkNum=0;
                        //
                        var f=0;
                        //创建一个空json对象
                        var jsonObj={};

                        for (var i=0;i<items.length;i++){
                            if (items[i].checked){  //当前下标的商品被选择
                                checkNum+=1;
                                //获取当前商品的id号,存放在json对象中
                                jsonObj["id"+f]=this.datas[i].pId;
                                f+=1;
                            }
                        }
                        console.log(jsonObj)

                        if(checkNum==0){ //没有任何被选择
                            alert("没有选中任何商品！")
                        }else {
                            //将json对象转换成json字符串便于传输
                            var jsonProductIdList = JSON.stringify(jsonObj);
                            console.log(jsonProductIdList)
                            var flag=confirm("确定删除吗？");
                            if(flag){
                                $.ajax({
                                    type:"post",
                                    contentType:"application/json; charset=utf-8",
                                    url:"<%=request.getContextPath() %>/cart/selectDelete",
                                    data:jsonProductIdList,
                                    sync:false,
                                    success:function (response) {
                                        if(response=="success"){
                                            alert("删除成功！");
                                            window.location.href="http://localhost:8080/aishouji-ssm/user_carts.jsp";
                                        }else {
                                            alert("发生异常错误！");
                                            window.location.href="http://localhost:8080/aishouji-ssm/user_carts.jsp";
                                        }
                                    },
                                });//ajax end
                            }
                        }
                    },//select_delete end

                    //结算按钮，将一些数据商品id，各个商品数量以及各个单价，图片img路径传到结算页面
                    buy_btn:function () {
                        //首先判断是否有被选中的商品
                        //获取所有商品的checkbox
                        var items=document.getElementsByName("items");
                        //用于判断是否有商品被选择
                        var checkNum=0;
                        //创建一个空json格式数组,存放被选择的id号和此id的个数
                        var jsonObj=[];
                        //循环判断是否有商品被选中
                        for (var i=0;i<items.length;i++){
                            if (items[i].checked){  //当前下标的商品被选择
                                checkNum+=1;
                            }
                        }

                        if(checkNum==0){ //没有任何被选择
                            alert("请选择商品！")
                        }else {
                            //获取被选中商品的id和数量
                            for (var i=0;i<items.length;i++){
                                if (items[i].checked){  //当前下标的商品被选择
                                    //获取当前商品的id号和此id的个数，存放在json格式数组中
                                    var zhi={};
                                    zhi.id=this.datas[i].pId;
                                    zhi.pNum=this.datas[i].pNum;
                                    zhi.pPrice=this.datas[i].pPrice;
                                    zhi.pImg=this.datas[i].pImg;
                                    zhi.pBrandDescribe=this.datas[i].pBrandDescribe;
                                    zhi.userAddress=this.datas[i].userAddress;
                                    jsonObj.push(zhi)
                                }
                            }
                            //将json对象转换成json字符串便于传输
                            var jsonStr = JSON.stringify(jsonObj);
                            console.log(jsonStr)
                            $.ajax({
                                type:"post",
                                contentType:"application/json; charset=utf-8",
                                url:"<%=request.getContextPath() %>/cart/infoConfirmation",
                                data:jsonStr,
                                sync:false,
                                success:function () {
                                    //进入checkout服务器进行跳转到结算页面
                                    window.location.href="<%=request.getContextPath() %>/cart/checkout";
                                },
                            });//ajax end
                        }
                    },//buy_btn end


                },//methods end
            });// vue end

            <% } %>
        });
    </script>
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
</head>
<body>

<% if(user==null) {%>   <!------------------------如果用户未登录，显示未登录的样式导航条-->
<jsp:include page="WEB-INF/views/userNotLoginNAV.jsp"></jsp:include>
<% } else{%>        <!------------------------------------------如果用户登录了，显示登陆后的样式导航条-->
<jsp:include page="WEB-INF/views/userLoginNAV.jsp"></jsp:include>
<% } %>

<div id="vue_div">  <!--vue 范围开始处-->
    <div v-cloak v-if="datas.length==0">    <!--如果用户购物车数据为0，代表购物车为空-->
        <jsp:include page="WEB-INF/views/shppingCartShowNull.jsp"></jsp:include>
    </div>
    <div v-cloak v-else-if="datas.length>0">
        <div  v-cloak style="margin-bottom: 40px">

            <div class="container">
                <div class="row">
                    <div class="col-md-4"><p class="all_products">全部商品 {{datas.length}}个</p></div>

                    <div class="address">
                        <p style="float: left">配 送 至：</p>
                        <div class="input-group input-group-sm" style="float: left;width: 420px">
                            <!--v-model,赋值到input，用户有多个地址值，默认显示ajax接收的list[0]中的地址值显示-->
                            <input type="text" id="address" v-model="datas[0].userAddress" class="form-control" placeholder="输入您的收获地址" aria-describedby="basic-addon2">
                        </div>
                    </div>

                </div>


                <div class="cart-main cart-main-new">
                    <div class="cart-thead">
                        <div class="column t-checkbox">
                            <div class="cart-checkbox">
                                <input type="checkbox" class="asjcheckbox" id="select_all_top_id" v-on:click="select_all_top">
                            </div>
                            全选
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