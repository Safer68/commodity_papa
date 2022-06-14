<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-12">
        <h1>Заказы</h1>
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
                    <th scope="col">Клиент</th>
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
                                <button class="dropdown-item"
                                        data-bs-toggle="modal"
                                        data-bs-target="#taskForm"
                                        data-task-name="${task.name}"
                                        data-task-curse="${task.curse}"
                                        data-task-action="newTask">
                                    Информация
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
<div class="modal fade" id="taskForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/home?pageName=task" method="post">
                <div class="modal-body">
                    Дата заказа <input id="taskName" name="Name" class='lf--input' type="Name"><br><br>
                    Curse: <select id="taskCurse" name="Course">
                    <c:forEach var="course" items="${courses}" varStatus="status">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
                </select><br>
                    <input id="action" type="hidden" name="action"/>
                    <input id="taskId" type="hidden" name="taskId"/>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".js-course-detail").click(
            function () {
                var dataTaskName = $(this).attr('data-task-name');
                var dataTaskId = $(this).attr('data-task-id');
                var dataTaskCurse = $(this).attr('data-task-curse');
                var dataTaskAction = $(this).attr('data-task-action');
                $("#taskName").val(dataTaskName)
                $("#taskCurse").val(dataTaskCurse)
                $("#action").val(dataTaskAction)
                $("#taskId").val(dataTaskId)
            })
    });
</script>
