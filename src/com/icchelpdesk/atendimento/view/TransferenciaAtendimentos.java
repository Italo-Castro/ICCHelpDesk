package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.Principal;
import com.icchelpdesk.usuario.control.UsuarioControl;
import com.icchelpdesk.usuario.model.bean.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

    


public class TransferenciaAtendimentos extends javax.swing.JInternalFrame {
    
    static int id =0; // protocolo que chegara por parametro da classe atendimento register depois da execução do botão  de transferir
    
    private static TransferenciaAtendimentos instance = null;
    
    public static TransferenciaAtendimentos getInstance(int id){
        if(instance == null){
            instance = new TransferenciaAtendimentos(id); // se a instancia for nula crio uma nova, com o id passado pelo parametro
             Principal.getInstance().getDesktopPane().add(instance);
        }
        return instance;
        }
        
        

        
        
    
    
    public TransferenciaAtendimentos(int id) {
        this.id=id;
        initComponents();
        jTextProtocolo.setText(""+id);
        jComboUsuarios();
    }
    public void jComboUsuarios(){
        jComboUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        ArrayList<Usuario> listaUsuario = new ArrayList();
        listaUsuario = UsuarioControl.getInstance().read();
            
        
        
            for (Usuario usuarios : listaUsuario){
                String usuario = Login.getInstance().getUsuario();
               listaUsuario.remove(usuarios.getNome().equals(usuario));// REMOVENDO DA LISTA ONDE O NOME DE USUARIO E IGUAL AO USUARIO QUE ESTA LOGADO, PARA NÃO PERMITIR QUE O ATENDIMENTO SEJA TRANSFERIDO PARA SI MESMO
              jComboUsuarios.addItem(usuarios.getNome());
                       }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextProtocolo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboUsuarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Para fazer a transferencia");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Informe para qual usuario deseja transferir");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Informe o protocolo");

        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jTextProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButton1)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextProtocolo.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Informe o protocolo do atendimento que deseja transferir","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else if(jComboUsuarios.getSelectedIndex() == 0){
              JOptionPane.showMessageDialog(null,"Informe para qual usuario deseja transferir deseja transferir","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else {
        id = Integer.parseInt(jTextProtocolo.getText());
        String usuarioReecbe = jComboUsuarios.getSelectedItem().toString();
        obsTransferenciaAtendimento.getInstance(id,usuarioReecbe).setVisible(false);
        obsTransferenciaAtendimento.getInstance(id,usuarioReecbe).setVisible(true);
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextProtocolo;
    // End of variables declaration//GEN-END:variables
}
