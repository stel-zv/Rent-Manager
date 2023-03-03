package com.epf.rentmanager.service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.dao.ReservationDao;

import java.util.List;


public class ReservationService {

    private ReservationDao reservationDao;
    public static ReservationService instance;

    private ReservationService() {
        this.reservationDao = ReservationDao.getInstance();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }

        return instance;
    }

    public long create(Reservation reservation) throws ServiceException {
        try{
            return ReservationDao.getInstance().create(reservation);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public long delete(long id) throws ServiceException {
        try{
            return ReservationDao.getInstance().delete((id));
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public List<Reservation> findAll() throws ServiceException {
        try{
            return ReservationDao.getInstance().findAll();
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public List<Reservation> findResaByVehicleId(int id_vehicle) throws ServiceException {
        try{
            return ReservationDao.getInstance().findResaByVehicleId(id_vehicle);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }
    }

    public List<Reservation> findResaByClientId(int id_client) throws ServiceException {
        try{
            return ReservationDao.getInstance().findResaByClientId(id_client);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }

    public Reservation findResaById(int id) throws ServiceException {
        try{
            return ReservationDao.getInstance().findResaById(id);
        } catch (DaoException e){
            e.printStackTrace();
            throw new ServiceException();
        }

    }


}
