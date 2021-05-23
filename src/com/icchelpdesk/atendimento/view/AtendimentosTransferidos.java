package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class AtendimentosTransferidos extends javax.swing.JInternalFrame {

    static AtendimentosTransferidos instance = null;
    
    public static AtendimentosTransferidos getInstance(){
        if (instance == null){
            instance = new AtendimentosTransferidos();
            PrincipalTeste.getInstance().getDesktopPane().add(instance);
        }
        return instance;
    }
    
    public AtendimentosTransferidos() {
        initComponents();
        addAtendimentosTransferidosJCombo();
    }

   public void addAtendimentosTransferidosJCombo(){
       ArrayList<atendimento> listaAtendimento = new ArrayList();
       listaAtendimento = atendimentoControl.getInstance().buscaAtendimentoTransferido();
            for (atendimento atendimentoTransferido : listaAtendimento){
                jComboNomeCliente.addItem(atendimentoTransferido.getNomeCliente());
       }
       
       
   }
   public void consultarDetalhesDeAtendimentoTransferido(){
       ArrayList<atendimento> listaAtendimento = new ArrayList();
       listaAtendimento = atendimentoControl.getInstance().buscaAtendimentoTransferido(); // este metodo busca atendimento transferido busca atendimentos transferidos para o usuario que esta logado, devido a forma que implementei no antedimentoControl
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       
       for (atendimento atendimentoTransferido : listaAtendimento){
           
           jTextObsTransferencia.setText(atendimentoTransferido.getObsTransferencia());
           jTextRelatoCliente.setText(atendimentoTransferido.getRelato());
           jTextObs.setText(atendimentoTransferido.getObservacao());
           jTextObs2.setText(atendimentoTransferido.getObservacao2());
           jTextSolucao.setText(atendimentoTransferido.getSolucao());
           jLabelNomeContato.setText(atendimentoTransferido.getNomeContato());
           jLabelData.setText(sdf.format(atendimentoTransferido.getData()));
           jLabelTransferidoPor.setText(atendimentoTransferido.getUsuario());
           jLabelProtocolo.setText(""+atendimentoTransferido.getId());
       
       }
   }
   public void recusarAtendimento(){
       
        if(jLabelProtocolo.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Você deve selecionar o nome do cliente o qual foi transferido o atendimento a você."
                    + "\n Apos isso você deve clicar em consultar detalhes."
                    + "\n para depois então recuar ou aceitar a transferencia do atendimento.","INFOMARTION",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        atendimento atendimento = new atendimento(); 
        int id = Integer.parseInt(jLabelProtocolo.getText());
        
        ArrayList<atendimento> listaAtendimento = atendimentoControl.getInstance().buscaAtendimentosTransferidosId(id);
        int idTransferido =0;
        
        for(int i=0;i<listaAtendimento.size();i++){
            
           idTransferido = listaAtendimento.get(i).getIdTransferido();
            atendimento.setId(idTransferido);
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setStatus("PAUSADO");
            atendimento.setUsuario(listaAtendimento.get(i).getUsuario());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setData(listaAtendimento.get(i).getData());
            atendimento.setTransferencia("TRANSFERENCIA DEVOLVIDA");
            atendimento.setIdTransferido(id);    
            atendimento.setObsTransferencia(jTextObsTransferencia.getText()); 
            atendimentoControl.getInstance().update(atendimento);
            atendimento.setMotivoPausa(",");
            atendimentoControl.getInstance().update(atendimento);
        
        }
        
        atendimento.setId(id);
        atendimentoControl.getInstance().delete(atendimento);
 
        
        }
   } 
   public void aceitarAtendimento(){
        atendimento atendimento = new atendimento(); 
        int id = Integer.parseInt(jLabelProtocolo.getText());
        
        ArrayList<atendimento> listaAtendimento = atendimentoControl.getInstance().buscaAtendimentosTransferidosId(id);
        int idTransferido =0;
        
        for(int i=0;i<listaAtendimento.size();i++){
            
          
            atendimento.setId(listaAtendimento.get(i).getId());
            atendimento.setNomeCliente(listaAtendimento.get(i).getNomeCliente());
            atendimento.setRelato(listaAtendimento.get(i).getRelato());
            atendimento.setObservacao(listaAtendimento.get(i).getObservacao());
            atendimento.setObservacao2(listaAtendimento.get(i).getObservacao2());
            atendimento.setSolucao(listaAtendimento.get(i).getSolucao());
            atendimento.setAssunto(listaAtendimento.get(i).getAssunto());
            atendimento.setStatus("PAUSADO");
            atendimento.setUsuario(Login.getInstance().getUsuario());
            atendimento.setNomeContato(listaAtendimento.get(i).getNomeContato());
            atendimento.setData(listaAtendimento.get(i).getData());
            atendimento.setTransferencia("TRANSFERENCIA DE ACEITA");
            atendimento.setIdTransferido(listaAtendimento.get(i).getIdTransferido());    
            atendimento.setObsTransferencia(jTextObsTransferencia.getText()); 
            atendimento.setMotivoPausa("");
            atendimentoControl.getInstance().update(atendimento);
 
        
        }
   }
   
   
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboNomeCliente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNomeContato = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelProtocolo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextRelatoCliente = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextObs = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextObs2 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextSolucao = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObsTransferencia = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabelTransferidoPor = new javax.swing.JLabel();
        jButtonNegative = new javax.swing.JButton();
        jButtonAccept = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Nome Cliente");

        jComboNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboNomeClienteKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/Zoom-icon.png"))); // NOI18N
        jButton1.setText("Consultar Detalhes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Nome de quem entrou em contato");

        jLabelNomeContato.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelNomeContato.setForeground(new java.awt.Color(255, 0, 0));
        jLabelNomeContato.setToolTipText("b");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Data do contato");

        jLabelData.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Protocolo");

        jLabelProtocolo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelProtocolo.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelNomeContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabelProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabelProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Contato", jPanel1);

        jTextRelatoCliente.setEditable(false);
        jTextRelatoCliente.setColumns(20);
        jTextRelatoCliente.setRows(5);
        jScrollPane2.setViewportView(jTextRelatoCliente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relato Cliente", jPanel2);

        jTextObs.setEditable(false);
        jTextObs.setColumns(20);
        jTextObs.setRows(5);
        jScrollPane3.setViewportView(jTextObs);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Observação", jPanel3);

        jTextObs2.setEditable(false);
        jTextObs2.setColumns(20);
        jTextObs2.setRows(5);
        jScrollPane4.setViewportView(jTextObs2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Observação 2", jPanel4);

        jTextSolucao.setEditable(false);
        jTextSolucao.setColumns(20);
        jTextSolucao.setRows(5);
        jScrollPane5.setViewportView(jTextSolucao);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Solução", jPanel5);

        jTextObsTransferencia.setEditable(false);
        jTextObsTransferencia.setColumns(20);
        jTextObsTransferencia.setRows(5);
        jScrollPane1.setViewportView(jTextObsTransferencia);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Observação de Transferencia", jPanel6);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Transferido Por");

        jLabelTransferidoPor.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabelTransferidoPor.setForeground(new java.awt.Color(255, 0, 0));

        jButtonNegative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16Exit.png"))); // NOI18N
        jButtonNegative.setText("RECUSAR");
        jButtonNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNegativeActionPerformed(evt);
            }
        });

        jButtonAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16X16Accept.png"))); // NOI18N
        jButtonAccept.setText("ACEITAR");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTransferidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboNomeCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonNegative)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAccept))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(342, 342, 342)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTransferidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAccept)
                    .addComponent(jButtonNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      consultarDetalhesDeAtendimentoTransferido();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNegativeActionPerformed
        recusarAtendimento();
    }//GEN-LAST:event_jButtonNegativeActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        aceitarAtendimento();
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    private void jComboNomeClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboNomeClienteKeyPressed
        if(evt.getKeyCode() == 116){
            addAtendimentosTransferidosJCombo();
        }
    }//GEN-LAST:event_jComboNomeClienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonNegative;
    private javax.swing.JComboBox<String> jComboNomeCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelNomeContato;
    private javax.swing.JLabel jLabelProtocolo;
    private javax.swing.JLabel jLabelTransferidoPor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextObs;
    private javax.swing.JTextArea jTextObs2;
    private javax.swing.JTextArea jTextObsTransferencia;
    private javax.swing.JTextArea jTextRelatoCliente;
    private javax.swing.JTextArea jTextSolucao;
    // End of variables declaration//GEN-END:variables
}
