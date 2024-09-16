package com.daza.api.servlet.tarealibreria.dto;

public class UsuarioDTO {
    private int id;
    private String username;
    private String password;

    public UsuarioDTO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UsuarioDTO(){}

    //Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
