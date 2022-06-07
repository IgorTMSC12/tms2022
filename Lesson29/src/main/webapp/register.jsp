<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-8 offset-4">
            <h2>Регистрация</h2>
            <form method="post" action="/register">
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="username" placeholder="Имя" name="username"
                           required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="userlastname" placeholder="Фамилия"
                           name="userlastname"
                           required>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control w-25" id="useremail" placeholder="Email" name="useremail"
                           required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="userpassword" placeholder="Пароль"
                           name="userpassword"
                           required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
