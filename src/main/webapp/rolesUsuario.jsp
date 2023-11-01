<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
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
<div class="row">
    <div class="container">
        <h3 class="text-center">Lista de Roles De Usuario</h3>
        <hr>
        <div class="container text-left">
        </div>
        <br>
        <a class="btn btn-primary" href="agregarRolUsuario.jsp" role="button">Agregar Nuevo Rol con usuario</a>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Usuario_id</th>
                <th>Rol_id</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="rol" items="${requestScope.listaRolesUsuario}">
                <tr>
                    <td>${rol.rlu_id}</td>
                    <td>${rol.rlu_usr_id}</td>
                    <td>${rol.rlu_rl_id}</td>
                    <td><a href="${pageContext.request.contextPath}/roles_usuario.do?op=eliminar&id=${rol.rlu_id}" class="btn btn-danger">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
