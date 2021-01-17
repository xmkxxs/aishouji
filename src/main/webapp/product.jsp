<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.xm.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品列表 · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/index.css">
    <script src="static/js/vue.js"></script>
    <style>
        /*分类筛选列表css*/
        .screen {
            width: 1198px;
            border: 1px solid #e6e6e6;
            border-bottom: none;
        }
        .screen dl {
            border-bottom: 1px solid #e6e6e6;
            min-height: 50px;
            position: relative;
        }
        .screen dt {
            float: left;
            width: 70px;
            height: 100%;
            position: absolute;
            line-height: 50px;
            font-size: 14px;
            color: #7a838d;
            text-align: center;
            background: #fafafa;
        }
        .screen dd {
            float: right;
            width: 1128px;
        }
        .dd-top {
            height: 20px;
            padding: 15px 0 15px 6px;
        }
        .dd-top .a-box {
            float: left;
            width: 940px;
            height: 20px;
            overflow: hidden;
        }
        .dd-top a {
            float: left;
            height: 20px;
            font-size: 14px;
            line-height: 20px;
            padding: 0 6px;
            color: #495056;
            margin: 0 8px;
        }

        a, abbr, acronym, address, applet, b, big, blockquote, body, caption, center, cite, code, dd, del, dfn, div, dl, dt, em, fieldset, font, form, h1, h2, h3, h4, h5, h6, html, i, iframe, img, ins, kbd, label, legend, li, object, ol, p, pre, q, s, samp, small, span, strike, strong, sub, sup, table, tbody, td, tfoot, th, thead, tr, tt, u, ul, var {
            margin: 0;
            padding: 0;
            border: 0;
            outline: 0;
        }/*分类筛选列表css结束*/

        /*用户点击筛选条件背景添加颜色*/
        .point-color{
            background: linear-gradient(to right, rgb(19, 122, 74) , rgb(174, 179, 109));
        }

        /*商品展示css*/
        li, ol, ul {
            list-style: none;
        }
        .phonelist {
            width: 1220px;
            margin-left: -10px;
            margin-bottom: 20px;
        }
        .phonelist li {
            float: left;
            margin-bottom: 10px;
        }

        .phonelist li a {
            display: block;
            width: 305px;   /*4个一排的图片的总体长度*/
            height: 299px;
            padding: 9px 9px;
            border: 1px solid transparent;
            position: relative;
        }
        .phonelist li a:hover{
            border:1px solid #e6e6e6;
            color:#495056;
            text-decoration:none;
            box-shadow:0 0 5px 2px #e6e6e6
        }

        .phonelist img {
            width: 285px;
            height: 190px;
            border: 1px solid #e9e9e9;
        }
        .t {
            font-size: 17px;
            color: white;
            font-weight: 400;
            padding: 5px 0 6px 4px;
            margin-top: 5px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            background: linear-gradient(to right, rgb(19, 122, 74) , rgb(174, 179, 109));
        }
        .t-i {
            color: #a5abb2;
            font-size: 14px;
            padding-left: 4px;
            padding-bottom: 2px;
            margin-top: 5px;
        }
        .t-price {
            font-size: 20px;
            color: #f95523;
            padding-left: 4px;
            height: 30px;
            overflow: hidden;
        }

        .t-price p {
            float: left;
            padding-bottom: 20px;
        }/*商品展示css结束*/

        .pagination li a{
            color: #006633;
        }


        /*解决Vue插值表达式闪烁问题*/
        [v-cloak]{
            display: none;
        }

        /*分页条按钮背景色*/
        .pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover {
            background: linear-gradient(to right, rgb(19, 122, 74) , rgb(174, 179, 109));
        }


    </style>

    <script>
        $(function(){
            //进入此页面后，清除导航栏所有灰色背景，active是所包含jsp的class名
            $("li").removeClass("active");
            //为购买手机添加灰色背景,从视觉上代表已经停留到此页
            $("#li_buy").addClass("active");

            //创建一个数据，接收ajax返回数据，将语句交给vue做试图渲染，此数据一开始存放第一页数据，然后交给vue，vue拿这个数据进行第一页数据渲染
            //让用户点击第2页，3页的时候，此变量就会接收不同的数据
            var data;

            //进入商品页面后，就会发送ajax请求，此请求会获取默认商品页面的数据，也就是第一页数据
            $.ajax({
                type:"get",
                url:"<%=request.getContextPath() %>/product/getData",
                async : false,//取消异步变为同步，作用是ajax请求整体完全结束后再执行接下来的代码，否则还没等success就执行后面的代码，导致datas拿不到返回数据
                success:function (response) {
                    data=response;
                }
            });//ajax结束处




            //创建vue
            var vm=new Vue({
                el:'#vue_div',
                data:{
                    datas:data,
                    url:'static/img/product/',
                    isShow:0,    //用于分页条被选中后的css样式控制
                    //设置4个变量，用于分类选择列表，比如用户点击条件是苹果，又点击了8新，通过这些变量能知道用户点了几个条件以及条件具体
                    conditionListBrand:'default',
                    conditionListLevel:'default',
                    conditionListSize:'default',
                    conditionListPrice:'default',
                },
                methods:{
                    //返回顶部，当用户点击上一下，下一页等等，会将商品页面自动向上距离顶层175px的距离，向上花费的过程为200hm
                    back_top:function(){
                            $("html,body").animate({scrollTop:"100px"},200);
                    },

                    //点击不同页面显示不同页面的数据
                    come_to_product_page:function (pageNum) {
                        //回到页面顶部，体验效果好
                        this.$options.methods.back_top();
                        //创建json对象
                        var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice,"tiaojian05":pageNum};
                        //将json对象转换为json字符串
                        var str=JSON.stringify(json);
                        //由于服务器的每个方法中所承载的代码不能太多，而以我目前最笨的方法代码还就是得那么多，得将服务器的代码分开写到不同的方法
                        //得进行判断，如果品牌成色存储价格全都被点击了
                        if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //你只要品牌是苹果三星华为中的其中一个，就进入我这个服务器
                            if(this.conditionListBrand == "pingguo" || this.conditionListBrand == "sanxing" || this.conditionListBrand == "huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourOne",
                                    success:function (response) {
                                        this.datas=response;
                                        //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                        var x=1;
                                        if(pageNum!=1 && x==1 ){
                                            $("#li_default_css").removeClass("active");
                                            x=0;
                                        }
                                        this.isShow=pageNum
                                    }.bind(this)
                                });
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourTwo",
                                    success:function (response) {
                                        this.datas=response;
                                        //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                        var x=1;
                                        if(pageNum!=1 && x==1 ){
                                            $("#li_default_css").removeClass("active");
                                            x=0;
                                        }
                                        this.isShow=pageNum
                                    }.bind(this)
                                });
                            }
                        }else {//只要有default，进这个服务器方法
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/page/distributor",
                                success:function (response) {
                                    this.datas=response;
                                    //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                    var x=1;
                                    if(pageNum!=1 && x==1 ){
                                        $("#li_default_css").removeClass("active");
                                        x=0;
                                    }
                                    this.isShow=pageNum
                                }.bind(this)
                            });
                        }
                    },

                    //点击上一页按钮
                    page_previous:function () {
                        //获取当前页的前一页
                        var prePage=this.datas.prePage;
                        //如果有前一页
                        if(prePage!=0){
                            //回到页面顶部，体验效果好
                            this.$options.methods.back_top();
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice,"tiaojian05":prePage};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            //由于服务器的每个方法中所承载的代码不能太多，而以我目前最笨的方法代码还就是得那么多，得将服务器的代码分开写到不同的方法
                            //得进行判断，如果品牌成色存储价格全都被点击了
                            if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                                //你只要品牌是苹果三星华为中的其中一个，就进入我这个服务器
                                if(this.conditionListBrand == "pingguo" || this.conditionListBrand == "sanxing" || this.conditionListBrand == "huawei"){
                                    $.ajax({
                                        type:"post",
                                        context:this,
                                        contentType: "application/json; charset=utf-8",
                                        data:str,
                                        url:"<%=request.getContextPath() %>/page/fourOne",
                                        success:function (response) {
                                            this.datas=response;
                                            this.isShow=prePage
                                        }.bind(this)
                                    });
                                }else {
                                    $.ajax({
                                        type:"post",
                                        context:this,
                                        contentType: "application/json; charset=utf-8",
                                        data:str,
                                        url:"<%=request.getContextPath() %>/page/fourTwo",
                                        success:function (response) {
                                            this.datas=response;
                                            this.isShow=prePage
                                        }.bind(this)
                                    });
                                }
                            }else {//只要有default，进这个服务器方法
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/distributor",
                                    success:function (response) {
                                        this.datas=response;
                                        this.isShow=prePage
                                    }.bind(this)
                                });
                            }
                        }
                    },


                    //点击下一页按钮
                    page_next:function () {
                        //获取下一页按钮
                        var nextPage=this.datas.nextPage;
                        //是否是最后一页
                        var isLastPage=this.datas.isLastPage;
                        //如果不是最后一页
                        if(!isLastPage){
                            //回到页面顶部，体验效果好
                            this.$options.methods.back_top();
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice,"tiaojian05":nextPage};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            //由于服务器的每个方法中所承载的代码不能太多，而以我目前最笨的方法代码还就是得那么多，得将服务器的代码分开写到不同的方法
                            //得进行判断，如果品牌成色存储价格全都被点击了
                            if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                                //你只要品牌是苹果三星华为中的其中一个，就进入我这个服务器
                                if(this.conditionListBrand == "pingguo" || this.conditionListBrand == "sanxing" || this.conditionListBrand == "huawei"){
                                    $.ajax({
                                        type:"post",
                                        context:this,
                                        contentType: "application/json; charset=utf-8",
                                        data:str,
                                        url:"<%=request.getContextPath() %>/page/fourOne",
                                        success:function (response) {
                                            this.datas=response;
                                            //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                            var x=1;
                                            if(nextPage!=1 && x==1 ){
                                                $("#li_default_css").removeClass("active");
                                                x=0;
                                            }
                                            this.isShow=nextPage
                                        }.bind(this)
                                    });
                                }else {
                                    $.ajax({
                                        type:"post",
                                        context:this,
                                        contentType: "application/json; charset=utf-8",
                                        data:str,
                                        url:"<%=request.getContextPath() %>/page/fourTwo",
                                        success:function (response) {
                                            this.datas=response;
                                            //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                            var x=1;
                                            if(nextPage!=1 && x==1 ){
                                                $("#li_default_css").removeClass("active");
                                                x=0;
                                            }
                                            this.isShow=nextPage
                                        }.bind(this)
                                    });
                                }
                            }else {//只要有default，进这个服务器方法
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/distributor",
                                    success:function (response) {
                                        this.datas=response;
                                        //这个x变量和底面的if是为了清除默认第一页的css，而且这样写防止了一个bug就是不断点第一页会导致css没了
                                        var x=1;
                                        if(nextPage!=1 && x==1 ){
                                            $("#li_default_css").removeClass("active");
                                            x=0;
                                        }
                                        this.isShow=nextPage
                                    }.bind(this)
                                });
                            }
                        }else {//如果没有下一页
                            return false;
                        }

                    },


                    //点击首页按钮
                    page_home:function () {
                        //回到页面顶部，体验效果好
                        this.$options.methods.back_top();
                        //创建json对象
                        var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice,"tiaojian05":1};
                        //将json对象转换为json字符串
                        var str=JSON.stringify(json);
                        //由于服务器的每个方法中所承载的代码不能太多，而以我目前最笨的方法代码还就是得那么多，得将服务器的代码分开写到不同的方法
                        //得进行判断，如果品牌成色存储价格全都被点击了
                        if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //你只要品牌是苹果三星华为中的其中一个，就进入我这个服务器
                            if(this.conditionListBrand == "pingguo" || this.conditionListBrand == "sanxing" || this.conditionListBrand == "huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourOne",
                                    success:function (response) {
                                        this.datas=response;
                                        this.isShow=1
                                    }.bind(this)
                                });
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourTwo",
                                    success:function (response) {
                                        this.datas=response;
                                        this.isShow=1
                                    }.bind(this)
                                });
                            }
                        }else {//只要有default，进这个服务器方法
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/page/distributor",
                                success:function (response) {
                                    this.datas=response;
                                    this.isShow=1
                                }.bind(this)
                            });
                        }
                    },

                    //点击尾页按钮
                    page_last:function () {
                        //回到页面顶部，体验效果好
                        this.$options.methods.back_top();
                        //获取总页码，也就是最后一页
                        var pages=this.datas.pages;
                        //创建json对象
                        var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice,"tiaojian05":pages};
                        //将json对象转换为json字符串
                        var str=JSON.stringify(json);
                        //由于服务器的每个方法中所承载的代码不能太多，而以我目前最笨的方法代码还就是得那么多，得将服务器的代码分开写到不同的方法
                        //得进行判断，如果品牌成色存储价格全都被点击了
                        if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //你只要品牌是苹果三星华为中的其中一个，就进入我这个服务器
                            if(this.conditionListBrand == "pingguo" || this.conditionListBrand == "sanxing" || this.conditionListBrand == "huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourOne",
                                    success:function (response) {
                                        $("#li_default_css").removeClass("active");
                                        this.datas=response;
                                        this.isShow=pages
                                    }.bind(this)
                                });
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/page/fourTwo",
                                    success:function (response) {
                                        $("#li_default_css").removeClass("active");
                                        this.datas=response;
                                        this.isShow=pages
                                    }.bind(this)
                                });
                            }
                        }else {//只要有default，进这个服务器方法
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/page/distributor",
                                success:function (response) {
                                    $("#li_default_css").removeClass("active");
                                    this.datas=response;
                                    this.isShow=pages
                                }.bind(this)
                            });
                        }
                    },


                    //点击分类选择列表的苹果条件展示苹果页面第一页
                    brand_pingguo:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到苹果选钮上
                        $(".brand :nth-child(2)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='pingguo';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                    //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"pingguo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {//用户其他都没点，只点了品牌
                            //调用发送ajax请求的方法
                            //this.$options.methods.categorySelectionListAjax(this.conditionListBrand);      无法将ajax封装出去，封装出去响应值赋值给datas在success中看到确实是赋值了，但是datas依然是原值，不清楚为什么
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                    },

                    //点击分类选择列表的三星条件
                    brand_sanxing:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到三星选钮上
                        $(".brand :nth-child(3)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='sanxing';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"sanxing","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else{
                            //调用发送ajax请求的方法
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                    },

                    //点击分类选择列表的华为条件
                    brand_huawei:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到华为选钮上
                        $(".brand :nth-child(4)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='huawei';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"huawei","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {
                            //调用发送ajax请求的方法
                            //this.$options.methods.categorySelectionListAjax(this.conditionListBrand);
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的小米条件
                    brand_xiaomi:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到小米选钮上
                        $(".brand :nth-child(5)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='xiaomi';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"xiaomi","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {
                            //调用发送ajax请求的方法
                            //this.$options.methods.categorySelectionListAjax(this.conditionListBrand);
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的oppo条件
                    brand_oppo:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到oppo选钮上
                        $(".brand :nth-child(6)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='oppo';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"oppo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {
                            //调用发送ajax请求的方法
                            //this.$options.methods.categorySelectionListAjax(this.conditionListBrand);
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的vivo条件
                    brand_vivo:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到vivo选钮上
                        $(".brand :nth-child(7)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='vivo';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"vivo","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的品牌不限条件
                    brand_unlimited:function(){
                        //将点选背景色清除
                        $(".brand a").removeClass("point-color");
                        //将点选背景色加到不限选钮上
                        $(".brand :nth-child(1)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListBrand='buxian';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储+品牌
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击价格+品牌
                            //创建json对象buxianjiage
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击品牌前判断用户是否点击了成色和存储
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了成色和价格
                        else if(this.conditionListLevel!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了存储和价格
                        else if(this.conditionListLevel=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击品牌前判断用户是否点击了 成色，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListLevel!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":"buxian","tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListBrand,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的成色99新
                    level_jiujiu:function(){
                        //将点选背景色清除
                        $(".level a").removeClass("point-color");
                        //将点选背景色加到99钮上
                        $(".level :nth-child(2)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListLevel='jiujiu';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击成色之前点击了存储
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default") {
                            //如果用户点击成色之前点击了价格
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json = {"tiaojian01": this.conditionListLevel, "tiaojian02": this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str = JSON.stringify(json);
                            $.ajax({
                                type: "post",
                                context: this,
                                contentType: "application/json; charset=utf-8",
                                data: str,
                                url: "<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success: function (response) {
                                    this.datas = response;
                                }.bind(this)
                            });
                            this.isShow = 1//将背景色添加到第一页按钮上

                        }
                        //点击成色前判断用户是否点击了品牌和存储
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了品牌和价格
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了存储和价格
                        else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了 品牌，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListLevel,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的成色95新
                    level_jiuwu:function(){
                        //将点选背景色清除
                        $(".level a").removeClass("point-color");
                        //将点选背景色加到95钮上
                        $(".level :nth-child(3)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListLevel='jiuwu';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击成色之前点击了存储
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击成色之前点击了价格
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击成色前判断用户是否点击了品牌和存储
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了品牌和价格
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了存储和价格
                        else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了 品牌，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListLevel,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的成色9新
                    level_jiu:function(){
                        //将点选背景色清除
                        $(".level a").removeClass("point-color");
                        //将点选背景色加到9钮上
                        $(".level :nth-child(4)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListLevel='jiu';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击成色之前点击了存储
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击成色之前点击了价格
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击成色前判断用户是否点击了品牌和存储
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了品牌和价格
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了存储和价格
                        else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了 品牌，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListLevel,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的成色8新
                    level_ba:function(){
                        //将点选背景色清除
                        $(".level a").removeClass("point-color");
                        //将点选背景色加到8钮上
                        $(".level :nth-child(5)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListLevel='ba';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击成色之前点击了存储
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击成色之前点击了价格
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击成色前判断用户是否点击了品牌和存储
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了品牌和价格
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了存储和价格
                        else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了 品牌，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListLevel,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    ////点击分类选择列表的成色不限
                    level_buxian:function(){
                        //将点选背景色清除
                        $(".level a").removeClass("point-color");
                        //将点选背景色加到成色不限选钮上
                        $(".level :nth-child(1)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListLevel='buxianchengse';
                        //判断用户是否点击了其他条件，比如点了苹果后又点了99新或是其他更多的组合
                        //如果用户点了成色+品牌双条件
                        if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice=="default"){
                            //发送ajax查询成色+品牌符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //如果用户点击成色之前点击了存储
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //如果用户点击成色之前点击了价格
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击成色前判断用户是否点击了品牌和存储
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了品牌和价格
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了存储和价格
                        else if(this.conditionListBrand=="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击成色前判断用户是否点击了 品牌，存储，价格   全条件查询
                        //四条件查询分两个服务器，含有iPhone，三星和华为的到第一个服务器，小米和OV和不限品牌到第二个服务器
                        else if(this.conditionListBrand!="default" && this.conditionListSize!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListLevel,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的储存512G
                    size_wuyier:function(){
                        //将点选背景色清除
                        $(".size a").removeClass("point-color");
                        //将点选背景色加到512钮上
                        $(".size :nth-child(2)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListSize='wuyier';
                        //双条件判断，如果用户点击存储前点击了品牌
                        if(this.conditionListBrand!="default" && this.conditionListLevel=="default" && this.conditionListPrice=="default"){
                            //如果用户点击品牌+存储
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储之前点击了成色
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListPrice!="default"){
                            //如果用户点击存储之前点击了价格
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击存储前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了品牌和价格
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了成色和价格
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了 品牌，成色，价格   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);

                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }

                        }
                        else{
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListSize,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的储存256G
                    size_erwuliu:function(){
                        //将点选背景色清除
                        $(".size a").removeClass("point-color");
                        //将点选背景色加到256钮上
                        $(".size :nth-child(3)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListSize='erwuliu';
                        //双条件判断，如果用户点击存储前点击了品牌
                        if(this.conditionListBrand!="default" && this.conditionListLevel=="default" && this.conditionListPrice=="default"){
                            //如果用户点击品牌+存储
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储之前点击了成色
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListPrice!="default"){
                            //如果用户点击存储之前点击了价格
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击存储前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了品牌和价格
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了成色和价格
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了 品牌，成色，价格   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListSize,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的储存128G
                    size_yierba:function(){
                        //将点选背景色清除
                        $(".size a").removeClass("point-color");
                        //将点选背景色加到128钮上
                        $(".size :nth-child(4)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListSize='yierba';
                        //双条件判断，如果用户点击存储前点击了品牌
                        if(this.conditionListBrand!="default" && this.conditionListLevel=="default" && this.conditionListPrice=="default"){
                            //如果用户点击品牌+存储
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储之前点击了成色
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListPrice!="default"){
                            //如果用户点击存储之前点击了价格
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击存储前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了品牌和价格
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了成色和价格
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了 品牌，成色，价格   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListSize,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的储存64G
                    size_liusi:function(){
                        //将点选背景色清除
                        $(".size a").removeClass("point-color");
                        //将点选背景色加到64钮上
                        $(".size :nth-child(5)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListSize='liusi';
                        //双条件判断，如果用户点击存储前点击了品牌
                        if(this.conditionListBrand!="default" && this.conditionListLevel=="default" && this.conditionListPrice=="default"){
                            //如果用户点击品牌+存储
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储之前点击了成色
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListPrice!="default"){
                            //如果用户点击存储之前点击了价格
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击存储前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了品牌和价格
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了成色和价格
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了 品牌，成色，价格   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListSize,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类选择列表的储存不限
                    size_buxian:function(){
                        //将点选背景色清除
                        $(".size a").removeClass("point-color");
                        //将点选背景色加到存储不限选钮上
                        $(".size :nth-child(1)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListSize='buxiancunchu';
                        //双条件判断，如果用户点击存储前点击了品牌
                        if(this.conditionListBrand!="default" && this.conditionListLevel=="default" && this.conditionListPrice=="default"){
                            //如果用户点击品牌+存储
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //如果用户点击存储之前点击了成色
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListPrice!="default"){
                            //如果用户点击存储之前点击了价格
                            //发送ajax查询成色+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击存储前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice=="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了品牌和价格
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了成色和价格
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击存储前判断用户是否点击了 品牌，成色，价格   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListPrice!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListSize,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类列表价格0-1499
                    price_ling_yisijiujiu:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格0-1499钮上
                        $(".price :nth-child(2)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='lingdaoyisijiujiu';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    ///点击分类列表价格1500-1999
                    price_yiwulingling_yijiujiujiu:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格1500-1999钮上
                        $(".price :nth-child(3)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='yiwulinglingdaoyijiujiujiu';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类列表价格2000-2999
                    price_erlinglingling_erjiujiujiu:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格2000-2999钮上
                        $(".price :nth-child(4)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='erlinglinglingdaoerjiujiujiu';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类列表价格3000-3999
                    price_sanlinglingling_sanjiujiujiu:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格3000-3999钮上
                        $(".price :nth-child(5)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='sanlinglinglingdaosanjiujiujiu';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类列表价格>4000
                    price_dayusilinglingling:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格>4000钮上
                        $(".price :nth-child(6)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='dayusilinglingling';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //点击分类列表价格不限
                    price_buxian:function(){
                        //将点选背景色清除
                        $(".price a").removeClass("point-color");
                        //将点选背景色加到价格不限钮上
                        $(".price :nth-child(1)").addClass("point-color");
                        this.isShow=''//将所有分页按钮背景色清除
                        //条件变量赋值
                        this.conditionListPrice='buxianjiage';
                        //双条件查询，点击价格之前查询是否点击了品牌
                        if(this.conditionListLevel=="default" && this.conditionListSize=="default" && this.conditionListBrand!="default"){
                            //如果用户点击品牌+价格
                            //创建json对象buxianjiage
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //如果用户点击价格之前点击了成色
                            //发送ajax查询成色+价格符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }else if(this.conditionListBrand=="default" && this.conditionListLevel=="default" && this.conditionListSize!="default"){
                            //如果用户点击价格之前点击了存储
                            //发送ajax查询价格+存储符合条件的商品
                            //创建json对象
                            var json={"tiaojian01":this.conditionListSize,"tiaojian02":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/doubleConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上

                        }
                        //点击价格前判断用户是否点击了品牌和成色
                        else if(this.conditionListBrand!="default" && this.conditionListSize=="default" && this.conditionListLevel!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了品牌和存储
                        else if(this.conditionListLevel=="default" && this.conditionListBrand!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了存储和成色
                        else if(this.conditionListBrand=="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListLevel,"tiaojian02":this.conditionListSize,"tiaojian03":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            $.ajax({
                                type:"post",
                                context:this,
                                contentType: "application/json; charset=utf-8",
                                data:str,
                                url:"<%=request.getContextPath() %>/conditionsQuery/threeConditionsQuery",
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }
                        //点击价格前判断用户是否点击了 品牌，成色，存储   全条件查询
                        else if(this.conditionListBrand!="default" && this.conditionListLevel!="default" && this.conditionListSize!="default"){
                            //创建json对象
                            var json={"tiaojian01":this.conditionListBrand,"tiaojian02":this.conditionListLevel,"tiaojian03":this.conditionListSize,"tiaojian04":this.conditionListPrice};
                            //将json对象转换为json字符串
                            var str=JSON.stringify(json);
                            if(this.conditionListBrand=="pingguo" || this.conditionListBrand=="sanxing" || this.conditionListBrand=="huawei"){
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryOne",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }else {
                                $.ajax({
                                    type:"post",
                                    context:this,
                                    contentType: "application/json; charset=utf-8",
                                    data:str,
                                    url:"<%=request.getContextPath() %>/conditionsQuery/fourConditionsQueryTwo",
                                    success:function (response) {
                                        this.datas=response;
                                    }.bind(this)
                                });
                                this.isShow=1//将背景色添加到第一页按钮上
                            }
                        }
                        else {
                            $.ajax({
                                type:"get",
                                context:this,
                                data:"condition="+this.conditionListPrice,
                                url:"<%=request.getContextPath() %>/conditionsQuery/singleConditionQuery",
                                async : false,
                                success:function (response) {
                                    this.datas=response;
                                }.bind(this)
                            });
                            this.isShow=1//将背景色添加到第一页按钮上
                        }

                    },

                    //用户点击某一具体商品，传入此商品id，然后将此id作为参数发送到商品详情页，详情页获取id进行信息查询
                    product_details:function (id) {
                        $.ajax({
                            success:function () {
                                window.location.href=("product_details.jsp?productInfoById="+id);
                            }
                        });
                    },


                }//methode结束处
            });//vue结束处



            //如果刚进入商城页面，需要将分页条的css背景颜色停留在第一页上
            var a_num=$('#a_text_num').text();//获取的值永远是li标签中一个a标签的内容，也就是1，我也不知道为什么
            if(a_num==1){
                $("#li_default_css").addClass("active");
            }


            //进入商城页面后设置分类选择列表中默认都被点击不限，给不限添加背景色
            //:nth-child选择器，可以选择父元素中第几个子元素
            $(".brand :nth-child(1)").addClass("point-color");
            $(".level :nth-child(1)").addClass("point-color");
            $(".size :nth-child(1)").addClass("point-color");
            $(".price :nth-child(1)").addClass("point-color");


            //获取用户在index页面的我要买板块用户点击的品牌
            //哪个session有值代表用户点了哪个品牌，然后自动点击当前品牌的点击事件就会展示出品牌商品到页面上
            var wantToBuypingguo="<%= session.getAttribute("pingguo") %>";
            var wantToBuysanxing="<%= session.getAttribute("sanxing") %>";
            var wantToBuyhuawei="<%= session.getAttribute("huawei") %>";
            var wantToBuyxiaomi="<%= session.getAttribute("xiaomi") %>";
            var wantToBuyoppo="<%= session.getAttribute("oppo") %>";
            var wantToBuyvivo="<%= session.getAttribute("vivo") %>";
            if(wantToBuypingguo!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_pingguo").click();//调取苹果的点击事件
                <% session.removeAttribute("pingguo"); %>
            }else if (wantToBuysanxing!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_sanxing").click();
                <% session.removeAttribute("sanxing"); %>
            }else if (wantToBuyhuawei!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_huawei").click();
                <% session.removeAttribute("huawei"); %>
            }else if (wantToBuyxiaomi!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_xiaomi").click();
                <% session.removeAttribute("xiaomi"); %>
            }else if (wantToBuyoppo!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_oppo").click();
                <% session.removeAttribute("oppo"); %>
            }else if (wantToBuyvivo!="null"){
                $(".brand :nth-child(1)").removeClass("point-color");
                document.getElementById("b_vivo").click();
                <% session.removeAttribute("vivo"); %>
            }


        });//入口函数end


    </script>
</head>
<body>
<!----------------------------------------------购买手机页面------------------------------------------------------------------>

<!--获取存在session中的用户数据，用来判断用户是否登录。未登录index顶部显示登录注册等，登录显示用户名，退出，查看购物车等-->
<!--此数据是在用户登录时服务器存在session中的-->
<%User user=(User)session.getAttribute("user"); %>

<% if(user==null) {%>   <!------------------------如果用户未登录，显示未登录的样式导航条-->
<jsp:include page="WEB-INF/views/userNotLoginNAV.jsp"></jsp:include>
<% } else{%>        <!------------------------------------------如果用户登录了，显示登陆后的样式导航条-->
<jsp:include page="WEB-INF/views/userLoginNAV.jsp"></jsp:include>
<% } %>

<!--搜索框-->
<%--<div style="width: 100%;padding-top: 40px">
    <div style="width: 500px;margin: 0 auto">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="商品搜索">
            <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
        </div>
    </div>
</div>--%>


<div class="container">
    <div id="vue_div" v-cloak>
        <!--路径导航-->
        <div style="margin-top: 50px;">
            <ol class="breadcrumb" style="width: 1198px">
                <li><a href="index.jsp">爱手机</a></li>
                <li v-if="conditionListBrand=='pingguo'" class="active">Apple</li>
                <li v-else-if="conditionListBrand=='sanxing'" class="active">三星</li>
                <li v-else-if="conditionListBrand=='huawei'" class="active">华为</li>
                <li v-else-if="conditionListBrand=='xiaomi'" class="active">小米</li>
                <li v-else-if="conditionListBrand=='oppo'" class="active">OPPO</li>
                <li v-else-if="conditionListBrand=='vivo'" class="active">ViVO</li>
                <li v-else-if="conditionListBrand=='dengyuyigebucunzaidezhi'" class="active"></li>
                <li v-if="conditionListLevel=='jiujiu'" class="active">99新</li>
                <li v-else-if="conditionListLevel=='jiuwu'" class="active">95新</li>
                <li v-else-if="conditionListLevel=='jiu'" class="active">9新</li>
                <li v-else-if="conditionListLevel=='ba'" class="active">8新</li>
                <li v-else-if="conditionListLevel=='dengyuyigebucunzaidezhi'" class="active"></li>
                <li v-if="conditionListSize=='wuyier'" class="active">512G</li>
                <li v-else-if="conditionListSize=='erwuliu'" class="active">256G</li>
                <li v-else-if="conditionListSize=='yierba'" class="active">128G</li>
                <li v-else-if="conditionListSize=='liusi'" class="active">64G</li>
                <li v-else-if="conditionListSize=='dengyuyigebucunzaidezhi'" class="active"></li>
                <li v-if="conditionListPrice=='lingdaoyisijiujiu'" class="active">0-1499</li>
                <li v-else-if="conditionListPrice=='yiwulinglingdaoyijiujiujiu'" class="active">1500-1999</li>
                <li v-else-if="conditionListPrice=='erlinglinglingdaoerjiujiujiu'" class="active">2000-2999</li>
                <li v-else-if="conditionListPrice=='sanlinglinglingdaosanjiujiujiu'" class="active">3000-3999</li>
                <li v-else-if="conditionListPrice=='dayusilinglingling'" class="active">4000及以上</li>
                <li v-else-if="conditionListPrice=='dengyuyigebucunzaidezhi'" class="active"></li>
            </ol>
        </div>

        <!--分类选择列表-->
        <div class="screen">
            <dl class="clearfix">   <!--dl列表行-->
                <dt>品牌</dt>         <!--dt列表的列头-->
                <dd>                <!--dd列表的列内容-->
                    <div class="dd-top">
                            <span class="a-box brand">
                                <a href="javascript:;" v-on:click="brand_unlimited">不限</a><!--class="point-color"，当前筛选条件被选择，增加颜色,在js中设置-->
                                <a href="javascript:;" v-on:click="brand_pingguo" id="b_pingguo">苹果</a>
                                <a href="javascript:;" v-on:click="brand_sanxing" id="b_sanxing">三星</a>
                                <a href="javascript:;" v-on:click="brand_huawei" id="b_huawei">华为</a>
                                <a href="javascript:;" v-on:click="brand_xiaomi" id="b_xiaomi">小米</a>
                                <a href="javascript:;" v-on:click="brand_oppo" id="b_oppo">OPPO</a>
                                <a href="javascript:;" v-on:click="brand_vivo" id="b_vivo">ViVO</a>
                            </span>
                    </div>
                </dd>
            </dl>
            <dl class="clearfix">
                <dt>成色</dt>         <!--dt列表的列头-->
                <dd>                <!--dd列表的列内容-->
                    <div class="dd-top">
                            <span class="a-box level">
                                <a href="javascript:;" v-on:click="level_buxian">不限</a>
                                <a href="javascript:;" v-on:click="level_jiujiu">99新</a>
                                <a href="javascript:;" v-on:click="level_jiuwu">95新</a>
                                <a href="javascript:;" v-on:click="level_jiu">9新</a>
                                <a href="javascript:;" v-on:click="level_ba">8新</a>
                            </span>
                    </div>
                </dd>
            </dl>
            <dl class="clearfix">
                <dt>存储</dt>         <!--dt列表的列头-->
                <dd>                <!--dd列表的列内容-->
                    <div class="dd-top">
                            <span class="a-box size">
                                <a href="javascript:;" v-on:click="size_buxian">不限</a>
                                <a href="javascript:;" v-on:click="size_wuyier">512G</a>
                                <a href="javascript:;" v-on:click="size_erwuliu">256G</a>
                                <a href="javascript:;" v-on:click="size_yierba">128G</a>
                                <a href="javascript:;" v-on:click="size_liusi">64G</a>
                            </span>
                    </div>
                </dd>
            </dl>
            <dl class="clearfix">
                <dt>价格</dt>         <!--dt列表的列头-->
                <dd>                <!--dd列表的列内容-->
                    <div class="dd-top">
                            <span class="a-box price">
                                <a href="javascript:;" v-on:click="price_buxian">不限</a>
                                <a href="javascript:;" v-on:click="price_ling_yisijiujiu">0-1499</a>
                                <a href="javascript:;" v-on:click="price_yiwulingling_yijiujiujiu">1500-1999</a>
                                <a href="javascript:;" v-on:click="price_erlinglingling_erjiujiujiu">2000-2999</a>
                                <a href="javascript:;" v-on:click="price_sanlinglingling_sanjiujiujiu">3000-3999</a>
                                <a href="javascript:;" v-on:click="price_dayusilinglingling">4000及以上</a>
                            </span>
                    </div>
                </dd>
            </dl>
        </div>


        <!-------------------------------------------------------------------商品展示，每页4行4列--------------------------->


        <div style="height: 930px">
            <ul class="phonelist">
                <li v-for="item in datas.list" v-on:click="product_details(item.id)">    <!--每个li是一个商品--> <!--v-for循环遍历取出datas.list数据-->
                    <a href="javascript:;">
                        <img :src="url+item.pImg">
                        <p class="t">{{item.pName}}</p>
                        <div class="t-i">成色：{{item.pLevel}}新、{{item.pSize}}G</div>
                        <div class="t-price">
                            <p>￥{{item.pPrice}}</p>
                        </div>
                    </a>
                </li>
            </ul>
        </div>

        <div>
            <p>当前为第{{datas.pageNum}}页，共{{datas.pages}}页，共{{datas.total}}条记录</p>
        </div>

        <!--分页-->
        <div style="text-align: center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="javascript:;" aria-label="Previous" style="color:#006633" v-on:click="page_home">
                            <span aria-hidden="true">首页</span>
                        </a>
                    </li>

                    <li>
                        <a href="javascript:;" aria-label="Previous" style="color:#006633" v-on:click="page_previous" >
                            <span aria-hidden="true"><em><</em>&nbsp;上一页</span>
                        </a>
                    </li>

                    <li id="li_default_css" v-for="pageNum in datas.navigatepageNums" v-bind:class="isShow == pageNum ? 'active' : '' " ><!--如果当前页=被点击的页，给此分页条加上css-->
                        <a href="javascript:;" v-on:click="come_to_product_page(pageNum)" id="a_text_num">{{pageNum}}</a><!--点击某一页面后发送ajax请求给vue-->
                    </li>

                    <li>
                        <a href="javascript:;" aria-label="Next" style="color:#006633" v-on:click="page_next" id="next">
                            <span aria-hidden="true">下一页&nbsp;<em>></em></span>
                        </a>
                    </li>

                    <li>
                        <a href="javascript:;" aria-label="Previous" style="color:#006633" v-on:click="page_last">
                            <span aria-hidden="true">尾页</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>



</div><!--栅格结束-->


<!--页面最底部-->
<jsp:include page="WEB-INF/views/bottom.jsp"></jsp:include>



</body>
</html>
