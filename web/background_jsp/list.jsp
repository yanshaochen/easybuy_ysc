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
    <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
            <li><a class="button border-main icon-plus-square-o" href="#add" id="addContent"> 添加商品</a></li>
            <li>搜索：</li>
            <li>一级分类
                <label>
                    <select id="ep_parent_select" name="ep_parent_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                        <option id="ep_parent_id" name="ep_parent_id" value="" onclick="resetCategory1()"
                                selected="selected">选择
                        </option>
                        <c:forEach var="item" items="${parentUtils}">
                            <option name="ep_parent_id"
                                    value="${item.product_parent.epp_id}"
                                    onclick="categoryQuery1(${item.product_parent.epp_id})">${item.product_parent.epp_name}</option>
                        </c:forEach>
                    </select>
                </label>
            </li>
            <li>二级分类
                <label>
                    <select id="ep_category_select" name="ep_category_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                        <option name="ep_category_id" value="" onclick="resetCategory2()" selected="selected">选择
                        </option>
                    </select>
                </label>
            </li>
            <li>三级分类
                <label>
                    <select id="ep_child_select" name="ep_child_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                        <option name="ep_child_id" value="" onclick="categoryQuery3()" selected="selected">选择</option>
                    </select>
                </label>
            </li>
            <li style="float: right;">
                <input id="my_input" type="text" placeholder="请输入名称关键字" name="keywords" value="" class="input"
                       style="width:250px; line-height:17px;display:inline-block"/>
                <a href="javascript:" class="button border-main icon-search" id="my_search"> 搜索</a>
            </li>
        </ul>
    </div>

    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">ID</th>
            <th width="10%">名称</th>
            <th>图片</th>
            <th>描述</th>
            <th>价格</th>
            <th>品牌</th>
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
<%--添加修改--%>
<div class="panel admin-panel margin-top" id="add" style="display: none">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
    <div class="body-content">
        <form id="add_form" method="post" class="form-x" action="${path}/AdminServlet/SetProductsServlet?action=add"
              enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="ep_name"
                           data-validate="required:请输入名称"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="ep_img" value="+ 浏览上传"/>
                    <div class="tipss">图片尺寸：1920*500</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="ep_title" value=""
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="ep_description" value=""
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="ep_price" value="100"
                           data-validate="required:,number:价格必须为数字"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>品牌：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="ep_brand" value="100"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>一级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_parent_set_f" name="ep_parent_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                        <option name="ep_parent_id" value="0">请选择</option>
                        <c:forEach var="item" items="${parentUtils}">
                            <option name="ep_parent_id"
                                    value="${item.product_parent.epp_id}"
                                    onclick="getCategories$f(${item.product_parent.epp_id})">${item.product_parent.epp_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>二级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_category_set_f" name="ep_category_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>三级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_child_set_f" name="ep_child_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>库存：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="ep_stock" value="100"
                           data-validate="required:,number:库存必须为数字"/>
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
              action="${path}/AdminServlet/SetProductsServlet?action=update"
              enctype="multipart/form-data">
            <input id="update" type="text" name="ep_id" value="" style="display: none">
            <div class="form-group">
                <div class="label">
                    <label>名称：</label>
                </div>
                <div class="field">
                    <input id="ep_name" type="text" class="input w50" value="" name="ep_name"
                           data-validate="required:请输入名称"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="ep_img" value="+ 浏览上传"/>
                    <div class="tipss">图片尺寸：1920*500</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input id="ep_title" type="text" class="input w50" name="ep_title" value=""
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <input id="ep_description" type="text" class="input w50" name="ep_description" value=""
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>价格：</label>
                </div>
                <div class="field">
                    <input id="ep_price" type="text" class="input w50" name="ep_price" value="100"
                           data-validate="required:,number:价格必须为数字"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>品牌：</label>
                </div>
                <div class="field">
                    <input id="ep_brand" type="text" class="input w50" name="ep_brand" value="100"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>一级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_parent_set" name="ep_parent_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>二级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_category_set" name="ep_category_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>三级分类：</label>
                </div>
                <div class="field">
                    <select id="ep_child_set" name="ep_child_id" class="input"
                            style="width:160px; line-height:17px; display:inline-block">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>库存：</label>
                </div>
                <div class="field">
                    <input id="ep_stock" type="text" class="input w50" name="ep_stock" value="100"
                           data-validate="required:,number:库存必须为数字"/>
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

        var ep_parent_id$f = $("#ep_parent_select option:selected").val();
        var ep_category_id$f = $("#ep_category_select option:selected").val();
        var ep_child_id$f = $("#ep_child_select option:selected").val();
        var searchKey = $("#my_input").val();

        $.getJSON("${path}/AdminServlet/AjaxSetProductServlet", {
            "pageIndex": pageIndex,
            "ep_parent_id": ep_parent_id$f,
            "ep_category_id": ep_category_id$f,
            "ep_child_id": ep_child_id$f,
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
                    '    value=""/>' + dom.ep_id + '</td>                                                                        ' +
                    '        <td>' + dom.ep_name + '</td>                   ' +
                    '        <td width="10%"><img src="${path}/images/' + dom.ep_img + '" alt="" width="70" height="50"/></td>   ' +
                    '        <td>' + dom.ep_description + '</td>                                                                       ' +
                    '       <td>' + dom.ep_price + '</td>                                                                        ' +
                    '       <td>' + dom.ep_brand + '</td>                                                                        ' +
                    '       <td>' + dom.epp_name + '</td>                                                                        ' +
                    '       <td>' + dom.epc_name + '</td>                                                                        ' +
                    '       <td>' + dom.epch_name + '</td>                                                                       ' +
                    '       <td>' + dom.ep_stock + '</td>                                                                       ' +
                    '        <td>                                                                                               ' +
                    '        <div class="button-group">                                                                         ' +
                    '        <a class="button border-main" href="javascript:void(0)" onclick="modify(' + dom.ep_id + ')"><span class="icon-edit"></span> 修改</a>                      ' +
                    '        <a class="button border-red" href="javascript:void(0)" onclick="return del(' + dom.ep_id + ')"><span class="icon-trash-o"></span> 删除</a>                    ' +
                    '        </div>                                                                                             ' +
                    '        </td>                                                                                              ' +
                    '        </tr>                                                                                              '
                );
            });
        });
    }
    function categoryQuery1(epp_id) {
        $("#ep_child_select").html('<option name="ep_child_id" value="" selected="selected">选择</option>');
        var epc = $("#ep_category_select");
        epc.html('<option name="ep_category_id" value="" onclick="resetCategory2()" selected="selected">选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epp_id": epp_id}, function (result) {
            $.each(result, function (i, dom) {
                epc.append(
                    '<option name="ep_category_id" ' +
                    'value="' + dom.epc_id + '" onclick="categoryQuery2(' + dom.epc_id + ')">' + dom.epc_name + '</option>'
                );
            });
        });
        pageInit(1);
    }
    function categoryQuery2(epc_id) {
        var epch = $("#ep_child_select");
        epch.html('<option name="ep_child_id" value="" onclick="categoryQuery3()" selected="selected">选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epc_id": epc_id}, function (result) {
            $.each(result, function (i, dom) {
                epch.append(
                    '<option name="ep_child_id" ' +
                    'value="' + dom.epch_id + '" onclick="categoryQuery3()">' + dom.epch_name + '</option>'
                );
            });
        });
        pageInit(1);
    }
    function categoryQuery3() {
        pageInit(1);
    }
    function resetCategory1() {
        $("#ep_category_select").html('<option name="ep_category_id" value="" onclick="resetCategory2()" selected>选择</option>');
        $("#ep_child_select").html('<option name="ep_child_id" value="" selected>选择</option>');
        pageInit(1);
    }
    function resetCategory2() {
        $("#ep_child_select").html('<option name="ep_child_id" value="" selected>选择</option>');
        pageInit(1);
    }
    function del(ep_id) {
        if (confirm("您确定要删除吗?")) {
            location.href = '${path}/AdminServlet/SetProductsServlet?action=delete&ep_id=' + ep_id;
        }
    }
    function modify(ep_id) {
        $("#update").val(ep_id);
        var ep_name;
        var ep_title;
        var ep_description;
        var ep_price;
        var ep_brand;
        var ep_stock;
        var ep_parent_id;
        var ep_category_id;
        var ep_child_id;

        $.getJSON("${path}/AdminServlet/AjaxGetProductByIdServlet", {"ep_id": ep_id}, function (result) {
            ep_name = result.product.ep_name;
            ep_title = result.product.ep_title;
            ep_description = result.product.ep_description;
            ep_price = result.product.ep_price;
            ep_brand = result.product.ep_brand;
            ep_stock = result.product.ep_stock;
            ep_parent_id = result.product.ep_parent_id;
            ep_category_id = result.product.ep_category_id;
            ep_child_id = result.product.ep_child_id;
            $("#ep_name").val(ep_name);
            $("#ep_title").val(ep_title);
            $("#ep_description").val(ep_description);
            $("#ep_price").val(ep_price);
            $("#ep_brand").val(ep_brand);
            $("#ep_stock").val(ep_stock);
            $("#ep_parent_set").html("");
            $("#ep_category_set").html("");
            $("#ep_child_set").html("");

            $.each(result.parents, function (i, dom) {
                if (dom.epp_id === ep_parent_id) {
                    $("#ep_parent_set").append(
                        '<option name="ep_parent_id" ' +
                        'value="' + dom.epp_id + '" onclick="getCategories(' + dom.epp_id + ')" selected="selected">' + dom.epp_name + '</option>'
                    );
                } else {
                    $("#ep_parent_set").append(
                        '<option name="ep_parent_id" ' +
                        'value="' + dom.epp_id + '" onclick="getCategories(' + dom.epp_id + ')">' + dom.epp_name + '</option>'
                    );
                }
            });

            $.each(result.categories, function (i, dom) {
                if (dom.epc_id === ep_category_id) {
                    $("#ep_category_set").append(
                        '<option name="ep_category_id" ' +
                        'value="' + dom.epc_id + '" onclick="getChildren(' + dom.epc_id + ')" selected="selected">' + dom.epc_name + '</option>'
                    );
                } else {
                    $("#ep_category_set").append(
                        '<option name="ep_category_id" ' +
                        'value="' + dom.epc_id + '" onclick="getChildren(' + dom.epc_id + ')">' + dom.epc_name + '</option>'
                    );
                }
            });

            $.each(result.children, function (i, dom) {
                if (dom.epch_id === ep_child_id) {
                    $("#ep_child_set").append(
                        '<option name="ep_child_id" ' +
                        'value="' + dom.epch_id + '" selected="selected">' + dom.epch_name + '</option>'
                    );
                } else {
                    $("#ep_child_set").append(
                        '<option name="ep_child_id" ' +
                        'value="' + dom.epch_id + '">' + dom.epch_name + '</option>'
                    );
                }
            });
            $("#modify").show();
            $("#add").hide();
            location.hash = "#modify";
        });
    }
    function getCategories(epp_id) {
        $("#ep_child_set").html('<option name="ep_child_id" value="0" selected="selected">请选择</option>');
        $("#ep_category_set").html('<option name="ep_category_id" value="0" selected="selected">请选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epp_id": epp_id}, function (result) {
            $.each(result, function (i, dom) {
                $("#ep_category_set").append(
                    '<option name="ep_category_id" ' +
                    'value="' + dom.epc_id + '" onclick="getChildren(' + dom.epc_id + ')">' + dom.epc_name + '</option>'
                );
            });
        });
    }
    function getChildren(epc_id) {
        $("#ep_child_set").html('<option name="ep_child_id" value="0" selected="selected">请选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epc_id": epc_id}, function (result) {
            $.each(result, function (i, dom) {
                $("#ep_child_set").append(
                    '<option name="ep_child_id" ' +
                    'value="' + dom.epch_id + '">' + dom.epch_name + '</option>'
                );
            });
        });
    }
    function getCategories$f(epp_id) {
        $("#ep_child_set_f").html('<option name="ep_child_id" value="0" selected="selected">请选择</option>');
        $("#ep_category_set_f").html('<option name="ep_category_id" value="0" selected="selected">请选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epp_id": epp_id}, function (result) {
            $.each(result, function (i, dom) {
                $("#ep_category_set_f").append(
                    '<option name="ep_category_id" ' +
                    'value="' + dom.epc_id + '" onclick="getChildren$f(' + dom.epc_id + ')">' + dom.epc_name + '</option>'
                );
            });
        });
    }
    function getChildren$f(epc_id) {
        $("#ep_child_set_f").html('<option name="ep_child_id" value="0" selected="selected">请选择</option>');
        $.getJSON("${path}/AdminServlet/AjaxClassificationQueryServlet", {"epc_id": epc_id}, function (result) {
            $.each(result, function (i, dom) {
                $("#ep_child_set_f").append(
                    '<option name="ep_child_id" ' +
                    'value="' + dom.epch_id + '">' + dom.epch_name + '</option>'
                );
            });
        });
    }
</script>
</body>
</html>