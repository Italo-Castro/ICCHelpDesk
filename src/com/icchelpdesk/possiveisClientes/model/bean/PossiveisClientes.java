package com.icchelpdesk.possiveisClientes.model.bean;

import java.sql.Timestamp;

public class PossiveisClientes {
    private int id;
    private String nome;
    private String tel_1;
    private String tel_2;
    private String relatoCliente;
    private String solucao;
    private String status;
    private Timestamp created_at; //criado em 
    private Timestamp update_at; //atualizado em

    
    
    public PossiveisClientes() {
    }
    /**
     * 
     * @param id
     * @param nome
     * @param tel_1
     * @param tel_2
     * @param relatoCliente
     * @param solucao
     * @param created_at
     * @param update_at
     */
    public PossiveisClientes(int id, String nome, String tel_1, String tel_2, String relatoCliente, String solucao, String status, Timestamp created_at, Timestamp update_at) {
        this.id = id;
        this.nome = nome;
        this.tel_1 = tel_1;
        this.tel_2 = tel_2;
        this.relatoCliente = relatoCliente;
        this.solucao = solucao;
        this.status = status;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel_1() {
        return tel_1;
    }

    public void setTel_1(String tel_1) {
        this.tel_1 = tel_1;
    }

    public String getTel_2() {
        return tel_2;
    }

    public void setTel_2(String tel_2) {
        this.tel_2 = tel_2;
    }

    public String getRelatoCliente() {
        return relatoCliente;
    }

    public void setRelatoCliente(String relatoCliente) {
        this.relatoCliente = relatoCliente;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
    
    
    
    
}
