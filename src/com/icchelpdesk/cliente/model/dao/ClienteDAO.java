package com.icchelpdesk.cliente.model.dao;

import com.icchelpdesk.cliente.model.bean.Cliente;
import com.icchelpdesk.sistema.model.util.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class ClienteDAO {
    
    private static ClienteDAO instance = null;
    
    public static ClienteDAO getInstance(){
        
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public int create (Cliente cliente){
        String query = "INSERT INTO CLIENTES values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        return MySQLDAO.executeQuery(query,
                null,
                cliente.getCnpj(),
                cliente.getNomeEmpresarial(),
                cliente.getNomeFantasia(),
                cliente.getTel_1(),
                cliente.getTel_2(),
                cliente.getResponsavel(),
                cliente.getNfe(),
                cliente.getNfce(),
                cliente.getCte(),
                cliente.getMdfe(),
                cliente.getInformacoes(),
                cliente.getMenut(),
                cliente.getMenuefd(),
                cliente.getMenucx(),
                cliente.getMercurio(),
                cliente.getMenuped(),
                cliente.getEdsys(),
                cliente.getStatus(),
                cliente.getCep(),
                cliente.getCidade(),
                cliente.getBairro(),
                cliente.getLogradouro(),
                cliente.getNumero(),
                cliente.getEstado()        
                );
        
        }
   public ArrayList<Cliente> read(String query){
    ArrayList<Cliente> listaCliente = new ArrayList();
    
    try {
        ResultSet rs = MySQLDAO.getResultSet(query);
        while (rs.next()){
    //instanciando cliente
        Cliente cliente = new Cliente();
        
        cliente.setId(rs.getInt("id"));
        cliente.setCnpj(rs.getString("cnpj"));
        cliente.setNomeEmpresarial(rs.getString("nomeEmpresarial"));
        cliente.setNomeFantasia(rs.getString("nomeFantasia"));
        cliente.setTel_1(rs.getString("telefone_1"));
        cliente.setTel_2(rs.getString("telefone_2"));
        cliente.setResponsavel(rs.getString("responsavel"));
        cliente.setNfe(rs.getInt("nf_e"));
        cliente.setNfce(rs.getInt("nfc_e"));
        cliente.setCte(rs.getInt("ct_e"));
        cliente.setMdfe(rs.getInt("mdf_e"));
        cliente.setInformacoes(rs.getString("informacoes"));
        cliente.setMenut(rs.getInt("menut"));
        cliente.setMenuefd(rs.getInt("menuEfd"));
        cliente.setMenucx(rs.getInt("menuCX"));
        cliente.setMercurio(rs.getInt("mercurio"));
        cliente.setMenuped(rs.getInt("menuped"));
        cliente.setEdsys(rs.getInt("edsys"));
        cliente.setStatus(rs.getString("status"));
        cliente.setCep(rs.getString("cep"));
        cliente.setCidade(rs.getString("cidade"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setLogradouro(rs.getString("logradouro"));
        cliente.setNumero(rs.getInt("numero"));
        cliente.setEstado(rs.getString("estado"));
        //adiciono todos os dados lidos ao meu objeto cliente
        
        listaCliente.add(cliente); //adiciono meu objeto cliente, a minha lista
        
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Erro ao fazer leitura no banco de dados");
    }
    return listaCliente;
    
   }
   
   
   public void update(Cliente cliente){
       
       String query = "update clientes"
               + " \n"
               + "set cnpj = ?, "
               + "nomeEmpresarial = ?,"
               + "nomeFantasia = ?,"
               + "telefone_1 = ?,"
               + "telefone_2 = ?"
               + "responsavel = ?"
               + "nf_e = ?,"
               + "nfc_e = ?,"
               + "ct_e = ?,"
               + "mdf_e = ?,"
               + "informacoes = ?,"
               + "menut = ?,"
               + "menuEfd = ?,"
               + "MenuCX = ?,"
               + "mercurio = ?,"
               + "menuped = ?,"
               + "edSys = ?,"
               + "status = ?,"
               + "cep = ?, "
               + "cidade = ?,"
               + "bairro = ?,"
               + "logradouro = ?,"
               + "numero = ?,"
               + "estado = ?"
               + "where id = ?";
       MySQLDAO.executeQuery(query,
               cliente.getCnpj(),
               cliente.getNomeEmpresarial(),
               cliente.getNomeFantasia(),
               cliente.getTel_1(),
               cliente.getTel_2(),
               cliente.getResponsavel(),
               cliente.getNfe(),
               cliente.getNfce(),
               cliente.getCte(),
               cliente.getMdfe(),
               cliente.getInformacoes(),
               cliente.getMenut(),
               cliente.getMenuefd(),
               cliente.getMenucx(),
               cliente.getMercurio(),
               cliente.getMenuped(),
               cliente.getEdsys(),
               cliente.getStatus(),
               cliente.getCep(),
               cliente.getCidade(),
               cliente.getBairro(),
               cliente.getLogradouro(),
               cliente.getNumero(),
               cliente.getEstado(),
               cliente.getId()
               );
     }
   public void delete(Cliente cliente){
       String query = "DELETE FROM CLIENTE where id = ?";
       MySQLDAO.executeQuery(query,cliente.getId());
   }
}
