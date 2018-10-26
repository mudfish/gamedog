<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <!--<link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/jquery-3.3.1.js"></script>-->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

    <style type="text/css">
        .login-form {
            width: 340px;
            margin: 50px 0px;
        }

        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            $("#login-form").validate({
                rules: {
                    account: "required",
                    password: "required",
                },
                messages: {
                    account: "请输入账号",
                    password: "请输入密码",
                }
            });
        });

    </script>
</head>
<body>
<div class="login-form">
    <form class="login-form" id="login-form" action="login">
        <h3 class="text-center">管理员登录</h3>

        <div class="form-group">
            <input type="text" id="account" name="account" class="form-control" placeholder="账号" autocomplete="off">
        </div>
        <div class="form-group">
            <input type="password" id="password" name="password" class="form-control" placeholder="密码"
                   autocomplete="off">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">登录</button>
        </div>
        <div class="form-group">
            <p id="error" class="bg-danger"></p>
        </div>
    </form>
</div>
</body>
</html>