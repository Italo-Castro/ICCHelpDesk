package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.cliente.control.ClienteControl;
import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
                 jButtonGravar.setVisible(true);
                 jButtonPausar.setVisible(true);
                String atendimentoPausado = jComboBoxAtendimentosPausados.getSelectedItem().toString();
                String vect[] = atendimentoPausado.split(" - ");
                
                
               ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
                listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausadosId(Integer.parseInt(vect[1]));
               if(listaAtendimentosPausados.isEmpty()){
                   JOptionPane.showMessageDialog(null,"Parabens "+Login.getInstance().getUsuario()+" Você não tem nenhum atendimento em aberto, confira sua lista de atendimentos transferidos ");
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
                  jLabelId.setText(""+listaAtendimentosPausados.get(i).getId());
                }
                  
                    }
     }
     public void updateAtendimentoPausado(){
         
          ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
          String nome = jComboBoxAtendimentosPausados.getSelectedItem().toString();
          String vect[] = nome.split(" - ");
          int id = Integer.parseInt(vect[1]);
         listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausadosId(id);
         atendimento atendimento = new atendimento();
        
        atendimento.setId(id);
        
         
     }
     public void novoAtendimento(){
            
         jTextNomeContato.requestFocus();
        atendimento atendimento = new atendimento();
        
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
      
        
        jTextNomeContato.setText("");
        jTextSolucao.setText("");
        jTextObs.setText("");
        jTextObs2.setText("");
        jComboCliente.setSelectedIndex(0);
        jComboAssunto.setSelectedIndex(0);
        jTextRelato.setText("");

        jButtonGravar.setVisible(true);
        jButtonPausar.setVisible(true);

        jLabelId.setText(""+x);
     }
     public void pausarAtendimento(){
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
        atendimento.setId(Integer.parseInt(jLabelId.getText()));
        atendimentoControl.getInstance().update(atendimento);
        
         
        
        jTextNomeContato.setText("");
        jTextSolucao.setText("");
        jTextObs.setText("");
        jTextObs2.setText("");
        jComboCliente.setSelectedIndex(0);
        jComboAssunto.setSelectedIndex(0);
        jTextRelato.setText("");

        jButtonGravar.setVisible(false);
        jButtonPausar.setVisible(false);
        
     }
     public void gravarAtendimento(){
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
        atendimento.setId(Integer.parseInt(jLabelId.getText()));
        atendimento.setData(new Timestamp(System.currentTimeMillis()));
        atendimentoControl.getInstance().update(atendimento);
        
        
     }
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
        jComboBoxAtendimentosPausados = new javax.swing.JComboBox<>();
        jButtonRetornarAtendimento = new javax.swing.JButton();
        jLabelAtendimentosPausados = new javax.swing.JLabel();
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
        jLabelId = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButton2.setText("SAIR");

        jButtonPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16X16Pause.png"))); // NOI18N
        jButtonPausar.setText("Pausar ");
        jButtonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausarActionPerformed(evt);
            }
        });

        jButtonNovoAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16NewAtendimento.png"))); // NOI18N
        jButtonNovoAtendimento.setText("Novo ");
        jButtonNovoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoAtendimentoActionPerformed(evt);
            }
        });

        jButton5.setText("Ver Atendimentos Pausados");

        jComboBoxAtendimentosPausados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxAtendimentosPausadosKeyPressed(evt);
            }
        });

        jButtonRetornarAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16RetomarAtendimento.png"))); // NOI18N
        jButtonRetornarAtendimento.setText("Retomar");
        jButtonRetornarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetornarAtendimentoActionPerformed(evt);
            }
        });

        jLabelAtendimentosPausados.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelAtendimentosPausados.setText("Atendimentos Pausados");

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
                    .addComponent(jComboBoxAtendimentosPausados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jButtonRetornarAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelAtendimentosPausados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jButtonRetornarAtendimento)
                .addGap(24, 24, 24)
                .addComponent(jLabelAtendimentosPausados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAtendimentosPausados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabel1.setText("Nome contato");

        jLabel2.setText("Cliente");

        jLabel3.setText("Relato");

        jTextRelato.setColumns(20);
        jTextRelato.setRows(5);
        jScrollPane1.setViewportView(jTextRelato);

        jLabel4.setText("Assunto");

        jComboAssunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "01; \"CONSULTA CLIENTE PRODUTO FORNECEDOR\"", "44; \"CONTABIL\"", "13; \"CONTAS A PAGAR\"", "14; \"CONTAS A RECEBER\"", "15; \"CUPOM FISCAL ECF MENUECF NFCE\"", "68; \"DATA DO SISTEMA\"", "60; \"DEFINITIVIDADE ST SIARE\"", "41; \"E-SOCIAL\"", "79; \"EDITAL\"", "52; \"ENTRADA DE PRODUCAO\"", "16; \"ESTOQUE\"", "17; \"ETIQUETA CLIENTE PRODUTO FORNECEDOR\"", "54; \"ETIQUETA EXPEDIÇÃO\"", "63; \"FOLHA DE PAGAMENTO\"", "65; \"FORMATACAO DE MAQUINA\"", "48; \"FORMULA PRODUTO\"", "75; \"FRANQUIA\"", "80; \"GERAÇÃO DE CARNES\"", "42; \"GRADE FISCAL\"", "59; \"IMPORTACAO PARTE FISCAL PARA CONTABIL\"", "70; \"IMPORTAR CSV\"", "18; \"IMPRESSÃO\"", "19; \"INVENTÁRIO\"", "39; \"LOCAÇÃO\"", "77; \"LOGO EMPRESA\"", "40; \"MANIFESTO DE CARGA MDFE \"", "20; \"MERCÚRIO TABLETS LOJA VIRTUAL\"", "21; \"MOVIMENTO DE USUÁRIO\"", "26; \"NOTA FISCAL BLOCO FORMULÁRIO\"", "67; \"NOTA FISCAL DE MANIFESTO\"", "22; \"NOTA FISCAL DE SERVIÇO ELETRÔNICA NFSE\"", "23; \"NOTA FISCAL DE TRANSFERÊNCIA NFE\"", "24; \"NOTA FISCAL ELETRÔNICA NFE\"", "25; \"NOTA FISCAL ENTRADA DE MERCADORIA\"", "36; \"ORÇAMENTO\"" }));

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

        jLabelIdAtendimento.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabelIdAtendimento.setText("Protocolo");

        jLabelId.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N

        javax.swing.GroupLayout jLabelGracinhaLayout = new javax.swing.GroupLayout(jLabelGracinha);
        jLabelGracinha.setLayout(jLabelGracinhaLayout);
        jLabelGracinhaLayout.setHorizontalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(376, 376, 376)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(jLabelIdAtendimento)))
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextNomeContato, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLabelGracinhaLayout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE))))
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addComponent(jComboAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLabelGracinhaLayout.setVerticalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                        .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIdAtendimento)
                            .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
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

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
         int x = JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar o atendimento "+jLabelId.getText());
         if( x == JOptionPane.YES_OPTION){
              gravarAtendimento();
               
            jTextNomeContato.setText("");
            jTextSolucao.setText("");
            jTextObs.setText("");
            jTextObs2.setText("");
            jComboCliente.setSelectedIndex(0);
            jComboAssunto.setSelectedIndex(0);
            jTextRelato.setText("");

         }
         else {
             JOptionPane.showMessageDialog(null," PROCESSADO CANCELADO PELO USUARIO "+Login.getInstance().getUsuario());
         }
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausarActionPerformed
        pausarAtendimento();
        adicionarAtendimentoPausadoJCombo();
    }//GEN-LAST:event_jButtonPausarActionPerformed

    private void jButtonNovoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoAtendimentoActionPerformed
       novoAtendimento();
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
        
    }//GEN-LAST:event_jButtonRetornarAtendimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabelAtendimentosPausados;
    private javax.swing.JPanel jLabelGracinha;
    private javax.swing.JLabel jLabelId;
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
