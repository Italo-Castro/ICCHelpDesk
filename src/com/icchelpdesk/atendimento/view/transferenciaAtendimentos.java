package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.sistema.view.Principal;




public class transferenciaAtendimentos extends javax.swing.JInternalFrame {
    
    private static transferenciaAtendimentos instance = null;
    
    public static transferenciaAtendimentos getInstance(){
        if(instance == null){
            instance = new transferenciaAtendimentos();
             Principal.getInstance().getDesktopPane().add(instance);
        }
        return instance;
        }
        
    
    
    public transferenciaAtendimentos() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
