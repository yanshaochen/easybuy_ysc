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
    <div class="panel-head"><strong class="icon-reorder"> 新闻列表</strong>
    </div>
    <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
            <li><a class="button border-main icon-plus-square-o" href="#add" id="addContent"> 添加新闻</a></li>
            <li>搜索：</li>
            <li style="float: right;">
                <input id="my_input" type="text" placeholder="请输入标题关键字" name="keywords" value="" class="input"
                       style="width:250px; line-height:17px;display:inline-block"/>
                <a href="javascript:" class="button border-main icon-search" id="my_search"> 搜索</a>
            </li>
        </ul>
    </div>

    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">ID</th>
            <th width="10%">标题</th>
            <th width="35%">内容</th>
            <th>创建时间</th>
            <th>修改时间</th>
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
<%--添加修改--%>
<div class="panel admin-panel margin-top" id="add" style="display: none">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
    <div class="body-content">
        <form id="add_form" method="post" class="form-x" action="${path}/AdminServlet/NewsServlet?action=add">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="en_title"
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="en_content" value=""
                           data-validate="required:请输入标题"/>
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
        <form id="modify_form" method="post" class="form-x"
              action="${path}/AdminServlet/NewsServlet?action=update">
            <input id="update" type="text" name="en_id" value="" style="display: none">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input id="en_title" type="text" class="input w50" value="" name="en_title"
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <input id="en_content" type="text" class="input w50" name="en_content" value=""
                           data-validate="required:请输入标题"/>
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
<input id="pageIndex" name="pageIndex" value="" style="display: none">
<input id="pageSize" name="pageSize" value="" style="display: none">
<input id="totalPageCount" name="totalPageCount" value="" style="display: none">
<input id="totalCountSize" name="totalCountSize" value="" style="display: none">
<script type="text/javascript">
    //init page and some buttons
    $(function () {
        pageInit(1);
        $("#one").click(function () {
            pageInit(1);
            $("#one").hide();
            $("#back").hide();
        });
        $("#last").click(function () {
            var totalPageCount$f = Number($("#totalPageCount").val());
            pageInit(totalPageCount$f);
            $("#last").hide();
            $("#next").hide();
        });
        $("#back").click(function () {
            var pageIndex$f = Number($("#pageIndex").val());
            if ((pageIndex$f - 1) > 1) {
                pageInit(pageIndex$f - 1);
            } else {
                pageInit(1);
                $("#one").hide();
                $("#back").hide();
            }
        });
        $("#next").click(function () {
            var pageIndex$f = Number($("#pageIndex").val());
            var totalPageCount$f = Number($("#totalPageCount").val());
            if ((pageIndex$f + 1) < totalPageCount$f) {
                pageInit(pageIndex$f + 1);
            } else {
                pageInit(totalPageCount$f);
                $("#last").hide();
                $("#next").hide();
            }
        });
        $("#my_search").click(function () {
            pageInit(1);
        })
        $("#addContent").click(function () {
            $("#add").show();
            $("#modify").hide();
        })
        $("#modify_form").submit(function () {
            var a = Number($("#ep_child_set option:selected").val());
            var b = Number($("#ep_category_set option:selected").val());
            return !(a == 0 || b == 0);
        })
        $("#add_form").submit(function () {
            var a = Number($("#ep_child_set_f option:selected").val());
            var b = Number($("#ep_category_set_f option:selected").val());
            return !(a == 0 || b == 0);
        })
    });
    //pageInit method --show page content
    function pageInit(pageIndex) {
        $("#one").show();
        $("#back").show();
        $("#next").show();
        $("#last").show();

        var searchKey = $("#my_input").val();

        $.getJSON("${path}/AdminServlet/AjaxSetNewsServlet", {
            "pageIndex": pageIndex,
            "searchKey": searchKey
        }, function (result) {
            $("#tbody").html("");
            $.each(result, function (i, dom) {
                if (dom.pageUtil != null) {
                    $("#pageIndex").val(dom.pageUtil.pageIndex);
                    $("#pageSize").val(dom.pageUtil.pageSize);
                    $("#totalPageCount").val(dom.pageUtil.pageCount);
                    $("#totalCountSize").val(dom.pageUtil.totalCount);
                }
                $("#tbody").append(
                    '    <tr>                                                                                                   ' +
                    '   <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="ep_id"                     ' +
                    '    value=""/>' + dom.en_id + '</td>                                                                        ' +
                    '        <td>' + dom.en_title + '</td>                                                                       ' +
                    '       <td>' + dom.en_content + '</td>                                                                        ' +
                    '       <td>' + dom.en_create_time + '</td>                                                                        ' +
                    '       <td>' + (dom.en_modify_time == null ? "" : dom.en_modify_time) + '</td>                                                                        ' +
                    '        <td>                                                                                               ' +
                    '        <div class="button-group">                                                                         ' +
                    '        <a class="button border-main" href="javascript:void(0)" onclick="modify(' + dom.en_id + ')"><span class="icon-edit"></span> 修改</a>                      ' +
                    '        <a class="button border-red" href="javascript:void(0)" onclick="return del(' + dom.en_id + ')"><span class="icon-trash-o"></span> 删除</a>                    ' +
                    '        </div>                                                                                             ' +
                    '        </td>                                                                                              ' +
                    '        </tr>                                                                                              '
                );
            });
        });
    }

    function del(en_id) {
        if (confirm("您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/NewsServlet?action=delete&en_id=' + en_id;
        }
    }
    function modify(en_id) {
        $("#update").val(en_id);
        var en_title;
        var en_content;

        $.getJSON("${path}/AdminServlet/AjaxGetNewsByIdServlet", {"en_id": en_id}, function (result) {
            en_title = result.en_title;
            en_content = result.en_content;
            $("#en_title").val(en_title);
            $("#en_content").val(en_content);

            $("#modify").show();
            $("#add").hide();
            location.hash = "#modify";
        });
    }
</script>
</body>
</html>