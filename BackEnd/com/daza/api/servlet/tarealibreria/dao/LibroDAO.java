package com.daza.api.servlet.tarealibreria.dao;

import com.daza.api.servlet.tarealibreria.dto.LibroDTO;
import com.daza.api.servlet.tarealibreria.util.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    //TODO: Implementacion de las constantes de uso
    private static final String SELECT_LIBROS = "SELECT * FROM tb_libro";
    private static final String INSERT_LIBRO = "INSERT INTO tb_libro (titulo, genero, numero_paginas, precio, imagen, id_autor) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_LIBRO = "UPDATE tb_libro SET titulo=?, genero=?, numero_paginas=?, precio=?, imagen=?, id_autor=? WHERE id=?";
    private static final String DELETE_LIBRO = "DELETE FROM tb_libro WHERE id=?";
    private static final String SELECT_LIBRO_BY_ID = "SELECT * FROM tb_libro WHERE id=?";

    //TODO Implementacion de los metodos CRUD
    public List<LibroDTO> getLibroDTOs() {
        List<LibroDTO> libros = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SELECT_LIBROS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                int numeroPaginas = rs.getInt("numero_paginas");
                double precio = rs.getDouble("precio");
                byte[] imagen = rs.getBytes("imagen");
                int idAutor = rs.getInt("id_autor");

                LibroDTO libro = new LibroDTO(id, titulo, genero, numeroPaginas, precio, imagen, idAutor);
                libros.add(libro);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return libros;
    }

    public void insertarLibro(LibroDTO libro) {
        try (Connection cn = MySQLConexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(INSERT_LIBRO)){

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getGenero());
            ps.setInt(3, libro.getNumeroPaginas());
            ps.setDouble(4, libro.getPrecio());
            ps.setBytes(5, libro.getImagen());
            ps.setInt(6, libro.getIdAutor());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizarLibro(LibroDTO libro) {
        try (Connection cn = MySQLConexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(UPDATE_LIBRO)){

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getGenero());
            ps.setInt(3, libro.getNumeroPaginas());
            ps.setDouble(4, libro.getPrecio());
            ps.setBytes(5, libro.getImagen());
            ps.setInt(6, libro.getIdAutor());
            ps.setInt(7, libro.getId());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void eliminarLibro(int id){
        try(Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(DELETE_LIBRO)){

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public LibroDTO obtenerLibroPorId(int id) {
        LibroDTO libro = null;
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SELECT_LIBRO_BY_ID)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        int idLibro = rs.getInt("id");
                        String titulo = rs.getString("titulo");
                        String genero = rs.getString("genero");
                        int numeroPaginas = rs.getInt("numero_paginas");
                        double precio = rs.getDouble("precio");
                        byte[] imagen = rs.getBytes("imagen");
                        int idAutor = rs.getInt("id_autor");

                        libro = new LibroDTO(idLibro, titulo, genero, numeroPaginas, precio, imagen, idAutor);
                    }
                }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return libro;
    }
}
