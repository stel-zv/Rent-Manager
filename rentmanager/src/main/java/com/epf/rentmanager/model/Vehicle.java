package com.epf.rentmanager.model;

import java.util.Objects;

public class Vehicle {

    private long id;
    private String constructeur;
    private int nb_places;


    public Vehicle() {
    }

    public Vehicle(String constructeur, int nb_places) {
        this.constructeur = constructeur;
        this.nb_places = nb_places;
    }

    public Vehicle(long id, String constructeur, int nb_places) {
        this.id = id;
        this.constructeur = constructeur;
        //this.modele = modele;
        this.nb_places = nb_places;
    }



    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", constructeur='" + constructeur + '\'' +
                ", nb_places=" + nb_places +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && nb_places == vehicle.nb_places && Objects.equals(constructeur, vehicle.constructeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, constructeur, nb_places);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }
}


