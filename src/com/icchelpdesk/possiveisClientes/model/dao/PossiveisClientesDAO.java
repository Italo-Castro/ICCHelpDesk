package com.icchelpdesk.possiveisClientes.model.dao;

import com.icchelpdesk.possiveisClientes.model.bean.PossiveisClientes;
import com.icchelpdesk.sistema.model.util.MySQLDAO;

/**
 *
 * @author Italo
 */
public class PossiveisClientesDAO {
    
    private static PossiveisClientesDAO instance = null;
    
    public static PossiveisClientesDAO getInstance(){
        if(instance == null){
            instance = new PossiveisClientesDAO();
        }
        return instance;
    }
    
    public int create (PossiveisClientes possivelCliente){
        String query = "INSERT INTO POSSIVEISCLIENETS values (?,?,?,?,?,?,?,?,?);";
        return MySQLDAO.executeQuery(
                query,
                null,
                possivelCliente.getNome(),
                possivelCliente.getTel_1(),
                possivelCliente.getTel_2(),
                possivelCliente.getRelatoCliente(),
                possivelCliente.getSolucao(),
                possivelCliente.getStatus(),
                possivelCliente.getCreated_at(),
                 possivelCliente.getUpdate_at()
                );
    }
    
}
