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
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-8 offset-4">
            <h2>Регистрация</h2>
            <form method="post" action="/register" onsubmit="return validateForm()">
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="username" placeholder="Имя" name="username"
                           oninput="validateName()">
                    <span id="nameError" style="display: none;">*Поле 'Имя' не заполнено!</span>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="userlastname" placeholder="Фамилия"
                           name="userlastname" oninput="validateLastName()">
                    <span id="userlastnameError" style="display: none;">*Поле 'Фамилия' не заполнено!</span>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="useremail" placeholder="Email"
                           name="useremail" oninput="validateEmail()">
                    <span id="emailError" style="display: none;">*Поле 'Email' не заполнено!</span>
                    <span id="validationErr" style="display: none;">*Неверный формат email адреса!</span>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="userpassword" placeholder="Пароль"
                           name="userpassword" oninput="validatePass()">
                    <span id="passwordError" style="display: none;">*Поле 'Пароль' не заполнено!</span>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control w-25" id="repeatpassword" placeholder="Повторите пароль"
                           name="reapetpassword" oninput="validateRepeatPass()">
                    <span id="repeatPassError" style="display: none;">*Поле 'Повторите пароль' не заполнено!</span>
                    <span id="matchingError" style="display: none;">*Пароли не совпадают!</span>
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
