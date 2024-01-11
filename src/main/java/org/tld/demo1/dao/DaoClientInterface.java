package org.tld.demo1.dao;
import org.tld.demo1.model.*;

import java.sql.SQLException;
import java.util.List;

public interface DaoClientInterface {

	
	public List<Client> getAllClients();
	public List<Client> getByID(int id) ;
	public Client updateClient(int id,Client client) throws SQLException;
	public void deleteClient(int id) throws SQLException;
	public Client createClient(Client client) throws SQLException;
	public List<Client> getByMC(String mc) throws SQLException;
}
