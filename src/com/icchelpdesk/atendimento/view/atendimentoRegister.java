package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.cliente.control.ClienteControl;
import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.Principal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class atendimentoRegister extends javax.swing.JInternalFrame {
    
     private static atendimentoRegister instance = null;

    public static atendimentoRegister getInstance() {
        if (instance == null) {
            instance = new atendimentoRegister();
            Principal.getInstance().getDesktopPane().add(instance);
        }
        return instance;
    }
    
    
    public atendimentoRegister() {
            initComponents();
             PegarHora();
             
            jButtonGravar.setVisible(false);
            jButtonFinalizarAtendimento.setVisible(false);
            jButtonPausar.setVisible(false);
             ArrayList<Cliente> listaClientes = new ArrayList();
             listaClientes = ClienteControl.getInstance().read();
             
                for (Cliente clientes : listaClientes){
               jComboCliente.addItem(clientes.getNomeEmpresarial());
                }
              
              adicionarAtendimentoPausadoJCombo();
               
            
              
              
              
    }
    public void adicionarAtendimentoPausadoJCombo(){
        jComboBoxAtendimentosPausados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
        listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausados();
            
            for (atendimento atendimentos : listaAtendimentosPausados){
               jComboBoxAtendimentosPausados.addItem(atendimentos.getNomeCliente()+ " - "+atendimentos.getId());
               }
        
    }
     public void PegarHora(){
          Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		int hora = cal.get(Calendar.HOUR_OF_DAY);

		if(hora < 12 ) {
			jLabel8.setText("Bom dia "+Login.getInstance().getUsuario());
		}else if(hora >= 12 && hora < 18) {
			jLabel8.setText("Boa Tarde "+Login.getInstance().getUsuario());
		}else {
			jLabel8.setText("Boa Noite "+Login.getInstance().getUsuario());
		}
     }
     public void retomarAtendimento(){
                String atendimentoPausado = jComboBoxAtendimentosPausados.getSelectedItem().toString();
                String vect[] = atendimentoPausado.split(" - ");
                
                
               ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
                listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausadosId(Integer.parseInt(vect[1]));
               if(listaAtendimentosPausados.isEmpty()){
                   JOptionPane.showMessageDialog(null,"Parabens "+Login.getInstance().getUsuario()+" Você não tem nenhum atendimento em aberto, confira sua lista de atendimentos transferidos");
               }
               else{
                   
                for(int i=0;i<listaAtendimentosPausados.size();i++){
                  jTextSolucao.setText(listaAtendimentosPausados.get(i).getSolucao());
                  jTextNomeContato.setText(listaAtendimentosPausados.get(i).getNomeContato());
                  jTextObs.setText(listaAtendimentosPausados.get(i).getObservacao());
                  jTextObs2.setText(listaAtendimentosPausados.get(i).getObservacao2());
                  jTextRelato.setText(listaAtendimentosPausados.get(i).getRelato());
                  jComboAssunto.setSelectedItem(listaAtendimentosPausados.get(i).getAssunto());
                  jComboCliente.setSelectedItem(listaAtendimentosPausados.get(i).getNomeCliente());
                }
                    jButtonFinalizarAtendimento.setVisible(true);
                    }
     }
     public void updateAtendimentoPausado(){
         
          ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
          String nome = jComboBoxAtendimentosPausados.getSelectedItem().toString();
          String vect[] = nome.split(" - ");
          int id = Integer.parseInt(vect[1]);
         JOptionPane.showMessageDialog(null,"ID "+id);
         listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausadosId(id);
         atendimento atendimento = new atendimento();
        
        atendimento.setAssunto(jComboAssunto.getSelectedItem().toString());
        atendimento.setNomeCliente(jComboCliente.getSelectedItem().toString());
        atendimento.setNomeContato(jTextNomeContato.getText());
        atendimento.setObservacao(jTextObs.getText());
        atendimento.setObservacao2(jTextObs2.getText());
        atendimento.setRelato(jTextRelato.getText());
        atendimento.setSolucao(jTextSolucao.getText());
        atendimento.setStatus("CONCLUIDO");
        atendimento.setUsuario(Login.getInstance().getUsuario());
         atendimentoControl.getInstance().update(atendimento);
         
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonGravar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonPausar = new javax.swing.JButton();
        jButtonNovoAtendimento = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonFinalizarAtendimento = new javax.swing.JButton();
        jComboBoxAtendimentosPausados = new javax.swing.JComboBox<>();
        jButtonRetornarAtendimento = new javax.swing.JButton();
        jLabelGracinha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextNomeContato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboCliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextRelato = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboAssunto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextObs2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextSolucao = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextObs = new javax.swing.JTextArea();
        jLabelIdAtendimento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16.png"))); // NOI18N
        jButtonGravar.setText("GRAVAR Atendimento");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButton2.setText("SAIR");

        jButtonPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16X16Pause.png"))); // NOI18N
        jButtonPausar.setText("Pausar Atendimento");
        jButtonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausarActionPerformed(evt);
            }
        });

        jButtonNovoAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16NewAtendimento.png"))); // NOI18N
        jButtonNovoAtendimento.setText("Novo Atendimento");
        jButtonNovoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoAtendimentoActionPerformed(evt);
            }
        });

        jButton5.setText("Ver Atendimentos Pausados");

        jButtonFinalizarAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16Exit.png"))); // NOI18N
        jButtonFinalizarAtendimento.setText("Finalizar Atendimento");
        jButtonFinalizarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAtendimentoActionPerformed(evt);
            }
        });

        jComboBoxAtendimentosPausados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonRetornarAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16RetomarAtendimento.png"))); // NOI18N
        jButtonRetornarAtendimento.setText("Retomar Atendimento");
        jButtonRetornarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetornarAtendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovoAtendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFinalizarAtendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxAtendimentosPausados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButtonRetornarAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovoAtendimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPausar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinalizarAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRetornarAtendimento)
                .addGap(8, 8, 8)
                .addComponent(jComboBoxAtendimentosPausados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabel1.setText("Nome contato");

        jLabel2.setText("Cliente");

        jLabel3.setText("Relato");

        jComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClienteActionPerformed(evt);
            }
        });

        jTextRelato.setColumns(20);
        jTextRelato.setRows(5);
        jScrollPane1.setViewportView(jTextRelato);

        jLabel4.setText("Assunto");

        jComboAssunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Observacao 2");

        jTextObs2.setColumns(20);
        jTextObs2.setRows(5);
        jScrollPane2.setViewportView(jTextObs2);

        jLabel6.setText("Observacao");

        jLabel7.setText("Solucao");

        jTextSolucao.setColumns(20);
        jTextSolucao.setRows(5);
        jScrollPane3.setViewportView(jTextSolucao);

        jTextObs.setColumns(20);
        jTextObs.setRows(5);
        jScrollPane4.setViewportView(jTextObs);

        jLabelIdAtendimento.setText("Atendimento ID");

        javax.swing.GroupLayout jLabelGracinhaLayout = new javax.swing.GroupLayout(jLabelGracinha);
        jLabelGracinha.setLayout(jLabelGracinhaLayout);
        jLabelGracinhaLayout.setHorizontalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextNomeContato)
                            .addComponent(jComboAssunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3))
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(376, 376, 376)
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(jLabelIdAtendimento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jLabelGracinhaLayout.setVerticalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addComponent(jLabelIdAtendimento)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jLabelGracinha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClienteActionPerformed

    }//GEN-LAST:event_jComboClienteActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        atendimento atendimento = new atendimento();
        
        atendimento.setAssunto(jComboAssunto.getSelectedItem().toString());
        atendimento.setNomeCliente(jComboCliente.getSelectedItem().toString());
        atendimento.setNomeContato(jTextNomeContato.getText());
        atendimento.setObservacao(jTextObs.getText());
        atendimento.setObservacao2(jTextObs2.getText());
        atendimento.setRelato(jTextRelato.getText());
        atendimento.setSolucao(jTextSolucao.getText());
        atendimento.setStatus("CONCLUIDO");
        atendimento.setUsuario(Login.getInstance().getUsuario());
        atendimentoControl.getInstance().create(atendimento);
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausarActionPerformed
       atendimento atendimento = new atendimento();
        
        atendimento.setAssunto(jComboAssunto.getSelectedItem().toString());
        atendimento.setNomeCliente(jComboCliente.getSelectedItem().toString());
        atendimento.setNomeContato(jTextNomeContato.getText());
        atendimento.setObservacao(jTextObs.getText());
        atendimento.setObservacao2(jTextObs2.getText());
        atendimento.setRelato(jTextRelato.getText());
        atendimento.setSolucao(jTextSolucao.getText());
        atendimento.setUsuario(Login.getInstance().getUsuario());
        atendimento.setStatus("PAUSADO");
        atendimentoControl.getInstance().create(atendimento);
    }//GEN-LAST:event_jButtonPausarActionPerformed

    private void jButtonNovoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoAtendimentoActionPerformed
       jTextNomeContato.setText("");
       jTextSolucao.setText("");
       jTextObs.setText("");
       jTextObs2.setText("");
       jComboCliente.setSelectedIndex(0);
       jComboAssunto.setSelectedIndex(0);
       jTextRelato.setText("");
        
       jButtonFinalizarAtendimento.setVisible(false);
       jButtonGravar.setVisible(true);
       jButtonPausar.setVisible(true);
    }//GEN-LAST:event_jButtonNovoAtendimentoActionPerformed

    private void jButtonRetomarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetomarAtendimentoActionPerformed
   
        
    }//GEN-LAST:event_jButtonRetomarAtendimentoActionPerformed

    private void jTextNomeContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeContatoActionPerformed

    private void jComboBoxAtendimentosPausadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxAtendimentosPausadosKeyPressed
        if(evt.getKeyCode() == 116){
            adicionarAtendimentoPausadoJCombo();
        }
    }//GEN-LAST:event_jComboBoxAtendimentosPausadosKeyPressed

    private void jButtonRetornarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetornarAtendimentoActionPerformed
          
        retomarAtendimento();
        jButtonGravar.setVisible(false);
        
    }//GEN-LAST:event_jButtonRetornarAtendimentoActionPerformed

    private void jButtonFinalizarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAtendimentoActionPerformed
        updateAtendimentoPausado();
    }//GEN-LAST:event_jButtonFinalizarAtendimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonFinalizarAtendimento;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovoAtendimento;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonRetornarAtendimento;
    private javax.swing.JComboBox<String> jComboAssunto;
    private javax.swing.JComboBox<String> jComboBoxAtendimentosPausados;
    private javax.swing.JComboBox<String> jComboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jLabelGracinha;
    private javax.swing.JLabel jLabelIdAtendimento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextNomeContato;
    private javax.swing.JTextArea jTextObs;
    private javax.swing.JTextArea jTextObs2;
    private javax.swing.JTextArea jTextRelato;
    private javax.swing.JTextArea jTextSolucao;
    // End of variables declaration//GEN-END:variables
}
