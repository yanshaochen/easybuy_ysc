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
                                <form id="addCategory_form"
                                      action="${path}/AdminServlet/SetCategoriesServlet?action=addChild" method="post"
                                      style="display: inline">
                                    <input name="epc_id" value="${categoryUtil.product_category.epc_id}"
                                           style="display: none;">
                                    &nbsp;&nbsp;&nbsp;
                                    三级分类名称：
                                    <input type="text" class="input w50" value="" name="epch_name"
                                           data-validate="required:请输入名称"/>
                                    <input type="submit" value="添加">
                                </form>
                            </li>
                            <div>
                                <ul>
                                    <c:if test="${not empty categoryUtil.product_children}">
                                        <c:forEach var="child" items="${categoryUtil.product_children}">
                                            <li>${child.epch_name}&nbsp;
                                                <a href="javascript:void(0)"
                                                   onclick="return delChild(${child.epch_id})"><span>- 删除</span></a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </div>
                        </c:forEach>
                        <li><a href="#">+添加</a></li>
                        <form id="addCategory_form"
                              action="${path}/AdminServlet/SetCategoriesServlet?action=addCategory" method="post">
                            <input name="epp_id" value="${parentUtil.product_parent.epp_id}" style="display: none;">
                            &nbsp;&nbsp;&nbsp;
                            二级分类名称：
                            <input type="text" class="input w50" value="" name="epc_name"
                                   data-validate="required:请输入名称"/>
                            <input type="submit" value="添加">
                        </form>
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
                <form id="addParent" action="${path}/AdminServlet/SetCategoriesServlet?action=addParent" method="post"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="label">
                            <label>一级分类名称：</label>
                        </div>
                        <div class="field">
                            <input id="epp_name" type="text" class="input w50" value="" name="epp_name"
                                   data-validate="required:请输入名称"/>
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>图片：</label>
                        </div>
                        <div class="field">
                            <input type="file" name="epp_img" value="+ 浏览上传"/>
                            <div class="tipss">图片尺寸：1920*500</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label></label>
                        </div>
                        <div class="field">
                            <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                        </div>
                    </div>
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
</html>
