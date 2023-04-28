package com.ensta.epf.rentmanager;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class VehicleServiceTest
    {
        @InjectMocks
        private VehicleService vehicleService;
        @Mock
        private VehicleDao vehicleDao;

        @Test
        public void findAll_should_fail_when_dao_throws_exception() throws DaoException {
        when(this.vehicleDao.findAll()).thenThrow(DaoException.class);
        assertThrows(ServiceException.class, () -> vehicleService.findAll());
        }

        @Test
        public void create_should_fail_when_dao_throws_exception() throws DaoException {
            Vehicle vehicle = new Vehicle();
            when(this.vehicleDao.create(isA(Vehicle.class))).thenThrow(DaoException.class);
            assertThrows(ServiceException.class, () -> vehicleService.create(vehicle));
        }
    }

