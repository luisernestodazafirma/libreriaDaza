package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dto.LibroDTO;

import java.util.List;

public interface LibroService {
    // TODO: implementar métodos para manejar libros
    List<LibroDTO> getLibroDTOs();
    LibroDTO getLibroDTOPorId(int id);
    void insertarLibro(LibroDTO libro);
    void editarLibro(LibroDTO libro);
    void eliminarLibro(int id);
}
