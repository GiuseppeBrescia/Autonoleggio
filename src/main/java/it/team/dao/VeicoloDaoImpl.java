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

	public Veicolo getById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}

	public Veicolo add(Veicolo veicolo) {
		persist(veicolo);
		return veicolo;
	}

	public Veicolo getModel(String modello) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("marca", modello));
		return (Veicolo) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Veicolo> getList() {
		return getSession().createCriteria(Veicolo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Veicolo> getListByCategoria(Categoria categoria) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("categoria", categoria));
		return criteria.list();
	}

	public Veicolo update(Veicolo veicolo) {
		update(veicolo);
		return veicolo;
	}

	public void delete(Veicolo veicolo) {
		delete(getModel(veicolo.getModello()));
	}

}
