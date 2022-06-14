<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <c:import url="client/partials/head.jsp"/>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jvectormap@2.0.4/jquery-jvectormap.min.css">
<div class="g-navigation fixed-top">
    <c:import url="client/partials/navigation.jsp"/>
</div>
<div class="g-container">
    <div class="col-12">
        <h1>Container</h1>
    </div>
    <main class="g-main container-fluid">
        <jsp:include page="../${sessionScope.pagePath}"/>
    </main>
</div>

<footer class="g-footer text-right">
    <span class="e-site-emphasize">Commodity Papa</span>
</footer>
<script src="resources/assets/js/custom.js"></script>
<div class="modal fade" id="userForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/clientPage" method="post">
                <div class="modal-body">
                    Name <input value="${UserName.name}" name="newName" class='lf--input'
                                type="Name"><br><br>
                    <input type="hidden" name="update" value="update"/>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>
