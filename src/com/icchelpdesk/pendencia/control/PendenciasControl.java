package com.icchelpdesk.pendencia.control;

public class PendenciasControl {
    
    private static PendenciasControl instance = null;
    
    public static PendenciasControl getInstance() {
        if (instance == null){
            instance = new PendenciasControl();
        }
        return instance;
    }
    
    
    
}
