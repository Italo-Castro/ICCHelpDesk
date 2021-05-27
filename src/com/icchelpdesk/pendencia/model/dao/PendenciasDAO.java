package com.icchelpdesk.pendencia.model.dao;

import com.icchelpdesk.pendencia.model.bean.Pendencias;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class PendenciasDAO {
    
    private static PendenciasDAO instance = null;
    
    public static  PendenciasDAO getInstance(){
        if(instance == null){
            instance = new PendenciasDAO();
        }
        return instance;
    }
    
    public int create(Pendencias pendencia){
        String query = "insert into pendencias values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        return MySQLDAO.executeQuery(query,
                null,
                pendencia.getCreated_at(),
                pendencia.getResolved_at(),
                pendencia.getDescricao(),
                pendencia.getObservacao(),
                pendencia.getSetor(),
                pendencia.getRegistradoPor(),
                pendencia.getTipoProblema()
        );
    }
    
    public ArrayList<Pendencias> read(String query) {
        ArrayList<Pendencias> listaPendencias = new ArrayList();
        
        try {
            
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while (rs.next()) {
                Pendencias pendencia = new Pendencias();
                
                pendencia.setId(rs.getInt("id"));
                pendencia.setCreated_at(rs.getTimestamp("created_at"));
                pendencia.setDescricao(rs.getString("descricao"));
                pendencia.setObservacao(rs.getString("observacao"));
                pendencia.setRegistradoPor(rs.getString("registradoPor"));
                pendencia.setResolved_at(rs.getTimestamp("resolved_at"));
                pendencia.setSetor(rs.getString("departamento"));
                pendencia.setTipoProblema(rs.getString("tipoProblema"));
                
                listaPendencias.add(pendencia);
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar todas pendencias");
        }
        
        return listaPendencias;
    }
    public  ArrayList<Pendencias> buscaPorDepartamento (String query){
        ArrayList<Pendencias> lista = new ArrayList();
        
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            
            while (rs.next()){
                Pendencias pendencia = new Pendencias();
                pendencia.setId(rs.getInt("id"));
                pendencia.setCreated_at(rs.getTimestamp("created_at"));
                pendencia.setDescricao(rs.getString("descricao"));
                pendencia.setObservacao(rs.getString("observacao"));
                pendencia.setRegistradoPor(rs.getString("registradoPor"));
                pendencia.setResolved_at(rs.getTimestamp("resolved_at"));
                pendencia.setSetor(rs.getString("departamento"));
                pendencia.setTipoProblema(rs.getString("tipoProblema"));
                
                lista.add(pendencia);
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao fazer busca por departamento"+e.getMessage());
        }
        return lista;
    }
    
   public void updateResolved_at (Pendencias pendencia) {
       
       String query = "update pendencias \n"
               + "set observacao = ? , "
               + "resolved_at = ? "
               + "where id = ?";
       
       MySQLDAO.executeQuery(query,
                pendencia.getObservacao(),
                pendencia.getResolved_at(),
                pendencia.getId()
               );
   }
}
