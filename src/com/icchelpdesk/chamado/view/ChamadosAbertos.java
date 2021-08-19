package com.icchelpdesk.chamado.view;

import com.icchelpdesk.atendimento.view.AtendimentoRegister;
import com.icchelpdesk.chamado.control.ChamadoControl;
import com.icchelpdesk.chamado.model.bean.Chamado;
import com.icchelpdesk.cliente.control.ClienteControl;
import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.PrincipalDev;
import com.icchelpdesk.sistema.view.PrincipalSuporte;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ChamadosAbertos extends javax.swing.JInternalFrame {

    private static ChamadosAbertos instance = null;
    
    public static ChamadosAbertos getInstance(){
        if (instance == null) {
            instance = new ChamadosAbertos();
            
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
    
    
    public ChamadosAbertos() {
        
        initComponents();
        carregarTabelaChamado();
        
    }

    public void carregarTabelaChamado() {
        DefaultTableModel modelo =  (DefaultTableModel) jTable1.getModel();
        
        modelo.setNumRows(0);
        
        ArrayList<Chamado> listaChamados = ChamadoControl.getInstance().buscarChamadosAbertoPorUsuario(Login.getInstance().getId());
        
        if(listaChamados.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há nenhum chamado em aberto para você"+Login.getInstance().getUsuario()+" (:");
            this.dispose();
        }
        
        else 
            //for (Chamado chamados : listaChamados){
            listaChamados.forEach((chamados) -> {
                Cliente cliente = new Cliente();
                cliente = ClienteControl.getInstance().readFromId(chamados.getIdCliente().getId());
                modelo.addRow(new Object []{
                    chamados.getId(),
                    cliente.getNomeEmpresarial(),
                    chamados.getNomeContato(),
                    chamados.getDataEHora(),
                    chamados.getNivelPriorirade(),
                });
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAccept = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonUpdateTable = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Nome Cliente", "Nome Contato", "Data e Hora", "Prioridade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonAccept.setText("Aceitar Chamado");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jButton2.setText("Recusar Chamado");

        jButtonUpdateTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/icon16x16/update16x16.png"))); // NOI18N
        jButtonUpdateTable.setText("Atualizar");
        jButtonUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jButtonUpdateTable, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAccept)
                                .addGap(14, 14, 14)))))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUpdateTable)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButtonAccept))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateTableActionPerformed
        carregarTabelaChamado();
    }//GEN-LAST:event_jButtonUpdateTableActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        DefaultTableModel modelo =  (DefaultTableModel) jTable1.getModel();
        if(jTable1.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null," Selecione o atendimento que deseja aceitar","ERROR",JOptionPane.WARNING_MESSAGE);
        }else {
            int x = JOptionPane.showConfirmDialog(null," O chamado sera transferido para sua lista de atendimentos \n Você deseja iniciar o atendimento neste momento ? ");
            
            if (x == JOptionPane.YES_OPTION){
                modelo.removeRow(jTable1.getSelectedRow()); //Remove da tabela a linha selecionada
                
               AtendimentoRegister atd = new AtendimentoRegister();
               atd.getInstanceChamado("Italo","Jose").setVisible(true);
                //executar a logica de transferir o atendimento da tabela chamado para a tabela atendimento
            }
            else if (x == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null,"O atendimento sera adicionado a sua lista de atendimentos pausados");
            }
        }
    }//GEN-LAST:event_jButtonAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonUpdateTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
