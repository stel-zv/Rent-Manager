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
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@WebServlet(name = "VehicleUpdateServlet", urlPatterns = "/cars/update")
public class VehicleUpdateServlet extends HttpServlet {
    @Autowired
    VehicleService vehicleService;

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
            int vehicleId = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("vehicle", vehicleService.findById(vehicleId));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Vehicle vehicle = new Vehicle(Integer.parseInt(request.getParameter("id")),request.getParameter("manufacturer"),Integer.parseInt(request.getParameter("seats")));
            vehicleService.update(vehicle);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/rentmanager/cars");

    }

}

