package com.icchelpdesk.pendencia.model.bean;

import java.sql.Timestamp;


public class Pendencias {
    
    private int id;
    private Timestamp created_at;
    private Timestamp resolved_at;
    private String descricao;
    private String observacao;
    private String setor;
    private String registradoPor;
    private String tipoProblema;
    private String status;

    public Pendencias() {
    }

    public Pendencias(int id, Timestamp created_at, Timestamp resolved_at, String descricao, String observacao, String setor, String registradoPor, String tipoProblema, String status) {
        this.id = id;
        this.created_at = created_at;
        this.resolved_at = resolved_at;
        this.descricao = descricao;
        this.observacao = observacao;
        this.setor = setor;
        this.registradoPor = registradoPor;
        this.tipoProblema = tipoProblema;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getResolved_at() {
        return resolved_at;
    }

    public void setResolved_at(Timestamp resolved_at) {
        this.resolved_at = resolved_at;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(String registradoPor) {
        this.registradoPor = registradoPor;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }
    
    
    
}
