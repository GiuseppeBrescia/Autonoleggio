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

import it.team.model.Cliente;
import it.team.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	private final Logger logger = Logger.getLogger(ClienteController.class.getName());
	
	@GetMapping("/getModel")
	public Cliente getCliente() {
		return new Cliente();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		try {
			Cliente addedCliente = clienteService.add(cliente);
			logger.info("Cliente added: " + addedCliente);
			return new ResponseEntity<Cliente>(addedCliente, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		try {
			Cliente updatedCliente = clienteService.update(cliente);
			logger.info("Cliente updated: " + updatedCliente);
			if (updatedCliente == null)
				return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);
			else
				return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete") 
	public ResponseEntity<Cliente> deleteCliente (@RequestBody Cliente cliente) {
		try {
			clienteService.delete(cliente);
			logger.info("Cliente deleted: " + cliente);
			if (cliente == null)
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			else
				return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<Cliente>> getListClienti () {
		try {
			List<Cliente> listClienti = clienteService.getList();
			logger.info("Lista clienti: " + listClienti);
			if (listClienti == null)
				return new ResponseEntity<List<Cliente>>(listClienti, HttpStatus.OK);
			else
				return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Cliente> getClienteById (@PathVariable("id") int id) {
		try {
			Cliente cliente = clienteService.getClienteById(id);
			logger.info("Cliente get by id=" + id + ": " + cliente);
			if (cliente == null)
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			else
				return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
}
