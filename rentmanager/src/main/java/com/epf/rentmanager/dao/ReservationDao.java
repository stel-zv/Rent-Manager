package com.epf.rentmanager.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import org.springframework.stereotype.Repository;


@Repository
public class ReservationDao {

	//private static ReservationDao instance = null;

	private ClientDao clientDao;
	private VehicleDao vehicleDao;

	private ReservationDao(ClientDao clientDao, VehicleDao vehicleDao) {
		this.clientDao=clientDao;
		this.vehicleDao=vehicleDao;

	}
	/*public static ReservationDao getInstance() {
		if(instance == null) {
			instance = new ReservationDao();
		}
		return instance;
	}*/
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String FIND_RESERVATION_BY_ID = "SELECT client_id, vehicle_id, debut, fin FROM Reservation WHERE id=?;";


	public long create(Reservation reservation) throws DaoException {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(CREATE_RESERVATION_QUERY,Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1,reservation.getClient().getId());
			statement.setLong(2,reservation.getVehicle().getId());
			statement.setDate(3,Date.valueOf(reservation.getDebut()));
			statement.setDate(4,Date.valueOf(reservation.getFin()));

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	public long delete(long id) throws DaoException {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_QUERY);
			statement.setLong(1,id);
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}


	public Reservation findResaById(int Id) throws DaoException {
		Reservation reservation = new Reservation();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_RESERVATION_BY_ID);
			statement.setLong(1,Id);
			ResultSet rs = statement.executeQuery();

				if (rs.next()) {
				int client_id = rs.getInt("client_id");
				int vehicle_id = rs.getInt("vehicle_id");
				LocalDate debut = rs.getDate("debut").toLocalDate();
				LocalDate fin = rs.getDate("fin").toLocalDate();

				Client client = this.clientDao.findById(client_id);
				Vehicle vehicle = this.vehicleDao.findById(vehicle_id);

				reservation = new Reservation(Id,vehicle, client, debut, fin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return reservation;
	}


	public List<Reservation> findResaByVehicleId(int vehicleId) throws DaoException {
		List <Reservation> reservations = new ArrayList<>();
		try {

			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_RESERVATIONS_BY_VEHICLE_QUERY);
			statement.setLong(1,vehicleId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int client_id = rs.getInt("client_id");
				LocalDate debut = rs.getDate("debut").toLocalDate();
				LocalDate fin = rs.getDate("fin").toLocalDate();

				Client client = this.clientDao.findById(client_id);
				Vehicle vehicle = this.vehicleDao.findById(vehicleId);

				reservations.add(new Reservation(id,vehicle,client,debut, fin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return reservations;
	}

	public List<Reservation> findResaByClientId(int clientId) throws DaoException {
		List <Reservation> reservations = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			statement.setLong(1,clientId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				int vehicle_id  = rs.getInt("vehicle_id");
				LocalDate debut = rs.getDate("debut").toLocalDate();
				LocalDate fin = rs.getDate("fin").toLocalDate();

				Client client = this.clientDao.findById(clientId);
				Vehicle vehicle = this.vehicleDao.findById(vehicle_id);

				reservations.add(new Reservation(id,vehicle,client, debut, fin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return reservations;
	}

	public List<Vehicle> findVehicleResaByClientId(int clientId) throws DaoException{
		List <Reservation> reservations = findResaByClientId(clientId);
		List <Vehicle> vehicles = new ArrayList<>();
		for (int i=0; i<reservations.size();i++){
			Vehicle vehicle = new Vehicle();
			vehicle = reservations.get(i).getVehicle();
			vehicles.add(vehicle);
		}

		List<Vehicle> newvehicles = new ArrayList<>(new LinkedHashSet<>(vehicles));

		return newvehicles;

	}

	public List<Client> findClientResaByVehicleId(int vehicleId) throws DaoException{
		List <Reservation> reservations = findResaByVehicleId(vehicleId);
		List <Client> clients= new ArrayList<>();
		for (int i=0; i<reservations.size();i++){
			Client client = new Client();
			client = reservations.get(i).getClient();
			clients.add(client);
		}
		List<Client> newclients = new ArrayList<>(new LinkedHashSet<>(clients));
		return newclients;

	}
	public List<Reservation> findAll() throws DaoException {
		List <Reservation> reservations = new ArrayList <Reservation>();
		try {
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_RESERVATIONS_QUERY);

			while (rs.next()) {
				int id = rs.getInt("id");
				int client_id = rs.getInt("client_id");
				int vehicle_id = rs.getInt("vehicle_id");
				LocalDate debut = rs.getDate("debut").toLocalDate();
				LocalDate fin = rs.getDate("fin").toLocalDate();

				Client client = this.clientDao.findById(client_id);
				Vehicle vehicle = this.vehicleDao.findById(vehicle_id);

				reservations.add(new Reservation(id,vehicle,client, debut, fin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return reservations;
	}
}
