package com.icchelpdesk.atendimento.control;

import com.icchelpdesk.atendimento.model.dao.atendimentoDAO;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.sistema.view.Login;
import java.util.ArrayList;


/**
 *
 * @author Italo
 */
public class atendimentoControl {
    
    private static atendimentoControl instance = null;
    
    public static atendimentoControl getInstance(){
        if(instance == null){
            instance = new atendimentoControl();
        }
        
        return instance;
    }
    
    
    public int create(atendimento atendimento){
        return atendimentoDAO.getInstance().create(atendimento);
    }
    
    public ArrayList<atendimento> read(){
        String query = "select *from clientes;";
        return atendimentoDAO.getInstance().read(query);
    } 
    
    public void update (atendimento atendimento){
         atendimentoDAO.getInstance().update(atendimento);
    }
    
    public void delete(atendimento atendimento){
        atendimentoDAO.getInstance().delete(atendimento);
    }
     public ArrayList<atendimento> buscaAtendimentosPausados() {
        String query = "select *from atendimento where status = 'PAUSADO' and usuario = '"+Login.getInstance().getUsuario()+"'";
        return atendimentoDAO.getInstance().buscarAtendimentosPausados(query);
    } 
     public ArrayList<atendimento> buscaAtendimentosPausadosId(int id) {
         
        String query = "select *from atendimento where status = 'PAUSADO' and id = '"+id+"'";
        return atendimentoDAO.getInstance().buscarAtendimentosPausadosId(query);
    } 
    public ArrayList<atendimento> buscaAtendimentosId(int id) {
         
        String query = "select *from atendimento where id = '"+id+"'";
        return atendimentoDAO.getInstance().buscarAtendimentosPausadosId(query);
    } 
    public ArrayList<atendimento> buscaAtendimentoTransferido(){
        String query = "select *from atendimento where transferencia like ('%"+Login.getInstance().getUsuario()+"') and status = 'RECEBIDO'";
        return atendimentoDAO.getInstance().buscarAtendimentosTransferidos(query);
        
    }
    public ArrayList<atendimento> buscaAtendimentosTransferidosId(int id) {
         
        String query = "select *from atendimento where id = '"+id+"'";
        return atendimentoDAO.getInstance().buscarAtendimentosTransferidosId(query);
    } 
}
