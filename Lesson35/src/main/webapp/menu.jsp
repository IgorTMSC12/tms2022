<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/eshop?command=sign-in">Главная</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/eshop?command=user-cabinet-page">Личный кабинет</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/eshop?command=redirect-to-shopping-cart">Корзина</a>
        </li>
        <form method="post" class="form-inline" action="/eshop?command=search-page">
            <input class="form-control mr-sm-2" type="text" name="search" placeholder="Search">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
    </ul>
</nav>
</body>
</html>


