package com.epf.rentmanager.servlet;

import java.io.IOException;
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
import com.epf.rentmanager.service.VehicleService;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private ClientService clientDao = new ClientService();
	private VehicleService vehicleDao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			int count_client = this.clientDao.findAll().size();
			int count_vehicles = this.vehicleDao.findAll().size();

			request.setAttribute("nb_clients",count_client);
			request.setAttribute("nb_vehicles",count_vehicles);
		}

		catch (ServiceException e){
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

}
