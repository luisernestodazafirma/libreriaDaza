package com.daza.api.servlet.tarealibreria.controllers;

import com.daza.api.servlet.tarealibreria.dto.AutorDTO;
import com.daza.api.servlet.tarealibreria.dto.UsuarioDTO;
import com.daza.api.servlet.tarealibreria.service.UsuarioService;
import com.daza.api.servlet.tarealibreria.service.UsuarioServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UsuarioServlet extends HttpServlet {
    UsuarioService service = new UsuarioServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null){
            switch (action){
                case "listar":
                    listarUsuarios(req, resp);
                    break;
                case "eliminar":
                    eliminarUsuario(req, resp);
                    break;
                    case "editar":
                        mostrarFormulario(req, resp);
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
                case "editar":
                    editarUsuario(req, resp);
                    break;
                case "agregar":
                    agregarUsuario(req, resp);
                    break;
                default:
                break;
            }
        }
    }

    private void agregarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        UsuarioDTO usuarioDTO = new UsuarioDTO(0, usuario, password);
        service.agregarUsuario(usuarioDTO);
        resp.sendRedirect("user?action=listar");
    }

    private void editarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        UsuarioDTO user = new UsuarioDTO(id, usuario, password);
        service.editarUsuario(user);
        resp.sendRedirect("user?action=listar");

    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UsuarioDTO user = service.obtenerUsuarioPorId(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("editar-usuario.jsp").forward(req, resp);
    }

    private void eliminarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
       service.eliminarUsuario(id);
       resp.sendRedirect("user?action=listar");
    }

    private void listarUsuarios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UsuarioDTO> usuarios = service.listarUsuarios();
        req.setAttribute("usuarios", usuarios);
        req.getRequestDispatcher("listar-usuarios.jsp").forward(req, resp);

    }
}
