package com.icchelpdesk.atendimento.view;

import com.icchelpdesk.atendimento.control.atendimentoControl;
import com.icchelpdesk.atendimento.model.bean.atendimento;
import com.icchelpdesk.cliente.control.ClienteControl;
import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import com.icchelpdesk.sistema.view.Login;
import com.icchelpdesk.sistema.view.PrincipalDev;
import com.icchelpdesk.sistema.view.PrincipalSuporte;
import com.icchelpdesk.sistema.view.PrincipalTeste;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Italo
 */
public class AtendimentoRegister extends javax.swing.JInternalFrame {
     private static AtendimentoRegister instance = null;
     String motivoPausa;
     
    public static AtendimentoRegister getInstance() {
        if (instance == null) {
            instance = new AtendimentoRegister();
              
            if(Login.getInstance().getPerfil().equals("SUPORTE")){
                  PrincipalSuporte.getInstance().getDesktopPane().add(instance);
            }
            else if(Login.getInstance().getPerfil().equals("DEV")){
                  PrincipalDev.getInstance().getDesktopPane().add(instance);
            }
            else if(Login.getInstance().getPerfil().equals("TESTE")){
                  PrincipalTeste.getInstance().getDesktopPane().add(instance);
            }
        }
        return instance;
    }
    
    public static void setInstance(AtendimentoRegister in){
        instance = in;
    }
    
    
    public  void setMotivoPausa(String motivoPausa){
        this.motivoPausa=motivoPausa;
    }
    
