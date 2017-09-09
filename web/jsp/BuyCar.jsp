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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="${path}/css/style.css"/>
    <script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>
    <title>easybuy</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
            <c:if test="${user_login_permission!=null}">
                <span><a href="#">${user_login_permission.eu_username}</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|&nbsp;<a
                        href="#">后台管理</a>&nbsp;|&nbsp;<a
                        href="#">注销</a>&nbsp;</span>
            </c:if>
            <c:if test="${user_login_permission==null}">
                <span class="fl">你好，请<a href="${path}/login.jsp">登录</a>&nbsp; <a href="${path}/regist.jsp"
                                                                                 style="color:#ff4e00;">免费注册</a></span>
            </c:if>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="${path}/UserServlet/ProductServlet"><img src="${path}/images/logo.png"/></a></div>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">全部商品分类</div>
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="${path}/UserServlet/ProductServlet">首页</a></li>
            <c:forEach var="parentUtil" items="${parentUtils}">
                <li><a href="#">${parentUtil.product_parent.epp_name}</a></li>
            </c:forEach>
            <li><a href="#">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div class="content mar_20">
        <img src="${path}/images/img1.jpg"/>
    </div>

    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20">
        <form id="my_form" action="#">
            <table id="my_Cart" border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0"
                   cellpadding="0">
                <thead>
                <tr>
                    <td class="car_th" width="490">商品名称</td>
                    <td class="car_th" width="140">属性</td>
                    <td class="car_th" width="150">购买数量</td>
                    <td class="car_th" width="130">小计</td>
                    <td class="car_th" width="150">操作</td>
                </tr>
                </thead>
                <tbody id="my_cartTbody">
                </tbody>
            </table>
        </form>
    </div>
    <script>
        $(function () {
            cartInit();
        });

        function cartInit() {
            var sum = 0;
            var esc_ids = [];
            $("#my_cartTbody").html("");
            $.getJSON("${path}/UserServletF/ConfirmCartServlet?action=show", {}, function (result) {
                $.each(result.cartSubs, function (i, dom) {
                    $("#my_cartTbody").append(
                        '    <tr>                                                                                                                                                ' +
                        '    <td>                                                                                                                                                ' +
                        '    <div class="c_s_img"><img src="${path}/images/' + dom.product.ep_img + '" width="73" height="73"/></div>                                                ' +
                        dom.product.ep_name +
                        '    </td>                                                                                                                                               ' +
                        '    <td align="center">' + dom.product.ep_description + '</td>                                                                                              ' +
                        '    <td align="center">                                                                                                                                 ' +
                        '    <div class="c_num">                                                                                                                                 ' +
                        '    <input type="button" value="" onclick="subQuantity(' + dom.esc_quantity + ',' + dom.esc_id + ');" class="car_btn_1"/>     ' +
                        '    <input type="text" value="' + dom.esc_quantity + '" class="car_ipt"/>                                                                                   ' +
                        '    <input type="button" value="" onclick="addQuantity(' + dom.esc_quantity + ',' + dom.esc_id + ');" class="car_btn_2"/>     ' +
                        '    </div>                                                                                                                                              ' +
                        '    </td>                                                                                                                                               ' +
                        '    <td class="my_totalPrice1" align="center" style="color:#ff4e00;">￥' + dom.totalPrice + '</td>                                                           ' +
                        '    <td align="center"><a onclick="delCart(' + dom.esc_id + ')">删除</a></td>                                                                                 ' +
                        '    </tr>                                                                                                                                               '
                    );
                    sum += dom.totalPrice;
                    esc_ids[i] = dom.esc_id;
                    //alert(i+","+esc_ids[i]);
                });
                $("#my_cartTbody").append(
                    '<tr height="70">                                                                                        ' +
                    '    <td colspan="6" style="font-family:\'Microsoft YaHei\'; border-bottom:0;">                            ' +
                    '    <span id="my_sum1" class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">￥' + sum + '</b></span>     ' +
                    '    </td>                                                                                               ' +
                    '    </tr>                                                                                               ' +
                    '    <tr valign="top" height="150">                                                                      ' +
                    '    <td colspan="6" align="right">                                                                      ' +
                    '    <a href="${path}/UserServlet/ProductServlet"><img src="${path}/images/buy1.gif"/></a>&nbsp; &nbsp;   ' +
                    '    <a href="javascript:" onclick="submitOrder(' + esc_ids + ')"><img src="${path}/images/buy2.gif" /></a>               ' +
                    '    </td>                                                                                               ' +
                    '    </tr>                                                                                               '
                );
            });
            //alert('ok!'+sum);会先执行这里的代码,然后再走上面的代码
        };

        function submitOrder(esc_ids) {
            location.href = "${path}/UserServletF/OrderServlet?action=show&esc_ids=" + esc_ids;
        }
        function delCart(esc_id) {
            $.getJSON("${path}/UserServletF/ConfirmCartServlet?action=delOne", {"esc_id": esc_id}, function (result) {
                if (result === true) {
                    cartInit()
                }
            });
        }
        function addQuantity(quantity, esc_id) {
            $.getJSON("${path}/UserServletF/ConfirmCartServlet?action=addOne", {
                "esc_quantity": quantity,
                "esc_id": esc_id
            }, function (result) {
                if (result === true) {
                    cartInit()
                }
                //alert(result+","+typeof (result));
            });
        }
        function subQuantity(quantity, esc_id) {
            if (quantity > 1) {
                $.getJSON("${path}/UserServletF/ConfirmCartServlet?action=subOne", {
                    "esc_quantity": quantity,
                    "esc_id": esc_id
                }, function (result) {
                    if (result === true) {
                        cartInit()
                    }
                });
            }
        }
    </script>
    <!--End 第一步：查看购物车 End-->

    <!--Begin Footer Begin -->
    <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="${path}/images/b1.png" width="62" height="62"/></td>
                    <td><h2>正品保障</h2>正品行货 放心购买</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="${path}/images/b2.png" width="62" height="62"/></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="${path}/images/b3.png" width="62" height="62"/></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="${path}/images/b4.png" width="62" height="62"/></td>
                    <td><h2>准时送达</h2>收货时间由你做主</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
            <a href="#" class="b_sh1">新浪微博</a>
            <a href="#" class="b_sh2">腾讯微博</a>
            <p>
                服务热线：<br/>
                <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="${path}/images/er.gif" width="118" height="118"/></div>
            <img src="${path}/images/ss.png"/>
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group <br/>
            <img src="${path}/images/b_1.gif" width="98" height="33"/><img src="${path}/images/b_2.gif" width="98"
                                                                           height="33"/><img
                src="${path}/images/b_3.gif" width="98" height="33"/><img src="${path}/images/b_4.gif" width="98"
                                                                          height="33"/><img
                src="${path}/images/b_5.gif" width="98" height="33"/><img src="${path}/images/b_6.gif" width="98"
                                                                          height="33"/>
        </div>
    </div>
    <!--End Footer End -->
</div>

</body>

</html>
