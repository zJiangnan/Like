<%--
  Created by IntelliJ IDEA.
  User: zhangjiangnan
  Date: 2021/1/30
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商品</title>
    <link rel="icon" href="img/title.png">
    <link href="layui/css/layui.css" rel="stylesheet"/>
    <script src="js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <style>
        #num {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body class="layui-layout-body" style="height: 300px">
<div class="layui-layout layui-layout-admin">
    <div>
        <div style="padding: 15px;">
            <table class="layui-table">
                <tr>
                    <th style="text-align: center">编号</th>
                    <th style="text-align: center">商品名</th>
                    <th style="text-align: center">描述</th>
                    <th style="text-align: center">销售价</th>
                    <th style="text-align: center">销售量</th>
                    <th style="text-align: center">库存</th>
                    <th style="text-align: center">购买数量</th>
                    <th style="text-align: center">操作</th>
                </tr>
                <c:forEach var="rec" items="${proinfo}" varStatus="vs">
                    <tr style="text-align: center">
                        <%-- 这里不使用从数据拿到ID --%>
                        <td id="${rec.id}">${vs.count}</td>
                        <td>${rec.name}</td>
                        <td>${rec.description}</td>
                        <td>${rec.sellprice}</td>
                        <td>${rec.sellcount}</td>
                        <td>${rec.productount}</td>
                        <td>
                            <button type="button" class="layui-btn layui-btn-xs layui-icon layui-icon-subtraction"
                                    name="minus"></button>
                            <input id="num" type="text" value="1" style="width: 17px;height: 17px"/>
                            <button type="button" class="layui-btn layui-btn-xs layui-icon layui-icon-addition"
                                    name="add"></button>
                        </td>
                        <td>
                            <button type="button" name="addcar" class="layui-btn layui-btn-danger">添加购物</button>
                            <button type="button" name="buy" class="layui-btn layui-btn-warm">立即购买</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <iframe name="content" width="100%" height="600px" style="border: 0px"></iframe>
        </div>
    </div>

</div>
<%--图片提交模态框--%>
<div id="myPictureModel" style="display: none;">
    <div class="modal-dialog" style="margin-top: 20px">
        <div class="modal-content">
            <div class="modal-body">
                <form action="uploadServlet" method="post" enctype="multipart/form-data">
                    <div><input type="file" name="myfile" class="layui-input"/></div>
                    <button>文件提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery/jquery-3.1.1.min.js"></script>
<script>
    layui.use(['layer'], function () {
        var layer = layui.layer;

        //增加
        $("[name='add']").click(function () {
            var s = $(this).parent().parent().children("td:eq(5)").text();
            // alert(s);
            var num = $(this).prev().val();
            num++;
            if (num <= s) {
                $(this).prev().val(num);
            } else {
                alert("超出库存");
            }
        });
        //减少
        $("[name='minus']").click(function () {
            var num = $(this).next().val();
            if (num > 1) {
                num--;
                $(this).next().val(num);
            } else {
                alert("数量不能小于1");
            }
        });
        //单击事件
        //添加购物车g
        $("[name=addcar]").click(function () {
            //获取被点击商品的id(此ID为数据库商品ID)
            var k = $(this).parent().parent().children("td:eq(0)").attr("id");
            alert(k);
            $.ajax({
                type:'get',
                url:"./productcategoryadd?id="+k,
                success:function (rep) {
                    if (rep != "ok") {
                        alert("你还没有登陆哦，登陆下吧😎！");
                    }else {
                        alert("添加购物车成功");
                    }
                }
            });
        });

        //立即购买
        $("[name=addpicture]").click(function () {

        });
    });
</script>
</html>
