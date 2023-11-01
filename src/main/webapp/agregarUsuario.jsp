<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 17/10/2023
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Agregar Usuario</title>
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
<div class="row justify-content-lg-center">
    <div class="row justify-content-lg-center col-12">
<h1>Agregar Usuario</h1>
    </div>
<form action="${pageContext.request.contextPath}/usuario.do?op=agregar" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Nombre</label>
        <input type="text" name="nombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <small class="text-danger">${errorNombre}</small>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Apellido</label>
        <input type="text" name="apellido" class="form-control" id="exampleInputPassword1">
        <small class="text-danger">${errorApellido}</small>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
        <small class="text-danger">${errorEmail}</small>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Pais</label>
        <input type="text" name="pais" class="form-control" id="exampleInputEmail3" aria-describedby="emailHelp">
        <small class="text-danger">${errorPais}</small>
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>
</body>
</html>
