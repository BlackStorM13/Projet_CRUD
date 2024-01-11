package org.tld.demo1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "getById", value = "/getById")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String nom = "Utilisateur";
        Integer age = 20;

        request.setAttribute("nom",nom);
        request.setAttribute("age",age);

        this.getServletContext().getRequestDispatcher("/.jsp").forward(request,response);

    }

    public void destroy() {
    }
}