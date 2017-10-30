package it.team.services;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.controller.NoleggioController;
import it.team.dao.NoleggioDao;
import it.team.dao.VeicoloDao;
import it.team.model.Noleggio;
import it.team.model.Veicolo;

@Service
public class NoleggioServiceImpl implements NoleggioService {
	private final Logger logger = Logger.getLogger(NoleggioController.class.getName());
	
	@Autowired
	NoleggioDao noleggioDao;
	@Autowired
	VeicoloDao veicoloDao;

	@Override
	public Noleggio addNoleggio(Noleggio noleggio) {
		return noleggioDao.addNoleggio(noleggio);
	}

	@Override
	public Noleggio getNoleggioById(int id) {
		return noleggioDao.getNoleggioById(id);
	}

	@Override
	public List<Veicolo> getListDisp(LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		List<Veicolo> veicoliDisponibili = veicoloDao.getListVeicoli();
		for (Veicolo veicolo : veicoliDisponibili) {
			logger.info(veicolo + " Data Inizio: " + inizioPrenotazione + " Data fine: " + finePrenotazione);
			if (noleggioDao.isNoleggiata(veicolo, inizioPrenotazione, finePrenotazione)) {
				logger.info("Risulta noleggiata");
				veicoliDisponibili.remove(veicolo);
			}
		}
		
		return veicoliDisponibili;
	}

	@Override
	public Noleggio updateNoleggio(Noleggio noleggio) {
		return noleggioDao.updateNoleggio(noleggio);
	}

	@Override
	public void deleteNoleggio(Noleggio noleggio) {
		noleggioDao.deleteNoleggio(noleggio);

	}

	@Override
	public boolean isNoleggiata(Veicolo veicolo, LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		return (noleggioDao.isNoleggiata(veicolo, inizioPrenotazione, finePrenotazione));
	}
}
