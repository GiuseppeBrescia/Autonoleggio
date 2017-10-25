package it.team.services;

import java.util.List;

import it.team.model.Categoria;
import it.team.model.Veicolo;

public interface VeicoloService {

	Veicolo getVeicoloById(int id);

	Veicolo addVeicolo(Veicolo veicolo);

	Veicolo getModelloVeicolo(String modello);

	List<Veicolo> getListVeicoli();

	List<Veicolo> getListVeicoliByCategoria(Categoria categoria);

	Veicolo updateVeicolo(Veicolo veicolo);

	void deleteVeicolo(Veicolo veicolo);

}
