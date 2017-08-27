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
    <script type="text/javascript" src="${path}/js/lrscroll_1.js"></script>
    <script type="text/javascript" src="${path}/js/n_nav.js"></script>
    <script type="text/javascript" src="${path}/js/milk_ban.js"></script>
    <script type="text/javascript" src="${path}/js/paper_ban.js"></script>
    <script type="text/javascript" src="${path}/js/baby_ban.js"></script>

    <title>易买网</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <!--Begin 所在收货地区 Begin-->
        <span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>北京</span>
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
                            <td class="c_h"><span class="c_check">北京</span></td>
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
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span>四川</span><span>陕西</span></td>
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
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="images/logo.png"/></a></div>
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
                    <div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58"/></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58"/></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58"/></a></div>
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
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="${path}/UserServlet/ProductServlet">首页</a></li>
            <li><a href="${path}/UserServlet/ListServlet">美食</a></li>
            <li><a href="${path}/UserServlet/ListServlet">生鲜</a></li>
            <li><a href="${path}/UserServlet/ListServlet">家居</a></li>
            <li><a href="${path}/UserServlet/ListServlet">女装</a></li>
            <li><a href="${path}/UserServlet/ListServlet">美妆</a></li>
            <li><a href="${path}/UserServlet/ListServlet">数码</a></li>
            <li><a href="${path}/UserServlet/ListServlet">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div class="content">
        <div class="cate_nav">
            <c:forEach var="item" items="${categories}">
                <dl>
                    <dt><a href="">${item.product_parent.epp_name}</a></dt>
                    <c:forEach var="subitem" items="${item.product_categories}">
                        <dd><a href="${path}/UserServlet/ListServlet?category=${subitem}">${subitem.epc_name}</a></dd>
                    </c:forEach>
                </dl>
            </c:forEach>
        </div>
        <!--Begin Banner Begin-->
        <div class="nban">
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <c:forEach var="item" items="${sliders}">
                        <li><img src="${path}/images/${item.es_img}" width="977" height="401"/></li>
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
    </div>
    <div class="content mar_15">
        <ul class="cate">
            <li><a href="CategoryList.html"><img src="${path}/images/ca_1.jpg" width="295" height="220"/></a></li>
            <li><a href="CategoryList.html"><img src="${path}/images/ca_2.jpg" width="295" height="220"/></a></li>
            <li><a href="CategoryList.html"><img src="${path}/images/ca_3.jpg" width="295" height="220"/></a></li>
            <li><a href="CategoryList.html"><img src="${path}/images/ca_4.jpg" width="295" height="220"/></a></li>
        </ul>
    </div>
    <!--Begin 热卖爆款商品 Begin-->
    <div class="i_t mar_10">
        <span class="fl">热卖爆款商品</span>
        <span class="fr">TOP .10</span>
    </div>
    <div class="like">
        <div id="featureContainer1">
            <div id="feature1">
                <div id="block1">
                    <div id="botton-scroll1">
                        <ul class="featureUL">
                            <c:forEach var="item" items="${top10}">
                                <li class="featureBox">
                                    <div class="box">
                                        <div class="imgbg">
                                            <a href="#"><img src="${path}/product_images/${item.ep_img}" width="160"
                                                             height="136"/></a>
                                        </div>
                                        <div class="name">
                                            <a href="#">
                                                <h2>${item.ep_title}</h2>
                                                    ${item.ep_name}
                                            </a>
                                        </div>
                                        <div class="price">
                                            <font>￥<span>${item.ep_price}</span></font> &nbsp;
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <a class="l_prev" href="javascript:void();">Previous</a>
                <a class="l_next" href="javascript:void();">Next</a>
            </div>
        </div>
    </div>
    <!--End 热卖爆款商品 End-->
    <!--Begin 奶粉辅食 Begin-->
    <div class="i_t mar_10">
        <span class="fl t_color">奶粉辅食</span>
        <span class="i_mores fr"><a href="#">营养品</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">孕妈背带裤</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">儿童玩具</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">婴儿床</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">喂奶器</a></span>
    </div>
    <div class="content">
        <div class="milk_ban">
            <div id="imgPlaym">
                <ul class="imgs" id="actorm">
                    <li><a href="#"><img src="${path}/images/milk_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="${path}/images/milk_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="${path}/images/milk_ban.jpg" width="228" height="418"/></a></li>
                </ul>
                <div class="prevm">上一张</div>
                <div class="nextm">下一张</div>
            </div>
        </div>
        <div class="milk_right">
            <ul>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_1.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_2.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_3.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_4.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_5.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_6.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_7.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="${path}/images/milk_8.jpg" width="185" height="155"/></a>
                    </div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!--End 奶粉辅食 End-->
    <!--Begin 尿裤湿巾 Begin-->
    <div class="i_t mar_10">
        <span class="fl t_color">尿裤湿巾</span>
        <span class="i_mores fr"><a href="#">营养品</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">孕妈背带裤</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">儿童玩具</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">婴儿床</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">喂奶器</a></span>
    </div>
    <div class="content">
        <div class="paper_ban">
            <div id="imgPlaypa">
                <ul class="imgs" id="actorpa">
                    <li><a href="#"><img src="images/paper_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="images/paper_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="images/paper_ban.jpg" width="228" height="418"/></a></li>
                </ul>
                <div class="prevpa">上一张</div>
                <div class="nextpa">下一张</div>
            </div>
        </div>
        <div class="milk_right">
            <ul>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_1.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_2.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_3.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_4.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_5.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_6.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_7.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pa_8.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!--End 尿裤湿巾 End-->
    <!--Begin 宝宝洗护 Begin-->
    <div class="i_t mar_10">
        <span class="fl t_color">宝宝洗护</span>
        <span class="i_mores fr"><a href="#">营养品</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">孕妈背带裤</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">儿童玩具</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a href="#">婴儿床</a>&nbsp; &nbsp; | &nbsp; &nbsp;<a
                href="#">喂奶器</a></span>
    </div>
    <div class="content">
        <div class="bb_ban">
            <div id="imgPlayba">
                <ul class="imgs" id="actorba">
                    <li><a href="#"><img src="images/bb_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="images/bb_ban.jpg" width="228" height="418"/></a></li>
                    <li><a href="#"><img src="images/bb_ban.jpg" width="228" height="418"/></a></li>
                </ul>
                <div class="prevba">上一张</div>
                <div class="nextba">下一张</div>
            </div>
        </div>
        <div class="milk_right">
            <ul>
                <li>
                    <div class="img"><a href="#"><img src="images/pro1.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro2.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro3.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro4.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro5.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro6.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro7.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
                <li>
                    <div class="img"><a href="#"><img src="images/pro8.jpg" width="185" height="155"/></a></div>
                    <div class="name"><a href="#">Topfer特福芬 德国原装进口</a></div>
                    <div class="price">
                        <font>￥<span>260.00</span></font> &nbsp; 20R
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!--End 宝宝洗护 End-->

    <!--Begin Footer Begin -->
    <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b1.png" width="62" height="62"/></td>
                    <td><h2>正品保障</h2>正品行货 放心购买</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b2.png" width="62" height="62"/></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b3.png" width="62" height="62"/></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b4.png" width="62" height="62"/></td>
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
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118"/></div>
            <img src="images/ss.png"/>
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group <br/>
            <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98" height="33"/><img
                src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98" height="33"/><img
                src="images/b_5.gif" width="98" height="33"/><img src="images/b_6.gif" width="98" height="33"/>
        </div>
    </div>
    <!--End Footer End -->
</div>
</body>
</html>
