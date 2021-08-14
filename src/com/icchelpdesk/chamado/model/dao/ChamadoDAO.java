package com.icchelpdesk.chamado.model.dao;

import com.icchelpdesk.chamado.model.bean.Chamado;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ChamadoDAO {
    
   private static ChamadoDAO instance = null;
   
   public static ChamadoDAO getInstance() {
       if (instance == null) {
           instance = new ChamadoDAO();    
       }
       return instance;
   }
    
   public int insert (Chamado chamado) {
       String query = "INSERT INTO CHAMADO values (?, ?, ?, ?, ?, ?, ?, ?)";
       return MySQLDAO.executeQuery(query, 
               chamado.getIdUsuario().getId(),
               chamado.getNivelPriorirade(),
               chamado.getIdCliente().getId(),
               chamado.getTelefoneContato(),
               chamado.getDataEHora(),
               chamado.getStatus(),
               chamado.getNomeContato(),
               null
               );
   }
    
    public ArrayList<Chamado> buscarChamados (String query) {
        ArrayList<Chamado> listaChamado = new ArrayList();
        
        
        try {
            Chamado chamado = new Chamado();
            
           ResultSet rs = MySQLDAO.getResultSet(query);
           
           while (rs.next()) {
               
               chamado.setId(rs.getInt("id"));
               chamado.setDataEHora(rs.getDate("dataEHora"));
               chamado.getIdCliente().setId(rs.getInt("idCliente"));
               chamado.getIdUsuario().setId(rs.getInt("idUsuario"));
               chamado.setNivelPriorirade(rs.getInt("nivelPrioridade"));
               chamado.setTelefoneContato(rs.getString("telefoneContato"));
               chamado.setStatus(rs.getString("status"));
               chamado.setNomeContato(rs.getString("nomeContato"));
               
               listaChamado.add(chamado);
           }
            
        }catch (SQLException e) {
            System.out.print("Erro ao buscar todos chamados \n metodo buscarChamados ");
        }
        return listaChamado;
    }
    
     public ArrayList<Chamado> buscarChamadosAbertoPorUsuario (String query) {
        ArrayList<Chamado> listaChamado = new ArrayList();
        
        
        try {
            Chamado chamado = new Chamado();
            
           ResultSet rs = MySQLDAO.getResultSet(query);
           
           while (rs.next()) {
               
               chamado.setId(rs.getInt("id"));
               chamado.setDataEHora(rs.getDate("dataEHora"));
               chamado.getIdCliente().setId(rs.getInt("idCliente"));
               chamado.getIdUsuario().setId(rs.getInt("idUsuario"));
               chamado.setNivelPriorirade(rs.getInt("nivelPrioridade"));
               chamado.setTelefoneContato(rs.getString("telefoneContato"));
               chamado.setStatus(rs.getString("status"));
               chamado.setNomeContato(rs.getString("nomeContato"));
               listaChamado.add(chamado);
               
           }
            
        }catch (SQLException e) {
            System.out.print("Erro ao buscar todos chamados \n metodo buscarChamados ");
        }
        return listaChamado;
    }
}
