package com.crud.crud_usuario.model;
import  com.crud.crud_usuario.beans.UsuariosBean;

import java.nio.file.attribute.UserPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UsuariosModel extends Conexion {
    public List<UsuariosBean> ListarUsuarios()throws SQLException{
        try{
            List<UsuariosBean> lista = new ArrayList<>();
            String Sql="SELECT * FROM usuarios;";
            this.conectar();
            st=conexion.prepareStatement(Sql);
            rs= st.executeQuery();
            while (rs.next()){
                UsuariosBean usuariosBean= new UsuariosBean();
                usuariosBean.setId(rs.getInt("id"));
                usuariosBean.setUsr_nombre(rs.getString("usr_nombre"));
                usuariosBean.setUsr_apellido(rs.getString("usr_apellido"));
                usuariosBean.setUsr_email(rs.getString("usr_email"));
                usuariosBean.setUsr_pais(rs.getString("usr_pais"));
                lista.add(usuariosBean);
            }
            this.desconectar();
            return lista;
        }catch (SQLException e){
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, e);
            this.desconectar();
            return null;
        }
    }
    public void agregarUsuario(UsuariosBean nuevoUsuario) throws SQLException {
        try {
            String sql = "INSERT INTO usuarios (usr_nombre, usr_apellido, usr_email, usr_pais) VALUES (?, ?, ?, ?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, nuevoUsuario.getUsr_nombre());
            st.setString(2, nuevoUsuario.getUsr_apellido());
            st.setString(3, nuevoUsuario.getUsr_email());
            st.setString(4, nuevoUsuario.getUsr_pais());
            st.executeUpdate();
            this.desconectar();
        } catch (SQLException e) {
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, e);
            this.desconectar();
        }
    }
    public UsuariosBean obtenerUsuarioPorId(int userId) throws SQLException {
        try {
            UsuariosBean usuario = null;
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, userId);
            rs = st.executeQuery();
            if (rs.next()) {
                usuario = new UsuariosBean();
                usuario.setId(rs.getInt("id"));
                usuario.setUsr_nombre(rs.getString("usr_nombre"));
                usuario.setUsr_apellido(rs.getString("usr_apellido"));
                usuario.setUsr_email(rs.getString("usr_email"));
                usuario.setUsr_pais(rs.getString("usr_pais"));
            }
            return usuario;
        } finally {
            this.desconectar();
        }
    }
    public void actualizarUsuario(UsuariosBean usuario) throws SQLException {
        try {
            String sql = "UPDATE usuarios SET usr_nombre=?, usr_apellido=?, usr_email=?, usr_pais=? WHERE id=?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, usuario.getUsr_nombre());
            st.setString(2, usuario.getUsr_apellido());
            st.setString(3, usuario.getUsr_email());
            st.setString(4, usuario.getUsr_pais());
            st.setInt(5, usuario.getId());
            st.executeUpdate();
        } finally {
            this.desconectar();
        }
    }
    public void eliminarUsuario(int idUsuario) throws SQLException {
        try {
            String sql = "DELETE FROM usuarios WHERE id=?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, idUsuario);
            st.executeUpdate();
        } finally {
            this.desconectar();
        }
    }
}
