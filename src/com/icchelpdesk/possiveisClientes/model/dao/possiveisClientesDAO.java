package com.icchelpdesk.possiveisClientes.model.dao;

import com.icchelpdesk.possiveisClientes.control.possiveisClienteControl;
import com.icchelpdesk.possiveisClientes.model.bean.possiveisClientes;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import com.icchelpdesk.usuario.model.bean.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Italo
 */
public class possiveisClientesDAO {
 
    private static possiveisClientesDAO instance = null;
    
    public static possiveisClientesDAO getInstance(){
        if(instance == null){
            instance = new possiveisClientesDAO();
        }
        return instance;
    }
    public int create (possiveisClientes possivelCliente){
        String query = "INSERT INTO possiveisClientes values(?,?,?,?,?,?,?)";
          return MySQLDAO.executeQuery(
            query,
            possivelCliente.getNome(),  
            possivelCliente.getTelefone(),
            possivelCliente.getRelatoCliente(),
            possivelCliente.getSolucao(),
            possivelCliente.getStatus(),
            null,
            possivelCliente.getCidade()    
           );            
}
    public ArrayList<possiveisClientes> read(String query){
        ArrayList<possiveisClientes> possiveisClientesLista = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            while(rs.next()){
                possiveisClientes possivelCliente = new possiveisClientes();
                
                possivelCliente.setTelefone(rs.getString("telefone"));
                possivelCliente.setStatus(rs.getString("status"));
                possivelCliente.setSolucao(rs.getString("solucao"));
                possivelCliente.setRelatoCliente(rs.getString("relatoCliente"));
                possivelCliente.setNome(rs.getString("nome"));
                possivelCliente.setId(rs.getInt("id"));
                     
                possiveisClientesLista.add(possivelCliente);                
            }
            }catch (SQLException ex){
                Logger.getLogger(possiveisClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return possiveisClientesLista;
        }
    
      public void update(possiveisClientes possiveisClientes) {
        String query = "UPDATE `possiveisClientes` set "
                + "`nome` = ?,\n"
                + "`relatoCliente` = ?,\n"
                + "`solucao` = ?,\n"
                + "`status` = ?,\n"
                + "`telefone` = ?\n"
                + " WHERE `id` = ?";
        MySQLDAO.executeQuery(query,
                possiveisClientes.getNome(),
                possiveisClientes.getRelatoCliente(),
                possiveisClientes.getSolucao(),
                possiveisClientes.getStatus(),
                possiveisClientes.getTelefone(),
                possiveisClientes.getId()
        );
    }

    public void delete(possiveisClientes possiveisClientes) {
        String query = "DELETE FROM `possiveisClientes` where id = ?";
        MySQLDAO.executeQuery(query, possiveisClientes.getId());
    }
    
    public ArrayList<possiveisClientes> readName(String nome){
        
        return possiveisClienteControl.getInstance().readName(nome);
    }
}
