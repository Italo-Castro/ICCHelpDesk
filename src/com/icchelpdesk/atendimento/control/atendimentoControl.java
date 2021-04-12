package com.icchelpdesk.atendimento.control;

import com.icchelpdesk.atendimento.dao.atendimentoDAO;
import com.icchelpdesk.atendimento.model.bean.atendimento;
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
    
    
    
}
