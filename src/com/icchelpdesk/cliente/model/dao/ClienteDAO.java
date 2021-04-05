package com.icchelpdesk.cliente.model.dao;

/**
 *
 * @author Italo
 */
public class ClienteDAO {
    
    private static ClienteDAO instance = null;
    
    public static ClienteDAO getInstance(){
        
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public int create (Cliente cliente){
        
    }
    
}
