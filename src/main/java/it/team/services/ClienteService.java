package it.team.services;

public interface ClienteService {
	
	Cliente getModel(int id);
	
	Cliente add(Cliente cliente);
	
	Cliente update(Cliente cliente);
	
	void delete(Cliente cliente);
	
	List<Cliente> getList();

}
