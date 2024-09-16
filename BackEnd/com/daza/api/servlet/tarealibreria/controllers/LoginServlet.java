package com.daza.api.servlet.tarealibreria.controllers;

import com.daza.api.servlet.tarealibreria.dto.UsuarioDTO;
import com.daza.api.servlet.tarealibreria.service.UsuarioService;
import com.daza.api.servlet.tarealibreria.service.UsuarioServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UsuarioService service = new UsuarioServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("username");
        String password = req.getParameter("password");

        if (usuario != null && !password.isEmpty()) {
            UsuarioDTO user = service.obtenerUsuarioNombre(usuario, password);
            if (user == null){
                req.setAttribute("error", "Usuario o contraseña incorrectos.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else {
                req.getSession().setAttribute("usuario", user);
                resp.sendRedirect("index.jsp");
            }
        }else {
            req.setAttribute("error", "Debe ingresar un nombre de usuario y una contraseña.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
