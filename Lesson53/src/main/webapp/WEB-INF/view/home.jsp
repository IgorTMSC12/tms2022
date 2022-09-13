<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Categories</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="menu.jsp"/>
<h2>Popular categories</h2>

<div class="container-fluid">
    <c:if test="${not empty categories}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-25 m-1" type="category">
                    <div class="card-body">
                        <a>${category.getName()}</a>
                        <c:forEach items="${imagesCategories}" var="imageCategory">
                            <c:if test="${category.getId() == imageCategory.getCategory().getId()}">
                                <a href="/category?categoryId=${category.getId()}&categoryName=${category.getName()}">
                                    <img class="card-img" style="width:150px;height:120px"
                                         src="${contextPath}/images/${imageCategory.getImagePath()}"
                                         alt="Card image"></a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</div>
<br>
<div class="container-fluid">
    <div class="card" style="width:300px">
        <div class="card-body w-20 m-1">
            <form method="post" enctype="multipart/form-data" action="${contextPath}/home/import">
                <h6>File to upload:</h6>
                <input type="file" name="file"><br>
                <input type="submit" value="Upload">
            </form>
            <br>
            <h6>Download:</h6>
            <a href="${contextPath}/home/export">
                <input type="submit" value="Download CSV File"></a>
        </div>
    </div>
</div>
</body>
</html>