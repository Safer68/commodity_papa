<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="d-flex bd-highlight mb-3">
    <div class="p-2 bd-highlight"><h2>Заказы</h2></div>
    <div class="ml-auto p-2 bd-highlight">
        <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/managerPage?pageName=newOrder"
           role="button">
            <i class="col-1 bi bi-plus-circle"> Создать</i>
        </a>
    </div>
</div>
<%--<div class="row">
    <div class="col-10">
        <h1>Заказы</h1>
    </div>
    <div class="col-2">
            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/managerPage?pageName=Orders"
               role="button">
                <i class="col-1 bi bi-plus-circle"> Создать</i>
            </a>
        </div>
</div>--%>
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
                    <th scope="col">Клиент</th>
                    <th scope="col">Сумма заказа</th>
                    <th scope="col">Доставка</th>
                    <th scope="col">Статус заказа</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}" varStatus="status">
                    <c:choose>
                        <c:when test="${order.status == 'Активен'}">
                            <tr class="table-warning">
                        </c:when>
                        <c:when test="${order.status == 'Выполнен'}">
                            <tr class="table-success">
                        </c:when>
                        <c:otherwise>
                            <tr>
                        </c:otherwise>
                    </c:choose>
                        <td>${order.id}</td>
                        <td>${order.dataCreate}</td>
                        <td>
                            <select name="product">
                                <c:forEach var="product" items="${order.products}" varStatus="status">
                                <option>${product.description}</option>
                                </c:forEach>
                        </td>
                        <td>${order.client.name}</td>
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
                                        data-bs-target="#OtderForm"
                                        data-сreate="${order}"
                                        data-order-client-name="${order.client.name}"
                                        order-price="${order.price}">
                                    Информация
                                </button>
                                <form action="${pageContext.request.contextPath}/managerPage" name="deleting"
                                      method="post">
                                    <input type="hidden" name="orderId" value="${order.id}"/>
                                    <input type="hidden" name="pageName" value="Order"/>
                                    <button class="dropdown-item">Информация</button>
                                </form>
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
<div class="modal fade" id="OtderForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/home?pageName=task" method="post">
                <div class="modal-body">
                    Дата заказа <input id="dataCreate" name="Name" class='lf--input' type="Name"><br><br>
                    Клиент <input id="clientName" name="Name" class='lf--input' type="Name"><br><br>
                    Сумма заказа <input id="orderPrice" name="Name" class='lf--input' type="Name"><br><br>
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
                var dataCreate = $(this).attachInternals('data-сreate');
                var clientName = $(this).attr('data-order-client-name');
                var orderPrice = $(this).attr('order-price');
                $("#dataCreate").text(dataCreate.attr)
                $("#clientName").val(clientName)
                $("#orderPrice").val(orderPrice)
            })
    });
</script>
