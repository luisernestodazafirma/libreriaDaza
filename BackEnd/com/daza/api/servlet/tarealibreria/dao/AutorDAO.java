package com.daza.api.servlet.tarealibreria.dao;

import com.daza.api.servlet.tarealibreria.dto.AutorDTO;
import com.daza.api.servlet.tarealibreria.util.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    //TODO Constantes de uso SQL para consultas 😎
    // TODO Implementar métodos para insertar, actualizar, eliminar y listar autores
    private static final String SQL_SELECT = "SELECT * FROM tb_autor";
    private static final String SQL_INSERT = "INSERT INTO tb_autor (nombre, nacionalidad) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE tb_autor SET nombre =?, nacionalidad=? WHERE id =?";
    private static final String SQL_DELETE = "DELETE FROM tb_autor WHERE id =?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM tb_autor WHERE id =?";

    //TODO Implementar métodos para llamar a las constantes de uso
    public List<AutorDTO> getAutores(){
        List<AutorDTO> autores = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AutorDTO autor = new AutorDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"));
                autores.add(autor);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return autores;
    }

    //TODO: Implementar metodo para insertar nuevos registros
    public void insertarAutor(AutorDTO autor){
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SQL_INSERT)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: Implementar metodo para actualizar los datos de un registro
    public void actualizarAutor(AutorDTO autor){
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getNacionalidad());
            ps.setInt(3, autor.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: Implementar metodo para eliminar un registro
    public void eliminarAutor(int id){
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: Implementar metodo para obtener un registro por su ID
    public AutorDTO obtenerAutorPorId(int id){
        AutorDTO autor = null;
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                autor = new AutorDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return autor;
    }

    //TODO: Implementar metodo para buscar autores por nombre
    public List<AutorDTO> buscarAutoresPorNombre(String nombre){
        List<AutorDTO> autores = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement("SELECT * FROM tb_autor WHERE nombre LIKE ?");
             ResultSet rs = ps.executeQuery()) {
            ps.setString(1, nombre);
            while (rs.next()) {
                AutorDTO autor = new AutorDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"));
                autores.add(autor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return autores;
    }
}
