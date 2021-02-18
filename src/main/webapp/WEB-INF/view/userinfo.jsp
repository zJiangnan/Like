<%--
  Created by IntelliJ IDEA.
  User: zhangjiangnan
  Date: 2021/1/27
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>个人信息❤️🧡💛喜歡</title>
    <link rel="icon" href="img/favicon.ico">
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <script src="js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <style>
        .cls{
            margin-top: 120px;
        }
        span {
            color: #FF0000;
            font-size: 12px
        }
    </style>
</head>
<script>
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
        if(phone.value==""){
            document.getElementById('LXDHerror').innerText="请输入联系电话";
        } else {
            document.getElementById('LXDHerror').innerText ="";
        }
    }
</script>
<body>
<div class="layui-container">
    <div class="layui-row  cls  layui-col-md4 layui-col-md-offset4">
        <div class="layui-tab layui-tab-brief ">
            <h2 style="color: red">${loginmsg}</h2>
            <ul class="layui-tab-title">
                <li class="layui-this" id="login">个人信息</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form-item"><h3>❤️ 个人信息修改输入新的值点击修改按钮即可❤️</h3></div>
                    <!--  登录表单 -->
                    <form class="layui-form layui-form-pane" id="infoform">
                        <span style="color: rgb(251, 86, 85)">不可更改用户名哦，亲🤪</span>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-block">
                                <input readonly name="username" placeholder="${uname.username}" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input type="password" id="password" name="password" class="layui-input"
                                       autocomplete="off" placeholder="请输入新的密码" onblur="passwordyan()"/>
                                <span id="MMerror"></span>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">真实姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="realname" autocomplete="off" placeholder="${uname.realname}"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block">
                                <input type="text" name="address" autocomplete="off" placeholder="${uname.address}"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email" autocomplete="off"
                                       placeholder="${uname.email}" class="layui-input" onblur="DZYXonblus()">
                                <span id="DZYXerror"></span>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" id="phone" name="mobile" autocomplete="off"
                                       placeholder="${uname.mobile}" class="layui-input" onblur="LXDHonblus()">
                                <span id="LXDHerror"></span>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button id="infobtn" onclick="return false" class="layui-btn layui-col-lg-offset4">修改个人信息
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
        $("#infobtn").click(function () {
            var pass = $("[name = password]").val();
            // var k = confirm("确认你修改的密码为" + pass + "吗?");
            if (confirm("确认你修改的密码为" + pass + "吗?")) {
                $.ajax({
                    type:"get",
                    url:"./updateuserinfo",
                    data:$("#infoform").serialize(),
                    success:function (resp) {
                        if(resp=="ok"){
                            // alert("你的消息已成功保存了鸭🥳！！！！");
                            var su = confirm("你的消息已成功保存了鸭🥳！！！！");
                            if (su){
                                window.location = "user.jsp";
                            }
                        }else{
                            alert("修改失败，请稍后再试哦🤨");
                        }
                    },
                    error:function () {
                        alert("系统错误");
                    }
                });
                return false;
            } else {
                layer.alert('取消修改信息');
                return false;
            }
        });
    });
</script>
</html>

