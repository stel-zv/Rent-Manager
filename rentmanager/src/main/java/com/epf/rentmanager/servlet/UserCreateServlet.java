package com.epf.rentmanager.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;


@WebServlet("/users/create")
public class UserCreateServlet extends HttpServlet {
    private ClientService clientservice = ClientService.getInstance();

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/create.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d");
            Client client = new Client(request.getParameter("last_name"),request.getParameter("first_name"),request.getParameter("email"), LocalDate.parse(request.getParameter("naissance"), format));
            System.out.println(client);
            clientservice.create(client);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/rentmanager/users");

    }

}

