package it.team.dao;

import java.util.List;

import it.team.model.Noleggio;

public interface NoleggioDao {

	Noleggio add(Noleggio noleggio);

	Noleggio getNoleggioById(int id);

	List<Noleggio> getListDisp();

	List<Noleggio> getListById(int id);

	Noleggio update(Noleggio noleggio);

	void delete(Noleggio noleggio);

	void noleggia(Noleggio noleggio);

	void restituisci();

}
