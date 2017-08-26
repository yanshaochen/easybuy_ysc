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
    <title></title>
    <link rel="stylesheet" href="${path}/css/pintuer.css">
    <link rel="stylesheet" href="${path}/css/admin.css">
    <script src="${path}/js/jquery.js"></script>
    <script src="${path}/js/pintuer.js"></script>
    <script>
        $(document).ready(function () {
            $("#addContent").click(function () {
                $("#add").show();
                $("#modify").hide();
            })
            $("#modifyContent").click(function () {
                $("#modify").show();
                $("#add").hide();
            })
        });
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button id="addContent" type="button" class="button border-yellow" onclick="window.location.href='#add'"><span
                class="icon-plus-square-o"></span> 添加内容
        </button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="10%">ID</th>
            <th width="20%">图片</th>
            <th width="15%">标题</th>
            <th width="20%">URL</th>
            <th width="10%">排序</th>
            <th width="15%">操作</th>
        </tr>
        <c:forEach var="item" items="${sliders}">
            <tr>
                <td>${item.es_id}</td>
                <td><img src="${path}/images/${item.es_img}" alt="" width="120" height="50"/></td>
                <td>${item.es_title}</td>
                <td>${item.es_servleturl}</td>
                <td>${item.es_sort}</td>
                <td>
                    <div class="button-group">
                        <a id="modifyContent" class="button border-main" href="#modify" onclick="modify(${item.es_id})"><span
                                class="icon-edit"></span> 修改</a>
                        <a class="button border-red" href="javascript:void(0)" onclick="return del(${item.es_id})"><span
                                class="icon-trash-o"></span> 删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SliderServlet?action=delete&id=' + id;
        }
    }
    function modify(id) {
        $("#update").val(id);
        $("#modify").show();
        $("#add").hide();
    }
</script>
<div class="panel admin-panel margin-top" id="add" style="display: none">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${path}/AdminServlet/SliderServlet?action=add"
              enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="es_title" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>URL：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="es_servleturl" value=""/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="es_img" value="+ 浏览上传"/>
                    <div class="tipss">图片尺寸：1920*500</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>排序：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="es_sort" value="100"
                           data-validate="required:,number:排序必须为数字"/>
                    <div class="tips"></div>
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
<div class="panel admin-panel margin-top" id="modify" style="display: none">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${path}/AdminServlet/SliderServlet?action=update"
              enctype="multipart/form-data">
            <input id="update" type="text" name="es_id" value="" style="display: none">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="es_title" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>URL：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="es_servleturl" value=""/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="es_img" value="+ 浏览上传"/>
                    <div class="tipss">图片尺寸：1920*500</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>排序：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="es_sort" value="100"
                           data-validate="required:,number:排序必须为数字"/>
                    <div class="tips"></div>
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
</body>
</html>