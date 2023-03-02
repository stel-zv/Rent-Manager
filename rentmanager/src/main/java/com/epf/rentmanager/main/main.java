package com.epf.rentmanager.main;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        try {

            //Date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = "16/09/2001";

            //Ajout et suppression client
            LocalDate naissancestella = LocalDate.parse(date, formatter);
            Client stella = new Client ("zaborov", "stella", "stella.zaborov@gmail.com",naissancestella);
                //ClientService.getInstance().create(stella);
               //ClientService.getInstance().delete(6);

            //Montrer tous les clients
            List<Client> clients = ClientService.getInstance().findAll();
            System.out.println(clients);

            //Montrer un seul client
            Client client = ClientService.getInstance().findById(4);
            //System.out.println(client);

            //Ajout et suppression vehicule
            Vehicle yaris = new Vehicle("Toyota",4);
                //VehicleService.getInstance().create(yaris);
              //VehicleService.getInstance().delete(6);

            //Montrer tous les vehicules
            List<Vehicle> vehicles = VehicleService.getInstance().findAll();
            System.out.println(vehicles);

            //Montrer un seul vehicule
            Vehicle vehicle = VehicleService.getInstance().findById(2);
                //System.out.println(vehicle);

            //Ajout reservation
                //Reservation reservation = new Reservation(1,1,)


        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}