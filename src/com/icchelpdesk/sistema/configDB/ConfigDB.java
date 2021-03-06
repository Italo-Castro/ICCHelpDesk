package com.icchelpdesk.sistema.configDB;

import com.icchelpdesk.sistema.model.util.MySQLDAO;
import com.icchelpdesk.sistema.view.Login;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class ConfigDB extends javax.swing.JFrame {

    public static ConfigDB instance = null;
    
    public static ConfigDB getInstance(){
        if(instance == null) {
            instance = new ConfigDB();
        }
        return instance;
    }
    
    public void setInstance (ConfigDB n){
        instance = n;
    }
    public ConfigDB() {
        initComponents();
       setLocationRelativeTo(null);
    }
    
   public void botaoSalvarESair(){
       
        String endereco = jTextEndereco.getText();
        int porta  = Integer.parseInt(jTextPorta.getText());
        String nomeBaseDeDados = jTextNomeBaseDeDados.getText();
        String usuario = jTextUsuario.getText();
        String senha = jTextSenha.getText();
        
        
        String path = "configDB.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            
            bw.write(endereco+";");
            bw.write(porta+";");
            bw.write(nomeBaseDeDados+";");
            bw.write(usuario+";");
            bw.write(senha+";");
            bw.close();
            
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error ao abrir arquivo de configuração!");
        }    

        MySQLDAO.setConnection(null);
        
        
        
        MySQLDAO.setDBURL(endereco, porta, nomeBaseDeDados);
        MySQLDAO.setUsuarioSenha(usuario, senha);
        MySQLDAO.getConnection_Local();
        
       
        if( MySQLDAO.resultado == 1){
            JOptionPane.showMessageDialog(null, "CONECTADO");
            this.dispose();
            Login.getInstance().setVisible(true);
        }
        else {
             JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR");
        }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextPorta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNomeBaseDeDados = new javax.swing.JTextField();
        jButtonSaveAndExit = new javax.swing.JButton();
        jButtoTest = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Endereço");

        jTextEndereco.setText("localhost");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Porta");

        jTextPorta.setText("3306");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Base de Dados");

        jTextNomeBaseDeDados.setText("icchelpdesk");

        jButtonSaveAndExit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonSaveAndExit.setText("Salvar e Sair");
        jButtonSaveAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveAndExitActionPerformed(evt);
            }
        });

        jButtoTest.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtoTest.setText("Testar");
        jButtoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoTestActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonExit.setText("Sair");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Usuario");

        jTextUsuario.setText("root");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Senha");

        jTextSenha.setText("8523");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExit)
                        .addGap(194, 194, 194)
                        .addComponent(jButtonSaveAndExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addComponent(jButtoTest))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEndereco)
                            .addComponent(jTextPorta)
                            .addComponent(jTextNomeBaseDeDados, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextSenha)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNomeBaseDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSaveAndExit)
                            .addComponent(jButtoTest))
                        .addContainerGap())
                    .addComponent(jButtonExit, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveAndExitActionPerformed
        botaoSalvarESair();
    }//GEN-LAST:event_jButtonSaveAndExitActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoTestActionPerformed
        MySQLDAO.setConnection(null);
        String endereco = jTextEndereco.getText();
        int porta  = Integer.parseInt(jTextPorta.getText());
        String nomeBaseDeDados = jTextNomeBaseDeDados.getText();
        String usuario = jTextUsuario.getText();
        String senha = jTextSenha.getText();
        
        
        MySQLDAO.setDBURL(endereco, porta, nomeBaseDeDados);
        MySQLDAO.setUsuarioSenha(usuario, senha);
        MySQLDAO.getConnection_Local();
        
       
        if( MySQLDAO.resultado == 1){
            JOptionPane.showMessageDialog(null, "CONECTADO");
           
        }
        else {
             JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR");
        }
                           
    }//GEN-LAST:event_jButtoTestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtoTest;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonSaveAndExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextNomeBaseDeDados;
    private javax.swing.JTextField jTextPorta;
    private javax.swing.JPasswordField jTextSenha;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
