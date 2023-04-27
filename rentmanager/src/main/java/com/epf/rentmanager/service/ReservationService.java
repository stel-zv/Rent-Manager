package com.epf.rentmanager.service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationService {

    private ReservationDao reservationDao;
    //public static ReservationService instance;

    /*private ReservationService() {
        this.reservationDao = ReservationDao.getInstance();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }

        return instance;
    }*/

    public ReservationService(ReservationDao reservationDao){
        this.reservationDao=reservationDao;
    }

    public long create(Reservation reservation) throws ServiceException {
        try{
            return this.reservationDao.create(reservation);
            //return ReservationDao.getInstance().create(reservation);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public long delete(long id) throws ServiceException {
        try{
            return this.reservationDao.delete(id);
            //return ReservationDao.getInstance().delete((id));
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public List<Reservation> findAll() throws ServiceException {
        try{
            return this.reservationDao.findAll();
            //return ReservationDao.getInstance().findAll();
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public List<Reservation> findResaByVehicleId(int id_vehicle) throws ServiceException {
        try{
            return this.reservationDao.findResaByVehicleId(id_vehicle);
            //return ReservationDao.getInstance().findResaByVehicleId(id_vehicle);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    public List<Reservation> findResaByClientId(int id_client) throws ServiceException {
        try{
            return this.reservationDao.findResaByClientId(id_client);
            //return ReservationDao.getInstance().findResaByClientId(id_client);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public List<Vehicle> findVehicleResaByClientId(int id_client) throws DaoException{
        try{
            return this.reservationDao.findVehicleResaByClientId(id_client);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    public Reservation findResaById(int id) throws ServiceException {
        try{
            return this.reservationDao.findResaById(id);
            //return ReservationDao.getInstance().findResaById(id);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }


}
