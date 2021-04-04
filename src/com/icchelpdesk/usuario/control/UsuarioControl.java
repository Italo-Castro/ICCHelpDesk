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

    public int create(Usuario usuario) {
        return UsuarioDAO.getInstance().create(usuario);
    }

    public ArrayList<Usuario> read() {
        return UsuarioDAO.getInstance().read();
    }

    public void update(Usuario usuario) {
        Y
    }

    public void delete(Usuario usuario) {
        throw new UnsupportedOperationException();
    }

    public void disable(Usuario usuario) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<String> estados() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("D");
        return lista;
    }

}
