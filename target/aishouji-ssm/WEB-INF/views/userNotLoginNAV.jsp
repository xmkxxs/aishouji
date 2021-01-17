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


            /**
             点击注册按钮跳出模态框
             **/
            $("#register").click(function(){
                //首先清空表单，防止上一次提交完成后数据不清空点击按钮后继续显示能继续提交
                $("#register-form")[0].reset();
                //将之前输入的样式去除，包括输入格式不对导致的input边框变红等
                $("#username").parent().removeClass("has-error has-success");
                $("#password").parent().removeClass("has-error has-success");
                $("#user-email").parent().removeClass("has-error has-success");
                $("#username").next("span").text("");
                $("#password").next("span").text("");
                $("#user-email").next("span").text("");
                $("#modal-register").modal({
                    /*点击空白处不会关闭模态框*/
                    backdrop: 'static'
                });
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


            /****************************************前端数据校验******************************************/
                //控制变量，用来判断是否用户输入的格式都正确用以能否注册按钮。0代表格式错误，1代表可以注册
            var checkU;
            var checkP;
            var checkE;
            //控制变量，用来判断用户名和邮箱是否已存在，用以判断注册按钮是否能被成功提交。0存在，1不存在
            var checkUU;
            var checkEE;
            //判断用户名格式是否正确的方法，当用户在文本框输入用户名时就会调用此函数
            function checkUserName() {
                //获取用户输入的用户名
                var username=$("#username").val();
                //创建用户名正则表达式，用户名由英文字母和数字组成的4-16位字符，以字母开头
                var regUserName=/^[a-zA-Z][a-zA-Z0-9]{4,16}$/;
                //如果用户名符合正则表达式
                if(regUserName.test(username)){
                    //首先将输入框的红色警告提示清除
                    $("#username").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#username").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#username").next("span").text("");
                    checkU=1
                    //向服务器发送异步请求查看用户名是否注册
                    $.ajax({
                        type:"get",
                        url:"<%=request.getContextPath() %>/user/existUserName",
                        data:"userName="+username,
                        success:function (response) {
                            if(response=="userNameCanBeUsed"){
                                //首先将输入框的红色警告提示清除
                                $("#username").parent().removeClass("has-error");
                                //将输入框颜色变为绿色
                                $("#username").parent().addClass("has-success");
                                //将输入框底部的错误文字提示去掉
                                $("#username").next("span").text("");
                                checkUU=1;
                            }else {
                                //用户名已经注册，将input边框变红并且提示
                                $("#username").parent().addClass("has-error");
                                $("#username").next("span").text("用户名已经存在！");
                                checkUU=0;
                            }
                        }
                    });
                }else{
                    //如果用户输入不符合正则，将输入框变成红色
                    $("#username").parent().addClass("has-error");
                    $("#username").next("span").text("用户名由字母和数字组成的5-16位字符，以字母开头");
                    checkU=0;
                }
            }

            //判断密码格式是否正确的方法，当用户在文本框输入密码时就会调用此函数
            function checkPassword(){
                //获取用户输入的密码
                var password=$("#password").val();
                //创建密码正则表达式，密码由英文字母和数字组成的4-10位字符
                var regPassword=/^[a-zA-Z0-9]{4,10}$/;
                //如果密码符合正则表达式
                if(regPassword.test(password)){
                    //首先将输入框的红色警告提示清除
                    $("#password").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#password").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#password").next("span").text("");
                    checkP=1
                }else{
                    //如果输入的密码不符合正则，将输入框变成红色
                    $("#password").parent().addClass("has-error");
                    $("#password").next("span").text("密码由英文字母和数字组成的4-10位字符");
                    checkP=0
                }
            }

            //判断邮箱格式是否正确的方法，当用户在文本框输入邮箱时就会调用此函数
            function checkEmail(){
                //获取用户输入的邮箱
                var userEmail=$("#user-email").val();
                //创建邮箱正则表达式
                var regEmail=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
                //如果邮箱符合正则表达式
                if(regEmail.test(userEmail)){
                    //首先将输入框的红色警告提示清除
                    $("#user-email").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#user-email").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#user-email").next("span").text("");
                    checkE=1
                    //向服务器发送异步请求查看邮箱是否注册
                    $.ajax({
                        type:"get",
                        url:"<%=request.getContextPath() %>/user/existEmail",
                        data:"email="+userEmail,
                        success:function (response) {
                            if(response=="emailCanBeUsed"){
                                //首先将输入框的红色警告提示清除
                                $("#user-email").parent().removeClass("has-error");
                                //将输入框颜色变为绿色
                                $("#user-email").parent().addClass("has-success");
                                //将输入框底部的错误文字提示去掉
                                $("#user-email").next("span").text("");
                                checkEE=1;
                            }else {
                                //用户名已经注册，将input边框变红并且提示
                                $("#user-email").parent().addClass("has-error");
                                $("#user-email").next("span").text("邮箱已经存在！");
                                checkEE=0;
                            }
                        }
                    });
                }else{
                    //如果输入的密码不符合正则，将输入框变成红色
                    $("#user-email").parent().addClass("has-error");
                    $("#user-email").next("span").text("Email格式不正确，例如web@gmail.com");
                    checkE=0
                }
            }

            //用户注册输入用户名时触发keyup事件，此事件调用checkUserName方法
            $("#username").keyup(function(){
                checkUserName();
            });
            //用户注册输入密码时触发keyup事件，此事件调用checkPassword方法
            $("#password").keyup(function(){
                checkPassword();
            });
            //用户注册输入邮箱时触发keyup事件，此事件调用checkEmail方法
            $("#user-email").keyup(function(){
                checkEmail();
            });


            //开始用户点击确认注册按钮后判断form中用户名密码邮箱是否为空,此按钮在注册模态框中，
            $(document).on("click","#btn-registe",function(){
                //获取用户输入的用户名
                var username=$("#username").val();
                //获取用户输入的密码
                var password=$("#password").val();
                //获取用户输入的邮箱
                var userEmail=$("#user-email").val();
                //开始判断
                if(username=="" && password=="" && userEmail==""){
                    alert("请输入用户名和密码以及邮箱 ！");
                    return false;
                }
                if(username=="" && password!="" && userEmail!=""){
                    alert("请输入用户名 ！");
                    return false;
                }
                if(username!="" && password=="" && userEmail!=""){
                    alert("请输入密码 ！");
                    return false;
                }
                if(username!="" && password!="" && userEmail==""){
                    alert("请输入邮箱 ！");
                    return false;
                }
                if(username!="" && password=="" && userEmail==""){
                    alert("请输入密码和邮箱 ！");
                    return false;
                }
                if(username=="" && password=="" && userEmail!=""){
                    alert("请输入用户名和密码 ！");
                    return false;
                }
                if(username=="" && password!="" && userEmail==""){
                    alert("请输入用户名和邮箱 ！");
                    return false;
                }
                //如果以上if都没有执行，说明用户名密码和邮箱都不为空
                //都不为空就要判断是否都符合标准
                if(checkU==0 || checkP==0 || checkE==0){//有某个input是格式错误的
                    if(checkU==0 && checkP!=0 && checkE!=0){
                        alert("用户名格式错误！");
                        return false;
                    }
                    else if(checkU!=0 && checkP==0 && checkE!=0){
                        alert("密码格式错误！");
                        return false;
                    }
                    else if(checkU!=0 && checkP!=0 && checkE==0){
                        alert("邮箱格式错误！");
                        return false;
                    }
                    else if(checkU==0 && checkP==0 && checkE!=0){
                        alert("用户名和密码格式错误！");
                        return false;
                    }
                    else if(checkU!=0 && checkP==0 && checkE==0){
                        alert("密码和邮箱格式错误！");
                        return false;
                    }
                    else if(checkU==0 && checkP!=0 && checkE==0){
                        alert("用户名和邮箱格式错误！");
                        return false;
                    }
                    else if(checkU==0 && checkP==0 && checkE==0){
                        alert("用户名和密码以及邮箱格式错误！");
                        return false;
                    }
                }else if(checkUU==0 ||checkEE==0){//有用户名和邮箱已被注册的
                    if(checkUU==0 && checkEE==0){
                        alert("用户名和邮箱均被注册！");
                        return false;
                    }
                    else if (checkUU==0 && checkEE!=0){
                        alert("用户名已被注册！");
                        return false;
                    }
                    else if(checkUU!=0 && checkEE==0){
                        alert("邮箱已被注册！");
                        return false;
                    }
                }else{
                    //如果用户名密码邮箱不为空切格式全部正确，向服务器发送请求
                    //jq提供serialize方法，将表单中的name和用户填写的数据会被提取
                    //提取的格式是如：empName=张三&email=xxx@163.com
                    var result=$("#register-form").serialize();
                    $.ajax({
                        type:'post',
                        url:"<%=request.getContextPath() %>/user/registeredUserInformationEnter",
                        data:result,
                        success:function (response) {
                            if(response=="insertSuccess"){//如果插入成功
                                alert("用户注册成功！");
                                //清除表单中残留的用户注册信息，防止重复注册
                                $("#register-form")[0].reset();
                            }else {
                                alert("用户注册失败，请刷新浏览器再次尝试！")
                                $("#register-form")[0].reset();
                            }
                        }
                    });
                }
            });


        });//入口函数end
    </script>
