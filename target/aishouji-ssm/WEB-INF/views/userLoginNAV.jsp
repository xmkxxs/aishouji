<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.xm.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <script>
        $(function () {
            //点击我要卖手机
            $("#sell").click(function () {
                alert("尽请期待！");
            });

            /*模态框居中显示*/
            function centerModals() {
                $('.modal').each(function(i) {
                    var $clone = $(this).clone().css('display', 'block').appendTo('body');
                    var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
                    top = top > 0 ? top : 0;   $clone.remove();
                    $(this).find('.modal-content').css("margin-top", top);
                });
            }
            $('.modal').on('show.bs.modal', centerModals);


            //用户点击退出按钮弹出模态框
            $(document).on("click","#logout",function(){
                //弹出提示是否退出模态框
                $("#modal-isExit").modal({
                    /*点击空白处不会关闭模态框*/
                    backdrop: 'static'
                });
            });
            //退出用户的模特框中，用户点击确定退出按钮
            $(document).on("click","#btn-logout-y",function(){
                //发送ajax请求
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath() %>/user/userLogout",
                    success:function (response) {
                        window.location.href="index.jsp";//用户退出后，刷新到主页
                    }
                });
            });

            //点击查看购物车
            $(document).on("click","#shoppingCart",function(){
                window.location.href="user_carts.jsp"
            });

            //点击查看订单
            $(document).on("click","#orderItem",function(){
                window.location.href="order.jsp"
            });


        });//入口函数end
    </script>
</head>
<body>
    <!------------------------------此页面是被包含页面---------------------------->

    <!--此数据是在用户登录时服务器存在session中的-->
    <%User user=(User)session.getAttribute("user"); %>

    <!--用户登录后显示如下的导航条-->
    <!--顶层导航条-->
    <nav class="navbar navbar-default" id="nav01">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!--网站LOGO-->
                <a href="#">
                    <img alt="LOGO" src="static/img/LOGO.jpg" style="width: 50px;height: 50px;" class="img-circle img-responsive center-block">
                </a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float:right ">
                <ul class="nav navbar-nav">
                    <li id="li_index" class="active"><a href="index.jsp">首页 <span class="sr-only">(current)</span></a></li>
                    <li id="li_buy" ><a href="product.jsp" id="buy">购买手机</a></li>
                    <li id="li3"><a href="javascript:;" id="sell">售卖手机</a></li>
                    <li id="li_about"><a href="about_us.jsp">关于我们</a></li>
                    <p class="navbar-text navbar-right" id="set-p">
                        <span id="allowedToSelect">热线电话 888-888-888</span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect">|</span><span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span class="glyphicon glyphicon-user" id="notAllowedToSelect"></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect">欢迎您：<%= user.getUserName() %></span>
                        <span id="notAllowedToSelect">&nbsp;</span>
                        <span id="notAllowedToSelect">/&nbsp;</span>
                        <span class="glyphicon glyphicon-shopping-cart" id="notAllowedToSelect"></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect"><a href="javascript:void(0)" class="navbar-link" id="shoppingCart" style="text-decoration:none">查看购物车</a></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect">/&nbsp;</span>
                        <span class="glyphicon glyphicon glyphicon-list-alt" id="notAllowedToSelect"></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect"><a href="javascript:void(0)" class="navbar-link" id="orderItem" style="text-decoration:none">订单</a></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect">/&nbsp;</span>
                        <span class="glyphicon glyphicon-log-out" id="notAllowedToSelect"></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect"><a href="javascript:void(0)" class="navbar-link" id="logout" style="text-decoration:none">退出登录</a></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                    </p>
                </ul>
            </div>

        </div>
    </nav>

    <!--模态框，用于用户点击退出按钮弹出，提示是否退出登录-->
    <div class="modal fade" tabindex="-1" role="dialog" id="modal-isExit">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div style="padding-left: 130px;font-weight:bold;font-size: large">
                        <p>您确定要退出登录?</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <div style="text-align: center">
                        <button type="button" class="btn btn-primary" id="btn-logout-y">退出登录</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</body>
</html>