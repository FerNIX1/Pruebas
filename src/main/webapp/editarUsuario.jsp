<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 17/10/2023
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <title>Editar Usuario</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <!-- ... Tu barra de navegación ... -->
</nav>
<div class="row justify-content-lg-center">
  <div class="row justify-content-lg-center col-12">
    <h1>Editar Usuario</h1>
  </div>
  <form action="${pageContext.request.contextPath}/usuario.do?op=actualizar" method="post">
    <input type="hidden" name="id" value="${usuario.id}">
    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre</label>
      <input type="text" name="nombre" class="form-control" id="nombre" value="${usuario.usr_nombre}">
    </div>
    <div class="mb-3">
      <label for="apellido" class="form-label">Apellido</label>
      <input type="text" name="apellido" class="form-control" id="apellido" value="${usuario.usr_apellido}">
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" name="email" class="form-control" id="email" value="${usuario.usr_email}">
    </div>
    <div class="mb-3">
      <label for="pais" class="form-label">País</label>
      <input type="text" name="pais" class="form-control" id="pais" value="${usuario.usr_pais}">
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
  </form>
</div>
</body>
</html>
