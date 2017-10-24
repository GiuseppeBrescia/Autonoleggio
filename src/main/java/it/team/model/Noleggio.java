package it.team.model;

import java.time.LocalDate;

public class Noleggio {
	
	private int id;
	
	private LocalDate inizioPrenotazione;
	
	private LocalDate finePrenotazione;
	
	private Cliente cliente;
	
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
