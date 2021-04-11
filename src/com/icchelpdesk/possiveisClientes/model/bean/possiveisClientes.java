package com.icchelpdesk.possiveisClientes.model.bean;

import java.sql.Timestamp;


public class possiveisClientes {
    
    private int id;
    private String nome;
    private String telefone;
    private String relatoCliente;
    private String solucao;
    private String status;
    private String cidade;
    private Timestamp created_at;

    public possiveisClientes() {
    }   

    public possiveisClientes(int id, String nome, String telefone, String relatoCliente, String solucao, String status, Timestamp created_at,String cidade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.relatoCliente = relatoCliente;
        this.solucao = solucao;
        this.status = status;
        this.created_at=created_at;
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    
    
    
    
}
