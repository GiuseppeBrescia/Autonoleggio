package it.team.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.dao.ClienteDao;
import it.team.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente add(Cliente cliente) {
		return clienteDao.addCliente(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		clienteDao.deleteCliente(cliente);
	}

	@Override
	public List<Cliente> getList() {
		return clienteDao.getListClienti();
	}

	@Override
	public Cliente getClienteById(int id) {
		return clienteDao.getClienteById(id);
	}

}
