package it.team.services;

import java.time.LocalDate;
import java.util.List;

import it.team.dao.NoleggioDao;
import it.team.dao.NoleggioDaoImpl;
import it.team.dao.VeicoloDao;
import it.team.dao.VeicoloDaoImpl;
import it.team.model.Noleggio;
import it.team.model.Veicolo;

public class NoleggioServiceImpl implements NoleggioService {

	NoleggioDao noleggioDao = new NoleggioDaoImpl();
	VeicoloDao veicoloDao = new VeicoloDaoImpl();

	@Override
	public Noleggio addNoleggio(Noleggio noleggio) {
		return null;
	}

	@Override
	public Noleggio getNoleggioById(int id) {
		return null;
	}

	@Override
	public List<Noleggio> getListNoleggi(LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		return noleggioDao.getListNoleggi(inizioPrenotazione, finePrenotazione);
	}

	@Override
	public List<Veicolo> getListDisp(LocalDate inizioPrenotazione, LocalDate finePrenotazione) {
		return noleggioDao.getListDisp(inizioPrenotazione, finePrenotazione);
	}

	@Override
	public Noleggio updateNoleggio(Noleggio noleggio) {
		return null;
	}

	@Override
	public void deleteNoleggio(Noleggio noleggio) {

	}
}
