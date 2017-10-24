package it.team.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.team.model.Noleggio;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	public Noleggio add(Noleggio noleggio) {
		persist(noleggio);
		return noleggio;
	}

	public Noleggio getNoleggioById(int id) {
		Criteria criteria = getSession().createCriteria(Noleggio.class);
		criteria.add(Restrictions.eq("id", id));
		return (Noleggio) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Noleggio> getListDisp() {
		return getSession().createCriteria(Noleggio.class).list();

	}

	public List<Noleggio> getListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Noleggio update(Noleggio noleggio) {
		update(noleggio);
		return noleggio;
	}

	public void delete(Noleggio noleggio) {
		delete(getNoleggioById(noleggio.getId()));
	}

	public void noleggia(Noleggio noleggio) {
		System.out.println("Dammi la lista dei veicoli");

	}

	public void restituisci() {
		// TODO Auto-generated method stub

	}

}
