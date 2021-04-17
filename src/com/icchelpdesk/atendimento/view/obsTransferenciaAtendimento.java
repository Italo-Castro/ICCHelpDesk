package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;

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
             Principal.getInstance().getDesktopPane().add(instance);
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
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setStatus("TRANSFERIDO");
            atendimento.setId(listaAtendimento.get(i).getId());
            atendimentoControl.getInstance().update(atendimento);
            
            
            
            
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setStatus("RECEBIDO");
            atendimento.setUsuario(usuarioRecebe);
            atendimento.setTransferencia(Login.getInstance().getUsuario()+ " PARA" + usuarioRecebe);      // Aqui estara na variavel transferencia ( ITALO PARA RAFAEL)  
            atendimento.setIdTransferido(atendimento.getId());
            atendimento.setObsTransferencia(jTextObsTransferencia.getText());
            atendimentoControl.getInstance().create(atendimento);
            
            //crio um novo atendimento, para o usuario que esta recebendo o atendimento, transferido.
        }
        
        
        atendimento.setAssunto("");
        atendimento.setNomeCliente("");
        atendimento.setNomeContato("");
        atendimento.setObservacao("");
        atendimento.setObservacao2("");
        atendimento.setRelato("");
        atendimento.setSolucao("");
        atendimento.setStatus("INICIADO");
        atendimento.setData(new Timestamp(System.currentTimeMillis()));
        atendimento.setUsuario(Login.getInstance().getUsuario());
        
        int x = atendimentoControl.getInstance().create(atendimento);
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObsTransferencia = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        jLabel1.setText("Informe alguma informação sobre a transferencia do atendimento");

        jTextObsTransferencia.setColumns(20);
        jTextObsTransferencia.setRows(5);
        jScrollPane1.setViewportView(jTextObsTransferencia);

        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setText("Concluir Transferencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(291, 291, 291)
                .addComponent(jButton1)
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
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        transferenciaAtendimentos.getInstance(id).setVisible(false);
        transferenciaAtendimentos.getInstance(id).setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       concluirTransferencia();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextObsTransferencia;
    // End of variables declaration//GEN-END:variables
}
