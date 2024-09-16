package com.daza.api.servlet.tarealibreria.controllers;

import com.daza.api.servlet.tarealibreria.dto.AutorDTO;
import com.daza.api.servlet.tarealibreria.service.AutorService;
import com.daza.api.servlet.tarealibreria.service.AutorServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/autor")
public class AutorServlet extends HttpServlet {
    private AutorService service = new AutorServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if (action != null){
            switch (action) {
                case "listar":
                    getAutor(req, resp);
                    break;
                case "editar":
                    mostrarFormulario(req, resp);
                    break;
                case "eliminar":
                    deleteAutor(req, resp);
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
            switch (action) {
                case "agregar":
                    addAutor(req, resp);
                    break;
                case "editar":
                    updateAutor(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    private void addAutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String nacionalidad = req.getParameter("nacionalidad");

        AutorDTO autor = new AutorDTO(0, nombre, nacionalidad);

        try {
            service.agregarAutor(autor);
            resp.sendRedirect("autor?action=listar");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el autor");
        }

    }

    private void updateAutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String nacionalidad = req.getParameter("nacionalidad");

        try{
            AutorDTO autor = new AutorDTO(id, nombre, nacionalidad);
            service.editarAutor(autor);
            resp.sendRedirect("autor?action=listar");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el autor");
        }

    }

    private void deleteAutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteAutor(id);
        resp.sendRedirect("autor?action=listar");
    }

    private void getAutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            List<AutorDTO> autores = service.listaAutores();
            req.setAttribute("autores", autores);
            req.getRequestDispatcher("listar-autores.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al listar los autores");
        }
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));

        try{
            AutorDTO autor = service.obtenerAutorPorId(id);
            req.setAttribute("autor", autor);
            req.getRequestDispatcher("editar-autor.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar el autor");
        }
    }
}
