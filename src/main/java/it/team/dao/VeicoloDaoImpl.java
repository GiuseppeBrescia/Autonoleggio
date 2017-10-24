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

	public Veicolo getVeicoloById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}

	public Veicolo addVeicolo(Veicolo veicolo) {
		persist(veicolo);
		return veicolo;
	}

	public Veicolo getModelloVeicolo(String modello) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("marca", modello));
		return (Veicolo) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Veicolo> getListVeicoli() {
		return getSession().createCriteria(Veicolo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Veicolo> getListVeicoliByCategoria(Categoria categoria) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("categoria", categoria));
		return criteria.list();
	}

	public Veicolo updateVeicolo(Veicolo veicolo) {
		update(veicolo);
		return veicolo;
	}

	public void deleteVeicolo(Veicolo veicolo) {
		delete(getModelloVeicolo(veicolo.getModello()));
	}

}
