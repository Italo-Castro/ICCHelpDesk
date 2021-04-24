package com.icchelpdesk.sistema.model.util;

import com.icchelpdesk.sistema.view.ConfigDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQLDAO {
    
    public static int resultado = 2 ;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL = "";
    private static Connection connection;

    private static final String WAMP_USER = "root", WAMP_PASSWORD = "";

    
    
    private static void setDBURL(String endereco, int porta, String nomeDataBase) {
        DBURL = "jdbc:mysql://"+endereco+":"+porta+"/"+nomeDataBase;
        //DBURL = "jdbc:mysql://localhost:3306/icchelpdesk?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public int getResultado() {
        return resultado;
    }

    public static void  setResultado(int resultado) {
        MySQLDAO.resultado = resultado;
    }
    
    public static Connection setConnection(String USER, String PASSWORD) {
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            
/*Aqui esta a logica que se cair no cacth eu chamo um JoptionPane para abrir ou nao a tela ConfigDB
            
            JOptionPane.showMessageDialog(null,"Não conectado ao banco de dados","ERROR",JOptionPane.ERROR_MESSAGE);
            int x = JOptionPane.showConfirmDialog(null, "Deseja abrir a tela de configuração da conexao com o banco de dados ?");
            
            if(x == JOptionPane.YES_OPTION){
                 new ConfigDB().setVisible(true);
            }
            else {
                return null;
            }
            
Implementarei em outra clase apartir do resultado == 1
*/

        }
         return null;
    }

    public static Connection getConnection_Local(String endereco, int porta, String icchelpdesk) {    
        
        setDBURL("localhost",3306,"icchelpdesk");
        setConnection(WAMP_USER, WAMP_PASSWORD);   
        if(connection != null){
             setResultado(1);
        }
        else {
             setResultado(0);
        }
        return connection;
    }

    public static ResultSet getResultSet(String query, Object... parametros) {
        getConnection_Local("localhost",3306,"icchelpdesk");
        PreparedStatement psmt;
        ResultSet rs = null;
        try {
            psmt = connection.prepareStatement(query);
            for (int i = 0; i < parametros.length; i++) {
                psmt.setObject(i + 1, parametros[i]);
            }
            rs = psmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao obter resultados.\n" + (ex.getMessage()), "Falha!", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public static int executeQuery(String query, Object... parametros) {
       
        getConnection_Local("localhost",3306,"icchelpdesk");
        long update = 0;
        PreparedStatement psmt;
        try {
            psmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < parametros.length; i++) {
                psmt.setObject(i + 1, parametros[i]);
            }

            psmt.execute();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                update = rs.getLong(1);
                
                 
            }
            setResultado(1);
           
            //JOptionPane.showMessageDialog(null,"Processo realizado com sucesso");
            psmt.close();
            
        } catch (SQLException ex) {
            setResultado(0);
            JOptionPane.showMessageDialog(null, "Falha ao Executar Query.\n\n"
                    + (ex.getMessage()) + "\n\n"
                    + query, "Falha!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (int) update;
    }

}
