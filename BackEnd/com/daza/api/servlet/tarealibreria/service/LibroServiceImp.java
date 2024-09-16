package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dao.LibroDAO;
import com.daza.api.servlet.tarealibreria.dto.LibroDTO;

import java.util.List;

public class LibroServiceImp implements LibroService{

    LibroDAO dao = new LibroDAO();

    @Override
    public List<LibroDTO> getLibroDTOs() {
        return dao.getLibroDTOs();
    }

    @Override
    public LibroDTO getLibroDTOPorId(int id) {
        return dao.obtenerLibroPorId(id);
    }

    @Override
    public void insertarLibro(LibroDTO libro) {
        dao.insertarLibro(libro);
    }

    @Override
    public void editarLibro(LibroDTO libro) {
        dao.actualizarLibro(libro);
    }

    @Override
    public void eliminarLibro(int id) {
        dao.eliminarLibro(id);
    }
}
