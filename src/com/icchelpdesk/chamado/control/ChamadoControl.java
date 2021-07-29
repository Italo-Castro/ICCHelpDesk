package com.icchelpdesk.chamado.control;

import com.icchelpdesk.chamado.model.dao.ChamadoDAO;
import com.icchelpdesk.chamado.model.bean.Chamado;
import java.util.ArrayList;

public class ChamadoControl {
    
    private static ChamadoControl instance = null;
    
    public static ChamadoControl getInstance() {
        if (instance == null) {
            instance = new ChamadoControl();
        }
        return instance;
    }
    
    public int insert (Chamado chamado) {
        return ChamadoDAO.getInstance().insert(chamado);
    }
    
    public ArrayList<Chamado> buscarChamados (){
        String query  = "select *from chamado";
        
        return ChamadoDAO.getInstance().buscarChamados(query);
    }
}
