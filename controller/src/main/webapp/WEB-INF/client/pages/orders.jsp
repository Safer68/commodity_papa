<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-12">
        <h1>Заказы<span class="g-main__subtitle">nice and clean</span></h1>
    </div>
</div>
<div class="row">
    <div class="col-12">
        <section class="g-section">
            <c:if test="${not empty orders}">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">№</th>
                    <th scope="col">Дата заказа</th>
                    <th scope="col">Товар</th>
                    <th scope="col">Сумма заказа</th>
                    <th scope="col">Доставка</th>
                    <th scope="col">Статус заказа</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}" varStatus="status">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.dataCreate}</td>
                        <td>
                            <select name="login">
                                <c:forEach var="product" items="${order.products}" varStatus="status">
                                <option>${product.description}</option>
                                </c:forEach>
                        </td>
                        <td>${order.price}</td>
                        <td>${order.delivery.name}</td>
                        <td>${order.status}</td>
                        <td>
                            <a class="g-header__nav-link"
                               data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <i class="g-header__icon--caret fas fa-caret-down"></i>
                            </a>
                            <div class="g-notification dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item js-course-detail"
                                        data-bs-toggle="modal"
                                        data-bs-target="#orderForm"
                                        data-create="${order.dataCreate}"
                                        data-price="${order.price}">
                                    Информация
                                </button>
                                <button class="dropdown-item js-course-detail"
                                        data-bs-toggle="modal"
                                        data-bs-target="#orderForm"
                                        data-create="${order.dataCreate}"
                                        data-price="${order.price}">
                                    Заказ получен
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
            <c:if test="${empty orders}">
            Заказов нет!
            </c:if>
    </div>
    </section>
</div>
<div class="modal fade" id="orderForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/home?pageName=task" method="post">
                <div class="modal-body">
                    Дата заказа <input id="dataCreate" name="Name" class='lf--input' type="Name"><br><br>
                    Сумма заказа <input id="datadPrice" name="Name" class='lf--input' type="Name"><br><br>

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
                var dataCreate = $(this).attr('data-create');
                var datadPrice = $(this).attr('data-price');
                $("#dataCreate").val(dataCreate)
                $("#datadPrice").val(datadPrice)
            })
    });
</script>