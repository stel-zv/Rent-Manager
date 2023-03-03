package com.epf.rentmanager.service;


import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.dao.ClientDao;

import java.util.List;

public class ClientService {

	private ClientDao clientDao;
	public static ClientService instance;
	
	private ClientService() {
		this.clientDao = ClientDao.getInstance();
	}
	
	public static ClientService getInstance() {
		if (instance == null) {
			instance = new ClientService();
		}
		
		return instance;
	}

	public long create(Client client) throws ServiceException {
		try{
			return ClientDao.getInstance().create(client);
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public long delete(long id) throws ServiceException {
		try{
			return ClientDao.getInstance().delete((id));
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public Client findById(long id) throws ServiceException {
		try {
			return ClientDao.getInstance().findById(id);
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	public List<Client> findAll() throws ServiceException {
		try{
			return ClientDao.getInstance().findAll();
		} catch (DaoException e){
			e.printStackTrace();
			throw new ServiceException();
		}

	}
	
}
