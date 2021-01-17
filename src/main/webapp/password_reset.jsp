<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot your password? · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/password_reset.css">
    <script>
        /****************************************前端数据校验******************************************/
        $(function () {
            //判断用户名格式是否正确，当用户在文本框输入就会调用此函数
            //控制变量，控制按钮是否可以提交。用来判断用户名格式是否错误。0F，1T
            var checkU;
            function checkUserName() {
                //获取用户输入的用户名
                var username=$("#username").val();
                //创建用户名正则表达式，用户名由英文字母和数字组成的4-16位字符，以字母开头
                var regUserName=/^[a-zA-Z][a-zA-Z0-9]{4,16}$/;
                //如果用户名符合正则表达式
                if(regUserName.test(username)) {
                    //首先将输入框的红色警告提示清除
                    $("#username").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#username").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#username").next("span").text("");
                    checkU=1;
                }else{
                    //如果用户输入不符合正则，将输入框变成红色
                    $("#username").parent().addClass("has-error");
                    $("#username").next("span").text("用户名由字母和数字组成的5-16位字符，以字母开头");
                    checkU=0;
                }
            }

            //用户输入邮箱时触发keyup事件，此事件调用checkEmail方法
            $("#username").keyup(function(){
                checkUserName();
            });


            //判断邮箱格式是否正确,当用户在文本框输入就会调用此函数
            //控制变量，控制按钮是否可以提交。用来判断邮箱格式是否错误。0F，1T
            var checkE;
            function checkEmail(){
                //获取文本框邮箱的值
                var userEmail=$("#user-email").val();
                //创建邮箱正则表达式
                var regEmail=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
                //如果用户输入的邮箱符合正则
                if(regEmail.test(userEmail)){
                    //首先将输入框的红色警告提示清除
                    $("#user-email").parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#user-email").parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#user-email").next("span").text("");
                    checkE=1;
                }else{
                    //如果用户输入不符合正则，将输入框变成红色
                    $("#user-email").parent().addClass("has-error");
                    $("#user-email").next("span").text("Email格式不正确，例如web@gmail.com");
                    checkE=0;
                }
            }

            //用户输入邮箱时触发keyup事件，此事件调用checkEmail方法
            $("#user-email").keyup(function(){
                checkEmail();
            });

            //判断密码格式是否正确的方法，当用户在文本框输入密码时就会调用此函数
            //用户输入新密码和确认新密码都会调用此方法
            //控制变量,用于判断两个密码格式是否一致，0不一致，1一致
            var checkP1;
            var checkP2;
            //控制变量，控制按钮是否可以提交,用来判断两个密码是否一致而导致可不可以提交
            var checkPP;
            function checkPassword(varpassword){
                //获取用户输入的密码
                var password=$("#"+varpassword).val();
                //创建密码正则表达式，密码由英文字母和数字组成的4-10位字符
                var regPassword=/^[a-zA-Z0-9]{4,10}$/;
                //如果密码符合正则表达式
                if(regPassword.test(password)){
                    //首先将输入框的红色警告提示清除
                    $("#"+varpassword).parent().removeClass("has-error");
                    //将输入框颜色变为绿色
                    $("#"+varpassword).parent().addClass("has-success");
                    //将输入框底部的错误文字提示去掉
                    $("#"+varpassword).next("span").text("");
                    $("#password2").next("span").text("");
                    //如果传递的参数是第一个input的id，做这一步是因为判断两个input密码格式是否一致用了同一个方法
                    if(varpassword=="password1"){//如果是第一个密码input调用了checkPassword方法
                        //将控制变量赋值为1，代表第一个input密码的格式没有错误
                        checkP1=1;
                    }else {
                        checkP2=1;
                    }
                    //如果新密码input和确认新密码input都不为空且都没有格式错误，就判断密码是否一致
                    var password1=$("#password1").val();
                    var password2=$("#password2").val();
                    if(password1!="" && password2!="" && checkP1!=0 && checkP2!=0){
                        /*alert("进来了")*/
                        if (password1==password2){//如果一致，清除第二个input的红色边框和底面提示
                            $("#password2").parent().removeClass("has-error");
                            $("#password2").parent().addClass("has-success");
                            $("#"+varpassword).next("span").text("");
                            checkPP=1;//代表密码一致
                        }else {//如果两个密码不一致，将确认新密码的input边框变化，底面提示两次密码不一致
                            $("#password2").parent().addClass("has-error");
                            $("#password2").next("span").text("两次密码不一致！");
                            checkPP=0;
                        }
                    }

                }else{
                    //如果输入的密码不符合正则，将输入框变成红色
                    $("#"+varpassword).parent().addClass("has-error");
                    $("#"+varpassword).next("span").text("密码由英文字母和数字组成的4-10位字符");
                    //如果传递的参数是第一个input的id
                    if(varpassword=="password1"){
                        //将控制变量赋值为0
                        checkP1=0;
                    }else {
                        checkP2=0;
                    }
                }
            }

            //用户输入新密码时触发keyup事件，此事件调用checkPassword方法
            $("#password1").keyup(function(){
                checkPassword('password1');
            });

            //用户输入确认新密码时触发keyup事件，此事件调用checkPassword方法
            $("#password2").keyup(function(){
                checkPassword('password2');
            });

            //用户点击重制按钮
            //判断用户名，邮箱，两次密码是否有空和格式，有任何一个就不能提交，提交后判断用户名和邮箱是否匹配
            $(document).on("click","#btn-reset",function() {
                //获取用户名
                var username=$("#username").val();
                //获取邮箱
                var userEmail=$("#user-email").val();
                //获取新密码
                var password1=$("#password1").val();
                //获取确认新密码
                var password2=$("#password2").val();
                //开始判断是否有空的
                if(username=="" && userEmail=="" && password1=="" && password2==""){
                    alert("请输入用户名、邮箱、新密码以及确认密码 ！");
                    return false;
                }
                if(username=="" && userEmail!="" && password1!="" && password2!=""){
                    alert("请输入用户名 ！");
                    return false;
                }
                if(username!="" && userEmail=="" && password1!="" && password2!=""){
                    alert("请输入邮箱 ！");
                    return false;
                }
                if(username!="" && userEmail!="" && password1=="" && password2!=""){
                    alert("请输入重置密码 ！");
                    return false;
                }
                if(username!="" && userEmail!="" && password1!="" && password2==""){
                    alert("请输入确认密码 ！");
                    return false;
                }
                if(username=="" && userEmail=="" && password1!="" && password2!=""){
                    alert("请输入用户名和邮箱 ！");
                    return false;
                }
                if(username=="" && userEmail!="" && password1=="" && password2!=""){
                    alert("请输入用户名和重制密码 ！");
                    return false;
                }
                if(username=="" && userEmail!="" && password1!="" && password2==""){
                    alert("请输入用户名和确认密码 ！");
                    return false;
                }
                if(username!="" && userEmail=="" && password1=="" && password2!=""){
                    alert("请输入邮箱和重制密码 ！");
                    return false;
                }
                if(username!="" && userEmail=="" && password1!="" && password2==""){
                    alert("请输入邮箱和确认密码 ！");
                    return false;
                }
                if(username!="" && userEmail!="" && password1=="" && password2==""){
                    alert("请输入重置密码和确认密码 ！");
                    return false;
                }
                if(username=="" && userEmail=="" && password1=="" && password2!=""){
                    alert("请输入用户名、邮箱和重置密码 ！");
                    return false;
                }
                if(username=="" && userEmail=="" && password1!="" && password2==""){
                    alert("请输入用户名、邮箱和确认密码 ！");
                    return false;
                }
                if(username=="" && userEmail!="" && password1=="" && password2==""){
                    alert("请输入用户名、重置密码和确认密码 ！");
                    return false;
                }
                if(username!="" && userEmail=="" && password1=="" && password2==""){
                    alert("请输入邮箱、重置密码和确认密码 ！");
                    return false;
                }
                //以上的if都没执行，说明全都不为空
                //接着判断是否存在input有格式错误以及两次密码不一致
                if(checkU==0 || checkE==0 || checkP1==0 || checkP2==0 || checkPP==0){//只要有一个错误
                    alert("表单中存在错误，请修正后再次提交！");
                    return false;
                }else{
                    //全没错误就提交向服务器，服务器判断是否邮箱和用户名一致
                    //jq提供serialize方法，将表单中的name和用户填写的数据会被提取
                    //提取的格式是如：empName=张三&email=xxx@163.com
                    var result=$("#registerForm").serialize();
                    $.ajax({
                        type:"post",
                        data:result,
                        dataType: "text",
                        url:"<%=request.getContextPath() %>/user/passwordReset",
                        success:function (response) {
                            if(response=="success"){
                                alert("重制成功，点击确定为您跳转到登录页面");
                                location.href="login.jsp";
                            }else if(response=="failed"){
                                alert("更新失败！此密码可能是您之前使用的密码或是系统其他错误，请尝试更换密码或继续使用此密码！");
                                return false;
                            }else if(response=="different"){
                                alert("您的用户名和您的邮箱不匹配！");
                                return false;
                            }else{
                                alert("用户不存在！");
                                return false;
                            }
                        },
                        error:function (response) {
                            alert("发生未知错误！")
                        }
                    });
                }
            });


        });
    </script>
