<%--
  @Author: stone
  @Date: 2020/03/20 23:06:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>${options.optionSiteTitle} &lsaquo;登录</title>
    <link rel="stylesheet" href="/plugin/font-awesome/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/img/logo.jpg">
    <link rel='stylesheet' id='dashicons-css' href='/plugin/login/dashicons.min.css' type='text/css' media='all'/>
    <link rel='stylesheet' id='buttons-css' href='/plugin/login/buttons.min.css' type='text/css' media='all'/>
    <link rel='stylesheet' id='forms-css' href='/plugin/login/forms.min.css' type='text/css' media='all'/>
    <link rel='stylesheet' id='l10n-css' href='/plugin/login/l10n.min.css' type='text/css' media='all'/>
    <link rel='stylesheet' id='login-css' href='/plugin/login/login.min.css' type='text/css' media='all'/>
    <style type="text/css">
        body {
            font-family: "Microsoft YaHei", Helvetica, Arial, Lucida Grande, Tahoma, sans-serif;
            background: url(/img/loginBg.jpg);
            width: 100%;
            height: 100%;
        }

        .login h1 a {
            background-size: 220px 50px;
            width: 220px;
            height: 50px;
            padding: 0;
            margin: 0 auto 1em;
        }

        .login form {
            background: #fff;
            background: rgba(255, 255, 255, 0.6);
            border-radius: 2px;
            border: 1px solid #fff;
        }

        .login label {
            color: #000;
            font-weight: bold;
        }

        #backtoblog a, #nav a {
            color: #fff !important;
        }
    </style>
    <meta name="robots" content="noindex,follow"/>
    <meta name="viewport" content="width=device-width">
    <style>
        body {
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body class="login login-action-login wp-core-ui locale-zh-cn">
<div id="login">
    <h1><a href="/" title="欢迎登录本站!" tabindex="-1">${options.optionSiteTitle}</a></h1>
    <%
        String username = "";
        String password = "";
        //获取当前站点的所有Cookie
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            //对cookies中的数据进行遍历,找到用户名和密码
            if ("username".equals(cookies[i].getName())) {
                username = cookies[i].getValue();
            } else if ("password".equals(cookies[i].getName())) {
                password = cookies[i].getValue();
            }
        }
    %>
</div>

</body>
</html>
