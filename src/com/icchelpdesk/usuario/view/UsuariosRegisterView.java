package com.icchelpdesk.usuario.view;

import com.icchelpdesk.sistema.view.PrincipalTeste;
import com.icchelpdesk.usuario.control.UsuarioControl;
import com.icchelpdesk.usuario.model.bean.Usuario;
import javax.swing.JOptionPane;

public class UsuariosRegisterView extends javax.swing.JInternalFrame {

    private static UsuariosRegisterView instance = null;

    public static UsuariosRegisterView getInstance() {
        if (instance == null) {
            instance = new UsuariosRegisterView();
            PrincipalTeste.getInstance().getDesktopPane().add(instance);
        }
        return instance;
    }

    Usuario usuario = null;

    boolean exclusaoPermitida = false;

    public UsuariosRegisterView() {
        initComponents();
    }

    public void novo() {
        this.usuario = null;
        limpar();
        this.setVisible(false);
        this.setVisible(true);
        jbSalvar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbCadastrar.setEnabled(true);
    }

    public void editar(Usuario usuario) {
        limpar();
        extrair(usuario);
        this.setVisible(false);
        this.setVisible(true);
        jbSalvar.setEnabled(true);
        jbExcluir.setEnabled(true);
        jbCadastrar.setEnabled(false);
    }

    private void limpar() {
        jsPermissao.setText(String.valueOf(0));
        jtfNome.setText("");
        jtfUsuario.setText("");
        jpfSenha.setText("");

        jcbEstado.removeAllItems();
        for (String s : UsuarioControl.getInstance().estados()) {
            jcbEstado.addItem(s);
        }
        jcbEstado.setSelectedIndex(0);
    }

    private void extrair(Usuario usuario) {
        this.usuario = usuario;
        jsPermissao.setText(usuario.getPermissao() + "");
        jtfNome.setText(usuario.getNome());
        jtfUsuario.setText(usuario.getCodigo());
        jpfSenha.setText(usuario.getSenha());
        jcbEstado.setSelectedItem(usuario.getEstado());
    }

    private Usuario criar() {
        Usuario usuarioCriar = new Usuario();
        if (this.usuario != null) {
            usuarioCriar.setId(this.usuario.getId());
            usuarioCriar.setCreated_at(this.usuario.getCreated_at());
        }
        usuarioCriar.setPermissao(Integer.parseInt(jsPermissao.getText()));
        usuarioCriar.setNome(jtfNome.getText());
        usuarioCriar.setCodigo(jtfUsuario.getText());
        usuarioCriar.setSenha(jpfSenha.getText());
        usuarioCriar.setEstado(jcbEstado.getSelectedItem().toString());

        return usuarioCriar;
    }

    private boolean validar() {
        if (jtfNome.getText().trim().length() > 0) {
            if (jtfUsuario.getText().trim().length() > 3) {
                if (jpfSenha.getText().trim().length() > 0) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "A senha não pode ser vazia");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo \"usuario\" precisa ter mais que 3 letras");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo \"nome\" está vazio");
        }
        return false;
    }

    private void cadastrar() {
        if (validar() == true) {
            Usuario usuario = criar();
            UsuarioControl.getInstance().create(usuario);
            JOptionPane.showMessageDialog(null, "Usuário \"" + usuario.getNome() + "\" foi cadastrado.");
            limpar();
        }
    }

    private void salvar() {
        if (validar() == true) {
            Usuario usuario = criar();
            UsuarioControl.getInstance().update(usuario);
            JOptionPane.showMessageDialog(null, "Usuário \"" + usuario.getNome() + "\" foi atualizado.");
            limpar();
            fechar();
        }
    }

    private void excluir() {
        if (exclusaoPermitida == true) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza") == JOptionPane.OK_OPTION) {
                UsuarioControl.getInstance().delete(usuario);
                JOptionPane.showMessageDialog(null, "Usuário \"" + usuario.getNome() + "\" apagado.");
                limpar();
                fechar();
            }
        } else {
            UsuarioControl.getInstance().disable(usuario);
            JOptionPane.showMessageDialog(null, "Usuário \"" + usuario.getNome() + "\" desativado.");
            limpar();
            fechar();
        }
    }

    private void fechar() {
        setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel8 = new javax.swing.JPanel();
        jbCadastrar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jsPermissao = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulário de Usuário");

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFechar)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel8);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Usuário");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Senha");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Estado");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Permissão");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Perfil");

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfNome)
                            .addComponent(jtfUsuario)
                            .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 482, Short.MAX_VALUE))
                            .addComponent(jsPermissao))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Usuário", jPanel1);

        jSplitPane2.setRightComponent(jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane2)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        fechar();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limpar();
    }//GEN-LAST:event_jbLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jsPermissao;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
