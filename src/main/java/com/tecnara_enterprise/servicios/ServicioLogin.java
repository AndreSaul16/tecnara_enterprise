package com.tecnara_enterprise.servicios;

import com.tecnara_enterprise.DAO.DAOUsuarios;

public class ServicioLogin {
    DAOUsuarios dao;

    public ServicioLogin() {
        this.dao = new DAOUsuarios();
    }
    
    public boolean comprobarUsuario(String user, String pass) throws Exception {
        return dao.verificarUsuario(user, pass);
    }
}
