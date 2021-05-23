package com.icchelpdesk.sistema.view;

import com.icchelpdesk.sistema.model.util.MySQLDAO;
import static com.icchelpdesk.sistema.model.util.MySQLDAO.setDBURL;
import static com.icchelpdesk.sistema.model.util.MySQLDAO.setUsuarioSenha;
import com.icchelpdesk.usuario.control.UsuarioControl;
import com.icchelpdesk.usuario.model.bean.Usuario;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public String usuario;
    private static Login instance = null;
    private int nvPermissao =0 ;
    
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
    
    public Login() {
        initComponents();
        construtor();
        String endereco = "";
        int porta = 3306;
        String nomeDataBase = "";
        String WAMP_USER = "";
        String WAMP_PASSWORD = " ";
        
        String path = "C://Users//Italo//Documents//NetBeansProjects//ICCHelpDesk//configDB.txt";
        try (BufferedReader bw = new BufferedReader(new FileReader(path))){
        
                String line = bw.readLine();
            
                
                 String vect[] = line.split(";");
                 endereco = vect[0];
                 Integer.parseInt(vect[1]);
                 nomeDataBase = vect[2];
                 WAMP_USER = vect[3];
                 WAMP_PASSWORD = vect[4];
  
            
           ;
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Erro ao manipular arquivo");
            
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Verifique o arquivo de configuração","Arquivo de configuração de conexão invalido",JOptionPane.ERROR_MESSAGE);
             int x = JOptionPane.showConfirmDialog(null, "Deseja abrir a tela de configuração da conexao com o banco de dados ?");
            
            if(x == JOptionPane.YES_OPTION){
                 new ConfigDB().setVisible(true);
            }
            else {
                System.exit(0);
            }
        
        }
        /*
        System.out.print("\n"+endereco);
        System.out.print("\n"+porta);
        System.out.print("\n"+nomeDataBase);
        System.out.print("\n"+WAMP_USER);
        System.out.print("\n Senha -> "+WAMP_PASSWORD);
        */
       
        
        
        MySQLDAO.setConnection(null);
        MySQLDAO.setDBURL(endereco, porta, nomeDataBase);
        MySQLDAO.setUsuarioSenha(WAMP_USER, WAMP_PASSWORD);
        MySQLDAO.getConnection_Local();
        
    }
   
    private void construtor() {
        setLocationRelativeTo(null);
    }
    public void setnvPermiss(int nvPermissao){
        this.nvPermissao=nvPermissao;
    }
    public int getNvPermiss(){
        return nvPermissao;
    }
    private void entrar() {
        if(MySQLDAO.resultado == 1){
        Usuario login = new Usuario();
        login.setCodigo(jtfUsuario.getText());
        login.setSenha(jpfSenha.getText());

        login = UsuarioControl.getInstance().realizarLogin(login);
        
       
            
            if (login != null) {
                if ((login.getEstado().equals("ATIVO") ) || login.getEstado().equals("A")) {
                    setnvPermiss(login.getPermissao());
                    JOptionPane.showMessageDialog(null, "Seja bem vindo " + login.getNome());
                    this.usuario = login.getNome();
                    
                    if(login.getPerfil().equals("DEV")) {
                        
                        PrincipalDev.getInstance().setVisible(true);
                        this.setVisible(false); 
                        System.out.print("dev");
                        
                    }
                    else if (login.getPerfil().equals("SUPORTE")) {
                        
                        this.setVisible(false);
                    }
                    else if (login.getPerfil().equals("TESTE")) {
                        
                      PrincipalTeste.getInstance().setVisible(true);
                      this.setVisible(false);
                      System.out.print("teste");
                      
                    }
                   
                    else {
                        JOptionPane.showMessageDialog(null,"USUARIO SEM PERFIL");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuário Desativado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados não conferem");
            }
            
        }else {
            JOptionPane.showMessageDialog(null,"Não conectado ao banco de dados","ERROR",JOptionPane.ERROR_MESSAGE);
            int x = JOptionPane.showConfirmDialog(null, "Deseja abrir a tela de configuração da conexao com o banco de dados ?");
            
            if(x == JOptionPane.YES_OPTION){
                 new ConfigDB().setVisible(true);
            }
            else {
                System.exit(0);
            }
        }

            
    }
     public String getUsuario(){
        return this.usuario;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jbEntrar = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/96x96/Occupations-Technical-Support-Representative-Male-Light-icon.png"))); // NOI18N

        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });

        jbEntrar.setText("Entrar");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });

        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/man-icon.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/Status-dialog-password-icon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jtfUsuario)))
                    .addComponent(jbEntrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEntrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntrarActionPerformed
        entrar();
    }//GEN-LAST:event_jbEntrarActionPerformed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    private void jpfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_jpfSenhaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbEntrar;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
