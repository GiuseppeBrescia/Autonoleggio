package it.team.dao;

import java.util.List;

import it.team.model.Categoria;
import it.team.model.Veicolo;

public interface VeicoloDao {

	Veicolo getById(int id);

	Veicolo add(Veicolo veicolo);

	Veicolo getModel(String modello);

	List<Veicolo> getList();

	List<Veicolo> getListByCategoria(Categoria categoria);

	Veicolo update(Veicolo veicolo);

	void delete(Veicolo veicolo);

}
