package it.team.model;

public enum Categoria {
	
	UTILITARIA(30), BERLINA(40), COUPE(50), SUV(60), SUPERCAR(100);
	
	private int costo;

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	private Categoria(int costo) {
		this.costo = costo;
	}

}
