package it.team.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Veicolo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String marca;
	
	private String targa;
	
	private Alimentazione alimentazione;
	
	private Categoria categoria;
	
	private Colore colore;
	
	private boolean disponibile;
	
	private LocalDate inizioNoleggio;
	
	private LocalDate fineNoleggio;
	
	private Cliente cliente;
	
	private double costoNoleggio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public LocalDate getInizioNoleggio() {
		return inizioNoleggio;
	}

	public void setInizioNoleggio(LocalDate inizioNoleggio) {
		this.inizioNoleggio = inizioNoleggio;
	}

	public LocalDate getFineNoleggio() {
		return fineNoleggio;
	}

	public void setFineNoleggio(LocalDate fineNoleggio) {
		this.fineNoleggio = fineNoleggio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getCostoNoleggio() {
		return costoNoleggio;
	}

	public void setCostoNoleggio(double costoNoleggio) {
		this.costoNoleggio = costoNoleggio;
	}

	@Override
	public String toString() {
		return "Veicolo [id=" + id + ", marca=" + marca + ", targa=" + targa + ", disponibile=" + disponibile
				+ ", inizioNoleggio=" + inizioNoleggio + ", fineNoleggio=" + fineNoleggio + ", costoNoleggio="
				+ costoNoleggio + "]";
	}

}
