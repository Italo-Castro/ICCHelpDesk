package com.icchelpdesk.chamado.model.bean;

import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.usuario.model.bean.Usuario;
import java.util.Date;

public class Chamado {
    
    private int id;
    private Usuario idUsuario;
    private int nivelPriorirade;
    private Cliente idCliente;
    private String telefoneContato;
    private Date dataEHora;
    private String status;
    private String nomeContato;

    public Chamado() {}
    
    public Chamado(int id, Usuario idUsuario, int nivelPriorirade, Cliente idCliente, String telefoneContato, Date dataEHora, String status, String nomeContato) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nivelPriorirade = nivelPriorirade;
        this.idCliente = idCliente;
        this.telefoneContato = telefoneContato;
        this.dataEHora = dataEHora;
        this.status = status;
        this.nomeContato = nomeContato;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNivelPriorirade() {
        return nivelPriorirade;
    }

    public void setNivelPriorirade(int nivelPriorirade) {
        this.nivelPriorirade = nivelPriorirade;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }
    
    
    
    
    
    
    
}
