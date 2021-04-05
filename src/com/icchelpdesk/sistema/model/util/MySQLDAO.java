package com.icchelpdesk.sistema.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQLDAO {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL = "";
    private static Connection connection;

    private static final String WAMP_USER = "root", WAMP_PASSWORD = "vertrigo";

    private static void setDBURL() {
        DBURL = "jdbc:mysql://localhost:3306/icchelpdesk?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public static Connection setConnection(String USER, String PASSWORD) {
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null,"Não conectado ao banco de dados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static Connection getConnection_Local() {
        setDBURL();
        setConnection(WAMP_USER, WAMP_PASSWORD);
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
            psmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao Executar Query.\n\n"
                    + (ex.getMessage()) + "\n\n"
                    + query, "Falha!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (int) update;
    }

}
