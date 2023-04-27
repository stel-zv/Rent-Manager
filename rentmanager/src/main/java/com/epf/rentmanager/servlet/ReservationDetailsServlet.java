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

@WebServlet(name = "ReservationDetailsServlet", urlPatterns = "/rents/details")
public class ReservationDetailsServlet extends HttpServlet {

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
            int reservationId = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("reservation", reservationService.findResaById(reservationId));
        } catch (ServiceException e) {
        e.printStackTrace();
        }
    request.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/details.jsp").forward(request, response);
        }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
        }

        }
