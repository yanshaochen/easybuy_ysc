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
    <c:forEach var="parentUtil" items="${parentUtils}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#${parentUtil.product_parent.epp_id}">
                            ${parentUtil.product_parent.epp_name}&nbsp;
                        <a href="javascript:void(0)"
                           onclick="return del(${parentUtil.product_parent.epp_id})"><span>- 删除</span></a>
                    </a>
                </h4>
            </div>
            <div id="${parentUtil.product_parent.epp_id}" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul style="list-style: none">
                        <c:forEach var="categoryUtil" items="${parentUtil.categoryUtils}">
                            <li>${categoryUtil.product_category.epc_name}&nbsp;
                                <a href="javascript:void(0)"
                                   onclick="return delCategory(${categoryUtil.product_category.epc_id})"><span>- 删除</span></a>
                            </li>
                            <div>
                                <ul>
                                    <c:forEach var="child" items="${categoryUtil.product_children}">
                                        <li>${child.epch_name}&nbsp;
                                            <a href="javascript:void(0)"
                                               onclick="return delChild(${child.epch_id})"><span>- 删除</span></a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
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
<%--delete--%>
<script type="text/javascript">
    function del(id) {
        if (confirm("删除分类将删除分类下所有分类及商品,该操作将不可撤回,您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetCategoriesServlet?action=delete&epp_id=' + id;
        }
    }
    function delCategory(id) {
        if (confirm("删除分类将删除分类下所有分类及商品,该操作将不可撤回,您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetCategoriesServlet?action=delete&epc_id=' + id;
        }
    }
    function delChild(id) {
        if (confirm("删除分类将删除分类下所有商品,您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetCategoriesServlet?action=delete&epch_id=' + id;
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
