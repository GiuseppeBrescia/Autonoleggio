package it.team.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Noleggio {
	
	@Id
	@GeneratedValue
	private int id;
	
	private LocalDate inizioPrenotazione;
	
	private LocalDate finePrenotazione;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Veicolo veicolo;
	
	private double costoNoleggio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getInizioPrenotazione() {
		return inizioPrenotazione;
	}

	public void setInizioPrenotazione(LocalDate inizioPrenotazione) {
		this.inizioPrenotazione = inizioPrenotazione;
	}

	public LocalDate getFinePrenotazione() {
		return finePrenotazione;
	}

	public void setFinePrenotazione(LocalDate finePrenotazione) {
		this.finePrenotazione = finePrenotazione;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public double getCostoNoleggio() {
		return costoNoleggio;
	}

	public void setCostoNoleggio(double costoNoleggio) {
		this.costoNoleggio = costoNoleggio;
	}

	@Override
	public String toString() {
		return "Noleggio [id=" + id + ", inizioPrenotazione=" + inizioPrenotazione + ", finePrenotazione="
				+ finePrenotazione + ", cliente=" + cliente + ", veicolo=" + veicolo + ", costoNoleggio="
				+ costoNoleggio + "]";
	}

}
