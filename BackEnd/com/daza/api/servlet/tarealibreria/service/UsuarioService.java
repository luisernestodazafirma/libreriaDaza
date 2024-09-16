package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(int id);
    void agregarUsuario(UsuarioDTO usuario);
    void editarUsuario(UsuarioDTO usuario);
    void eliminarUsuario(int id);
    UsuarioDTO obtenerUsuarioNombre(String nombre, String password);
}
