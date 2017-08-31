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
    <link type="text/css" rel="stylesheet" href="${path}/css/style.css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.bxslider_e88acd1b.js"></script>
    <script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/menu.js"></script>
    <script type="text/javascript" src="${path}/js/select.js"></script>
    <script type="text/javascript" src="${path}/js/lrscroll.js"></script>
    <script type="text/javascript" src="${path}/js/iban.js"></script>
    <script type="text/javascript" src="${path}/js/fban.js"></script>
    <script type="text/javascript" src="${path}/js/f_ban.js"></script>
    <script type="text/javascript" src="${path}/js/mban.js"></script>
    <script type="text/javascript" src="${path}/js/bban.js"></script>
    <script type="text/javascript" src="${path}/js/hban.js"></script>
    <script type="text/javascript" src="${path}/js/tban.js"></script>
    <script type="text/javascript" src="${path}/js/lrscroll_1.js"></script>


    <title>easybuy</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <!--Begin 所在收货地区 Begin-->
        <span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0"
                               cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<span class="fl">你好，请<a href="Login.html">登录</a>&nbsp; <a href="Regist.html" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;<a
                    href="#">我的订单</a>&nbsp;|</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${path}/images/s_tel.png"
                                                              align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="${path}/images/logo.png"/></a></div>
    <div class="search">
        <form>
            <input type="text" value="" class="s_ipt"/>
            <input type="submit" value="搜索" class="s_btn"/>
        </form>
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a
                href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
        <div class="car_t">购物车 [ <span>3</span> ]</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/car1.jpg" width="58" height="58"/></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/car2.jpg" width="58" height="58"/></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/car2.jpg" width="58" height="58"/></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="#">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">全部商品分类</div>
            <div class="leftNav">
                <ul>
                    <c:forEach var="parentUtil" items="${parentUtils}">
                        <li>
                            <div class="fj">
                                <span class="n_img"><span></span><img
                                        src="${path}/images/${parentUtil.product_parent.epp_img}"/></span>
                                <span class="fl">${parentUtil.product_parent.epp_name}</span>
                            </div>
                            <div class="zj">
                                <div class="zj_l">
                                    <c:forEach var="categoryUtil" items="${parentUtil.categoryUtils}">
                                        <div class="zj_l_c">
                                            <h2>${categoryUtil.product_category.epc_name}</h2>
                                            <c:forEach var="child" items="${categoryUtil.product_children}">
                                                <a href="#">${child.epch_name}</a>|
                                            </c:forEach>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="zj_r">
                                    <a href="#"><img src="${path}/images/n_img1.jpg" width="236" height="200"/></a>
                                    <a href="#"><img src="${path}/images/n_img2.jpg" width="236" height="200"/></a>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <%--Ajax实现三级分类,首页只要刷新父级即可.由于会覆盖原有js,此处不猜用此技术--%>
                <%--<script>
                    $(".leftNav ul li").mouseover(function () {
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
                </script>--%>
            </div>
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="#">首页</a></li>
            <c:forEach var="parentUtil" items="${parentUtils}">
                <li><a href="#">${parentUtil.product_parent.epp_name}</a></li>
            </c:forEach>
            <li><a href="#">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End-->
<div class="i_bg bg_color">
    <div class="i_ban_bg">
        <!--Begin Banner Begin-->
        <div class="banner">
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <c:forEach var="item" items="${sliders}">
                        <li><img src="${path}/images/${item.es_img}" width="740" height="401"/></li>
                    </c:forEach>
                </ul>
                <div class="op_btns clearfix">
                    <a href="#" class="op_btn op_prev"><span></span></a>
                    <a href="#" class="op_btn op_next"><span></span></a>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            //var jq = jQuery.noConflict();
            (function () {
                $(".bxslider").bxSlider({
                    auto: true,
                    prevSelector: jq(".top_slide_wrap .op_prev")[0], nextSelector: jq(".top_slide_wrap .op_next")[0]
                });
            })();
        </script>
        <!--End Banner End-->
        <div class="inews">
            <div class="news_t">
                <span class="fr"><a href="#">更多 ></a></span>新闻资讯
            </div>
            <ul>
                <li><span>[ 特惠 ]</span><a href="#">掬一轮明月 表无尽惦念</a></li>
                <li><span>[ 公告 ]</span><a href="#">好奇金装成长裤新品上市</a></li>
                <li><span>[ 特惠 ]</span><a href="#">大牌闪购 · 抢！</a></li>
                <li><span>[ 公告 ]</span><a href="#">发福利 买车就抢千元油卡</a></li>
                <li><span>[ 公告 ]</span><a href="#">家电低至五折</a></li>
            </ul>
        </div>
    </div>
    <!--Begin 热门商品 Begin-->
    <div class="content mar_10">
        <div class="h_l_img">
            <c:forEach var="item" items="${top10}" varStatus="status">
                <c:if test="${status.first}">
                    <div class="img"><img src="${path}/images/${item.ep_img}" width="188" height="188"/></div>
                    <div class="pri_bg">
                        <span class="price fl">￥${item.ep_price}</span>
                        <span class="fr">16R</span>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="hot_pro">
            <div id="featureContainer">
                <div id="feature">
                    <div id="block">
                        <div id="botton-scroll">
                            <ul class="featureUL">
                                <c:forEach var="item" items="${top10}">
                                    <li class="featureBox">
                                        <div class="box">
                                            <div class="h_icon"><img src="${path}/images/hot.png" width="50"
                                                                     height="50"/>
                                            </div>
                                            <div class="imgbg">
                                                <a href="#"><img src="${item}/images/${item.ep_img}" width="160"
                                                                 height="136"/></a>
                                            </div>
                                            <div class="name">
                                                <a href="#">
                                                    <h2>${item.ep_name}</h2>
                                                        ${item.ep_title}
                                                </a>
                                            </div>
                                            <div class="price">
                                                <font>￥<span>${item.ep_price}</span></font>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <a class="h_prev" href="javascript:void(0);">Previous</a>
                    <a class="h_next" href="javascript:void(0);">Next</a>
                </div>
            </div>
        </div>
    </div>
    <!--Begin 限时特卖 Begin-->
    <div class="i_t mar_10">
        <span class="fl">限时特卖</span>
        <span class="i_mores fr"><a href="#">更多</a></span>
    </div>
    <div class="content">
        <div class="i_sell">
            <div id="imgPlay">
                <ul class="imgs" id="actor">
                    <c:forEach var="item" items="${limit8}" varStatus="status">
                        <li><a href="#"><img src="${path}/images/${item.ep_img}" width="211" height="357"/></a></li>
                    </c:forEach>
                </ul>
                <div class="previ">上一张</div>
                <div class="nexti">下一张</div>
            </div>
        </div>
        <div class="sell_right">
            <c:forEach var="item" items="${limit8}" varStatus="status">
                <div class="${item.ep_id}"
                     style="width: 244px;height: 177px;overflow: hidden;border-bottom: 1px solid #eaeaea;
position: relative;float: left;">
                    <div class="s_img"><a href="#"><img src="${path}/images/${item.ep_img}" width="185"
                                                        height="155"/></a></div>
                    <div class="s_price">￥<span>${item.ep_price}</span></div>
                    <div class="s_name">
                        <h2><a href="#">${item.ep_name}</a></h2>
                        倒计时：<span>1</span> 时 <span>30</span> 分 <span>28</span> 秒
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!--End 限时特卖 End-->
    <div class="content mar_20">
        <img src="${path}/images/mban_1.jpg" width="1200" height="110"/>
    </div>

    <c:forEach var="parentUtil" items="${parentUtils}" varStatus="status">
        <!--Begin *** Begin-->
        <div class="i_t mar_10">
            <span class="floor_num">${status.count}F</span>
            <span class="fl">${parentUtil.product_parent.epp_name}</span>
            <span class="i_mores fr">
                <c:forEach var="categoryUtil" items="${parentUtil.categoryUtils}" varStatus="status">
                    &nbsp; &nbsp; &nbsp;<a href="#">${categoryUtil.product_category.epc_name}</a>
                </c:forEach>
            </span>
        </div>

        <div class="content">
            <div class="fresh_left">
                <div class="fre_ban">
                    <div id="imgPlay1">
                            <%--The parent img--%>
                        <ul class="imgs" id="actor1">
                            <li><a href="#"><img src="${path}/images/${parentUtil.product_parent.epp_img}" width="211"
                                                 height="286"/></a></li>
                        </ul>
                        <div class="prevf">上一张</div>
                        <div class="nextf">下一张</div>
                    </div>
                </div>
                <div class="fresh_txt">
                    <div class="fresh_txt_c">
                        <c:forEach var="categoryUtil" items="${parentUtil.categoryUtils}">
                            <a href="#">${categoryUtil.product_category.epc_name}</a>&nbsp; &nbsp; &nbsp;
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="fresh_mid">
                <ul class="ysc_mid" id="${parentUtil.product_parent.epp_id}">
                        <%--<li>
                            <div class="name"><a href="#">新鲜美味 进口美食</a></div>
                            <div class="price">
                                <font>￥<span>198.00</span></font> &nbsp; 26R
                            </div>
                            <div class="img"><a href="#"><img src="${path}/images/fre_1.jpg" width="185" height="155"/></a>
                            </div>
                        </li>--%>
                </ul>
            </div>
            <div class="fresh_right">
                <ul>
                    <li><a href="#"><img src="${path}/images/${parentUtil.product_parent.epp_img}" width="260"
                                         height="220"/></a></li>
                    <li><a href="#"><img src="${path}/images/${parentUtil.product_parent.epp_img}" width="260"
                                         height="220"/></a></li>
                </ul>
            </div>
        </div>
        <!--End *** End-->
    </c:forEach>
</div>
<script>
    $(document).ready(function () {
        $(".ysc_mid").each(function () {
            var products = $(this);
            var epp_id = products.attr("id");
            products.html("");
            $.getJSON("${path}/UserServlet/AjaxProductServlet", {"epp_id": epp_id}, function (result) {
                $.each(result, function (i, dom) {
                    products.append(
                        '<li>                                                                                               ' +
                        '<div class="name"><a href="#">' + dom.ep_name + '</a></div>                                                   ' +
                        '<div class="price">                                                                                 ' +
                        '    <font>￥<span>' + dom.ep_price + '</span></font> &nbsp;                                                   ' +
                        '</div>                                                                                              ' +
                        '<div class="img"><a href="#"><img src="' + '${path}/images/' + dom.ep_img + '" width="185" height="155"/></a>     ' +
                        '    </div>                                                                                         ' +
                        '    </li>                '
                    );
                });
            });
        });
        /*var epp_id = $(this).attr('class');
         $.getJSON("$?path?/UserServlet/AjaxCategoryServlet", {"epp_id": epp_id}, function (result) {
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
         });*/
    });
</script>
<!--Begin 猜你喜欢 Begin-->
<div class="i_t mar_10">
    <span class="fl">猜你喜欢</span>
</div>
<div class="like">
    <div id="featureContainer1">
        <div id="feature1">
            <div id="block1">
                <div id="botton-scroll1">
                    <ul class="featureUL">
                        <li class="featureBox">
                            <div class="box">
                                <div class="imgbg">
                                    <a href="#"><img src="${path}/images/hot1.jpg" width="160" height="136"/></a>
                                </div>
                                <div class="name">
                                    <a href="#">
                                        <h2>德国进口</h2>
                                        德亚全脂纯牛奶200ml*48盒
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>189</span></font> &nbsp; 26R
                                </div>
                            </div>
                        </li>
                        <li class="featureBox">
                            <div class="box">
                                <div class="imgbg">
                                    <a href="#"><img src="${path}/images/hot2.jpg" width="160" height="136"/></a>
                                </div>
                                <div class="name">
                                    <a href="#">
                                        <h2>iphone 6S</h2>
                                        Apple/苹果 iPhone 6s Plus公开版
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>5288</span></font> &nbsp; 25R
                                </div>
                            </div>
                        </li>
                        <li class="featureBox">
                            <div class="box">
                                <div class="imgbg">
                                    <a href="#"><img src="${path}/images/hot3.jpg" width="160" height="136"/></a>
                                </div>
                                <div class="name">
                                    <a href="#">
                                        <h2>倩碧特惠组合套装</h2>
                                        倩碧补水组合套装8折促销
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>368</span></font> &nbsp; 18R
                                </div>
                            </div>
                        </li>
                        <li class="featureBox">
                            <div class="box">
                                <div class="imgbg">
                                    <a href="#"><img src="${path}/images/hot4.jpg" width="160" height="136"/></a>
                                </div>
                                <div class="name">
                                    <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>280</span></font> &nbsp; 30R
                                </div>
                            </div>
                        </li>
                        <li class="featureBox">
                            <div class="box">
                                <div class="imgbg">
                                    <a href="#"><img src="${path}/images/hot4.jpg" width="160" height="136"/></a>
                                </div>
                                <div class="name">
                                    <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>280</span></font> &nbsp; 30R
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <a class="l_prev" href="javascript:void(0);">Previous</a>
            <a class="l_next" href="javascript:void(0);">Next</a>
        </div>
    </div>
</div>
<!--End 猜你喜欢 End-->

<!--Begin Footer Begin -->
<div class="b_btm_bg b_btm_c">
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

<div class="top">
    <div class="logo"><a href="${path}/Home?action=index"><img src="${path}/images/logo.png"></a></div>
    <div class="search">
        <form>
            <input txype="text" value="" class="s_ipt">
            <input type="submit" value="搜索" class="s_btn">
        </form>
        <span class="fl">
            <a href="javascript:void(0)">咖啡</a>
            <a href="javascript:void(0)">iphone 6S</a>
            <a href="javascript:void(0)">新鲜美食</a>
            <a href="javascript:void(0)">蛋糕</a>
            <a href="javascript:void(0)">日用品</a>
            <a href="javascript:void(0)">连衣裙</a>
        </span>
    </div>
    <div class="i_car">
        <div class="car_t">购物车 [ <span>3</span> ]</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.loginUser==null}">
                <div class="un_login">还未登录！<a href="${path}/Login?action=toLogin" style="color:#ff4e00;">马上登录</a> 查看购物车！
                </div>
            </c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <c:if test="${sessionScope.cart2==null || sessionScope.cart2.items.size()<1}"> 您尚未购买任何物品，是否进入<a href="${path}/Home?action=index">商品页</a>进行购买！</c:if>
                <c:if test="${sessionScope.cart2.items.size()>=1}">
                    <li>
                        <div class="img">
                            <a href="javascript:void(0)">
                                <img src="${path}/images/car1.jpg" width="58" height="58">
                            </a>
                        </div>
                        <div class="name">
                            <a href="javascript:void(0)">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a>
                        </div>
                        <div class="price">
                            <font color="#ff4e00">￥399</font>X1
                        </div>
                    </li>
                </c:if>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="javascript:void(0)">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>