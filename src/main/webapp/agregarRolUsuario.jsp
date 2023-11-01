<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 18/10/2023
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>AgregarRolUsuario</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/usuario.do?op=listar">Crud_Usuario</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/roles.do?op=listar">Crud_roles</a>
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/roles_usuario.do?op=listar">Crud_roles_Usuario</a>
            </div>
        </div>
    </div>
</nav>
<div class="container mt-3">
    <h3>Agregar Nuevo Rol Usuario</h3>
    <form action="${pageContext.request.contextPath}/roles_usuario.do?op=agregar" method="post">
        <!-- Agrega los campos del formulario según la estructura de tu tabla -->
        <div class="mb-3">
            <label for="rlu_usr_id" class="form-label">Usuario ID:</label>
            <input type="text" class="form-control" id="rlu_usr_id" name="rlu_usr_id">
            <small class="text-danger">${errorUsuarioID}</small>
        </div>
        <div class="mb-3">
            <label for="rlu_rl_id" class="form-label">Rol ID:</label>
            <input type="text" class="form-control" id="rlu_rl_id" name="rlu_rl_id">
            <small class="text-danger">${errorRolID}</small>
        </div>
        <button type="submit" class="btn btn-primary">Agregar Rol Usuario</button>
    </form>
</div>

</body>
</html>
