package com.crud.crud_usuario.model;

import com.crud.crud_usuario.beans.RolesBean;
import com.crud.crud_usuario.beans.UsuariosBean;

import javax.management.relation.Role;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolesModel extends Conexion{
    public List<RolesBean> ListarRoles()throws SQLException {
        try{
            List<RolesBean> lista = new ArrayList<>();
            String Sql="SELECT * FROM roles;";
            this.conectar();
            st=conexion.prepareStatement(Sql);
            rs= st.executeQuery();
            while (rs.next()){
                RolesBean rolesBean= new RolesBean();
                rolesBean.setRl_id(rs.getInt("rl_id"));
                rolesBean.setRl_nombre(rs.getString("rl_nombre"));
                lista.add(rolesBean);
            }
            this.desconectar();
            return lista;
        }catch (SQLException e){
            Logger.getLogger(RolesModel.class.getName()).log(Level.SEVERE, null, e);
            this.desconectar();
            return null;
        }
    }
    public void agregarRoles(RolesBean nuevoRolbean) throws SQLException {
        try {
            String sql = "INSERT INTO roles (rl_nombre) VALUES (?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1,nuevoRolbean.getRl_nombre());
            st.executeUpdate();
            this.desconectar();
        } catch (SQLException e) {
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, e);
            this.desconectar();
        }
    }
    public RolesBean obtenerRolesPorId(int roleId) throws SQLException {
        try {
            RolesBean rolesBean = null;
            String sql = "SELECT * FROM roles WHERE rl_id = ?";  // Cambiar 'id' a 'rl_id'
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, roleId);
            rs = st.executeQuery();
            if (rs.next()) {
                rolesBean = new RolesBean();
                rolesBean.setRl_id(rs.getInt("rl_id"));
                rolesBean.setRl_nombre(rs.getString("rl_nombre"));
            }
            return rolesBean;
        } finally {
            this.desconectar();
        }
    }
    public void actualizarRol(RolesBean rolesBean) throws SQLException {
        try {
            String sql = "UPDATE roles SET rl_nombre=? WHERE rl_id=?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, rolesBean.getRl_nombre());
            st.setInt(2, rolesBean.getRl_id());
            st.executeUpdate();
        } finally {
            this.desconectar();
        }
    }
    public void eliminarRol(int idUsuario) throws SQLException {
        try {
            String sql = "DELETE FROM roles WHERE rl_id=?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, idUsuario);
            st.executeUpdate();
        } finally {
            this.desconectar();
        }
    }
}
