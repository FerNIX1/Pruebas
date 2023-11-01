package com.crud.crud_usuario.controler;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.crud.crud_usuario.beans.UsuariosBean;
import com.crud.crud_usuario.model.UsuariosModel;

import java.io.IOException;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario.do"})
public class UsuarioServlet extends HttpServlet {

    UsuariosModel modelo = new UsuariosModel();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("op") == null) {
                listar(request, response);
                return;
            }
            String operacion = request.getParameter("op");
            switch (operacion) {
                case "listar":
                    listar(request, response);
                    break;
                case "agregar":
                    agregar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "actualizar":
                    // Manejar la operación de actualizar
                    actualizar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    private void listar(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("listaUsuarios",modelo.ListarUsuarios());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (SQLException | ServletException | IOException exception ){
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE,null,exception);
        }

    }
    private void agregar(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        //para validar
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (nombre.equals("")) {
            request.setAttribute("errorNombre", "Nombre vacío");
        } else if (!nombre.matches("[A-Za-záéíóúÁÉÍÓÚñÑ ]+")) {
            request.setAttribute("errorNombre", "Nombre no válido");
        }

        if (apellido.equals("")) {
            request.setAttribute("errorApellido", "Apellido vacío");
        } else if (!apellido.matches("[A-Za-záéíóúÁÉÍÓÚñÑ ]+")) {
            request.setAttribute("errorApellido", "Apellido no válido");
        }

        if (email.equals("")) {
            request.setAttribute("errorEmail", "Email vacío");
        } else if (!email.matches(emailRegex)) {
            request.setAttribute("errorEmail", "Correo electrónico no válido");
        }
        if(pais.equals("")){
            request.setAttribute("errorPais","Pais Vacio");
        }
        if (request.getAttribute("errorNombre") != null || request.getAttribute("errorApellido") != null || request.getAttribute("errorEmail") != null||request.getAttribute("errorPais")!=null) {
            // Uno o más campos tienen errores, redirige de vuelta al formulario en caso de errores
            try {
                request.getRequestDispatcher("agregarUsuario.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else {
            UsuariosBean nuevoUsuario = new UsuariosBean();
            nuevoUsuario.setUsr_nombre(nombre);
            nuevoUsuario.setUsr_apellido(apellido);
            nuevoUsuario.setUsr_email(email);
            nuevoUsuario.setUsr_pais(pais);

            try {
                modelo.agregarUsuario(nuevoUsuario);
                // Puedes redirigir a la página de listado u otra página después de agregar exitosamente.
                response.sendRedirect(request.getContextPath() + "/usuario.do?op=listar");
            } catch (SQLException | IOException e) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
    private void editar(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int userId = Integer.parseInt(idStr);
                UsuariosBean usuario = modelo.obtenerUsuarioPorId(userId);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
            } catch (NumberFormatException | SQLException | ServletException | IOException e) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        // Obtener los datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");

        // Crear un objeto UsuariosBean con los nuevos datos
        UsuariosBean usuarioActualizado = new UsuariosBean();
        usuarioActualizado.setId(id);
        usuarioActualizado.setUsr_nombre(nombre);
        usuarioActualizado.setUsr_apellido(apellido);
        usuarioActualizado.setUsr_email(email);
        usuarioActualizado.setUsr_pais(pais);

        try {
            // Actualizar el usuario en la base de datos
            modelo.actualizarUsuario(usuarioActualizado);
            // Redirigir a la página de listado después de la actualización
            response.sendRedirect(request.getContextPath() + "/usuario.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        // Obtener el ID del usuario a eliminar
        int idUsuario = Integer.parseInt(request.getParameter("id"));

        try {
            // Eliminar el usuario de la base de datos
            modelo.eliminarUsuario(idUsuario);

            // Redirigir a la página de listado después de la eliminación
            response.sendRedirect(request.getContextPath() + "/usuario.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
