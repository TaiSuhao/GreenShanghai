<%--
  Created by IntelliJ IDEA.
  User: 95632
  Date: 2019/5/25
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>

<body style="margin: -2px">

<iframe src="head.jsp" scrolling="no" width="100%" height="90px"></iframe>
<section class="sec">
    <form action="UserAction_login" method="post">
        <div class="register-box">
            <label for="username" class="username_label">
                用 户 名
                <input maxlength="20" name="username" type="text"
                       placeholder="您的用户名和登录名"/>
            </label>
            <div class="tips">
            </div>
        </div>

        <div class="register-box">
            <label for="username" class="other_label">
                设 置 密 码
                <input maxlength="20" type="password" name="password"
                       placeholder="建议至少使用两种字符组合"/>
            </label>
            <div class="tips">
                <font color="red">
                    <s:property value="error" />
                </font>
            </div>
        </div>

        <div class="submit_btn">
            <button type="submit" id="submit_btn">
                立 即 登录
            </button>
        </div>
    </form>
</section>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</body>
