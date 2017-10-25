package it.team.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.dao.VeicoloDao;
import it.team.model.Categoria;
import it.team.model.Veicolo;

@Service
public class VeicoloServiceImpl implements VeicoloService {

	@Autowired
	private VeicoloDao veicoloDao;

	@Override
	public Veicolo getVeicoloById(int id) {
		return veicoloDao.getVeicoloById(id);
	}

	@Override
	public Veicolo addVeicolo(Veicolo veicolo) {
		return veicoloDao.addVeicolo(veicolo);
	}

	@Override
	public Veicolo getModelloVeicolo(String modello) {
		return veicoloDao.getModelloVeicolo(modello);
	}

	@Override
	public List<Veicolo> getListVeicoli() {
		return veicoloDao.getListVeicoli();
	}

	@Override
	public List<Veicolo> getListVeicoliByCategoria(Categoria categoria) {
		return veicoloDao.getListVeicoliByCategoria(categoria);
	}

	@Override
	public Veicolo updateVeicolo(Veicolo veicolo) {
		return veicoloDao.updateVeicolo(veicolo);
	}

	@Override
	public void deleteVeicolo(Veicolo veicolo) {
		veicoloDao.deleteVeicolo(veicolo);
	}

}
