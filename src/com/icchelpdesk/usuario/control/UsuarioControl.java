package com.icchelpdesk.usuario.control;

import com.icchelpdesk.usuario.model.bean.Usuario;
import com.icchelpdesk.usuario.model.dao.UsuarioDAO;
import java.util.ArrayList;

public class UsuarioControl {

    private static UsuarioControl instance = null;

    public static UsuarioControl getInstance() {
        if (instance == null) {
            instance = new UsuarioControl();
        }
        return instance;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public int create(Usuario usuario) {
        return UsuarioDAO.getInstance().create(usuario);
    }

    /**
     *
     * @return
     */
    public ArrayList<Usuario> read() {
        String query = "SELECT * FROM `usuarios`;";
        return UsuarioDAO.getInstance().read(query);
    }

    public Usuario readFromName(String nome) {
        String query = "SELECT * FROM `usuarios` where nome = ';"+nome+"'";
        return UsuarioDAO.getInstance().readFromName(query);
    }
    
    /**
     *
     * @param usuario
     */
    public void update(Usuario usuario) {
        UsuarioDAO.getInstance().update(usuario);
    }

    /**
     *
     * @param usuario
     */
    public void delete(Usuario usuario) {
        UsuarioDAO.getInstance().delete(usuario);
    }

    /**
     * Este método desativa o usuário.
     *
     * @param usuario
     */
    public void disable(Usuario usuario) {
        usuario.setEstado("D");
        update(usuario);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> estados() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("D");
        return lista;
    }

    public Usuario realizarLogin(Usuario usuario) {
        String query = "SELECT * FROM `usuarios` where codigo = '" + usuario.getCodigo() + "' and senha = '" + usuario.getSenha() + "';";
        ArrayList<Usuario> lista = UsuarioDAO.getInstance().read(query);
        
        for (Usuario u : lista){
            return u;
        }
        
        return null;
    }

}
