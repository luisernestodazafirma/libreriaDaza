package com.daza.api.servlet.tarealibreria.dto;

public class LibroDTO {
    private int id;
    private String titulo;
    private String genero;
    private int numeroPaginas;
    private double precio;
    private byte[] imagen;
    private int idAutor;

    public LibroDTO(int id, String titulo, String genero, int numeroPaginas, double precio, byte[] imagen, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.imagen = imagen;
        this.idAutor = idAutor;
    }

    public LibroDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
}
