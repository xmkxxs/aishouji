<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.xm.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>爱手机网 - 品质二手手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/index.css">

    <script>
      $(function(){
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


        //点击我要买iPhone按钮
        $(".buy_iphone").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"pingguo",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });

        //点击我要买三星按钮
        $(".buy_samsung").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"sanxing",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });
        //点击我要买华为按钮
        $(".buy_huawei").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"huawei",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });
        //点击我要买小米按钮
        $(".buy_xiaomi").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"xiaomi",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });
        //点击我要买oppo按钮
        $(".buy_oppo").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"oppo",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });
        //点击我要买vivo按钮
        $(".buy_vivo").click(function(){
          $.ajax({
            type:"get",
            url:"<%=request.getContextPath() %>/product/wantToBuy",
            async : false,//取消异步变为同步
            data:"brand="+"vivo",
            success:function () {
              window.location.href="product.jsp"
            }
          });
        });


      });//入口函数结束处

      </script>
</head>
<body>
    <!--获取存在session中的用户数据，用来判断用户是否登录。未登录index顶部显示登录注册等，登录显示用户名，退出，查看购物车等-->
    <!--此数据是在用户登录时服务器存在session中的-->
    <%User user=(User)session.getAttribute("user"); %>

    <% if(user==null) {%>   <!------------------------如果用户未登录，显示未登录的样式导航条-->
        <jsp:include page="WEB-INF/views/userNotLoginNAV.jsp"></jsp:include>
    <% } else{%>        <!------------------------------------------如果用户登录了，显示登陆后的样式导航条-->
        <jsp:include page="WEB-INF/views/userLoginNAV.jsp"></jsp:include>
    <% } %>

      <!--爱手机网slogan部分-->
      <div id="propaganda">
        <div id="div-propaganda">
            <span id="span01-propaganda">爱手机网&nbsp;&nbsp;</span>
            <span id="span02-propaganda">懂你的二手手机市场&nbsp;</span>
            <span id="span02-propaganda">买的放心&nbsp;</span>
            <span id="span02-propaganda">用的安心</span>    
        </div>

        <div class="hidden-xs" style="position: absolute;padding-left: 1040px;margin-top:130px;height: 200px;"><!--hidden-xs响应式，网页缩放到一定程度此img消失，妥协做法，否则导致图片飞了-->
            <img src="static/img/phone.png" class="img-responsive img-slogan-iphone" alt="phone" style="height:220px;">
        </div>
        <!--输入框-->
        <%--<div class="container-fluid">
            <div class="col-lg-6 col-md-offset-1" style="padding-top: 250px;padding-right: 250px;">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
                </div>
            </div>
        </div>--%>
      </div>

      <!--手机品牌展示-->
      <div class="container">
        <div class="jumbotron">
          <span style="color: black;font-weight:bold;font-size: 25px;">我要买</span><span class="glyphicon glyphicon-triangle-right"></span>
          <!--此写法是防止br被鼠标选中-->
          <div id="notAllowedToSelect">
            </br>
          </div>
          <div class="row">
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/iphone.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_iphone" id="phone-logo">iPhone</a></div>
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/samsung.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_samsung" id="phone-logo">三星</a></div>
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/huawei.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_huawei" id="phone-logo">华为</a></div>
          </div>
          <div id="notAllowedToSelect">
            </br>
          </div>
          <div class="row">
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/mi.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_xiaomi" id="phone-logo">小米</a></div>
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/oppo.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_oppo" id="phone-logo">OPPO</a></div>
            <div class="col-md-4 col-xs-4"><img src="static/img/phoneLOGO/vivo.png" id="phone-logo-img-size"><span id="notAllowedToSelect">&nbsp;&nbsp;</span><a href="javascript:;" class="buy_vivo" id="phone-logo">ViVO</a></div>
          </div>
        </div>
      </div>

      <!--品质保障-->
      <div class="container">
        <div style="text-align: center;color: black;font-weight:bold;font-size: 35px;">品质保障</div>
        <div id="notAllowedToSelect">
          </br>
        </div>
        <div class="row">
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/back.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/sf.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/fix.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/picture.png"></div>
        </div>
      
        <div id="notAllowedToSelect">
          </br>
        </div>

        <div class="row" id="quality-assurance-font01">
          <div class="col-md-3 col-xs-3" style="text-align: center;">7天包退</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">顺丰包邮</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">一年保修</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">一机一拍</div>
        </div>
        <div class="row" id="quality-assurance-font02">
          <div class="col-md-3 col-xs-3" style="text-align: center;">商品质量问题退换无忧</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">顺丰陆运极速送达</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">365天免费质保</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">买家尽情淘好货</div>
        </div>

        <div id="notAllowedToSelect">
          </br></br>
        </div>
      
        <div class="row">
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/service.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/quick.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/broken.png"></div>
          <div class="col-md-3 col-xs-3" style="text-align: center;"><img id="quality-assurance" src="static/img/qualityAssurance/good.png"></div>
        </div>

        <div id="notAllowedToSelect">
          </br>
        </div>
      
        <div class="row" id="quality-assurance-font01">
          <div class="col-md-3 col-xs-3" style="text-align: center;">一对一专业客服</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">闪电发货</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">无忧分期</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">数以万计用户好评</div>
        </div>
        <div class="row" id="quality-assurance-font02">
          <div class="col-md-3 col-xs-3" style="text-align: center;">专属客服零距离服务</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">万余商品极速发货</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">多种分期方式无忧购</div>
          <div class="col-md-3 col-xs-3" style="text-align: center;">好评率高达97.5%</div>
        </div>

      </div>
      
      <div id="notAllowedToSelect">
        </br></br></br></br>
      </div>
    
      <!--相信我们，超给力！-->
      <div class="container-fluid" style="background-image: -webkit-linear-gradient(310deg, #fe7142 0%, #67b6c0 50%, #9A57E8 75%, #53A0E8 100%);">
        <div class="row">
          <div class="col-md-12 col-xs-12" id="notAllowedToSelect" style="text-align: center;color: #222;font-size: 40px;font-weight: 700;">&nbsp;</div>
        </div>
        
        <div class="row">
          <div class="col-md-12 col-xs-12" style="text-align: center;color: #222;font-size: 40px;font-weight: 700;">相信我们，超给力！</div>
        </div>
        <div class="row">
          <div class="col-md-12 col-xs-12" style="text-align: center;color: #555;font-size: 16px;font-weight: 100;letter-spacing: 2px;line-height: 1.6;">二手商品看似相同，件件不同，笼统的发一台99新，95新给消费者太不负责任。</div>
        </div>
        <div class="row">
          <div class="col-md-12 col-xs-12" style="text-align: center;color: #555;font-size: 16px;font-weight: 100;letter-spacing: 2px;line-height: 1.6;">爱手机把挑选商品的权利还给爱粉，您就对着质检报告一台一台精挑细选，享受淘物的乐趣。</div>
        </div>

        <div id="notAllowedToSelect">
          </br></br></br>
        </div>

        <!--三个圆形div球-->
        <div style="text-align: center;">  
          <div id="div-circular01">
            <span>25道</span>
            <span>外观检测</span>
          </div>
          <div id="div-circular02">
            <span>52项</span>
            <span>功能检测</span>
          </div>
          <div id="div-circular03">
            <span>大型游戏</span>
            <span>跑分测试</span>
          </div>
        </div>

        <div id="notAllowedToSelect">
          </br></br></br>
        </div>

        <!--质检师img-->
        <div class="row" >
          <div class="col-md-4  col-xs-4" style="text-align: center;">
            <img src="static/img/checker/checker01.png" class="img-responsive" style="width: 470px;height: 510px;">
          </div>
          <div class="col-md-4  col-xs-4" style="text-align: center;">
            <img src="static/img/checker/checker02.png" class="img-responsive" style="width: 470px;height: 500px;">
          </div>
          <div class="col-md-4  col-xs-4" style="text-align: center;">
            <img src="static/img/checker/checker03.png" class="img-responsive" style="width: 470px;height: 499px;">
          </div>
        </div>

        <!--质检师img底部的文字-->
        <div class="row" >
          <div class="col-md-2 col-md-offset-1 col-xs-4" style="text-align: center;font-size: 28px;color: #555;" id="notAllowedToSelect">iPhone X
          </br>
          <div style="color: rgb(99, 19, 19);font-size: 16px;" id="notAllowedToSelect">IEMI号：3567********230</div>
          </div>
          <div class="col-md-4 col-md-offset-1 col-xs-4" style="text-align: center;font-size: 28px;color: #555;" id="notAllowedToSelect">iPhone X
          </br>
          <div style="color: rgb(99, 19, 19);font-size: 16px;" id="notAllowedToSelect">IEMI号：3567********493</div>
          </div>
          <div class="col-md-2 col-md-offset-1 col-xs-4" style="text-align: center;font-size: 28px;color: #555;" id="notAllowedToSelect">iPhone X
          </br>
          <div style="color: rgb(99, 19, 19);font-size: 16px;" id="notAllowedToSelect">IEMI号：3567********555</div>
          </div>
        </div>

        <div id="notAllowedToSelect">
          </br></br></br>
        </div>

      </div>

      <div id="notAllowedToSelect">
        </br></br></br>
      </div>

      <!--检测样机图模块-->
      <div style="background: #fbfbfb;">
        <div>
          <div style="text-align: center;"><p style="font-size: 40px;color: #222;font-weight: 700;letter-spacing: 3px;">素颜照，所见即所得</p></div>
          <div style="text-align: center;"><p style="color: #252525;font-size: 16px;letter-spacing: 3px;">产品图片不加任何PS美化效果，还原机器本色</p></div>
        </div>

        <div id="notAllowedToSelect">
          </br></br></br>
        </div>

        <div class="pic">
          <div class="img">
            <div>
              <div class="phonetr1"><img id="checking-phone01" src="static/img/checkingPhone/Bitmap3.png" alt="产品图片"></div>
              <div class="phonetr2"><img id="checking-phone02" src="static/img/checkingPhone/IMG_9519.png" alt="产品图片"></div>
              <div class="phonetr3"><img id="checking-phone03" src="static/img/checkingPhone/IMG_9518%202.png" alt="产品图片"></div>
            </div>
            <div class="phonetr4">
              <img id="checking-phone04" src="static/img/checkingPhone/IMG_9524.png" alt="产品图片">
            </div>
          </div>
        </div>
      </div>

      <div id="notAllowedToSelect">
        </br></br></br>
      </div>

      <!--合作伙伴模块-->
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-xs-12" style="text-align: center;">
            <p style="color: #383838;font-size: 40px;margin-top: 30px;margin-bottom: 76px;letter-spacing: 3px;font-weight:bold">我们的合作伙伴</p>
          </div>
        </div>
        <div class="row" id="friendly-img">
          <div class="col-md-2 col-xs-2"><a href="https://www.apple.com.cn/" target=_blank><img src="static/img/friendly/Bitm8.png"></a></div>
          <div class="col-md-2 col-xs-2"><a href="https://www.samsungeshop.com.cn/" target=_blank><img src="static/img/friendly/Bitm13.png"></a></div>
          <div class="col-md-2 col-xs-2"><a href="https://www.vmall.com/" target=_blank><img src="static/img/friendly/Bitm11.png"></a></div>
          <div class="col-md-2 col-xs-2"><a href="https://www.mi.com/" target=_blank><img src="static/img/friendly/Bitm12.png"></a></div>
          <div class="col-md-2 col-xs-2"><a href="https://www.oppo.com/cn/" target=_blank><img src="static/img/friendly/Bitm9.png"></a></div>
          <div class="col-md-2 col-xs-2"><a href="https://www.vivo.com/" target=_blank><img src="static/img/friendly/Bitm10.png"></a></div>
        </div>
      </div>

      <div id="notAllowedToSelect">
        </br></br></br></br></br></br></br></br></br></br></br></br>
      </div>

      <!--页面最底部-->
      <jsp:include page="WEB-INF/views/bottom.jsp"></jsp:include>

      <!--回到顶部按钮-->
      <div id="article"></div>
      <div id="back_top">
        <div class="arrow"></div>
        <div class="stick"></div>
      </div>





         
</body>
</html>