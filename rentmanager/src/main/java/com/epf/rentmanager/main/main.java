package com.epf.rentmanager.main;
import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;
import com.epf.rentmanager.servlet.HomeServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) throws ServiceException {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ClientService clientService = context.getBean(ClientService.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        ReservationService reservationService = context.getBean(ReservationService.class);

    }
}
