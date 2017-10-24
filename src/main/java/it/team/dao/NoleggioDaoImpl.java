package it.team.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.team.model.Cliente;
import it.team.model.Noleggio;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	private static List<Noleggio> listaN;

	@Override
	public Noleggio add(Noleggio noleggio) {
		persist(noleggio);
		return noleggio;
	}

	@Override
	public Noleggio getNoleggioById(int id) {
		Criteria criteria = getSession().createCriteria(Noleggio.class);
		criteria.add(Restrictions.eq("id", id));
		return (Noleggio) criteria.uniqueResult();
	}

	@Override
	public List<Noleggio> getListDisp() {
		return getSession().createCriteria(Noleggio.class).list();
	}

	@Override
	public List<Noleggio> getListById(int id) {
		return null;
	}

	@Override
	public Noleggio update(Noleggio noleggio) {
		update(noleggio);
		return null;
	}

	@Override
	public void delete(Noleggio noleggio) {
		delete(getNoleggioById(noleggio.getId()));
	}

	@Override
	public void noleggia(Noleggio noleggio) {
		System.out.println("Dammi la lista dei veicoli");

	}

	@Override
	public void restituisci() {

	}

}
