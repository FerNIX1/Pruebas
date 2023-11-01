package com.crud.crud_usuario.model;

import com.crud.crud_usuario.beans.RolesBean;
import com.crud.crud_usuario.beans.Roles_Usuario_Bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Roles_UsuarioModel extends Conexion{
    public List<Roles_Usuario_Bean> ListarRolesUsuario()throws SQLException {
        try{
            List<Roles_Usuario_Bean> lista = new ArrayList<>();
            String Sql="SELECT * FROM roles_usuario;";
            this.conectar();
            st=conexion.prepareStatement(Sql);
            rs= st.executeQuery();
            while (rs.next()){
                Roles_Usuario_Bean rolesBean= new Roles_Usuario_Bean();
                rolesBean.setRlu_id(rs.getInt("rlu_id"));
                rolesBean.setRlu_usr_id(rs.getInt("rlu_usr_id"));
                rolesBean.setRlu_rl_id(rs.getInt("rlu_rl_id"));
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
    public void eliminarRolUsuario(int idUsuario) throws SQLException {
        try {
            String sql = "DELETE FROM roles_usuario WHERE rlu_id =?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, idUsuario);
            st.executeUpdate();
        } finally {
            this.desconectar();
        }
    }
    public void agregarRolesUsuarios(Roles_Usuario_Bean nuevoRoluserbean) throws SQLException {
        try {
            String sql = "INSERT INTO roles_usuario (rlu_usr_id ,rlu_rl_id) VALUES (?,?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, String.valueOf(nuevoRoluserbean.getRlu_id()));
            st.setString(2, String.valueOf(nuevoRoluserbean.getRlu_rl_id()));
            this.desconectar();
        } catch (SQLException e) {
            Logger.getLogger(RolesModel.class.getName()).log(Level.SEVERE, null, e);
            this.desconectar();
        }
    }
}
