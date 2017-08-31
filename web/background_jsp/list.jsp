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
    <script src="${path}/js/jquery-2.1.1.min.js"></script>
    <script src="${path}/js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 商品列表</strong>
    </div>
    <form method="post" action="" id="listform">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li><a class="button border-main icon-plus-square-o" href="#"> 添加商品</a></li>
                <li>搜索：</li>
                <li>一级分类
                    <label>
                        <select name="ep_parent_id" class="input" onchange="changesearch()"
                                style="width:60px; line-height:17px; display:inline-block">
                            <option name="ep_parent_id" value="" selected>选择</option>
                            <c:forEach var="item" items="${parentUtils}">
                                <option name="ep_parent_id"
                                        value="${item.product_parent.epp_id}">${item.product_parent.epp_name}</option>
                            </c:forEach>
                        </select>
                    </label>
                </li>
                <li style="float: right;">
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()"> 搜索</a>
                </li>
            </ul>
        </div>
    </form>
    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">ID</th>
            <th width="10%">名称</th>
            <th>图片</th>
            <th>标题</th>
            <th>价格</th>
            <th>一级分类</th>
            <th>二级分类</th>
            <th>三级分类</th>
            <th width="10%">库存</th>
            <th width="310">操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
</div>

<div class="pagelist">
    <a href="javascript:" id="one">首页</a>
    <a href="javascript:" id="back">上一页</a>
    <a href="javascript:" id="next">下一页</a>
    <a href="javascript:" id="last">尾页</a>
</div>

<script type="text/javascript">
    $(function () {
        var pageIndex = "";
        var pageSize = "";
        var totalPageCount = "";
        var totalCountSize = "";

        pageInit(pageIndex);

        function pageInit(pageIndex) {
            $("#one").show();
            $("#back").show();
            $("#next").show();
            $("#last").show();

            $.ajax({
                url: "${path}/AdminServlet/AjaxSetProductServlet",
                type: "POST",
                data: {"pageIndex": pageIndex},
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=utf-8",
                success: callBack
            });
        }

        function callBack(data) {
            $("#tbody").html("");
            $(data).each(function () {
                if (this.pageUtil != null) {
                    pageIndex = this.pageUtil.pageIndex;
                    pageSize = this.pageUtil.pageSize;
                    totalPageCount = this.pageUtil.pageCount;
                    totalCountSize = this.pageUtil.totalCount;
                }
                $("#tbody").append(
                    '    <tr>                                                                                                   ' +
                    '   <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="ep_id"                     ' +
                    '    value=""/>' + this.ep_id + '</td>                                                                        ' +
                    '        <td>' + this.ep_name + '</td>                   ' +
                    '        <td width="10%"><img src="${path}/images/' + this.ep_img + '+" alt="" width="70" height="50"/></td>   ' +
                    '        <td>' + this.ep_title + '</td>                                                                       ' +
                    '       <td>' + this.ep_price + '</td>                                                                        ' +
                    '       <td>' + this.epp_name + '</td>                                                                        ' +
                    '       <td>' + this.epc_name + '</td>                                                                        ' +
                    '       <td>' + this.epch_name + '</td>                                                                       ' +
                    '       <td>' + this.ep_stock + '</td>                                                                       ' +
                    '        <td>                                                                                               ' +
                    '        <div class="button-group">                                                                         ' +
                    '        <a class="button border-main" href="#"><span class="icon-edit"></span> 修改</a>                      ' +
                    '        <a class="button border-red" href="#"><span class="icon-trash-o"></span> 删除</a>                    ' +
                    '        </div>                                                                                             ' +
                    '        </td>                                                                                              ' +
                    '        </tr>                                                                                              '
                );
            });
        }

        $("#one").click(function () {
            pageInit(1);
            $("#one").hide();
            $("#back").hide();
        });
        $("#last").click(function () {
            pageInit(totalPageCount);
            $("#last").hide();
            $("#next").hide();
        });
        $("#back").click(function () {
            if ((pageIndex - 1) > 1) {
                pageInit(pageIndex - 1);
            } else {
                pageInit(1);
                $("#one").hide();
                $("#back").hide();
            }
        });
        $("#next").click(function () {
            if ((pageIndex + 1) < totalPageCount) {
                pageInit(pageIndex + 1);
            } else {
                pageInit(totalPageCount);
                $("#last").hide();
                $("#next").hide();
            }
        });
    });
</script>
</body>
</html>