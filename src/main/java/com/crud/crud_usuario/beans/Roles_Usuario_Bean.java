package com.crud.crud_usuario.beans;

public class Roles_Usuario_Bean {
    private int rlu_id;
    private int rlu_usr_id;
    private int rlu_rl_id;

    public Roles_Usuario_Bean() {
    }

    public Roles_Usuario_Bean(int rlu_id, int rlu_usr_id, int rlu_rl_id) {
        this.rlu_id = rlu_id;
        this.rlu_usr_id = rlu_usr_id;
        this.rlu_rl_id = rlu_rl_id;
    }

    public int getRlu_id() {
        return rlu_id;
    }

    public void setRlu_id(int rlu_id) {
        this.rlu_id = rlu_id;
    }

    public int getRlu_usr_id() {
        return rlu_usr_id;
    }

    public void setRlu_usr_id(int rlu_usr_id) {
        this.rlu_usr_id = rlu_usr_id;
    }

    public int getRlu_rl_id() {
        return rlu_rl_id;
    }

    public void setRlu_rl_id(int rlu_rl_id) {
        this.rlu_rl_id = rlu_rl_id;
    }
}
