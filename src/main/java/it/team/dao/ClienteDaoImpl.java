package it.team.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.team.model.Cliente;

@Repository
@Transactional
public class ClienteDaoImpl extends AbstractDao implements ClienteDao {

	public Cliente addCliente(Cliente cliente) {
		persist(cliente);
		return cliente;
	}

	public Cliente getClienteById(int id) {
		Criteria criteria = getSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		return (Cliente) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getListClienti() {
		return getSession().createCriteria(Cliente.class).list();
	}

	public Cliente updateCliente(Cliente cliente) {
		update(cliente);
		return null;
	}

	public void deleteCliente(Cliente cliente) {
		delete(getClienteById(cliente.getId()));
	}

}
