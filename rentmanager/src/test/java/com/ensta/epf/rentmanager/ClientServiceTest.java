package com.ensta.epf.rentmanager;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @InjectMocks
    private ClientService clientService;
    @Mock
    private ClientDao clientDao;

    @Test
    public void findAll_should_fail_when_dao_throws_exception() throws DaoException {
        when(this.clientDao.findAll()).thenThrow(DaoException.class);
        assertThrows(ServiceException.class, () -> clientService.findAll());
    }
    @Test
    public void create_should_fail_when_dao_throws_exception() throws DaoException {
        Client client = new Client();
        when(this.clientDao.create(isA(Client.class))).thenThrow(DaoException.class);
        assertThrows(ServiceException.class, () -> clientService.create(client));
    }


}