package com.icchelpdesk.atendimento.model.bean;


public class atendimento {
    
    private int id;
    private String nomeContato;
    private String nomeCliente;
    private String relato;
    private String observacao;
    private String observacao2;
    private String solucao;
    public String assunto;
    private String status;
    private String usuario;

    public atendimento() {
        
    }

    public atendimento(int id,String nomeCliente, String relato, String observacao, String observacao2, String solucao, String assunto,String status,String nomeContato,String usuario) {
        this.nomeCliente = nomeCliente;
        this.relato = relato;
        this.observacao = observacao;
        this.observacao2 = observacao2;
        this.solucao = solucao;
        this.assunto = assunto;
        this.id=id;
        this.status=status;
        this.nomeContato=nomeContato;
        this.usuario=usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

        
    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
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
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao2() {
        return observacao2;
    }

    public void setObservacao2(String observacao2) {
        this.observacao2 = observacao2;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
   
    
    
    
}
