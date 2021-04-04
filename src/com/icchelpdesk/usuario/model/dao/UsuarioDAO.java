package com.icchelpdesk.usuario.model.dao;

import com.icchelpdesk.sistema.model.util.MySQLDAO;
import com.icchelpdesk.usuario.model.bean.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static UsuarioDAO instance = null;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public int create(Usuario usuario) {
        String query = "INSERT INTO `usuarios` values (?,?,?,?,?,?,?,?);";
        return MySQLDAO.executeQuery(
                query,
                null,
                usuario.getPermissao(),
                usuario.getNome(),
                usuario.getUsuario(),
                usuario.getSenha(),
                usuario.getEstado(),
                usuario.getCreated_at(),
                null
        );
    }

    public ArrayList<Usuario> read() {
        String query = "SELECT * FROM `usuarios`;";
        ArrayList<Usuario> lista = new ArrayList();
        try {
            ResultSet rs = MySQLDAO.getResultSet(query);
            while (rs.next()) {
                // instanciando usuário
                Usuario usuario = new Usuario();
                // preenchendo propriedades do usuário
                usuario.setId(rs.getInt("id"));
                usuario.setPermissao(rs.getInt("permissao"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCreated_at(rs.getTimestamp("created_at"));
                usuario.setUpdated_at(rs.getTimestamp("updated_at"));
                // adicionando usuário na lista
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void update(Usuario usuario) {
        String query = "UPDATE `usuarios` set "
                + "`permissao` = ?,\n"
                + "`nome` = ?,\n"
                + "`usuario` = ?,\n"
                + "`senha` = ?,\n"
                + "`estado` = ?,\n"
                + "`updated_at` = now()\n"
                + " WHERE `id` = ?";
        MySQLDAO.executeQuery(query,
                usuario.getPermissao(),
                usuario.getNome(),
                usuario.getUsuario(),
                usuario.getSenha(),
                usuario.getEstado(),
                usuario.getId()
        );
    }

    public void delete(Usuario usuario) {
        String query = "DELETE FROM `usuarios` where id = ?";
        MySQLDAO.executeQuery(query, usuario.getId());
    }
    
}
