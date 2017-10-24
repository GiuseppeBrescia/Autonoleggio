package it.team.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String cognome;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="veicolo")
	private List<Noleggio> listNoleggi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", listNoleggi=" + listNoleggi + "]";
	}

}
