package it.team.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.team.model.Categoria;
import it.team.model.Veicolo;

@Repository
@Transactional
public class VeicoloDaoImpl extends AbstractDao implements VeicoloDao {

	@Override
	public Veicolo getById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}

	@Override
	public Veicolo add(Veicolo veicolo) {
		persist(veicolo);
		return veicolo;
	}

	@Override
	public Veicolo getModel(String modello) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("marca", modello));
		return (Veicolo) criteria.uniqueResult();
	}

	@Override
	public List<Veicolo> getList() {
		return getSession().createCriteria(Veicolo.class).list();
	}

	@Override
	public List<Veicolo> getListByCategoria(Categoria categoria) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("categoria", categoria));
		return criteria.list();
	}

	@Override
	public Veicolo update(Veicolo veicolo) {
		update(veicolo);
		return null;
	}

	@Override
	public void delete(Veicolo veicolo) {
		delete(getModel(veicolo.getModello()));
	}

}
