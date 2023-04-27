package com.epf.rentmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.persistence.ConnectionManager;

import org.springframework.stereotype.Repository;


@Repository

public class ClientDao {

	//private static ClientDao instance = null;

	private ClientDao() {
	}

	/*public static ClientDao getInstance() {
		if (instance == null) {
			instance = new ClientDao();
		}
		return instance;
	}*/

	private static final String CREATE_CLIENT_QUERY = "INSERT INTO Client(nom, prenom, email, naissance) VALUES(?, ?, ?, ?);";
	private static final String DELETE_CLIENT_QUERY = "DELETE FROM Client WHERE id=?;";
	private static final String FIND_CLIENT_QUERY = "SELECT nom, prenom, email, naissance FROM Client WHERE id=?;";
	private static final String FIND_CLIENTS_QUERY = "SELECT id, nom, prenom, email, naissance FROM Client;";
	private static final String UPDATE_CLIENT_QUERY = "UPDATE Client SET nom = ?, prenom = ?, email = ?, naissance = ? WHERE id = ?;";



	public long create(Client client) throws DaoException {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(CREATE_CLIENT_QUERY,Statement.RETURN_GENERATED_KEYS);

			statement.setString(1,client.getPrenom());
			statement.setString(2,client.getNom());
			statement.setString(3,client.getEmail());
			statement.setDate(4,Date.valueOf(client.getNaissance()));

			long key = statement.executeUpdate();
			connection.close();
			return key;

		} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}

	public long update(Client client) throws DaoException{
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_QUERY,Statement.RETURN_GENERATED_KEYS);

			statement.setString(1,client.getPrenom());
			statement.setString(2,client.getNom());
			statement.setString(3,client.getEmail());
			statement.setDate(4,Date.valueOf(client.getNaissance()));
			statement.setLong(5, client.getId());

			long key = statement.executeUpdate();
			connection.close();
			return key;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public long delete(long id) throws DaoException {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_QUERY);
			statement.setLong(1,id);

			long key = statement.executeUpdate();
			connection.close();
			return key;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public List<Client> findAll() throws DaoException {
		List <Client> clients = new ArrayList <Client>();
		try {
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_CLIENTS_QUERY);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email =rs.getString("email");
				LocalDate naissance = rs.getDate("naissance").toLocalDate();

				clients.add(new Client(id,nom, prenom, email, naissance));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return clients;
	}

	public Client findById(long id) throws DaoException {
		Client client = new Client();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND_CLIENT_QUERY);
			statement.setLong(1,id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				LocalDate naissance = rs.getDate("naissance").toLocalDate();

				client = new Client(id, nom, prenom, email, naissance);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} return client;

	}

}
