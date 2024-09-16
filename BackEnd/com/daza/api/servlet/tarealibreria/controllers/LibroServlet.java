package com.daza.api.servlet.tarealibreria.controllers;

import com.daza.api.servlet.tarealibreria.dto.LibroDTO;
import com.daza.api.servlet.tarealibreria.service.LibroService;
import com.daza.api.servlet.tarealibreria.service.LibroServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

@WebServlet("/libro")
@MultipartConfig
public class LibroServlet extends HttpServlet {

    LibroService service = new LibroServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null){
            switch (action){
                case "listar":
                    listarLibros(req, resp);
                    break;
                case "eliminar":
                    eliminarLibro(req, resp);
                    break;
                case "editar":
                    mostrarFormularioEdicion(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null){
            switch (action){
                case "agregar":
                    agregarLibro(req, resp);
                    break;
                case "editar":
                    editarLibro(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    private void mostrarFormularioEdicion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        LibroDTO libro = service.getLibroDTOPorId(id);
        req.setAttribute("libro", libro);
        req.getRequestDispatcher("editar-libro.jsp").forward(req, resp);
    }

    private void eliminarLibro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.eliminarLibro(id);
        resp.sendRedirect("libro?action=listar");
    }

    private void listarLibros(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<LibroDTO> libros = service.getLibroDTOs();
        req.setAttribute("libros", libros);
        req.getRequestDispatcher("listar-libros.jsp").forward(req, resp);
    }

    private void editarLibro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String genero = req.getParameter("genero");
        int numeroPaginas = Integer.parseInt(req.getParameter("numeroPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        //Trabajar con imagenes
        Part imagenPart = req.getPart("imagenPart");
        byte [] imagenBytes = null;
        int idAutor = Integer.parseInt(req.getParameter("idAutor"));

        if (imagenPart != null && imagenPart.getSize() > 0){
            imagenBytes = imagenPart.getInputStream().readAllBytes();
        }else{
            //Obtengo la imagen actual caso de que no se halla subido uno nuevo
            LibroDTO libroActual = service.getLibroDTOPorId(id);
            imagenBytes = libroActual.getImagen();
        }

        LibroDTO libro = new LibroDTO(id, titulo, genero, numeroPaginas, precio, imagenBytes, idAutor);
        service.editarLibro(libro);

        resp.sendRedirect("libro?action=listar");
    }

    private void agregarLibro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String genero = req.getParameter("genero");
        int numeroPaginas = Integer.parseInt(req.getParameter("numeroPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        //Trabajar con imagenes
        Part imagenPart = req.getPart("imagenPart");
        byte [] imagenBytes = imagenPart.getInputStream().readAllBytes();
        int idAutor = Integer.parseInt(req.getParameter("idAutor"));

        LibroDTO libro = new LibroDTO(0, titulo, genero, numeroPaginas, precio, imagenBytes, idAutor);
        service.insertarLibro(libro);

        resp.sendRedirect("libro?action=listar");
    }
}
