package com.icchelpdesk.pendencia.view;

import com.icchelpdesk.pendencia.control.PendenciasControl;
import com.icchelpdesk.pendencia.model.bean.Pendencias;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.PrincipalDev;
import com.icchelpdesk.sistema.view.PrincipalSuporte;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PendenciasView extends javax.swing.JInternalFrame {

    private static PendenciasView instance = null;
    
    
    public PendenciasView getInstance(){
        if (instance == null) {
            instance = new PendenciasView();

            if(Login.getInstance().getPerfil().equals("SUPORTE")){
                  PrincipalSuporte.getInstance().getDesktopPane().add(instance); 
            }
            else if(Login.getInstance().getPerfil().equals("DEV")){
                  PrincipalDev.getInstance().getDesktopPane().add(instance); 
            }
            else if(Login.getInstance().getPerfil().equals("TESTE")){
                  PrincipalTeste.getInstance().getDesktopPane().add(instance);  
            }
        }
        return instance;
    }
    
    public static void setInstance(PendenciasView in) {
        instance = in;
    }
    public PendenciasView() {
        initComponents();
       
        carregarTabela();
    }

    public void carregarTabela(){
        String perfil = Login.getInstance().getPerfil();
        
        String departamento = "";
        if(perfil == "DEV"){
            departamento = "desenvolvimento";
        }
       
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        ArrayList<Pendencias> listaPendencias = PendenciasControl.getInstance().buscarPorDepartamento(departamento);
        ArrayList<String> listaNaoFeitos = new ArrayList();
        ArrayList<String> listaEmAndamento = new ArrayList();
        ArrayList<String> listaTeste = new ArrayList();
        
        for (int i=0;i<listaPendencias.size();i++){
            if(listaPendencias.get(i).getStatus().equals("NAO FEITO")) {
                listaNaoFeitos.add(listaPendencias.get(i).getDescricao());                
            }
            else  if(listaPendencias.get(i).getStatus().equals("EM ANDAMENTO")) {
                listaEmAndamento.add(listaPendencias.get(i).getDescricao());                
            }
            else  if(listaPendencias.get(i).getStatus().equals("TESTE")) {
                listaTeste.add(listaPendencias.get(i).getDescricao());                
            }
        }
    }
        /*
        for (int i=0 ;i<listaNaoFeitos.size();i++){
           // JOptionPane.showMessageDialog(null,"Tamanho lista nao feitos"+listaNaoFeitos.size());
        modelo.setValueAt(new String[]{listaNaoFeitos.get(i).toString()},i,0);

        //modelo.setValueAt(new String[]{listaEmAndamento.get(i).toString()},i,1);
        //modelo.setValueAt(new String[]{listaTeste.get(i).toString()},i,2);
        
        }
    }
        
        /*
        for(Pendencias p : listaPendencias) {
            if(p.getStatus().equals("NAO FEITO")) {
                modelo.setValueAt(p.getDescricao(), 0, 1);
            }
           // modelo.addRow(new String []{p.getTipoProblema(),"","",});
        }
    }
*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N??o Feito", "Em andamento", "Teste", "Concluido"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 472, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
