<%--
  Created by IntelliJ IDEA.
  User: zhangjiangnan
  Date: 2020/12/21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>喜歡购物-登陆❤️🧡💛注册</title>
    <link rel="icon" href="img/favicon.ico">
    <link href="layui/css/layui.css" rel="stylesheet"/>
    <script src="js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="layui/layui.js"></script>
    <style>
        .cls {
            margin-top: 100px;
        }

        body {
            background-image: url("img/loginbgck.jpg");
        }

        span {
            color: #FF0000;
            font-size: 12px
        }
    </style>
</head>
<script>
    <%--    用户名效验--%>

    function usernameyan() {
        var username = document.getElementById("username");
        // var reN =/^\d{6,18}$/;
        var re = /^[\u4E00-\u9FA5A-Za-z0-9]{4,20}$/;
        if (username.value == "") {
            document.getElementById('YHMerror').innerText = "请输入用户名";
        } else if (username.value.length < 4 || username.value.length > 20) {
            console.log(username.value);
            document.getElementById('YHMerror').innerText = "格式错误,长度应为4-20个字符";
        } else if (!re.test(username.value)) {

            document.getElementById('YHMerror').innerText = "格式错误,只能包含中文、英文和数字";
        } else {
            document.getElementById('YHMerror').innerText = "";
        }
    }

    <%-- 密码效验 --%>
    function passwordyan() {
        var password = document.getElementById("password");
        var re = /^[A-Za-z0-9]{3,18}$/;
        if (password.value == "") {
            document.getElementById('MMerror').innerText = "请输入密码";
        } else if (password.value.length < 3 || password.value.length > 18) {
            document.getElementById('MMerror').innerText = "格式错误,密码长度应为3-18位";
        } else if (!re.test(password.value)) {
            document.getElementById('MMerror').innerText = "格式错误,必须包含英文字母或数字";
        } else {
            document.getElementById('MMerror').innerText = "";
        }
    }

    <%-- 确认密码 --%>
    function passwordyan1() {
        var password = document.getElementById("password");
        var password1 = document.getElementById("password1");
        if (password1.value == "") {
            document.getElementById('MMerror1').innerText = "请输入确认密码";
        } else if(password.value == password1.value) {
            document.getElementById('MMerror1').innerText = "";
        } else {
            document.getElementById('MMerror1').innerText = "两次密码不一致";
        }
    }

    <%-- 邮箱 --%>
    function DZYXonblus(){
        var email=document.getElementById("email");
        var re= /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;
        if(email.value==""){
            document.getElementById('DZYXerror').innerText="请输入电子邮箱";
        }
        else if(!re.test(email.value)){
            document.getElementById("DZYXerror").innerHTML="邮箱格式不正确";
        }
        else {
            document.getElementById('DZYXerror').innerText ="";
        }
    }
    <%-- 手机号 --%>
    function LXDHonblus(){
        var phone=document.getElementById("phone");
        var re = /^1\d{10}$/;
        if(phone.value==""){
            document.getElementById('LXDHerror').innerText="请输入联系电话";
        } else {
            document.getElementById('LXDHerror').innerText ="";
        }
    }
</script>
<body>
<div class="layui-container ">
    <div class="layui-row  cls  layui-col-md4 layui-col-md-offset4">
        <div class="layui-tab layui-tab-brief ">
            <ul class="layui-tab-title">
                <li class="layui-this" id="login">登录</li>
                <li id="zhuce">注册</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <!--  登录表单 -->
                    <form class="layui-form layui-form-pane" id="loginform">

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
                            <div class="layui-input-block">
                                <input type="text" name="username" placeholder="请输入用户名" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                            <div class="layui-input-block">
                                <input type="password" name="password" class="layui-input" autocomplete="off"
                                       placeholder="请输入密码"/>
                            </div>
                        </div>
                        <%--                        验证码--%>
                        <div class="layui-form-item">
                            <button id="loginbtn" class="layui-btn">登录
                            </button>
                            <a href="#" style="margin-left: 30px;">忘记密码</a>
                        </div>
                    </form>
                </div>
                <div class="layui-tab-item">
                    <!--  注册表单 -->
                    <form class="layui-form layui-form-pane" id="regform">

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
                            <div class="layui-input-block">
                                <input type="text" id="username" name="username" autocomplete="off" placeholder="请输入用户名"
                                       class="layui-input" onblur="usernameyan()">
                                <span id="YHMerror"></span>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                            <div class="layui-input-block">
                                <input type="password" id="password" name="password" class="layui-input"
                                       autocomplete="off"
                                       placeholder="请输入密码" onblur="passwordyan()"/>
                                <span id="MMerror"></span>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                            <div class="layui-input-block">
                                <input type="password" id="password1" name="password" class="layui-input"
                                       autocomplete="off"
                                       placeholder="确认密码" onblur="passwordyan1()"/>
                                <span id="MMerror1"></span>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-friends"></i></label>
                            <div class="layui-input-block">
                                <input type="text" name="realname" autocomplete="off" placeholder="请输入真实姓名"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-home"></i></label>
                            <div class="layui-input-block">
                                <input type="text" name="address" autocomplete="off" placeholder="请输入您的地址"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-email"></i></label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email" autocomplete="off" placeholder="请输入邮箱"
                                       onblur="DZYXonblus()" class="layui-input">
                                <span id="DZYXerror"></span>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><i class="layui-icon layui-icon-cellphone"></i></label>
                            <div class="layui-input-block">
                                <input type="text" id="phone" name="mobile" autocomplete="off" placeholder="请输入手机号"
                                       onblur="LXDHonblus()" class="layui-input">
                                <span id="LXDHerror"></span>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button id="regbtn" class="layui-btn">注册
                            </button>
                            <a href="#login" style="margin-left: 30px;">已有账号？登陆！</a>
                        </div>

                    </form>
                </div>

            </div>
        </div>

    </div>
</div>
</body>
<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use(['layer', 'form', 'element'], function () {
        var element = layui.element;
        var layer = layui.layer;
        var form = layui.form;
    });
    $(function () {
        //登陆
        $("#loginbtn").click(function () {
            $.ajax({
                type: "get",
                url: "./userlogin",
                data: $("#loginform").serialize(),
                success: function (res) {
                    if (res.username != null) {
                        window.location.href = "user.jsp";
                    } else {
                        alert("用户名或密码错误");
                    }
                },
                error: function () {
                    alert("未知错误，请稍后再试！");
                }
            });
            //    防止表单自动提交
            return false;
        });
        // 注册
        $("#regbtn").click(function () {
            $.ajax({
                type: "get",
                url: "./getRegister",
                data: $("#regform").serialize(),
                success: function (resp) {
                    if (resp == "ok") {
                        location.href = "user.jsp";
                    } else {
                        alert("注册时出现错误！！！");
                    }
                },
                error: function (resp) {
                    alert("异常错误，请稍后再试！");
                }
            });
            //    防止表单自动提交
            return false;
        });
    });
</script>
</html>
</body>
</html>
