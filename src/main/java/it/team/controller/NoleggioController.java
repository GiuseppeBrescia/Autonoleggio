package it.team.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.team.model.Cliente;
import it.team.model.Noleggio;
import it.team.model.Veicolo;
import it.team.services.ClienteService;
import it.team.services.NoleggioService;
import it.team.services.VeicoloService;

@RestController
@RequestMapping("/noleggio")
public class NoleggioController {
	@Autowired
	private NoleggioService noleggioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VeicoloService veicoloService;
	
	private final Logger logger = Logger.getLogger(NoleggioController.class.getName());
	
	@GetMapping("/getModel")
	public Noleggio getNoleggio() {
		return new Noleggio();
	}
	
	@GetMapping("/getListDisp/{dataInizio}/{dataFine}")
	public ResponseEntity<List<Veicolo>> getListDisp (@PathVariable("dataInizio") String dataInizio, @PathVariable("dataFine") String dataFine) {
		try {
			LocalDate prenotazioneInizio = LocalDate.parse(dataInizio);
			LocalDate prenotazioneFine = LocalDate.parse(dataFine);
			List<Veicolo> listVeicoli = noleggioService.getListDisp(prenotazioneInizio, prenotazioneFine);
			logger.info("Lista veicoli disponibili: " + listVeicoli);
			if (listVeicoli != null)
				return new ResponseEntity<List<Veicolo>>(listVeicoli, HttpStatus.OK);
			else
				return new ResponseEntity<List<Veicolo>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@PutMapping("/noleggio/cliente={idCliente}&veicolo={idVeicolo}")
	public ResponseEntity<Noleggio> noleggia(@RequestBody Noleggio noleggio, @PathVariable("idCliente") int idCliente, @PathVariable("idVeicolo") int idVeicolo) {
		try {
			Cliente cliente = clienteService.getClienteById(idCliente);
			Veicolo veicolo = veicoloService.getVeicoloById(idVeicolo);
			if ( cliente != null && veicolo != null)
				if (!noleggioService.isNoleggiata(veicolo, noleggio.getInizioPrenotazione(), noleggio.getFinePrenotazione())) {
					noleggio.setCliente(cliente);
					noleggio.setVeicolo(veicolo);
					noleggioService.addNoleggio(noleggio);
					logger.info("Noleggio added: " + noleggio);
					return new ResponseEntity<Noleggio>(noleggio, HttpStatus.CREATED);
				} else 
					return new ResponseEntity<Noleggio>(HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<Noleggio>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
