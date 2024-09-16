package com.daza.api.servlet.tarealibreria.dao;

import com.daza.api.servlet.tarealibreria.dto.UsuarioDTO;
import com.daza.api.servlet.tarealibreria.util.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    //TODO: Constructor por defecto
    public UsuarioDAO(){}
    //TODO: Constantes de uso
    private static final String SQL_SELECT = "SELECT * FROM tb_usuario";
    private static final String SQL_INSERT = "INSERT INTO tb_usuario (username, pass) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE tb_usuario SET username =?, pass=? WHERE id =?";
    private static final String SQL_DELETE = "DELETE FROM tb_usuario WHERE id =?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM tb_usuario WHERE id =?";
    private static final String SQL_SELECT_BY_NAME = "SELECT * FROM tb_usuario WHERE username = ? AND pass = ?";

    //TODO: Metodos CRUD DAO
    public UsuarioDTO getUsuarioNombre(String username, String pass){
        UsuarioDTO user = null;
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_NAME)){
            ps.setString(1, username);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    user = new UsuarioDTO(rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pass"));
                }
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public List<UsuarioDTO> getUsuarios() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                UsuarioDTO user = new UsuarioDTO(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pass"));

                usuarios.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return usuarios;
    }

    public UsuarioDTO getUsuarioById(int id){
        UsuarioDTO user = null;
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SQL_SELECT_BY_ID)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    user = new UsuarioDTO(rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pass"));
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return user;

    }

    public void updateUsuario(UsuarioDTO user){
        try (Connection cn = MySQLConexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(SQL_UPDATE)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());

            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int id){
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SQL_DELETE)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void insertUsuario(UsuarioDTO user){
        try (Connection cn = MySQLConexion.getConexion();
        PreparedStatement ps = cn.prepareStatement(SQL_INSERT)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
