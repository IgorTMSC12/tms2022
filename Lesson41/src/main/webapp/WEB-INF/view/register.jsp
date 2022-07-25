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
    <script type="text/javascript" src="/resources/script.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-8 offset-4">
            <h2>Регистрация</h2>
            <form method="post" action="/registration"
            ">
            <div class="form-group">
                <input type="text" class="form-control w-25" id="name" placeholder="Имя" name="name"">
                <span class="" error>${nameError}</span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control w-25" id="lastName" placeholder="Фамилия"
                       name="lastName"">
                <span class="" error>${lastNameError}</span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control w-25" id="email" placeholder="Email"
                       name="email">
                <span class="" error>${emailError}</span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control w-25" id="password" placeholder="Пароль"
                       name="password">
                <span class="" error>${passwordError}</span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control w-25" id="repeatpassword" placeholder="Повторите пароль"
                       name="repeatpassword">
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
