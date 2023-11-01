package com.crud.crud_usuario.beans;

public class RolesBean {
    private int rl_id;
    private String rl_nombre;

    public RolesBean() {
    }

    public RolesBean(int rl_id, String rl_nombre) {
        this.rl_id = rl_id;
        this.rl_nombre = rl_nombre;
    }

    public int getRl_id() {
        return rl_id;
    }

    public void setRl_id(int rl_id) {
        this.rl_id = rl_id;
    }

    public String getRl_nombre() {
        return rl_nombre;
    }

    public void setRl_nombre(String rl_nombre) {
        this.rl_nombre = rl_nombre;
    }
}
