package it.team.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.team.model.Noleggio;
import it.team.model.Veicolo;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	@Override
	public Noleggio addNoleggio(Noleggio noleggio) {
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
	public Noleggio updateNoleggio(Noleggio noleggio) {
		update(noleggio);
		return noleggio;
	}

	@Override
	public void deleteNoleggio(Noleggio noleggio) {
		delete(getNoleggioById(noleggio.getId()));
	}

	@Override
	public List<Veicolo> getListDisp(LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		return null;
	}

	@Override
	public boolean isNoleggiata(Veicolo veicolo, LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		Noleggio noleggio = (Noleggio) getSession().createCriteria(Noleggio.class)
									 .add(Restrictions.eq("veicolo", veicolo))
									 .add(Restrictions.ge("inizioPrenotazione", inizioPrenotazione))
									 .add(Restrictions.le("finePrenotazione", finePrenotazione))
									 .uniqueResult();
		return (noleggio != null);
	}


}
