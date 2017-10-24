package it.team.dao;

import java.util.List;

import it.team.model.Cliente;

public interface ClienteDao {

	Cliente addCliente(Cliente cliente);

	Cliente getClienteById(int id);

	List<Cliente> getListClienti();

	Cliente updateCliente(Cliente cliente);

	void deleteCliente(Cliente cliente);
}
