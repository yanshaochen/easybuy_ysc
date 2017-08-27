<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 17-8-27
  Time: 下午4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script src="${path}/js/pintuer.js"></script>
    <script src="${path}/js/jquery-2.1.1.min.js"></script>
    <script src="${path}/js/bootstrap-3.3.7.js"></script>
</head>
<body>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapseOne">
                    一级分类:
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <div class="panel-body">
                <ul>
                    <li>二级分类1 <a href="#">修改</a><a href="#">删除</a></li>
                    <li>二级分类2</li>
                    <li>二级分类3</li>
                    <li><a href="#">添加</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapseThree">
                    +添加
                </a>
            </h4>
        </div>
        <div id="collapseThree" class="panel-collapse collapse">
            <div class="panel-body">
                <form action="" method="post" enctype="multipart/form-data">
                    标题:<input id="update" type="text" name="es_id" value="" style="display: none">
                    <input type="text" class="input w50" name="es_servleturl" value=""/>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
