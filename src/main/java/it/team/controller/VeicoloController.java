package it.team.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.team.model.Categoria;
import it.team.model.Veicolo;
import it.team.services.VeicoloService;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {
	@Autowired
	private VeicoloService veicoloService;

	private final Logger logger = Logger.getLogger(VeicoloController.class.getName());

	@GetMapping("/getModel")
	public Veicolo getVeicolo() {
		return new Veicolo();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Veicolo> addVeicolo(@RequestBody Veicolo veicolo) {
		try {
			Veicolo addedVeicolo = veicoloService.addVeicolo(veicolo);
			logger.info("Veicolo added: " + addedVeicolo);
			return new ResponseEntity<Veicolo>(addedVeicolo, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Veicolo> updateVeicolo(@RequestBody Veicolo veicolo) {
		try {
			Veicolo updatedVeicolo = veicoloService.updateVeicolo(veicolo);
			logger.info("Veicolo updated: " + updatedVeicolo);
			if (updatedVeicolo != null)
				return new ResponseEntity<Veicolo>(updatedVeicolo, HttpStatus.OK);
			else
				return new ResponseEntity<Veicolo>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete") 
	public ResponseEntity<Veicolo> deleteVeicolo (@RequestBody Veicolo veicolo) {
		try {
			veicoloService.deleteVeicolo(veicolo);
			logger.info("Veicolo deleted: " + veicolo);
			if (veicolo != null)
				return new ResponseEntity<Veicolo>(veicolo, HttpStatus.OK);
			else
				return new ResponseEntity<Veicolo>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<Veicolo>> getListVeicoli () {
		try {
			List<Veicolo> listVeicoli = veicoloService.getListVeicoli();
			logger.info("Lista veicoli: " + listVeicoli);
			if (listVeicoli != null)
				return new ResponseEntity<List<Veicolo>>(listVeicoli, HttpStatus.OK);
			else
				return new ResponseEntity<List<Veicolo>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Veicolo> getVeicoloById (@PathVariable("id") int id) {
		try {
			Veicolo veicolo = veicoloService.getVeicoloById(id);
			logger.info("Veicolo get by id=" + id + ": " + veicolo);
			if (veicolo != null)
				return new ResponseEntity<Veicolo>(veicolo, HttpStatus.OK);
			else
				return new ResponseEntity<Veicolo>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getListByCategoria")
	public ResponseEntity<List<Veicolo>> getListVeicoliByCategoria (@PathVariable("categoria") Categoria categoria) {
		try {
			List<Veicolo> listVeicoli = veicoloService.getListVeicoliByCategoria(categoria);
			logger.info("Lista veicoli by categori=" + categoria + ": " + listVeicoli);
			if (listVeicoli != null)
				return new ResponseEntity<List<Veicolo>>(listVeicoli, HttpStatus.OK);
			else
				return new ResponseEntity<List<Veicolo>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
}
