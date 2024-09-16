package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dao.UsuarioDAO;
import com.daza.api.servlet.tarealibreria.dto.UsuarioDTO;

import java.util.List;

public class UsuarioServiceImp implements UsuarioService{

    //TODO: INSTANCIA DEL DAO ya sabes ._.
    UsuarioDAO dao = new UsuarioDAO();
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return dao.getUsuarios();
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(int id) {
        return dao.getUsuarioById(id);
    }

    @Override
    public void agregarUsuario(UsuarioDTO usuario) {
        dao.insertUsuario(usuario);
    }

    @Override
    public void editarUsuario(UsuarioDTO usuario) {
        dao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        dao.deleteUsuario(id);
    }

    @Override
    public UsuarioDTO obtenerUsuarioNombre(String nombre, String password) {
        return dao.getUsuarioNombre(nombre, password);
    }


}
