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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@WebServlet(name = "ClientUpdateServlet", urlPatterns = "/users/update")
public class UserUpdateServlet extends HttpServlet {
    @Autowired
    ClientService clientService;

    /**
     *
     */
    @Override
    public void init() throws ServletException{
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int clientId = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("client", clientService.findById(clientId));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d");
            Client client = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("last_name"),request.getParameter("first_name"),request.getParameter("email"), LocalDate.parse(request.getParameter("naissance"), format));
            clientService.update(client);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/rentmanager/users");

    }

}

