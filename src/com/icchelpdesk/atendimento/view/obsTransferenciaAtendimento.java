package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.PrincipalDev;
import com.icchelpdesk.sistema.view.PrincipalSuporte;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class obsTransferenciaAtendimento extends javax.swing.JInternalFrame {
     
    static String usuarioRecebe="";
     static int id = 0;
     private static obsTransferenciaAtendimento instance = null;
    
    public static obsTransferenciaAtendimento getInstance(int id,String usuarioRecebe){
        if(instance == null){
            instance = new obsTransferenciaAtendimento(id,usuarioRecebe);
               
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
    
    
    public obsTransferenciaAtendimento(int id,String usuarioRecebe) {
        this.id=id;
        this.usuarioRecebe=usuarioRecebe;
        initComponents();
    }
    
    
    
    public void concluirTransferencia(){
        ArrayList<atendimento> listaAtendimento = new ArrayList();
        listaAtendimento = atendimentoControl.getInstance().buscaAtendimentosId(id);
        
        
        
        atendimento atendimento = new atendimento();
        
        for(int i=0;i<listaAtendimento.size();i++){
    
            if((listaAtendimento.get(i).getStatus().equals("CONCLUIDO")) || (listaAtendimento.get(i).getStatus().equals("TRANSFERIDO"))){
                JOptionPane.showMessageDialog(null,"Atendimento já transferido ou finalizado\n TRANSFERENCIA IMPOSSIVEL","ERROR",JOptionPane.WARNING_MESSAGE);
            }
            else {
            atendimento.setId(listaAtendimento.get(i).getId());        
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setStatus("RECEBIDO");
            atendimento.setUsuario(listaAtendimento.get(i).getUsuario());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setData(listaAtendimento.get(i).getData());
            atendimento.setTransferencia(Login.getInstance().getUsuario()+" TRANSFERIU PARA "+ usuarioRecebe);
            atendimento.setObsTransferencia(jTextObsTransferencia.getText());
            atendimento.setIdTransferido(listaAtendimento.get(i).getId());
            atendimento.setMotivoPausa("");
            int id = atendimentoControl.getInstance().create(atendimento);
            //crio um novo atendimento, para o usuario que esta recebendo o atendimento, transferido.
            
            
            atendimento.setId(listaAtendimento.get(i).getId());        
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setStatus("TRANSFERIDO");
            atendimento.setUsuario(listaAtendimento.get(i).getUsuario());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setData(listaAtendimento.get(i).getData());
            atendimento.setTransferencia("Atendimento transferido para "+usuarioRecebe);
            atendimento.setIdTransferido(id);    
            atendimento.setObsTransferencia(jTextObsTransferencia.getText()); 
            atendimentoControl.getInstance().update(atendimento);
            //faço um update no atendimento que foi transferido colocando o status como transferido, e as informações da transferencia
        }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObsTransferencia = new javax.swing.JTextArea();
        jButtonConcluirTransferencia = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        jLabel1.setText("Informe alguma informação sobre a transferencia do atendimento");

        jTextObsTransferencia.setColumns(20);
        jTextObsTransferencia.setRows(5);
        jScrollPane1.setViewportView(jTextObsTransferencia);

        jButtonConcluirTransferencia.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonConcluirTransferencia.setText("Concluir Transferencia");
        jButtonConcluirTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirTransferenciaActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVoltar)
                .addGap(291, 291, 291)
                .addComponent(jButtonConcluirTransferencia)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonConcluirTransferencia)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        TransferenciaAtendimentos.getInstance(id).setVisible(false);
        TransferenciaAtendimentos.getInstance(id).setVisible(true);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonConcluirTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirTransferenciaActionPerformed
       concluirTransferencia();
    }//GEN-LAST:event_jButtonConcluirTransferenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcluirTransferencia;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextObsTransferencia;
    // End of variables declaration//GEN-END:variables
}
