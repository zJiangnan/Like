<%--
  Created by IntelliJ IDEA.
  User: zhangjiangnan
  Date: 2021/1/24
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>喜歡你鸭(>^ω^<)❤️🧡💛</title>
    <link rel="icon" href="img/favicon.ico">
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <script src="js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <style>
        .cls {
            margin-top: 10px;
        }
    </style>
</head>
<body class="layui-layout-body" style="overflow-x:hidden;overflow-y:hidden">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <img src="img/likelogo.png" style="width: 127px;height: 50px" alt="logo">
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">首页</a></li>
            <li class="layui-nav-item"><a href="./productcategoryinfohot" target="content">推荐</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它</a>
                <dl class="layui-nav-child">
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-col-md3 layui-col-md-offset7">
            <li class="layui-nav cls">
                <div>
                    <form>
                        <input class="layui-input" type="text" id="search" name="search" placeholder="输入看看有没有你中意的">
                    </form>
                </div>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <c:if test="${uname.realname == null}">
                <li class="layui-nav-item">
                    <a href="userlogin.jsp">登陆</a>
                </li>
                <li class="layui-nav-item"><a href="userlogin.jsp#regform">注册</a></li>
            </c:if>
            <c:if test="${uname.realname != null}">
                <li class="layui-nav-item">
                    <a href="javascript:;">${uname.realname}</a>
                    <dl class="layui-nav-child">
                        <dd><a href="./userinfos">个人信息</a></dd>
                        <dd><a href="">查看订单</a></dd>
                        <dd><a href="http://localhost:8080/Like">退出登陆</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="./usershoppingcarinfo" target="content">
                        购物车<span class="layui-badge-dot"></span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
    <%-- 侧边栏分类 --%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <%--                recommendedServlet--%>
                <c:forEach items="${listpro}" var="lp" varStatus="vs">
                    <%-- 分类不超过12个否则太长影响美观 --%>
                    <c:if test="${vs.count < 13}">
                        <li class="layui-nav-item">
                            <a href="./productcategoryinfo?id=${lp.id}" target="content">${lp.name}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe name="content" src="homes.html" scrolling="no" border="0" frameborder="no" height="1800px"
                width="100%"></iframe>
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
    $(function () {
        $('#search').bind('keypress', function (event) {
            if (event.keyCode == "13") {
                var sou = $("[name = search]").val();
                alert("开始搜索" + sou);
                $.ajax({
                    url: "./getSou",
                });
            }
        })
    });
</script>
</body>
</html>
