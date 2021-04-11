package com.icchelpdesk.possiveisClientes.control;

import com.icchelpdesk.possiveisClientes.model.bean.possiveisClientes;
import com.icchelpdesk.possiveisClientes.model.dao.possiveisClientesDAO;
import java.util.ArrayList;

/**
 *
 * @author Italo
 */
public class possiveisClienteControl {
    
    private static possiveisClienteControl instance = null;
    
    public static possiveisClienteControl getInstance(){
        if(instance == null){
            instance = new possiveisClienteControl();
        }
        return instance;
    }
    
    public int create(possiveisClientes possiveisClientes){
        return possiveisClientesDAO.getInstance().create(possiveisClientes);
    }
    
    public ArrayList<possiveisClientes> read(){
        String query = "select *from possiveisClientes";
       return possiveisClientesDAO.getInstance().read(query);
    }
    
   public void update (possiveisClientes possiveisClientes){
    possiveisClientesDAO.getInstance().update(possiveisClientes);
    }
   
   public void delete(possiveisClientes possiveisClientes){
       possiveisClientesDAO.getInstance().delete(possiveisClientes);
   }
   
   public ArrayList<possiveisClientes> readName(String nome){
       String query = "select *from possiveisClientes where nome = "+nome;
       return possiveisClientesDAO.getInstance().read(query);
   }
}
