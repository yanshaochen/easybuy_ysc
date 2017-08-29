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
    <c:forEach var="item" items="${parents}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#${item.epp_id}">
                            ${item.epp_name}&nbsp;
                        <a href="javascript:void(0)"
                           onclick="return del(${item.epp_id})"><span>- 删除</span></a>
                    </a>
                </h4>
            </div>
            <div id="${item.epp_id}" class="panel-collapse collapse" onclick="function getCategories() {
                    var epp_id = $(this).attr('id');
                    alert(epp_id);
                    }
                    getCategories(${item.epp_id})">
                <div class="panel-body">
                    <ul style="list-style: none">
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
<%--delete--%>
<script type="text/javascript">
    function del(id) {
        if (confirm("删除分类将删除分类下所有商品,您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetCategoriesServlet?action=delete=' + id;
        }
    }
</script>
<%--show--%>
<script>
    $(".panel-collapse").mouseover(function () {
        var epp_id = $(this).attr('class');
        $.getJSON("${path}/UserServlet/AjaxCategoryServlet", {"epp_id": epp_id}, function (result) {
            $('.zj_l_c').html("");
            $.each(result, function (i, dom) {
                $('.zj_l_c').append(
                    "<h2>" + dom.product_category.epc_name + "</h2>"
                );
                $.each(dom.product_children, function (i, child) {
                    $('.zj_l_c').append(
                        "<a href='#'>" + child.epch_name + "</a>|"
                    );
                });
            });
        });
    })
</script>
</html>
