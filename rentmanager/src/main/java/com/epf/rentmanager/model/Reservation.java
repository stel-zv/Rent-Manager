package com.epf.rentmanager.model;


import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

import java.time.LocalDate;

import java.util.List;

public class Reservation {

    private int id;
    private Client client;
    private Vehicle vehicle;
    private LocalDate debut;
    private LocalDate fin;


    public Reservation(int id, Vehicle vehicle, Client client, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.client = client;
        this.vehicle = vehicle;
        this.debut = debut;
        this.fin = fin;
    }

    public Reservation(Client client, Vehicle vehicle, LocalDate debut, LocalDate fin) {
        this.client = client;
        this.vehicle = vehicle;
        this.debut = debut;
        this.fin = fin;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", vehicle=" + vehicle +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }
}