<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-11">
        <h1>Заказ <span class="g-main__subtitle">№:${order.id}  Дата заказа:${order.dataCreate} 
        <c:choose>
            <c:when test="${order.status == 'Активен'}">
                <span class="badge badge-warning">${order.status}</span>
            </c:when>
            <c:when test="${order.status == 'Выполнен'}">
                <span class="badge badge-success">${order.status}</span>
            </c:when>
            <c:otherwise>
                <span class="badge badge-primary">${order.status}</span>
            </c:otherwise>
        </c:choose>
        </span></h1>
    </div>
    <div class="col-1">
        <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/managerPage?pageName=Orders"
           role="button">
            <i class="col-1 bi bi-arrow-90deg-left"> Назад</i>
        </a>
    </div>
</div>
<%--<div class="d-flex bd-highlight mb-3">
    <div class="p-2 bd-highlight">Flex элемент</div>
    <div class="p-2 bd-highlight">Flex элемент</div>
    <div class="ml-auto p-2 bd-highlight">
        <button type="button" class="btn btn-outline-primary">
            <i class="col-1 bi bi-arrow-90deg-left"> Назад</i>
        </button>
    </div>
</div>--%>
<div class="row">
    <div class="col-12">
        <section class="g-section">
            <h4>Клиент</h4>
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">Фамилия<br>
                    <input type="text" class="form-control" value="${order.client.surname}"></label>

                <label class="col-sm-2 col-form-label">Имя<br>
                    <input type="text" class="form-control" value="${order.client.name}"></label>

                <label class="col-sm-3 col-form-label">Отчество<br>
                    <input type="text" class="form-control" value="${order.client.patronymic}"></label>

                <label class="col-sm-2 col-form-label">Телефон<br>
                    <input type="text" class="form-control" value="${order.client.phoneNumber}"></label>
                <label class="col-sm-2 col-form-label">Эл. адрес<br>
                    <input type="email" class="form-control"></label>
            </div>
            <h4>Доставка <span class="g-main__subtitle">(${order.delivery.name})</span></h4>
            <div class="mb-3 row">
                <label class="col-sm-3 col-form-label">Город<br>
                    <input type="text" class="form-control" value="${order.client.address.city}"></label>

                <label class="col-sm-2 col-form-label">Ул.<br>
                    <input type="text" class="form-control" value="${order.client.address.street}"></label>

                <label class="col-sm-3 col-form-label">Дом.<br>
                    <input type="text" class="form-control" value="-"></label>

                <label class="col-sm-2 col-form-label">Корп.<br>
                    <input type="text" class="form-control" value="-"></label>
                <label class="col-sm-2 col-form-label">Индекс<br>
                    <input type="email" class="form-control" value="${order.client.address.postalCode}"></label>
            </div>
            <h4>Товар</h4>
            <c:if test="${not empty order.products}">
                <table class="table">
                    <thead class="thead">
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Цена</th>
                        <th scope="col">Категория</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${order.products}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.section}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty order.products}">
                Заказов нет!
            </c:if>
        </section>
    </div>
</div>
