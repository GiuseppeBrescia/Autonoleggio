package it.team.services;

import java.time.LocalDate;
import java.util.List;

import it.team.model.Noleggio;
import it.team.model.Veicolo;

public interface NoleggioService {
	Noleggio addNoleggio(Noleggio noleggio);
	Noleggio getNoleggioById(int id);
	List<Veicolo> getListDisp(LocalDate inizioPrenotazione,LocalDate finePrenotazione);
	boolean isNoleggiata(Veicolo veicolo, LocalDate inizioPrenotazione, LocalDate finePrenotazione);
	Noleggio updateNoleggio(Noleggio noleggio);
	void deleteNoleggio(Noleggio noleggio);
}