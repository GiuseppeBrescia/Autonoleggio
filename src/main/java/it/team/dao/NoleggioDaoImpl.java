package it.team.dao;

import java.time.LocalDate;

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
	public boolean isNoleggiata(Veicolo veicolo, LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		Noleggio noleggio = (Noleggio) getSession().createCriteria(Noleggio.class, "noleggio")
									 .createAlias("noleggio.veicolo", "veicolo")
									 .add(Restrictions.eq("veicolo.id", veicolo.getId()))
									 .add ( Restrictions.or( 
											 Restrictions.between("inizioPrenotazione", inizioPrenotazione, finePrenotazione),
											 Restrictions.between("finePrenotazione", inizioPrenotazione, finePrenotazione)
									      ))
									.uniqueResult();
		
		return (noleggio != null);
	}


}
