package com.icchelpdesk.cliente.view;

import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPException;
import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.cliente.control.ClienteControl;
import com.icchelpdesk.cliente.model.dao.ClienteDAO;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class ClienteCadastro extends javax.swing.JInternalFrame {

    private static ClienteCadastro instance = null;

    public static ClienteCadastro getInstance() {
        if (instance == null) {
            instance = new ClienteCadastro();
            PrincipalTeste.getInstance().getDesktopPane().add(instance);
        }
        return instance;
    }

    public static void setInstance(ClienteCadastro in) {
        instance = in;
    }
    
    public ClienteCadastro() {
        initComponents();
    }
    
    
    public void insertCliente (Cliente cliente){
     
       ClienteControl.getInstance().create(cliente);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel8 = new javax.swing.JPanel();
        jButtonImportFromCsv = new javax.swing.JButton();
        jButtonRegister = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jTabbedPaneClient = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextCnpj = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextEmpresarial = new javax.swing.JTextField();
        jTextFantasia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextResponsavel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextTel_1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextTel_2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextLogradouro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextNumero = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextCep = new javax.swing.JFormattedTextField();
        jComboEstado = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jCheckMenuped = new javax.swing.JCheckBox();
        jCheckMenuCx = new javax.swing.JCheckBox();
        jCheckMenuEfd = new javax.swing.JCheckBox();
        jCheckMercurio = new javax.swing.JCheckBox();
        jCheckEdsys = new javax.swing.JCheckBox();
        jCheckMenut = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabelCaracters = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckNfe = new javax.swing.JCheckBox();
        jCheckNfce = new javax.swing.JCheckBox();
        jCheckCte = new javax.swing.JCheckBox();
        jCheckMdfe = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Clientes");

        jButtonImportFromCsv.setText("Importar");

        jButtonRegister.setText("Cadastrar");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        jButtonSave.setText("Gravar");
        jButtonSave.setEnabled(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonExit.setText("Sair");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonImportFromCsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonImportFromCsv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExit)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel8);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextCodigoKeyPressed(evt);
            }
        });

        jLabel1.setText("C??digo");

        jLabel2.setText("CNPJ *");

        jLabel3.setText("Empresa *");

        jLabel4.setText("Fantasia");

        jLabel5.setText("Respons??vel *");

        jLabel6.setText("Telefone 1 *");

        jLabel7.setText("Telefone 2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCodigo)
                    .addComponent(jTextCnpj)
                    .addComponent(jTextEmpresarial)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 593, Short.MAX_VALUE))
                    .addComponent(jTextFantasia)
                    .addComponent(jTextResponsavel)
                    .addComponent(jTextTel_1)
                    .addComponent(jTextTel_2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEmpresarial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextTel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextTel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneClient.addTab("Cliente", null, jPanel1, "k,");

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jLabel8.setText("CEP");

        jLabel9.setText("Cidade *");

        jLabel11.setText("Bairro");

        jLabel12.setText("Logradouro");

        jLabel13.setText("N");

        jTextNumero.setText("0");

        jLabel14.setText("Estado");

        try {
            jTextCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextCepKeyPressed(evt);
            }
        });

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------------------------------------------------------------------------------------------------------------------------------------", "Acre (AC)", "Alagoas (AL)", "Amap?? (AP)", "Amazonas (AM)", "Bahia (BA)", "Cear?? (CE)", "Distrito Federal (DF)", "Esp??rito Santo (ES)", "Goi??s (GO)", "Maranh??o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par?? (PA)", "Para??ba (PB)", "Paran?? (PR)", "Pernambuco (PE)", "Piau?? (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond??nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S??o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        jComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboEstado, 0, 674, Short.MAX_VALUE)
                    .addComponent(jTextCidade)
                    .addComponent(jTextCep)
                    .addComponent(jTextBairro)
                    .addComponent(jTextLogradouro)
                    .addComponent(jTextNumero)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneClient.addTab("Endere??o", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));

        jCheckMenuped.setText("MENUPED");

        jCheckMenuCx.setText("MENUCX");

        jCheckMenuEfd.setText("MENUEFD");

        jCheckMercurio.setText("MERCURIO");

        jCheckEdsys.setText("EDSys");

        jCheckMenut.setText("MENUT");

        jButton1.setText("Limpar texto");

        jLabelCaracters.setText("500");

        jLabel15.setText("INFORME OS MODULOS QUE O CLIENTE UTILIZA");

        jCheckNfe.setText("NF_E");

        jCheckNfce.setText("NFC_E");

        jCheckCte.setText("CT_E");

        jCheckMdfe.setText("MDF_E");

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea);

        jLabel16.setText("Caracteres restantes");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckMenuEfd)
                    .addComponent(jCheckMercurio)
                    .addComponent(jCheckEdsys)
                    .addComponent(jCheckMenut)
                    .addComponent(jCheckMenuped)
                    .addComponent(jCheckMenuCx))
                .addGap(51, 51, 51)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCaracters)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckCte)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckNfce)
                        .addComponent(jCheckNfe))
                    .addComponent(jCheckMdfe, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(186, 186, 186))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jCheckMenut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckMenuped)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckMenuCx)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckMenuEfd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckMercurio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckEdsys))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jCheckNfe, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckNfce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckCte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckMdfe)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel16)
                    .addComponent(jLabelCaracters))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPaneClient.addTab("M??dulos", jPanel10);

        jSplitPane2.setRightComponent(jTabbedPaneClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane2)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed

       Cliente cliente = new Cliente ();
       
       if(jTextCnpj.getText().equals("")){
           jTextCnpj.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo CNPJ vazio");
       }
       else if(jTextEmpresarial.getText().equals("")){
           jTextEmpresarial.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo NOME EMPRESA vazio");
       }
       else if(jTextResponsavel.getText().equals("")){
           jTextResponsavel.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo RESPONSAVEL vazio");
       }
       else if(jTextTel_1.getText().equals("")){
           jTextTel_1.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo TELEFONE_1 vazio");
       }
       else if(jTextCidade.getText().equals("")){
           jPanel7.requestFocus();
           jTextCidade.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo CIDADE vazio");
       }
    
       
       else {
       cliente.setCnpj(jTextCnpj.getText());
       cliente.setNomeEmpresarial(jTextEmpresarial.getText());
       cliente.setNomeFantasia(jTextFantasia.getText());
       cliente.setResponsavel(jTextResponsavel.getText());
       cliente.setTel_1(jTextTel_1.getText());
       cliente.setTel_2(jTextTel_2.getText());
       cliente.setBairro(jTextBairro.getText());
       cliente.setCep(jTextCep.getText());
       cliente.setCidade(jTextCidade.getText());
       cliente.setLogradouro(jTextLogradouro.getText());
       cliente.setNumero(Integer.parseInt(jTextNumero.getText()));
       cliente.setEstado(jComboEstado.getSelectedItem().toString());
       cliente.setInformacoes(jTextArea.getText());
       
        if(jCheckMenut.isSelected()){
           cliente.setMenut(1);
       }
         if(jCheckMenuped.isSelected()){
           cliente.setMenuped(1);
       }
        if(jCheckMenuCx.isSelected()){
           cliente.setMenucx(1);
       }
        if(jCheckMenuEfd.isSelected()){
           cliente.setMenuefd(1);
       }
        if(jCheckMercurio.isSelected()){
           cliente.setMercurio(1);
       }
        if(jCheckEdsys.isSelected()){
           cliente.setEdsys(1);
       }
        if(jCheckNfe.isSelected()){
           cliente.setNfe(1);
       }
        if(jCheckNfce.isSelected()){
           cliente.setNfce(1);
       }
        if(jCheckCte.isSelected()){
           cliente.setCte(1);
       }
        if(jCheckMdfe.isSelected()){
           cliente.setMdfe(1);
       }
       
       insertCliente(cliente);
       }
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jTextCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(jTextCodigo.getText().equals("0")){
                JOptionPane.showMessageDialog(null,"Novo cliente");
                jTextCnpj.setText("");
                          jTextEmpresarial.setText("");
                          jTextFantasia.setText("");
                          jTextResponsavel.setText("");
                          jTextTel_1.setText("");
                          jTextTel_2.setText("");
                          jTextCep.setText("");
                          jTextCidade.setText("");
                          jTextBairro.setText("");
                          jTextLogradouro.setText("");
                          jTextNumero.setText(""+"");
                          jComboEstado.setSelectedItem("");
                          jButtonSave.enable(false);
                
            }else{
                String cod = jTextCodigo.getText();
                int codigo = Integer.parseInt(cod);
                
                ArrayList<Cliente> listCli = ClienteDAO.getInstance().read("select *from clientes");
                
                if(listCli!= null){
                    for(int i=0; i<listCli.size();i++){
                     if(listCli.get(i).getId() == codigo){
                         JOptionPane.showMessageDialog(null,"Codigo encontrado no clinete"+listCli.get(i).getNomeEmpresarial());
                          jButtonRegister.setEnabled(false);
                          jButtonSave.setEnabled(true);
                          jTextCnpj.setText(listCli.get(i).getCnpj());
                          jTextEmpresarial.setText(listCli.get(i).getNomeEmpresarial());
                          jTextFantasia.setText(listCli.get(i).getNomeFantasia());
                          jTextResponsavel.setText(listCli.get(i).getResponsavel());
                          jTextTel_1.setText(listCli.get(i).getTel_1());
                          jTextTel_2.setText(listCli.get(i).getTel_2());
                          jTextCep.setText(listCli.get(i).getCep());
                          jTextCidade.setText(listCli.get(i).getCidade());
                          jTextBairro.setText(listCli.get(i).getBairro());
                          jTextLogradouro.setText(listCli.get(i).getLogradouro());
                          jTextNumero.setText(""+listCli.get(i).getNumero());
                         jComboEstado.setSelectedItem(listCli.get(i).getEstado());
                         
                     }   
                    }
                }
                
                
            }
        }
    }//GEN-LAST:event_jTextCodigoKeyPressed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
       Cliente cliente = new Cliente ();
       
       if(jTextCnpj.getText().equals("")){
           jTextCnpj.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo CNPJ vazio");
       }
       else if(jTextEmpresarial.getText().equals("")){
           jTextEmpresarial.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo NOME EMPRESA vazio");
       }
       else if(jTextResponsavel.getText().equals("")){
           jTextResponsavel.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo RESPONSAVEL vazio");
       }
       else if(jTextTel_1.getText().equals("")){
           jTextTel_1.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo TELEFONE_1 vazio");
       }
       else if(jTextCidade.getText().equals("")){
           jTextCidade.setBorder(new LineBorder(Color.RED));
           JOptionPane.showMessageDialog(null,"Campo CIDADE vazio");
       }
       else {
       cliente.setId(Integer.parseInt(jTextCodigo.getText()));
       cliente.setCnpj(jTextCnpj.getText());
       cliente.setNomeEmpresarial(jTextEmpresarial.getText());
       cliente.setNomeFantasia(jTextFantasia.getText());
       cliente.setResponsavel(jTextResponsavel.getText());
       cliente.setTel_1(jTextTel_1.getText());
       cliente.setTel_2(jTextTel_2.getText());
       cliente.setBairro(jTextBairro.getText());
       cliente.setCep(jTextCep.getText());
       cliente.setCidade(jTextCidade.getText());
       cliente.setLogradouro(jTextLogradouro.getText());
       cliente.setNumero(Integer.parseInt(jTextNumero.getText()));
       //cliente.setEstado(jComboEstado.getSelectedItem().toString());
   
       ClienteControl.getInstance().update(cliente);
       System.out.print("opa ja passei pelo control");
       }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        ClienteCadastro.setInstance(null);
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyPressed
         String jText = jTextArea.getText();
        
        int x = jText.length();
        int qntRestante = 500 - x;

        jLabelCaracters.setText(""+qntRestante);
    }//GEN-LAST:event_jTextAreaKeyPressed

    private void jTextCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCepKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
          ViaCEP cep = new ViaCEP();
 
            try {
                cep.buscar(jTextCep.getText());
            } catch (ViaCEPException ex) {
                Logger.getLogger(ClienteCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        
               jTextLogradouro.setText(cep.getLogradouro());
               jTextCidade.setText(cep.getLocalidade());
               jTextBairro.setText(cep.getBairro());
            
        }
        
       
    }//GEN-LAST:event_jTextCepKeyPressed

    private void jComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonImportFromCsv;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckCte;
    private javax.swing.JCheckBox jCheckEdsys;
    private javax.swing.JCheckBox jCheckMdfe;
    private javax.swing.JCheckBox jCheckMenuCx;
    private javax.swing.JCheckBox jCheckMenuEfd;
    private javax.swing.JCheckBox jCheckMenuped;
    private javax.swing.JCheckBox jCheckMenut;
    private javax.swing.JCheckBox jCheckMercurio;
    private javax.swing.JCheckBox jCheckNfce;
    private javax.swing.JCheckBox jCheckNfe;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCaracters;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPaneClient;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextBairro;
    private javax.swing.JFormattedTextField jTextCep;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextCnpj;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextEmpresarial;
    private javax.swing.JTextField jTextFantasia;
    private javax.swing.JTextField jTextLogradouro;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JTextField jTextResponsavel;
    private javax.swing.JTextField jTextTel_1;
    private javax.swing.JTextField jTextTel_2;
    // End of variables declaration//GEN-END:variables
}
