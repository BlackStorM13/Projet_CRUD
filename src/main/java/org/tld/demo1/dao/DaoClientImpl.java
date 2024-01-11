package org.tld.demo1.dao;

import org.tld.demo1.model.Client;
import org.tld.demo1.util.ConnexionJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoClientImpl implements DaoClientInterface {
	ConnexionJdbc connexionJdbc;
	public DaoClientImpl(){
		this.connexionJdbc = new ConnexionJdbc();
	}

	@Override
	public List<Client> getAllClients()  {
		PreparedStatement request = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();
		try {
			request = connexionJdbc.getConnection().prepareStatement("SELECT * FROM clients ");
			ResultSet resultSet;
			resultSet = request.executeQuery();

			while (resultSet.next()) {
				client = new Client(
						resultSet.getInt("id"),
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getString("email"),
						resultSet.getString("tel")
				);

				clients.add(client);
			}
			connexionJdbc.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;
	};

	@Override
	public List<Client> getByID(int id) {
        PreparedStatement request = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();
		try {
			request = connexionJdbc.getConnection().prepareStatement("SELECT * FROM clients WHERE id = ? ");
			ResultSet resultSet;
			request.setInt(1,id);
			resultSet = request.executeQuery();

			while (resultSet.next()) {
				client = new Client(
						resultSet.getInt("id"),
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getString("email"),
						resultSet.getString("tel")
				);

				clients.add(client);
			}
			connexionJdbc.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;

	}

	@Override
	public Client updateClient(int id,Client client) throws SQLException{
		try {
			int resultSet;
			PreparedStatement preparedStatement = connexionJdbc.getConnection().prepareStatement("UPDATE personne SET nom = ? , prenom = ?, email = ?, tel = ? WHERE id = ?");

			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getEmail());
			preparedStatement.setString(4, client.getTel());
			preparedStatement.setInt(5, id);

			resultSet = preparedStatement.executeUpdate();

			connexionJdbc.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void deleteClient(int id) throws  SQLException{
		PreparedStatement request = connexionJdbc.getConnection().prepareStatement("DELETE FROM personne WHERE id = ? ");
		ResultSet resultSet;
		request.setInt(1, id);
		resultSet = request.executeQuery();
		connexionJdbc.getConnection().close();

	}

	@Override
	public Client createClient(Client client) throws SQLException {
		PreparedStatement request = connexionJdbc.getConnection().prepareStatement("INSERT INTO personne VALUES ?, ?, ?, ?");
		ResultSet resultSet;
		request.setString(1, client.getNom());
		request.setString(2, client.getPrenom());
		request.setString(3, client.getEmail());
		request.setString(4, client.getTel());

		resultSet = request.executeQuery();
		connexionJdbc.getConnection().close();

		return client;
	}

	@Override
	public List<Client> getByMC(String mc) throws SQLException {
		PreparedStatement request = connexionJdbc.getConnection().prepareStatement("SELECT * FROM personne WHERE nom LIKE % ? % OR prenom like % ? % OR email like % ? % OR tel like % ? %;");
		ResultSet resultSet;
		List<Client> clients = new ArrayList<>();
		request.setString(1,mc);
		request.setString(2,mc);
		request.setString(3,mc);
		request.setString(4,mc);
		request.setString(5,mc);



		resultSet = request.executeQuery();


		Client client = null;

		while (resultSet.next()) {
			client = new Client(
					resultSet.getInt("id"),
					resultSet.getString("nom"),
					resultSet.getString("prenom"),
					resultSet.getString("email"),
					resultSet.getString("tel")
			);

			clients.add(client);
		}
		connexionJdbc.getConnection().close();
		return clients;
	}

}
