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

	@Override
	public Cliente add(Cliente cliente) {
		persist(cliente);
		return cliente;
	}

	@Override
	public Cliente getClienteById(int id) {
		Criteria criteria = getSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		return (Cliente) criteria.uniqueResult();

	}

	@Override
	public List<Cliente> getList() {
		return getSession().createCriteria(Cliente.class).list();
	}

	@Override
	public Cliente update(Cliente cliente) {
		update(cliente);
		return null;
	}

	@Override
	public void delete(Cliente cliente) {
		delete(getClienteById(cliente.getId()));
	}

}
