package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dto.AutorDTO;

import java.util.List;

public interface AutorService {
    List<AutorDTO> listaAutores();
    AutorDTO obtenerAutorPorId(int id);
    void agregarAutor(AutorDTO autor);
    void editarAutor(AutorDTO autor);
    void deleteAutor(int id);
    List<AutorDTO> buscarAutorPorNombre(String nombre);
}
