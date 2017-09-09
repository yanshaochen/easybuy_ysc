<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/menu.js"></script>
    <script type="text/javascript" src="${path}/js/lrscroll_1.js"></script>
    <script type="text/javascript" src="${path}/js/n_nav.js"></script>
    <link rel="stylesheet" type="text/css" href="${path}/css/ShopShow.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/MagicZoom.css"/>
    <script type="text/javascript" src="${path}/js/MagicZoom.js"></script>
    <script type="text/javascript" src="${path}/js/num.js"></script>
    <script type="text/javascript" src="${path}/js/p_tab.js"></script>
    <script type="text/javascript" src="${path}/js/shade.js"></script>
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
    <div class="logo"><a href="UserServlet/ProductServlet"><img src="${path}/images/logo.png"/></a></div>
    <div class="search">
        <form>
            <input type="text" value="" class="s_ipt"/>
            <input type="submit" value="搜索" class="s_btn"/>
        </form>
    </div>
    <div class="i_car">
        <div class="car_t">购物车 [ <span>${fn:length(cartUtil.cartSubs)}</span> ]</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.user_login_permission==null}">
                <div class="un_login">还未登录！<a href="${path}/login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！
                </div>
            </c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <c:set value="0" var="sum"/>
                <c:forEach var="item" items="${cartUtil.cartSubs}">
                    <li>
                        <div class="img"><a href="#"><img src="${path}/images/${item.product.ep_img}" width="58"
                                                          height="58"/></a></div>
                        <div class="name"><a href="#">${item.product.ep_name}</a></div>
                        <div class="price"><font color="#ff4e00">￥${item.product.ep_price}</font> X${item.esc_quantity}
                        </div>
                    </li>
                    <c:set value="${sum + item.totalPrice}" var="sum"/>
                </c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>${sum}</span></div>
            <c:if test="${sessionScope.user_login_permission==null}">
                <div class="price_a"><a href="${path}/login.jsp">马上登录</a></div>
            </c:if>
            <c:if test="${sessionScope.user_login_permission!=null}">
                <div class="price_a"><a href="${path}/jsp/BuyCar.jsp">去购物车结算</a></div>
            </c:if>
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
            <div class="leftNav none">
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
            </div>
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
    <div class="postion">
        <span class="fl">全部 > ${product.epp_name} > ${product.epc_name} > ${product.epch_name} </span>
    </div>
    <div class="content">
        <div id="tsShopContainer">
            <div id="tsImgS"><a href="${path}/images/${product.ep_img}" title="Images" class="MagicZoom" id="MagicZoom"><img
                    src="${path}/images/${product.ep_img}" width="390" height="390"/></a></div>

            <img class="MagicZoomLoading" width="16" height="16" src="images/loading.gif" alt="Loading..."/>
        </div>

        <div class="pro_des">
            <div class="des_name">
                <p>${product.ep_name}</p>
                ${product.ep_description}
            </div>
            <div class="des_price">
                本店价格：<b>￥${product.ep_price}</b><br/>
            </div>
            <div class="des_price">
                库存：<b>${product.ep_stock}</b><br>
            </div>
            <div class="des_choice">
                <span class="fl">型号选择：</span>
                <ul>

                </ul>
            </div>
            <div class="des_choice">
                <span class="fl">颜色选择：</span>
                <ul>

                </ul>
            </div>
            <div class="des_join">
                <div class="j_nums">
                    <input id="my_quantity" value="1" name="quantity" class="n_ipt" type="text">
                    <input value="" onclick="addUpdate(jq(this));" class="n_btn_1" type="button">
                    <input value="" onclick="jianUpdate(jq(this));" class="n_btn_2" type="button">
                </div>
                <span>
                     <img src="${path}/images/j_car.png" onclick="addCart()">
                </span>
            </div>
            <script>
                function addCart() {
                    var quantity = jQuery("#my_quantity").val();
                    location.href = '${path}/UserServlet/CartServlet?action=addCart&ep_id=${product.ep_id}&quantity=' + quantity;
                }
            </script>
        </div>
    </div>
    <div class="content mar_20">
        <div id="favoriteList">
            <div class="l_history">
                <div class="fav_t" id="history">我的收藏</div>

            </div>
        </div>
        <div class="l_list">
            <div class="des_border">
                <div class="des_tit">
                    <ul>
                        <li class="current"><a href="#p_attribute">商品属性</a></li>
                        <li><a href="#p_details">商品详情</a></li>
                    </ul>
                </div>
                <div class="des_con" id="p_attribute">
                    <table style="width:100%; font-family:'宋体'; margin:10px auto;" cellspacing="0" cellpadding="0"
                           border="0" align="center">
                        <tbody>
                        <tr>
                            <td>商品名称：${product.ep_name}</td>
                            <td>商品价格：${product.ep_price}</td>
                            <td>品牌： ${product.ep_brand}</td>

                        </tr>
                        <tr>
                            <td>描述：${product.ep_description}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="des_border" id="p_details">
                <div class="des_t">商品详情</div>
                <div class="des_con">
                    <table style="width:745px; font-size:14px; font-family:'宋体';" cellspacing="0" cellpadding="0"
                           border="0" align="center">
                        <tbody>
                        <tr>
                            <td>

                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <p align="center">
                        <img src="${path}/images/${product.ep_img}" width="185" height="155">
                    </p>
                </div>
            </div>
        </div>
    </div>

    <!--Begin 弹出层-加入购物车 Begin-->
    <div id="fade1" class="black_overlay"></div>
    <div id="MyDiv1" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img
                        src="images/close.gif"/></span>
            </div>
            <div class="notice_c">

                <table border="0" align="center" style="margin-top: auto" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="40"><img src="images/suc.png"/></td>
                        <td>
                            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;">宝贝已成功添加到购物车</span><br/>
                            购物车共有1种宝贝（3件） &nbsp; &nbsp; 合计：1120元
                        </td>
                    </tr>
                    <tr height="50" valign="bottom">
                        <td>&nbsp;</td>
                        <td><a href="#" class="b_sure">去购物车结算</a><a href="#" class="b_buy">继续购物</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!--End 弹出层-加入购物车 End-->


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

<script src="js/ShopShow.js"></script>

</html>
