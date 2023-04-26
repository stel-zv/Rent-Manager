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
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@WebServlet("/rents/create")
public class ReservationCreateServlet extends HttpServlet {
    @Autowired
    ClientService clientService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    ReservationService reservationService;

    /**
     *
     */
    @Override
    public void init() throws ServletException{
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{

            List<Vehicle> vehicles = vehicleService.findAll();
            List<Client> clients = clientService.findAll();
            request.setAttribute("clients",clients);
            request.setAttribute("vehicles",vehicles);

        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/create.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d");

            long clientId = Integer.parseInt(request.getParameter("client"));
            System.out.println (clientId);
            Client client = clientService.findById(clientId);

            long vehicleId=Integer.parseInt(request.getParameter("voiture"));
            Vehicle vehicle = vehicleService.findById(vehicleId);

            LocalDate begin = LocalDate.parse(request.getParameter("begin"), format);
            LocalDate end = LocalDate.parse(request.getParameter("end"), format);

            Reservation reservation = new Reservation(client, vehicle, begin, end);

            reservationService.create(reservation);

        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/rentmanager/rents");

    }

}

