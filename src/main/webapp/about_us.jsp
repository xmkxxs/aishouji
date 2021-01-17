<%--
  Created by IntelliJ IDEA.
  User: people in the wind and rain
  Date: 2021/1/16
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xm.bean.User" %>
<html>
<head>
    <title>关于我们 · 爱手机</title>
    <script src="static/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/index.css">
    <script>
        $(function () {
            //进入此页面后，清除导航栏所有灰色背景，active是所包含jsp的class名
            $("li").removeClass("active");
            //为购买手机添加灰色背景,从视觉上代表已经停留到此页
            $("#li_about").addClass("active");

            //来到页面首先显示内容为公司简介，将公司简介字调为红色
            $('.jianjie').css('color','red');

            //点击公司历程，显示公司历程内容
            $(".licheng").click(function(){
                //将默认显示的公司简介的display：block改为display：none，将公司历成添加display：block属性
                //将联系我们的display：block改为display：none
                $('.one').css('display','none');
                $('.two').css('display','block');
                $('.three').css('display','none');
                //将公司历成改为红色
                $('.licheng').css('color','red');
                //去除公司简介和联系我们红色字体
                $('.jianjie').css('color','');
                $('.lianxi').css('color','');
            });

            //点击联系我们，显示联系我们内容
            $(".lianxi").click(function(){
                $('.one').css('display','none');
                $('.two').css('display','none');
                $('.three').css('display','block');
                //将公司历成改为红色
                $('.lianxi').css('color','red');
                //去除公司简介和联系我们红色字体
                $('.jianjie').css('color','');
                $('.licheng').css('color','');
            });

            //点击公司简介，显示公司简介内容
            $(".jianjie").click(function(){
                $('.one').css('display','block');
                $('.two').css('display','none');
                $('.three').css('display','none');
                //将公司历成改为红色
                $('.jianjie').css('color','red');
                //去除公司简介和联系我们红色字体
                $('.lianxi').css('color','');
                $('.licheng').css('color','');
            });

        });
    </script>
    <style>
        html {
            text-shadow: 0 0 0 !important;
        }
        body {
            font-family: "PingFang SC","Microsoft YaHei",sans-serif;
        }
        .about-m {
            width: 1180px;
            margin: 0 auto;
            background: #fff;
            padding: 44px 60px 0;
            display: flex;
            box-sizing: border-box;
            min-height: 600px;
        }
        .about-m>ul {
            width: 200px;
        }
        ol, ul {
            list-style: none;
        }
        blockquote, body, button, dd, dl, dt, fieldset, form, h1, h2, h3, h4, h5, h6, hr, input, legend, li, ol, p, pre, td, textarea, th, ul {
            margin: 0;
            padding: 0;
        }
        ul {
            display: block;
            list-style-type: disc;
            margin-block-start: 1em;
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
            padding-inline-start: 40px;
        }
        /*.about-m>ul>li.active {
            color: #dd4334;
            border-left: 2px solid #dd4334;
        }*/
        .about-m>ul>li {
            font-size: 16px;
            color: #555;
            margin: 6px 0;
            font-weight: 700;
            padding-left: 14px;
            line-height: 22px;
            border-left: 2px solid transparent;
            cursor: pointer;
            width: 90px;
        }
        li {
            display: list-item;
            text-align: -webkit-match-parent;
            /*去掉li小圆点*/
            list-style-type:none;
        }
        .about-m>div>div {
            color: #777;
            font-size: 14px;
            padding: 17px;
            border: 1px solid #e7e7e7;
            display: none;
        }
        .about-m>div>div>span {
            color: #333;
            font-size: 14px;
            font-weight: 100;
            line-height: 1.5;
        }

    </style>
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

    <div style="min-width: 1190px;width: 100%;font-size: 0;">
        <img src="static/img/rxk.png">
    </div>

    <div class="about-m">
        <ul>
            <li class="jianjie" class="active">公司简介</li>
            <li class="licheng">公司历程</li>
            <li class="lianxi">联系我们</li>
        </ul>

        <div style="padding-bottom: 16px;margin-left: 60px">
            <div class="one" style="display: block;">
                <span>
                    南京信息职业技术学院（Nanjing Vocational College of Information Technology）位于南京市栖霞区仙林大学城，是一所由江苏省人民政府举办的全日制高等职业技术学院，入选国家骨干高职院校、教育部优质专科高等职业院校、中国特色高水平高职学校和专业建设计划、国家首批现代学徒制试点单位、江苏省高水平高等职业院校、江苏省卓越高等职业院校培育校。
                    </br></br>
                    南京信息职业技术学院的前身是于1953年的南京无线电工业学校，后历经南京电信学校、华东第一工业学校、南京工业学校，1954年华东第二工业学校无线电专业、1964年南京二九二技工学校合并至该校，2002年6月28日，经江苏省人民政府批准，独立升格建院，成立南京信息职业技术学院。
                    </br></br>
                    据2018年11月学校网站信息显示，南京信息职业技术学院占地1000余亩，建筑面积38.1万平方米，固定资产逾12亿元，各类教学、科研仪器设备总值超过14亿元。截至2017年12月，共开设有63个高职专科专业；共有全日制普通高职在校生12473人，教师1156人，其中专任教师452人。
                </span>
            </div>
            <div class="two">
                <span>
                    1953年，学院的前身南京无线电工业学校创建，当时学校简称“南京电信工业学校”，9月1日， 奉中央第二机械工业部命并经中央高等教育部同意更改校名为“华东第一工业学校”。
                    <br/><br/>
                    1956年4月1日， 奉国家第二机械工业部命并经高等教育部同意更改校名为"南京无线电工业学校"。
                    <br/><br/>
                    1960年12月21日， 柬埔寨西哈努克亲王和夫人，王位最高委员会副主席宾努，首相福波沦，第一副首相涅刁龙及西哈努克亲王的公主和王子等到一行40余人，由周恩来总理、陈毅副总理和夫人张茜莅校参观。
                    <br/><br/>
                    1979年，国家第四机械工业部批准恢复后的南京无线电工业学校新校址定在南京市东郊沧波门以南的丘陵地带。
                    <br/><br/>
                    1981年10月4日， 南京无线电工业学校复校后的第一届新生报到。
                    <br/><br/>
                    1983年3月5日，电子工业部批准南京无线电工业学校在南京市古平岗35号建校。
                    <br/><br/>
                    1984年7月3日，电子工业部批准该校恢复“文革”前行政级别，为地市级单位。
                    <br/><br/>
                    1987年2月3日，电子工业部和江苏省政府联合发文，将南京无线电工业学校下放至江苏省，由江苏省电子工业厅归口管理。
                    <br/><br/>
                    1990年9月1日， 学校录取新生共294人。校本部在校生已达967人，达到设计规划招生规模。另：扬州教学点录取新生80人。
                    <br/><br/>
                    1991年5月6日，江苏省电子信息产业集团与该校商定，由该集团研究所与该校校办工厂共同组建江苏电子信息集团计算机厂。
                    <br/><br/>
                    1996年11月，该校被国家教委授予“国家级重点普通中等专业中学校”。
                    <br/><br/>
                    1998年6月 ，江苏省电子工业厅批准南京无线电工业学校与扬州电子职工中专校联合办学，两校联合办学协议书已于4月在扬州电子职工中专校签字。两校联合后校名仍为南京无线电工业学校，现扬州电子职工中专校为扬州校区，并保留扬州电子职工中专校名称及服务功能，现南无校为南京校区。
                    <br/><br/>
                    2000年9月，该校被教育部批准为首批国家级重点中等专业学校。
                    <br/><br/>
                    2002年6月28日，经江苏省人民政府批准，独立升格建院，成立南京信息职业技术学院。
                    <br/><br/>
                    2004年10月18日，该院举行入驻仙林新校区暨新生开学庆典，该院仙林大学城新校区正式交付使用，首批9000名师生搬迁入驻。
                    <br/><br/>
                    2006年，通过国家高职高专人才培养工作水平评估并被评为优秀等级。
                    <br/><br/>
                    2010年，被列入全国100所骨干高职院校建设单位之一。
                    <br/><br/>
                    2016年3月，通过国家骨干高职院校建设验收。
                    <br/><br/>
                    2019年7月，被教育部认定为国家优质专科高等职业院校。
                    <br/><br/>
                    2020年11月6日，发起成立全国高职高专院校思想政治理论课联盟长三角地区分联盟。
                </span>
            </div>
            <div class="three">
                <span>
                    我校目前位于江苏省南京市栖霞区仙林大学城文澜路99号。<div style="width: 834px;float: right"></div>
                    <br/><br/>
                    热线电话 888-888-888（周一至周日 8:00-21:00）
                    <br/><br/>
                    <iframe src="map.html" style="height:600px;width: 834px"></iframe>
                </span>
            </div>
        </div>
    </div>

    <!--页面最底部-->
    <div style="padding-top: 68px">
        <jsp:include page="WEB-INF/views/bottom.jsp"></jsp:include>
    </div>

</body>
</html>
