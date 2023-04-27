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
    public static void main(String[] args) {

        try {



            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
            ClientService clientService = context.getBean(ClientService.class);
            VehicleService vehicleService = context.getBean(VehicleService.class);
            ReservationService reservationService = context.getBean(ReservationService.class);
            // ReservationService reservationService = context.getBean(ReservationService.class);

            //Date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = "16/09/2001";

            //Ajout et suppression client
            LocalDate naissancestella = LocalDate.parse(date, formatter);
            Client stella = new Client ("zaborov", "stella", "stella.zaborov@gmail.com",naissancestella);

            //Montrer tous les clients
            List<Client> clients = clientService.findAll();
            System.out.println(clients);

            //Montrer un seul client
            Client client = clientService.findById(4);
            //System.out.println(client);

            //Ajout et suppression vehicule
            Vehicle yaris = new Vehicle("Toyota",4);
                //VehicleService.getInstance().create(yaris);
              //VehicleService.getInstance().delete(6);

            //Montrer tous les vehicules
            List<Vehicle> vehicles = vehicleService.findAll();
            //System.out.println(vehicles);

            //Montrer un seul vehicule
            Vehicle vehicle = vehicleService.findById(2);
                //System.out.println(vehicle);

            //Ajout reservation
                //Reservation reservation = new Reservation(1,1,naissancestella,naissancestella);
                //ReservationService.getInstance().create(reservation);
                //List <Reservation> resas = ReservationService.getInstance().findAll();
                //System.out.println (resas);
                //System.out.println (resas.size());
                //System.out.println(ReservationService.getInstance().findResaById(1));
                //System.out.println(ReservationService.getInstance().findResaByVehicleId(1));
                //System.out.println(ReservationService.getInstance().findResaByClientId(1));

            //counter clients
            int count_clients = clientService.findAll().size();
            int count_vehicles = vehicleService.findAll().size();
           // System.out.println (count_clients);
            //System.out.println (count_vehicles);

           List<Vehicle> vehiclesss = reservationService.findVehicleResaByClientId(1);


        } catch (ServiceException e) {
            throw new RuntimeException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}