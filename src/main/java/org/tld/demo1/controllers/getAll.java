package org.tld.demo1.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.tld.demo1.dao.DaoClientImpl;
import org.tld.demo1.model.Client;


@WebServlet(name = "getAll", value = "/Listeclient")
public class getAll extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        DaoClientImpl dao = new DaoClientImpl();
        List<Client> listClients = dao.getAllClients();
        Client client = new Client();
        request.setAttribute("listClient",listClients);
        this.getServletContext().getRequestDispatcher("/getAll.jsp").forward(request,response);


    }


}
