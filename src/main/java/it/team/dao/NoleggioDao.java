package it.team.dao;

import java.time.LocalDate;
import java.util.List;

import it.team.model.Noleggio;
import it.team.model.Veicolo;

public interface NoleggioDao {
	Noleggio addNoleggio(Noleggio noleggio);
	Noleggio getNoleggioById(int id);
	boolean isNoleggiata(Veicolo veicolo, LocalDate inizioPrenotazione, LocalDate finePrenotazione);
	List<Veicolo> getListDisp(LocalDate inizioPrenotazione,LocalDate finePrenotazione);
	Noleggio updateNoleggio(Noleggio noleggio);
	void deleteNoleggio(Noleggio noleggio);
}
