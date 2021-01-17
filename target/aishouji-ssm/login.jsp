<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in to AiShouJi · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/login.css">

    <script type="text/javascript">
        /****************************************前端数据校验******************************************/
        $(function(){
            //控制变量，控制按钮是否可以提交。0F，1T
            var userNameIsCan;
            //判断用户名格式是否正确的方法，当用户在文本框输入就会调用此函数
            function checkUserName() {
                //获取用户名文本框的值
                var userName=$("#userName").val();
                //创建正则表达式，用户名由英文字母和数字组成的4-16位字符，以字母开头
                var regName=/^[a-zA-Z][a-zA-Z0-9]{4,16}$/;
                //如果用户输入符合正则
                if(regName.test(userName)){
                    //首先将输入框的红色警告提示清除
                    $("#userName").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#userName").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#userName").next("span").text("");
                    userNameIsCan=1;
                }else{
                    //如果用户输入不符合正则，将输入框变成红色
                    $("#userName").parent().addClass("has-error");
                    $("#userName").next("span").text("用户名由字母和数字组成的5-16位字符，以字母开头");
                    userNameIsCan=0;
                    /*return false;*/
                }
            }

            //用户输入用户名时触发keyup事件，此事件调用checkUserName方法
            $("#userName").keyup(function(){
                checkUserName();
            });

            //用户点击登录后判断用户名密码是否为空
            $(document).on("click",".btn-login",function() {
                //获取用户名输入框内容
                var userName=$("#userName").val();
                //获取密码输入框内容
                var password=$("#password").val();
                //开始判断
                if(userName=="" && password==""){
                    alert("请输入用户名和密码 ！");
                    return false;
                }
                if(userName=="" && password!=""){
                    alert("请输入用户名 ！");
                    return false;
                }
                if(userName=!"" && password==""){
                    alert("请输入密码 ！");
                    return false;
                }
                //以上的if都没执行，说明用户名密码不为空了
                //如果用户名和密码不为空了，但是输入格式不对，提示无法登录
                if (userNameIsCan==0){
                    alert("请输入正确的用户名！");
                    return false
                }else{
                    //如果用户名和密码不为空且用户名格式正确，就向服务器发送登录请求，查询用户名和密码是否正确为能否登录
                    //获取表单中用户填写的用户名和密码
                    //jq提供serialize方法，将表单中的name和用户填写的数据会被提取
                    //提取的格式是如：empName=张三&email=xxx@163.com
                    var result=$("#userForm").serialize();
                    //返送ajax请求，由于ajax发送请求后，服务器跳转不会生效，所以在success中进行跳转
                    $.ajax({
                        type:"POST",
                        url:"<%=request.getContextPath() %>/user/login",
                        data:result,
                        dataType: "text",
                        success:function (response) {
                            if(response=="0"){
                                alert("用户名或密码错误！")
                                $("#password").val("");//将密码文本框清空
                                //window.location.href="login.jsp";
                            }else{
                                alert("欢迎您！"+response)
                                window.location.href="index.jsp";
                            }
                        }
                    });
                }
            });

        });//入口函数结束处


    </script>

</head>
<body>
    <!--网站LOGO-->
    <div>
        <div class="div-logo"><img src="static/img/LOGO.jpg" alt="LOGO" class="img-circle" style="width: 60px;"></div>
    </div>

    <div style="text-align: center;">
        <div style="margin-bottom: 30px;"><p style="font-size: 20px;font-weight: 3000;">登 陆 账 户 到 爱 手 机 网</p></div>
    </div>

    <!--包含账户密码登录按钮部分-->
    <div class="div-login">
        <div style="margin-left: 50px;padding-top: 50px;">
            <form id="userForm">
                <div class="form-group">
                <label for="exampleInputEmail1">用户名</label><span class="glyphicon glyphicon-user" style="padding-left: 10px;"></span>
                <input type="text" name="userName" id="userName" class="form-control"  placeholder="在此处填写您的用户名">
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                <label for="exampleInputPassword1">密码</label><span class="glyphicon glyphicon-eye-close" style="padding-left: 10px;"></span>
                <label style="float: right;margin-right: 40px;"><a href="password_reset.jsp" style="text-decoration:none">忘记密码？</a></label>
                <input type="password" name="password" id="password" class="form-control" placeholder="在此处填写您的密码">
                    <span class="help-block"></span>
                </div>
                <%--<input type="submit" value="登录" ></input>--%><!--发送ajax请求不能使用submit类型提交-->
                <button type="button" class="btn btn-default btn-login">登录</button>
            </form>
        </div>
        <a href="index.jsp"><button type="submit" class="btn btn-default btn-back-index" style="margin-left: 50px;">返回主页</button></a>
        <!--用来撑开div底部-->
        <div style="padding-bottom: 50px;height: 20px;"></div>
    </div>


</body>
</html>