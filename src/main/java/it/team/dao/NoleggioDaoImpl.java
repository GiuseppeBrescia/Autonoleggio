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

	public Noleggio addNoleggio(Noleggio noleggio) {
		persist(noleggio);
		return noleggio;
	}

	public Noleggio getNoleggioById(int id) {
		Criteria criteria = getSession().createCriteria(Noleggio.class);
		criteria.add(Restrictions.eq("id", id));
		return (Noleggio) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Noleggio> getListNoleggiDisp() {
		return getSession().createCriteria(Noleggio.class).list();

	}

	public Noleggio updateNoleggio(Noleggio noleggio) {
		update(noleggio);
		return noleggio;
	}

	public void deleteNoleggio(Noleggio noleggio) {
		delete(getNoleggioById(noleggio.getId()));
	}

}
