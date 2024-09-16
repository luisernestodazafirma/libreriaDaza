package com.daza.api.servlet.tarealibreria.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Destruir la sesión y redirigir al login
        HttpSession sesion = req.getSession(false);
        if (sesion != null) {
            req.getSession().invalidate();
        }
        // Redirecciona a la página de login u otra página de tu elección
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
