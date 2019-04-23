package fr.eni.javaee.ProjetEnchereAmiObjet.bo;

import java.time.LocalTime;

public class Enchere {

	private LocalTime datEnchere;
	private int montantEnchere;

	public Enchere() {
		super();
	}

	public Enchere(LocalTime datEnchere, int montantEnchere) {
		super();
		this.datEnchere = datEnchere;
		this.montantEnchere = montantEnchere;
	}

	public LocalTime getDatEnchere() {
		return datEnchere;
	}

	public void setDatEnchere(LocalTime datEnchere) {
		this.datEnchere = datEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [datEnchere=" + datEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

}
