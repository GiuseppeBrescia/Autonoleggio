package it.team.dao;

import java.util.List;

import it.team.model.Noleggio;

public interface NoleggioDao {

	Noleggio addNoleggio(Noleggio noleggio);

	Noleggio getNoleggioById(int id);

	List<Noleggio> getListNoleggiDisp();

	Noleggio updateNoleggio(Noleggio noleggio);

	void deleteNoleggio(Noleggio noleggio);

}
