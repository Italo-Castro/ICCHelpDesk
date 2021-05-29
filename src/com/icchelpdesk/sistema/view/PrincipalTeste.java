

package com.icchelpdesk.sistema.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.atendimento.view.AtendimentosTransferidos;
import com.icchelpdesk.atendimento.view.AtendimentoRegister;
import com.icchelpdesk.atendimento.view.AtendimentosView;
import com.icchelpdesk.atendimento.view.TransferenciaAtendimentos;
import com.icchelpdesk.cliente.view.ClienteCadastro;
import com.icchelpdesk.pendencia.view.RegistrarPendencia;
import com.icchelpdesk.possiveisClientes.view.possiveisClientesVIEW;
import com.icchelpdesk.usuario.view.UsuariosRegisterView;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class PrincipalTeste extends javax.swing.JFrame {

    private static PrincipalTeste instance = null;

    public static PrincipalTeste getInstance() {
        if (instance == null) {
            instance = new PrincipalTeste();
        }
        return instance;
    }

    public JDesktopPane getDesktopPane() {
        return jDesktopPane1;
    }
    
    public PrincipalTeste() {
        initComponents();
        construtor();
     
        this.setTitle("Ola ! "+Login.getInstance().getUsuario());
        jLabelUsuario.setText("Ola ! "+Login.getInstance().getUsuario());        
    }

    private void construtor() {
       
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jMenuItem3 = new javax.swing.JMenuItem();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAtendimento = new javax.swing.JMenu();
        jMenuItemRegistrarAtendimento = new javax.swing.JMenuItem();
        jMenuItemConsultarAtendimento = new javax.swing.JMenuItem();
        jMenuTransferenciaDeAtendimento = new javax.swing.JMenu();
        jMenuItemTransferenciaDeAtendimento = new javax.swing.JMenuItem();
        jMenuItemAtendimentosTransferidos = new javax.swing.JMenuItem();
        jMenuPossiveisClientes = new javax.swing.JMenu();
        jMenuItemRegistrarPossivelCliente = new javax.swing.JMenuItem();
        jMenuItemVerPossiveisClientes = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemCadastro = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jTree1);

        jMenuItem3.setText("jMenuItem3");

        jFormattedTextField1.setText("jFormattedTextField1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jCheckBox1.setText("jCheckBox1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPasswordField1.setText("jPasswordField1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/64x64NewAtendimento.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Registrar Atendiemento");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Transferidos A Você");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/64X64transfer-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LOGOUT");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setText("Voce esta logado com o perfil de teste");

        jDesktopPane1.setLayer(jLabelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel3)))
        );

        jMenuAtendimento.setText("Atendimento");

        jMenuItemRegistrarAtendimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRegistrarAtendimento.setText("Registrar Atendimento");
        jMenuItemRegistrarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarAtendimentoActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemRegistrarAtendimento);

        jMenuItemConsultarAtendimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemConsultarAtendimento.setText("Consultar Atendimento");
        jMenuItemConsultarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarAtendimentoActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemConsultarAtendimento);

        jMenuBar1.add(jMenuAtendimento);

        jMenuTransferenciaDeAtendimento.setText("Transferencia de Atendimento");

        jMenuItemTransferenciaDeAtendimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTransferenciaDeAtendimento.setText("Transferencia de atendimento");
        jMenuItemTransferenciaDeAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransferenciaDeAtendimentoActionPerformed(evt);
            }
        });
        jMenuTransferenciaDeAtendimento.add(jMenuItemTransferenciaDeAtendimento);

        jMenuItemAtendimentosTransferidos.setText("Atendimentos transferidos para você");
        jMenuItemAtendimentosTransferidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtendimentosTransferidosActionPerformed(evt);
            }
        });
        jMenuTransferenciaDeAtendimento.add(jMenuItemAtendimentosTransferidos);

        jMenuBar1.add(jMenuTransferenciaDeAtendimento);

        jMenuPossiveisClientes.setText("Possiveis Clientes");

        jMenuItemRegistrarPossivelCliente.setText("Registrar possivel cliente");
        jMenuItemRegistrarPossivelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarPossivelClienteActionPerformed(evt);
            }
        });
        jMenuPossiveisClientes.add(jMenuItemRegistrarPossivelCliente);

        jMenuItemVerPossiveisClientes.setText("Ver possiveis clientes");
        jMenuItemVerPossiveisClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerPossiveisClientesActionPerformed(evt);
            }
        });
        jMenuPossiveisClientes.add(jMenuItemVerPossiveisClientes);

        jMenuBar1.add(jMenuPossiveisClientes);

        jMenuUsuarios.setText("Usuarios");

        jMenuItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        jMenuCliente.setText("Cliente");

        jMenuItemCadastro.setText("Cadastro");
        jMenuItemCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemCadastro);

        jMenuBar1.add(jMenuCliente);

        jMenu1.setText("Pendencias");

        jMenuItem2.setText("Registrar Pendencia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    private void jMenuItemCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroActionPerformed
        if(Login.getInstance().getNvPermiss() < 10){
                
            JOptionPane.showMessageDialog(null,Login.getInstance().getUsuario() + " Você não tem permissão para cadastrar novos clientes","   ACESS DENIED!!!      ",JOptionPane.ERROR_MESSAGE);
            
        }else {
        
        ClienteCadastro.getInstance().setVisible(false);
        ClienteCadastro.getInstance().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemCadastroActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        if(Login.getInstance().getNvPermiss() < 10){
                
            JOptionPane.showMessageDialog(null,Login.getInstance().getUsuario() + " Você não tem permissão para cadastrar novos usuarios","   ACESS DENIED!!!      ",JOptionPane.ERROR_MESSAGE);
            
        }else {
         UsuariosRegisterView.getInstance().setVisible(false);
         UsuariosRegisterView.getInstance().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemRegistrarPossivelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarPossivelClienteActionPerformed
        possiveisClientesVIEW.getInstance().setVisible(false);
        possiveisClientesVIEW.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistrarPossivelClienteActionPerformed

    private void jMenuItemRegistrarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarAtendimentoActionPerformed
         AtendimentoRegister.getInstance().setVisible(false);
         AtendimentoRegister.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistrarAtendimentoActionPerformed

    private void jMenuItemConsultarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarAtendimentoActionPerformed
         AtendimentosView.getInstance().setVisible(false);
         AtendimentosView.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultarAtendimentoActionPerformed

    private void jMenuItemTransferenciaDeAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransferenciaDeAtendimentoActionPerformed
            TransferenciaAtendimentos.getInstance(0).setVisible(false);
           TransferenciaAtendimentos.getInstance(0).setVisible(true);
    }//GEN-LAST:event_jMenuItemTransferenciaDeAtendimentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         AtendimentoRegister.getInstance().setVisible(false);
         AtendimentoRegister.getInstance().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
        atendimentoControl.getInstance().buscaAtendimentosPausados();
        
        if(listaAtendimentosPausados.isEmpty()){
            JOptionPane.showMessageDialog(null,"Não há atendimentos transferidos para você","",JOptionPane.PLAIN_MESSAGE);
        }
        else {
         AtendimentosTransferidos.getInstance().setVisible(false);
         AtendimentosTransferidos.getInstance().setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItemAtendimentosTransferidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtendimentosTransferidosActionPerformed
        
         AtendimentosTransferidos.getInstance().setVisible(false);
         AtendimentosTransferidos.getInstance().setVisible(true);
        
    }//GEN-LAST:event_jMenuItemAtendimentosTransferidosActionPerformed

    private void jMenuItemVerPossiveisClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerPossiveisClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVerPossiveisClientesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RegistrarPendencia.getInstance().setVisible(false);
        RegistrarPendencia.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAtendimento;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAtendimentosTransferidos;
    private javax.swing.JMenuItem jMenuItemCadastro;
    private javax.swing.JMenuItem jMenuItemConsultarAtendimento;
    private javax.swing.JMenuItem jMenuItemRegistrarAtendimento;
    private javax.swing.JMenuItem jMenuItemRegistrarPossivelCliente;
    private javax.swing.JMenuItem jMenuItemTransferenciaDeAtendimento;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenuItem jMenuItemVerPossiveisClientes;
    private javax.swing.JMenu jMenuPossiveisClientes;
    private javax.swing.JMenu jMenuTransferenciaDeAtendimento;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
