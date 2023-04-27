package com.epf.rentmanager.service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.VehicleDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	//public static VehicleService instance;
	
	/*private VehicleService() {
		this.vehicleDao = VehicleDao.getInstance();
	}
	
	public static VehicleService getInstance() {
		if (instance == null) {
			instance = new VehicleService();
		}
		
		return instance;
	}*/

	public VehicleService(VehicleDao vehicleDao){
		this.vehicleDao=vehicleDao;
	}
	
	
	public long create(Vehicle vehicle) throws ServiceException {
		try{
			return this.vehicleDao.create(vehicle);
			//return VehicleDao.getInstance().create(vehicle);
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public long update(Vehicle vehicle) throws ServiceException {
		try{
			return this.vehicleDao.update(vehicle);
			//return VehicleDao.getInstance().create(vehicle);
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public Vehicle findById(long id) throws ServiceException {
		try {
			return this.vehicleDao.findById(id);
			//return VehicleDao.getInstance().findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public long delete (long id) throws ServiceException {
		try {
			return this.vehicleDao.delete(id);
			//return VehicleDao.getInstance().delete((id));
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	public List<Vehicle> findAll() throws ServiceException {
		try{
			return this.vehicleDao.findAll();
			//return VehicleDao.getInstance().findAll();
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}


	}
	
}
