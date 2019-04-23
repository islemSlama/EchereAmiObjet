package fr.eni.javaee.ProjetEnchereAmiObjet.bo;

public class Categorie {

	private int noCategorie;
	private String libelle;

	public Categorie() {
		super();
	}

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

}
