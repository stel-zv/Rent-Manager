package com.epf.rentmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name = "VehicleDetailsServlet", urlPatterns = "/cars/details")
public class VehicleDetailsServlet extends HttpServlet {

    @Autowired
    ClientService clientService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    ReservationService reservationService;

    @Override
    public void init() throws ServletException{
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int vehicleId = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("vehicle", vehicleService.findById(vehicleId));
            request.setAttribute("reservations", reservationService.findResaByVehicleId(vehicleId));
            request.setAttribute("clients",reservationService.findClientResaByVehicleId(vehicleId));

            request.setAttribute("nb_clients",reservationService.findClientResaByVehicleId(vehicleId).size());
            request.setAttribute("nb_reservations",reservationService.findResaByVehicleId(vehicleId).size());

        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
