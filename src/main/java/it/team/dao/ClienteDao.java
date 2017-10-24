package it.team.dao;

import java.util.List;

import it.team.model.Cliente;

public interface ClienteDao {

	Cliente add(Cliente cliente);

	Cliente getClienteById(int id);

	List<Cliente> getList();

	Cliente update(Cliente cliente);

	void delete(Cliente cliente);
}