</head>
<body>
    <!--网站LOGO-->
    <div>
        <div class="div-logo"><img src="static/img/LOGO.jpg" alt="LOGO" class="img-circle" style="width: 60px;"></div>
    </div>

    <div style="text-align: center;">
        <div style="margin-bottom: 30px;"><p style="font-size: 20px;font-weight: 3000;">重 制 您 的 账 户 密 码</p></div>
        <div style="margin-bottom: 30px;"><p style="font-size: 15px;font-weight: 3000;">用 户 名 和 邮 箱 匹 配 即 可 修 改</p></div>
    </div>

    <!--包含账户密码登录按钮部分-->
    <div class="div-reset">
        <div style="margin-left: 50px;padding-top: 50px;">
            <form id="registerForm">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label><span class="glyphicon glyphicon-user" style="padding-left: 10px;"></span>
                    <input type="text" class="form-control" name="userName" id="username" placeholder="在此输入您注册时的用户名">
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">邮箱</label><span class="glyphicon glyphicon-envelope" style="padding-left: 10px;"></span>
                    <input type="text" class="form-control" name="email" id="user-email" placeholder="填写与您用户名所绑定的邮箱">
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">重制密码</label><span class="glyphicon glyphicon-eye-close" style="padding-left: 10px;"></span>
                    <input type="password" class="form-control" name="password" id="password1" placeholder="在此处填写您的新密码">
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">确认密码</label><span class="glyphicon glyphicon-eye-close" style="padding-left: 10px;"></span>
                    <input type="password" class="form-control" name="password" id="password2" placeholder="在此处确认您的新密码">
                    <span class="help-block"></span>
                </div>
                <button type="button" class="btn btn-default btn-reset" id="btn-reset">重制</button>
            </form>
        </div>
        <a href="login.jsp"><button type="submit" class="btn btn-default btn-back-login" style="margin-left: 50px;">返回登录页面</button></a>
        <a href="index.jsp"><button type="submit" class="btn btn-default btn-back-index" style="margin-left: 50px;">返回主页</button></a>
        <!--用来撑开div底部-->
        <div style="padding-bottom: 50px;height: 20px;"></div>
    </div>

    <!--用来撑开div底部-->
    <div style="padding-bottom: 50px;height: 20px;"></div>

</body>
</html>