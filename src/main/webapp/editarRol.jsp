<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 17/10/2023
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <title>Editar</title>
</head>
<body>
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
      </div>
    </div>
  </div>
</nav>
<div class="row justify-content-lg-center">
  <div class="row justify-content-lg-center col-12">
    <h1>Editar Rol</h1>
  </div>
  <form action="${pageContext.request.contextPath}/roles.do?op=actualizar" method="post">
    <input type="hidden" name="id" value="${rol.rl_id}">
    <input type="text" name="nombre" value="${rol.rl_nombre}">
    <button type="submit" class="btn btn-primary">Enviar</button>
  </form>
</div>
</body>
</body>
</html>
