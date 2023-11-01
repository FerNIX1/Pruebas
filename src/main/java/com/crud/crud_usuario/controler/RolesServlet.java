package com.crud.crud_usuario.controler;

import com.crud.crud_usuario.beans.RolesBean;
import com.crud.crud_usuario.beans.UsuariosBean;
import com.crud.crud_usuario.model.RolesModel;
import com.crud.crud_usuario.model.UsuariosModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RolesServlet", urlPatterns = {"/roles.do"})
public class RolesServlet extends HttpServlet {
    RolesModel modelo = new RolesModel();
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
                    agregar(request,response);
                    break;
                case "editar":
                    editar(request,response);
                    break;
                case "actualizar":
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
            request.setAttribute("listaRoles",modelo.ListarRoles());
            request.getRequestDispatcher("roles.jsp").forward(request,response);
        }catch (SQLException | ServletException | IOException exception ){
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE,null,exception);
        }

    }
    private void agregar(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        if(nombre.equals("")){
            request.setAttribute("errorNombre","Nombre vacio");
        }
        if (request.getAttribute("errorNombre") != null) {
            // Uno o más campos tienen errores, redirige de vuelta al formulario en caso de errores
            try {
                request.getRequestDispatcher("agregarRol.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        RolesBean nuevoRolBean = new RolesBean();
        nuevoRolBean.setRl_nombre(nombre);
        try {
            modelo.agregarRoles(nuevoRolBean);
            request.removeAttribute("errorNombre");
            // Puedes redirigir a la página de listado u otra página después de agregar exitosamente.
            response.sendRedirect(request.getContextPath() + "/roles.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void editar(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int userId = Integer.parseInt(idStr);
                RolesBean rol = modelo.obtenerRolesPorId(userId);
                request.setAttribute("rol", rol);
                request.getRequestDispatcher("editarRol.jsp").forward(request, response);
            } catch (NumberFormatException | SQLException | ServletException | IOException e) {
                Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        // Obtener los datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        // Crear un objeto UsuariosBean con los nuevos datos
        RolesBean RolActualizado = new RolesBean();
        RolActualizado.setRl_id(id);
        RolActualizado.setRl_nombre(nombre);
        try {
            // Actualizar el usuario en la base de datos
            modelo.actualizarRol(RolActualizado);
            // Redirigir a la página de listado después de la actualización
            response.sendRedirect(request.getContextPath() + "/roles.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {

        int idRol = Integer.parseInt(request.getParameter("id"));

        try {
            modelo.eliminarRol(idRol);

            response.sendRedirect(request.getContextPath() + "/roles.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(RolesServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
