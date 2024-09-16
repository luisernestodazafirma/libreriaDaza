package com.daza.api.servlet.tarealibreria.service;

import com.daza.api.servlet.tarealibreria.dao.AutorDAO;
import com.daza.api.servlet.tarealibreria.dto.AutorDTO;

import java.util.List;

public class AutorServiceImp implements AutorService{

    AutorDAO serviceAutor = new AutorDAO();
    @Override
    public List<AutorDTO> listaAutores() {
        return serviceAutor.getAutores();
    }

    @Override
    public AutorDTO obtenerAutorPorId(int id) {
        return serviceAutor.obtenerAutorPorId(id);
    }

    @Override
    public void agregarAutor(AutorDTO autor) {
        serviceAutor.insertarAutor(autor);
    }

    @Override
    public void editarAutor(AutorDTO autor) {
        serviceAutor.actualizarAutor(autor);
    }

    @Override
    public void deleteAutor(int id) {
        serviceAutor.eliminarAutor(id);
    }

    @Override
    public List<AutorDTO> buscarAutorPorNombre(String nombre) {
        return serviceAutor.buscarAutoresPorNombre(nombre);
    }
}
