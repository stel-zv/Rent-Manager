package com.epf.rentmanager.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@WebServlet(name = "ReservationDeleteServlet", urlPatterns = "/rents/delete")
public class ReservationDeleteServlet extends HttpServlet {

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int resaId = Integer.parseInt(request.getParameter("id"));
            reservationService.delete(resaId);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/rentmanager/rents");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
