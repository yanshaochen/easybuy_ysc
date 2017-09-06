<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ include file="header.jsp" %>
<title>登录</title>

<!--Begin Login Begin-->
<input id="status" value="${status}" style="display: none">
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="regist.jsp"><img src="images/logo.png"/></a></div>
    </div>
    <div class="login">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425"/></div>
        <div class="log_c">
            <!-- 登录的表单   -->
            <form id="login" action="UserServlet/LoginServlet?type=user" method="post">
                <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="55">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">登录</span>
                            <span class="fr">还没有商城账号，<a href="regist.jsp" style="color:#ff4e00;">立即注册</a></span>
                        </td>
                    </tr>
                    <tr height="70">
                        <td>用户名</td>
                        <td><input type="text" value="" name="loginName" class="l_user"/></td>
                    </tr>
                    <tr height="70">
                        <td>密&nbsp; &nbsp; 码</td>
                        <td><input type="password" value="" name="password" class="l_pwd"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox"/></label><label class="r_txt">请保存我这次的登录信息</label>
                    </span>
                            <span class="fr"><a href="#" style="color:#ff4e00;">忘记密码</a></span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="登录" class="log_btn"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical
        Support: Dgg Group <br/>
        <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98" height="33"/><img
            src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98" height="33"/><img
            src="images/b_5.gif" width="98" height="33"/><img src="images/b_6.gif" width="98" height="33"/>
    </div>
</div>


<%@ include file="footer.jsp" %>
<!-- 引入自身特有的js -->
<script type="text/javascript">
    jQuery(function ($) {
        if ($("#status").val() === "failed") {
            alert("用户名或密码错误");
        }
        $("#login").validate({
            //鼠标失去焦点立刻验证
            onfocusout: function (element) {
                $(element).valid()
            },
            //验证规则
            rules: {
                loginName: {
                    required: true,
                    //ajax 异步验证
                    remote: {
                        type: "POST",
                        url: "UserServlet/AjaxValidateServlet",
                        dataType: "html",
                        data: {
                            loginName: function () { //登录用户名
                                return $("[name='loginName']").val();
                            }
                        },
                        dataFilter: function (data, type) {  //登录和注册相反
                            if (data == "false") {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 12
                }
            },
            //错误信息提示
            messages: {
                loginName: {
                    required: "请输入用户名",
                    remote: "无此用户"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码长度不能少于6位",
                    maxlength: "密码长度不能大于12位"
                }
            }
        });
    })
</script>
