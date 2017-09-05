<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 17-8-24
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery-2.1.1.min.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="../images/y.jpg" class="radius-circle rotate-hover" height="50" alt=""/>后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-red"
                           href="${path}/AdminServlet/LogoutServlet?type=admin"><span
            class="icon-power-off"></span> 退出登录</a></div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="${path}/background_jsp/pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
        <li><a href="${path}/AdminServlet/SliderServlet?action=show" target="right"><span
                class="icon-caret-right"></span>首页轮播</a></li>
        <li><a href="${path}/AdminServlet/SetCategoriesServlet?action=show" target="right"><span
                class="icon-caret-right"></span>分类管理</a></li>
        <li><a href="${path}/AdminServlet/SetProductsServlet?action=show" target="right"><span
                class="icon-caret-right"></span>商品管理</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
    <ul>
        <li><a href="${path}/AdminServlet/NewsServlet?action=show" target="right"><span class="icon-caret-right"></span>新闻管理</a>
        </li>
        <li><a href="#" target="right"><span class="icon-caret-right"></span>订单管理</a></li>
        <li><a href="#" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="#" target="right" class="icon-home"> 设置</a></li>
    <li><a href="#" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" src="${path}/info.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>