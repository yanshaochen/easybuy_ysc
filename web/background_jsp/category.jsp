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
    <c:forEach var="item" items="${categories}" varStatus="status">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#${item.product_parent.epp_id}">
                        ${item.product_parent.epp_name}&nbsp;
                    <a href="javascript:void(0)"
                       onclick="return del(${item.product_parent.epp_id})"><span>- 删除</span></a>
                </a>
            </h4>
        </div>
        <c:choose>
        <c:when test="${status.first}">
        <div id="${item.product_parent.epp_id}" class="panel-collapse collapse in">
            </c:when>
            <c:otherwise>
            <div id="${item.product_parent.epp_id}" class="panel-collapse collapse">
                </c:otherwise>
                </c:choose>
                <div class="panel-body">
                    <ul style="list-style: none">
                        <c:forEach var="categoryItem" items="${item.product_categories}">
                            <li>${categoryItem.epc_name}&nbsp;
                                <a href="#">修改</a>&nbsp;
                                <a href="#">删除</a></li>
                        </c:forEach>
                        <li><a href="#">+添加</a></li>
                    </ul>
                </div>
            </div>
        </div>
        </c:forEach>
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
<script type="text/javascript">
    function del(id) {
        if (confirm("删除分类将删除分类下所有商品,您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetCategoriesServlet?action=delete&epp_id=' + id;
        }
    }
</script>
</html>
