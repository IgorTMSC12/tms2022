<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="menu.jsp"/>
<br>
${name}
<div class="container-fluid">
    <c:if test="${not empty products}">
        <c:forEach items="${products}" var="product">
            <div class="card-body">
                <div class="row">
                    <div class="col-1">
                        <a href="/eshop?command=product-redirect&productId=${product.getId()}">
                            <img style="width:100%;height:100%"
                                 src="${contextPath}/images/image_product/${product.getImageName()}"
                                 alt="${product.getImageName()}"></a>
                    </div>
                    <div class="col-11">
                        <b>Модель:</b> ${product.getName()}<br>
                        <b>Описание:</b> ${product.getDescription()}<br>
                        <b>Цена:</b> ${product.getPrice()} руб.
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
