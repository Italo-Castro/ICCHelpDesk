package com.icchelpdesk.cliente.control;

import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.cliente.model.dao.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Italo
 */
public class ClienteControl {
    
    private static ClienteControl instance = null;
    
    public static ClienteControl getInstance(){
        if(instance == null){
            instance = new ClienteControl();
        }
        
        return instance;
    }
    
    
    public int create(Cliente cliente){
        return ClienteDAO.getInstance().create(cliente);
    }
    
    public ArrayList<Cliente> read(){
        String query = "select *from clientes;";
        return ClienteDAO.getInstance().read(query);
    } 
    
    public Cliente readFromId(String nome){
        String query = "select *from clientes where nomeEmpresarial =';"+nome+"'";
        return ClienteDAO.getInstance().readFromNameBusiness(query);
    } 
    
    public void update (Cliente cliente){
         ClienteDAO.getInstance().update(cliente);
    }
    
    public void delete(Cliente cliente){
        ClienteDAO.getInstance().delete(cliente);
    }
    
}
