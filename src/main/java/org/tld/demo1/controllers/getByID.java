package org.tld.demo1.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.tld.demo1.dao.DaoClientImpl;
import org.tld.demo1.model.Client;


@WebServlet(name = "getById", value = "/client")
public class getByID extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        Integer idClient = null;
        if(request.getParameter("id") != null){
            idClient = Integer.valueOf(request.getParameter("id"));
        }
        System.out.println(idClient);
        DaoClientImpl dao = new DaoClientImpl();
        List<Client> listClients = dao.getByID(idClient);
        Client client = listClients.get(0);
        request.setAttribute("client",client);
        System.out.println("test");
        this.getServletContext().getRequestDispatcher("/getById.jsp").forward(request,response);


    }


}
