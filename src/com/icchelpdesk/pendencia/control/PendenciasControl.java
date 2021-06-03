package com.icchelpdesk.pendencia.control;

import com.icchelpdesk.pendencia.model.bean.Pendencias;
import com.icchelpdesk.pendencia.model.dao.PendenciasDAO;
import java.util.ArrayList;

public class PendenciasControl {
    
    private static PendenciasControl instance = null;
    
    public static PendenciasControl getInstance() {
        if (instance == null){
            instance = new PendenciasControl();
        }
        return instance;
    }
    
    public int create (Pendencias pendencia){
        return PendenciasDAO.getInstance().create(pendencia);
    }
    
    public ArrayList <Pendencias> read() {
        String query = " select *from pendencias";
        return PendenciasDAO.getInstance().read(query);
    }
    
    public void updateResolved_at (Pendencias pendencia) {
        PendenciasDAO.getInstance().updateResolved_at(pendencia);
    }
   public ArrayList <Pendencias> buscarPorDepartamento(String departamento){
       String query = "select *from pendencias where departamento = '"+departamento+"'";
       return PendenciasDAO.getInstance().buscaPorDepartamento(query); 
   } 
   
}
