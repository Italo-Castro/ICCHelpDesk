package com.icchelpdesk.usuario.model.bean;

import java.sql.Timestamp;

public class Usuario {

    private int id;
    private int permissao;
    private String nome;
    private String usuario;
    private String senha;
    private String estado;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Usuario() {
    }

    /**
     * 
     * @param id
     * @param permissao
     * @param nome
     * @param usuario
     * @param senha
     * @param estado
     * @param created_at
     * @param updated_at 
     */
    public Usuario(int id, int permissao, String nome, String usuario, String senha, String estado, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.permissao = permissao;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
