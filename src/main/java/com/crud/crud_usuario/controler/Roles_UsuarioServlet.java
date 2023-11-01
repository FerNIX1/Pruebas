package com.crud.crud_usuario.controler;


import com.crud.crud_usuario.beans.RolesBean;
import com.crud.crud_usuario.beans.Roles_Usuario_Bean;
import com.crud.crud_usuario.model.Roles_UsuarioModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Roles_UsuarioServlet", urlPatterns = {"/roles_usuario.do"})
public class Roles_UsuarioServlet extends HttpServlet {
    Roles_UsuarioModel modelo = new Roles_UsuarioModel();
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
                    listar(request,response);
                    break;
                case "agregar":
                    agregar(request,response);
                    break;
                case "eliminar":
                    eliminar(request,response);
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
            request.setAttribute("listaRolesUsuario",modelo.ListarRolesUsuario());
            request.getRequestDispatcher("rolesUsuario.jsp").forward(request,response);
        }catch (SQLException | ServletException | IOException exception ){
            Logger.getLogger(Roles_UsuarioServlet.class.getName()).log(Level.SEVERE,null,exception);
        }

    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {

        int idRol = Integer.parseInt(request.getParameter("id"));

        try {
            modelo.eliminarRolUsuario(idRol);
            response.sendRedirect(request.getContextPath() + "/roles_usuario.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(Roles_UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void agregar(HttpServletRequest request, HttpServletResponse response) {
        String idUsuario = request.getParameter("rlu_usr_id");
        String idRol = request.getParameter("rlu_rl_id");
        if(idUsuario.equals("")){
            request.setAttribute("errorUsuarioID","EL Id del usuario esta vacio");
        }
        if(idRol.equals("")){
            request.setAttribute("errorRolID","El id de rol esta vacio");
        }
        if (request.getAttribute("errorUsuarioID") != null || request.getAttribute("errorRolID") != null ) {
            // Uno o más campos tienen errores, redirige de vuelta al formulario en caso de errores
            try {
                request.getRequestDispatcher("agregarRolUsuario.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        Roles_Usuario_Bean nuevoRolUserBean = new Roles_Usuario_Bean();
        nuevoRolUserBean.setRlu_usr_id(Integer.parseInt(idUsuario));
        nuevoRolUserBean.setRlu_rl_id(Integer.parseInt(idRol));
        try {
            modelo.agregarRolesUsuarios(nuevoRolUserBean);
            // Puedes redirigir a la página de listado u otra página después de agregar exitosamente.
            response.sendRedirect(request.getContextPath() + "/roles_usuario.do?op=listar");
        } catch (SQLException | IOException e) {
            Logger.getLogger(Roles_UsuarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
