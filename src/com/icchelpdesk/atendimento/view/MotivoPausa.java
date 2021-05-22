package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.sistema.view.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class MotivoPausa extends javax.swing.JInternalFrame {
    
    public static MotivoPausa instance = null;
    
    public static MotivoPausa getInstance(){
        if(instance == null){
            instance = new MotivoPausa();
            Principal.getInstance().getDesktopPane().add(instance);
        }
        return instance;
    }
    
    public static void setInstance(MotivoPausa in) {
       instance = in;
    }
    
    public MotivoPausa() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboMotivo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonSaiTelaMotivoPausa = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);

        jComboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "HORARIO DE ALMOÇO", "FIM DO EXPEDIENTE", " " }));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Selecione o motivo que o atendimento esta sendo pausado");

        jButtonSaiTelaMotivoPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16Exit.png"))); // NOI18N
        jButtonSaiTelaMotivoPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaiTelaMotivoPausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jButtonSaiTelaMotivoPausa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaiTelaMotivoPausa)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaiTelaMotivoPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaiTelaMotivoPausaActionPerformed
        if(jComboMotivo.getSelectedItem().toString().equals(" ")) {
            JOptionPane.showMessageDialog(null,"É necessario informar o motivo pelo qual esta pausando o atendimento","MOTIVO FAILED",JOptionPane.ERROR_MESSAGE);
            MotivoPausa.setInstance(null);
        }
        else {
        AtendimentoRegister.getInstance().setMotivoPausa(jComboMotivo.getSelectedItem().toString());
        this.dispose();
        AtendimentoRegister.getInstance().pausarAtendimento();
        }
    }//GEN-LAST:event_jButtonSaiTelaMotivoPausaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaiTelaMotivoPausa;
    private javax.swing.JComboBox<String> jComboMotivo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