    public String getMotivoPausa(){
        return motivoPausa;
    }
     public AtendimentoRegister() {
            initComponents();
            PegarHora();
            jScrollPane5.getVerticalScrollBar().setUnitIncrement(15); //esta linha faz com que a barra de rolagem /ScrollPane role mais rapido

            jButtonGravar.setVisible(false);
            jButtonPausar.setVisible(false);
            jButtonTransferir.setVisible(false);
            ArrayList<Cliente> listaClientes = new ArrayList();
            listaClientes = ClienteControl.getInstance().read();
             
                for (Cliente clientes : listaClientes){  
                    jComboCliente.addItem(clientes.getNomeEmpresarial());
                }
              
              adicionarAtendimentoPausadoJCombo();
               
            
              
              
              
    }
     public void adicionarAtendimentoPausadoJCombo(){
        jComboAtendimentosPausados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
        listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausados();
            
                  for (atendimento atendimentos : listaAtendimentosPausados){
               jComboAtendimentosPausados.addItem(atendimentos.getNomeCliente()+ " - "+atendimentos.getId());
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
                 jButtonTransferir.setVisible(true);
                String atendimentoPausado = jComboAtendimentosPausados.getSelectedItem().toString();
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
          String nome = jComboAtendimentosPausados.getSelectedItem().toString();
          String vect[] = nome.split(" - ");
          int id = Integer.parseInt(vect[1]);
         listaAtendimentosPausados = atendimentoControl.getInstance().buscaAtendimentosPausadosId(id);
         atendimento atendimento = new atendimento();
        
        atendimento.setId(id);
        
         
     }
     public void novoAtendimento(){
        jButtonNovoAtendimento.setVisible(false);
        jButtonTransferir.setVisible(false);
        jButtonRetornarAtendimento.setVisible(false);
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
      

        
        int resultado = MySQLDAO.resultado;
        if(resultado == 1){
         
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
        }else {
            JOptionPane.showMessageDialog(null,"Erro ao iniciar novo atendimento");
        }
     }
     public void pausarAtendimento(){
             
         if(jTextNomeContato.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Nome do contato obrigatorio");
                 jTextNomeContato.setBorder(new LineBorder(java.awt.Color.RED));
             }
             else if(jComboCliente.getSelectedIndex() == 0){
                 JOptionPane.showMessageDialog(null,"Nome do cliente obrigatorio");  
                 jComboCliente.setBorder(new LineBorder(java.awt.Color.RED));
             }
             else {
         
         
         jButtonNovoAtendimento.setVisible(true);
         jButtonTransferir.setVisible(true);
         jButtonRetornarAtendimento.setVisible(true);
         atendimento atendimento = new atendimento();
        
           
        atendimento.setAssunto(jComboAssunto.getSelectedItem().toString());
        atendimento.setNomeCliente(jComboCliente.getSelectedItem().toString());
        atendimento.setNomeContato(jTextNomeContato.getText());
        atendimento.setObservacao(jTextObs.getText());
        atendimento.setObservacao2(jTextObs2.getText());
        atendimento.setRelato(jTextRelato.getText());
        atendimento.setSolucao(jTextSolucao.getText());
        atendimento.setStatus("PAUSADO");
        atendimento.setUsuario(Login.getInstance().getUsuario());
        atendimento.setId(Integer.parseInt(jLabelId.getText()));
        atendimento.setData(new Timestamp(System.currentTimeMillis()));
        atendimento.setMotivoPausa(getMotivoPausa());
        
        atendimentoControl.getInstance().update(atendimento);
        
        if(MySQLDAO.resultado == 1){
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
        else {
            JOptionPane.showMessageDialog(null,"ERRO AO PAUSAR ATENDIMENTO","FATAL ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
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
        
        if(MySQLDAO.resultado == 1){
            JOptionPane.showMessageDialog(null,"Atendimento registrado com sucesso");
        }else {
            JOptionPane.showMessageDialog(null," Erro ao gravar atendimeto ","FATAL ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
     }
     public void transferirAtendimento(){
         
          if(jComboAtendimentosPausados.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null,"Selecione na sua lista de atendimentos pausados, o atendimento que deseja transferir");
            TransferenciaAtendimentos.getInstance(0).setVisible(false);
            TransferenciaAtendimentos.getInstance(0).setVisible(true);
            
        
        }else{
              
      
       String atendimentoPausado = jComboAtendimentosPausados.getSelectedItem().toString();
       String vect[] = atendimentoPausado.split(" - "); //split no texto do jComboBox, pois o texto armazena, o nome do cliente - id
      
       
       ArrayList<atendimento> listaAtendimentosPausados = new ArrayList();
       int id = Integer.parseInt(vect[1]);
       
        TransferenciaAtendimentos.getInstance(id).setVisible(false);
        TransferenciaAtendimentos.getInstance(id).setVisible(true);
        }
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
        jComboAtendimentosPausados = new javax.swing.JComboBox<>();
        jButtonRetornarAtendimento = new javax.swing.JButton();
        jLabelAtendimentosPausados = new javax.swing.JLabel();
        jButtonTransferir = new javax.swing.JButton();
        jLabelGracinha = new javax.swing.JPanel();
        jLabelIdAtendimento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextNomeContato = new javax.swing.JTextField();
        jComboCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextRelato = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboAssunto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextObs = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextObs2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextSolucao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jButton5.setText("Ver Atendimentos Transferidos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboAtendimentosPausados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboAtendimentosPausadosKeyPressed(evt);
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

        jButtonTransferir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icchelpdesk/sistema/view/16x16/16x16transfer-icon.png"))); // NOI18N
        jButtonTransferir.setText("Transferir");
        jButtonTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovoAtendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboAtendimentosPausados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRetornarAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelAtendimentosPausados)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonTransferir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(7, 7, 7)
                .addComponent(jButtonTransferir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAtendimentosPausados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboAtendimentosPausados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabelIdAtendimento.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabelIdAtendimento.setText("Protocolo");

        jLabelId.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLabel1.setText("Nome contato");

        jLabel2.setText("Cliente");

        jTextRelato.setColumns(20);
        jTextRelato.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextRelato.setRows(5);
        jTextRelato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRelatoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextRelato);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Relato");

        jLabel4.setText("Assunto");

        jComboAssunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "CONSULTA CLIENTE PRODUTO FORNECEDOR", "CONTABIL", "CONTAS A PAGAR", "CONTAS A RECEBER", "CUPOM FISCAL ECF MENUECF NFCE", "DATA DO SISTEMA", "DEFINITIVIDADE ST SIARE", "E-SOCIAL", "EDITAL", "ENTRADA DE PRODUCAO", "ESTOQUE", "ETIQUETA CLIENTE PRODUTO FORNECEDOR", "ETIQUETA EXPEDIÇÃO", "FOLHA DE PAGAMENTO", "FORMATACAO DE MAQUINA", "FORMULA PRODUTO", "FRANQUIA", "GERAÇÃO DE CARNES", "GRADE FISCAL", "IMPORTAR CSV", "IMPRESSÃO", "INVENTÁRIO", "LOCAÇÃO", "LOGO EMPRESA", "MANIFESTO DE CARGA MDFE ", "MERCÚRIO TABLETS LOJA VIRTUAL", "MOVIMENTO DE USUÁRIO", "NOTA FISCAL BLOCO FORMULÁRIO", "NOTA FISCAL DE MANIFESTO", "NOTA FISCAL DE SERVIÇO ELETRÔNICA NFSE", "NOTA FISCAL DE TRANSFERÊNCIA NFE", "NOTA FISCAL ELETRÔNICA NFE", "NOTA FISCAL ENTRADA DE MERCADORIA", "ORÇAMENTO" }));
        jComboAssunto.setSelectedItem(-1
        );

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Observacao");

        jTextObs.setColumns(20);
        jTextObs.setRows(5);
        jScrollPane4.setViewportView(jTextObs);

        jTextObs2.setColumns(20);
        jTextObs2.setRows(5);
        jScrollPane2.setViewportView(jTextObs2);

        jTextSolucao.setColumns(20);
        jTextSolucao.setRows(5);
        jScrollPane3.setViewportView(jTextSolucao);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Solucao");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Observacao 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jTextNomeContato, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addComponent(jComboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jComboAssunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 128, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel2);

        javax.swing.GroupLayout jLabelGracinhaLayout = new javax.swing.GroupLayout(jLabelGracinha);
        jLabelGracinha.setLayout(jLabelGracinhaLayout);
        jLabelGracinhaLayout.setHorizontalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabelIdAtendimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jLabelGracinhaLayout.setVerticalGroup(
            jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLabelGracinhaLayout.createSequentialGroup()
                .addGroup(jLabelGracinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelIdAtendimento)
                    .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
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
             
             if(jTextNomeContato.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Nome do contato obrigatorio");
                 jTextNomeContato.setBorder(new LineBorder(java.awt.Color.RED));
             }
             else if(jComboCliente.getSelectedIndex() == 0){
                   jComboCliente.setBorder(new LineBorder(java.awt.Color.RED));
             }
             else {
              gravarAtendimento();
               
            jTextNomeContato.setText("");
            jTextSolucao.setText("");
            jTextObs.setText("");
            jTextObs2.setText("");
            jComboCliente.setSelectedIndex(0);
            jComboAssunto.setSelectedIndex(0);
            jTextRelato.setText("");
             }
         }
         else {
             JOptionPane.showMessageDialog(null," PROCESSADO CANCELADO PELO USUARIO "+Login.getInstance().getUsuario());
         }
    }//GEN-LAST:event_jButtonGravarActionPerformed
    
    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausarActionPerformed
        MotivoPausa.getInstance().setVisible(false);
        MotivoPausa.getInstance().setVisible(true);
        adicionarAtendimentoPausadoJCombo();
    }//GEN-LAST:event_jButtonPausarActionPerformed

    private void jButtonNovoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoAtendimentoActionPerformed
       novoAtendimento();
    }//GEN-LAST:event_jButtonNovoAtendimentoActionPerformed

    private void jButtonRetomarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetomarAtendimentoActionPerformed

    }//GEN-LAST:event_jButtonRetomarAtendimentoActionPerformed

