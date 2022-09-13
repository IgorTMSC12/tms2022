<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="menu.jsp"/>
<div class="container-fluid">
    <c:if test="${not empty products}">
        <c:forEach items="${products}" var="product">
            <div class="card-body">
                <div class="row">
                    <div class="col-1">
                        <c:forEach items="${images}" var="image">
                            <c:if test="${image.getProduct().getId() == product.getId()}">
                                <a href="/product?productId=${product.getId()}">
                                    <img style="width:100%; height:100%"
                                         src="${contextPath}/images/image_product/${image.getImagePath()}"></a>
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="col-11">
                        <h4><b>Модель:</b> ${product.getName()}<br></h4>
                        <h5><b>Описание:</b> ${product.getDescription()}<br></h5>
                        <h5><b>Цена:</b> ${product.getPrice()} руб.</h5>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <div class="pages">
        <c:if test="${not empty number_of_pages}">
            <c:forEach items="${number_of_pages}" var="page">
                <a href="${contextPath}/search/${search}/${page}">
                        ${page} </a>
            </c:forEach>
        </c:if>
    </div>

    <c:if test="${empty products}">
    <h4><b>По Вашему зпросу ничего не найдено</b>
        </c:if>
</div>
</body>
</html>
