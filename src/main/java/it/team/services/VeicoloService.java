package it.team.services;

import java.util.List;

import it.relatech.model.User;

public interface VeicoloService {

	Veicolo getModel(String modello);

	Veicolo add(Veicolo veicolo);

	Veicolo update(Veicolo veicolo);

	void delete(Veicolo veicolo);

	List<Veicolo> getList();

	Veicolo getById(int id);

	List<Veicolo> getListDisp();

	void noleggia(int id);

	void restituisci(int id);

	List<Veicolo> getListByCategoria(Categoria categoria);

}
