package com.icchelpdesk.sistema.model.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
   private static String endereco = "localhost";
    private static String nomeDataBase = "icchelpDesk";
    private static int porta = 3306 ;
    
    private static Connection connection;

    private static String WAMP_USER = "";//root
    private static  String WAMP_PASSWORD = ""; //vazio
    
  
    
   /* public static void configDB(){
 
        String path = "C://Users//Italo//Documents//NetBeansProjects//ICCHelpDesk//configDB.txt";
        try (BufferedReader bw = new BufferedReader(new FileReader(path))){
        
                String line = bw.readLine();
            
                
                String vect[] = line.split(";");
                System.out.print(vect[0]);
                endereco = vect[0];
                porta = Integer.parseInt(vect[1]);
                nomeDataBase = vect[2];
                WAMP_USER = vect[3];
                WAMP_PASSWORD = vect[4];
                setUsuarioSenha(WAMP_USER,WAMP_PASSWORD);
                setDBURL(endereco,porta,nomeDataBase);
            
            bw.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Erro ao manipular arquivo");
            
        }
    
    }
    */
   public static void setUsuarioSenha(String usuario,String senha){
       WAMP_USER = usuario;
       WAMP_PASSWORD = senha;
   }
    public static void setDBURL(String endereco, int porta, String nomeDataBase) {
        MySQLDAO.endereco = endereco;
        MySQLDAO.nomeDataBase = nomeDataBase;
        MySQLDAO.porta = porta ;
         DBURL = "jdbc:mysql://"+endereco+":"+porta+"/"+nomeDataBase;
        //DBURL = "jdbc:mysql://localhost:3306/icchelpdesk?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public int getResultado() {
        return resultado;
    }

    public static void  setResultado(int resultado) {
        MySQLDAO.resultado = resultado;
    }
     public static void  setConnection(Connection con) {
        MySQLDAO.connection = con;
    }
    
    public static Connection setConnection(String USER, String PASSWORD) {
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());

        }
         return null;
    }

    public static Connection getConnection_Local() {    
       
       
        setDBURL(endereco,porta,nomeDataBase);
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
   
        getConnection_Local();
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
    
        getConnection_Local();
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
