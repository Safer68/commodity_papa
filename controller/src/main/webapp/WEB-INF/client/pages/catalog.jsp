<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-12">
        <h1>Каталог</h1>
    </div>
</div>
<div class="row">
    <div class="col-12">
        <section class="g-section">
            <c:if test="${not empty products}">
                <table class="table">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Цена</th>
                        <th scope="col">Категория</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}" varStatus="status">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.section}</td>
                            <td>
                                <a class="g-header__nav-link"
                                   data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="g-header__icon--caret fas fa-caret-down"></i>
                                </a>
                                <div class="g-notification dropdown-menu dropdown-menu-right">
                                    <button class="dropdown-item js-course-detail"
                                            data-bs-toggle="modal"
                                            data-bs-target="#product"
                                            data-product-description="${product.description}"
                                            data-product-price="${product.price}"
                                            data-product="${product.id}"
                                            data-action="update">
                                        Информация
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty products}">
                Каталог пуст!
            </c:if>
        </section>
    </div>
</div>
<div class="modal fade" id="product" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/managerPage?pageName=Catalog" method="post">
                <div class="modal-body">
                    Описание <input id="productDescription" name="description" class='lf--input' type="Name"><br><br>
                    Цена <input id="productPrice" name="price" class='lf--input' type="Name"><br><br>
                    <input id="action" type="hidden" name="action"/>
                    <input id="productId" type="hidden" name="productId"/>
                </div>
                <div class="modal-footer">

                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".js-course-detail").click(
            function () {
                var productDescription = $(this).attr('data-product-description');
                var productPrice = $(this).attr('data-product-price');
                var dataProduct = $(this).attr('data-product');
                var dataAction = $(this).attr('data-action');

                $("#productDescription").val(productDescription)
                $("#productPrice").val(productPrice)
                $("#action").val(dataAction)
                $("#productId").val(dataProduct)

            })
    });
</script>