</head>
<body>
    <!------------------------------此页面是被包含页面---------------------------->

    <!--用户未登录后显示如下的导航条-->
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
                    <li id="li_buy"><a href="product.jsp" id="buy">购买手机</a></li>
                    <li id="li3"><a href="javascript:;" id="sell">售卖手机</a></li>
                    <li id="li_about"><a href="about_us.jsp">关于我们</a></li>
                    <p class="navbar-text navbar-right" id="set-p">
                        <span id="allowedToSelect">热线电话 888-888-888</span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect">|</span><span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span class="glyphicon glyphicon-user" id="notAllowedToSelect"></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                        <span id="notAllowedToSelect"><a href="login.jsp" class="navbar-link" id="login">登录</a></span>
                        <span id="notAllowedToSelect">&nbsp;</span>
                        <span id="notAllowedToSelect">/&nbsp;</span>
                        <span id="notAllowedToSelect"><a href="javascript:void(0)" class="navbar-link" id="register">注册</a></span>
                        <span id="notAllowedToSelect">&nbsp;&nbsp;</span>
                    </p>
                </ul>
            </div>

        </div>
    </nav>


    <!--模态框，用户点击注册按钮时调用js会调用出模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="modal-register">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">快速注册</h4>
                </div>
                <div class="modal-body">
                    <!-- 模态框中的表单 -->
                    <form class="form-horizontal" id="register-form">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 col-md-2 control-label">用户名：</label>
                            <div class="col-sm-10">
                                <input type="text" name="userName" class="form-control" id="username" placeholder="请输入您想使用的用户名">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 col-md-2 control-label">密码：</label>
                            <div class="col-sm-10">
                                <input type="text" name="password" class="form-control" id="password" placeholder="请设置您的密码">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 col-md-2 control-label">邮箱：</label>
                            <div class="col-sm-10">
                                <input type="text" name="email" class="form-control" id="user-email" placeholder="此唯一邮箱用于找回您的密码">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="btn-registe">注册</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</body>
</html>