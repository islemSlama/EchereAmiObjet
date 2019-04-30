package fr.eni.javaee.ProjetEnchereAmiObjet.bo;

import java.time.LocalTime;

public class Enchere {
	private int noUtilisateur;
	private int noArticle;
	private LocalTime datEnchere;
	private int montantEnchere;

	public Enchere() {
		super();
	}

	public Enchere(int noUtilisateur, int noArticle, LocalTime datEnchere, int montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.datEnchere = datEnchere;
		this.montantEnchere = montantEnchere;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
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
		return "Enchere [noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle + ", datEnchere=" + datEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}

}