    private void jTextNomeContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeContatoActionPerformed
       
    }//GEN-LAST:event_jTextNomeContatoActionPerformed

    private void jComboAtendimentosPausadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboAtendimentosPausadosKeyPressed
        if(evt.getKeyCode() == 10){
            adicionarAtendimentoPausadoJCombo();
        }
    }//GEN-LAST:event_jComboAtendimentosPausadosKeyPressed

    private void jButtonRetornarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetornarAtendimentoActionPerformed
        if(jComboAtendimentosPausados.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null," Você deve selecionar um atendimento da sua lista de atendimentos em pausa","",JOptionPane.QUESTION_MESSAGE);
        }
        else {
            retomarAtendimento(); 
        }
    }//GEN-LAST:event_jButtonRetornarAtendimentoActionPerformed

    private void jTextRelatoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRelatoKeyPressed
       if(evt.getKeyCode() == 116){
            jComboAssunto.requestFocus();
        }
    }//GEN-LAST:event_jTextRelatoKeyPressed

    private void jButtonTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferirActionPerformed
      transferirAtendimento();
    }//GEN-LAST:event_jButtonTransferirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AtendimentoRegister.setInstance(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AtendimentosTransferidos.getInstance().setVisible(false);
        AtendimentosTransferidos.getInstance().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovoAtendimento;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonRetornarAtendimento;
    private javax.swing.JButton jButtonTransferir;
    private javax.swing.JComboBox<String> jComboAssunto;
    private javax.swing.JComboBox<String> jComboAtendimentosPausados;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextNomeContato;
    private javax.swing.JTextArea jTextObs;
    private javax.swing.JTextArea jTextObs2;
    private javax.swing.JTextArea jTextRelato;
    private javax.swing.JTextArea jTextSolucao;
    // End of variables declaration//GEN-END:variables
}
