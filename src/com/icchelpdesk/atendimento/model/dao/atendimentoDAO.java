package com.icchelpdesk.atendimento.model.dao;

import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.possiveisClientes.model.dao.possiveisClientesDAO;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Italo
 */
public class atendimentoDAO {
    
    private static atendimentoDAO instance = null;
    
    public static atendimentoDAO getInstance(){
        if(instance == null){
            instance = new atendimentoDAO();
        }
        return instance;
    }
    
    
    public int create(atendimento atendimento){
        
        String query = "insert into atendimento values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query,
                null,
                atendimento.getNomeCliente(),
                atendimento.getRelato(),
                atendimento.getObservacao(),
                atendimento.getObservacao2(),
                atendimento.getSolucao(),
                atendimento.getAssunto(),
                atendimento.getStatus(),
                atendimento.getUsuario(),
                atendimento.getNomeContato(),
                atendimento.getData(),
                atendimento.getTransferencia(),
                atendimento.getIdTransferido(),
                atendimento.getObsTransferencia()
               
                
                );       
    }
    public ArrayList<atendimento>  read(String query){
        ArrayList<atendimento> listaAtendimento = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato(rs.getString("nomeContato"));
                atendimento.setData(rs.getTimestamp("data"));
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                listaAtendimento.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimento;
    }
    public void update(atendimento atendimento){
        String query = "UPDATE `atendimento` set "
                + "`nomeCliente` = ?,\n"
                + "`relato` = ?,\n"
                + "`observacao` = ?,\n"
                + "`observacao2` = ?,\n"
                + "`solucao` = ?,\n"
                + "`assunto` = ?,\n"
                + "`status` = ?,\n"
                + "`usuario` = ?,\n"
                + "`nomeContato` = ?,\n"
                + "`data` = ?,\n"
                + "`transferencia` = ?,\n"
                + "idTransferido = ?,\n"
                + "obsTransferencia = ? \n"
                + "WHERE `id` = ?";
                MySQLDAO.executeQuery(query,
                       atendimento.getNomeCliente(),
                       atendimento.getRelato(),
                       atendimento.getObservacao(),
                       atendimento.getObservacao2(),
                       atendimento.getSolucao(),
                       atendimento.getAssunto(), 
                       atendimento.getStatus(),
                       atendimento.getUsuario(),
                       atendimento.getNomeContato(),
                       atendimento.getData(),
                       atendimento.getTransferencia(),
                       atendimento.getIdTransferido(),
                       atendimento.getObsTransferencia(),
                       atendimento.getId()
                        );
                 
    }
     public void delete(atendimento atendimento) {
        String query = "DELETE FROM `atendimento` where id = ?";
        MySQLDAO.executeQuery(query, atendimento.getId());
    }
    public ArrayList<atendimento> buscarAtendimentosPausados(String query){
          ArrayList<atendimento> listaAtendimentoPausados = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato("nomeContato");
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                atendimento.setData(rs.getTimestamp("data"));
                
                listaAtendimentoPausados.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimentoPausados;
    } 
    public ArrayList<atendimento> buscarAtendimentosPausadosId(String query){
          ArrayList<atendimento> listaAtendimentoPausados = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato(rs.getString("nomeContato"));
                atendimento.setData(rs.getTimestamp("data"));
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                listaAtendimentoPausados.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimentoPausados;
    } 
        public ArrayList<atendimento> buscarAtendimentosId(String query){
          ArrayList<atendimento> listaAtendimentoPausados = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato(rs.getString("nomeContato"));
                atendimento.setData(rs.getTimestamp("data"));
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                listaAtendimentoPausados.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimentoPausados;
    } 
        public ArrayList<atendimento> buscarAtendimentosTransferidos(String query){
          ArrayList<atendimento> listaAtendimentoPausados = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato(rs.getString("nomeContato"));
                atendimento.setData(rs.getTimestamp("data"));
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                listaAtendimentoPausados.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimentoPausados;
    } 
    public ArrayList<atendimento> buscarAtendimentosTransferidosId(String query){
          ArrayList<atendimento> listaAtendimentoPausados = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while(rs.next()){
                atendimento atendimento = new atendimento();
                
                atendimento.setId(rs.getInt("id"));
                atendimento.setNomeCliente(rs.getString("nomeCliente"));
                atendimento.setRelato(rs.getString("relato"));
                atendimento.setObservacao(rs.getString("observacao"));
                atendimento.setObservacao2(rs.getString("observacao2"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setAssunto(rs.getString("assunto"));
                atendimento.setStatus(rs.getString("status"));
                atendimento.setUsuario(rs.getString("usuario"));
                atendimento.setNomeContato(rs.getString("nomeContato"));
                atendimento.setData(rs.getTimestamp("data"));
                atendimento.setTransferencia(rs.getString("transferencia"));
                atendimento.setIdTransferido(rs.getInt("idTransferido"));
                atendimento.setObsTransferencia(rs.getString("obsTransferencia"));
                listaAtendimentoPausados.add(atendimento);
            }
        }catch(SQLException e){
            Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAtendimentoPausados;
    } 


}

