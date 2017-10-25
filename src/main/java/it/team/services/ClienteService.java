package it.team.services;

import java.util.List;

import it.team.model.Cliente;

public interface ClienteService {

	Cliente add(Cliente cliente);

	Cliente update(Cliente cliente);

	void delete(Cliente cliente);

	List<Cliente> getList();

}
