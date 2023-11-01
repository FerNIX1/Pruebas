package com.crud.crud_usuario.beans;

public class UsuariosBean {
    private int id;
    private String usr_nombre;
    private String usr_apellido;
    private String usr_email;
    private String usr_pais;

    public UsuariosBean() {
    }

    public UsuariosBean(int id, String usr_nombre, String usr_apellido, String usr_email, String usr_pais) {
        this.id = id;
        this.usr_nombre = usr_nombre;
        this.usr_apellido = usr_apellido;
        this.usr_email = usr_email;
        this.usr_pais = usr_pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr_nombre() {
        return usr_nombre;
    }

    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
    }

    public String getUsr_apellido() {
        return usr_apellido;
    }

    public void setUsr_apellido(String usr_apellido) {
        this.usr_apellido = usr_apellido;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public String getUsr_pais() {
        return usr_pais;
    }

    public void setUsr_pais(String usr_pais) {
        this.usr_pais = usr_pais;
    }
}
