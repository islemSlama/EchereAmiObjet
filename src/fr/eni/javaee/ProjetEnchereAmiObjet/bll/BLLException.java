package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

	private List<Integer> listeCodesErreur;

	public List<Integer> getListeCodesErreur() {
		return listeCodesErreur;
	}

	public void setListeCodesErreur(List<Integer> listeCodesErreur) {
		this.listeCodesErreur = listeCodesErreur;
	}

	public BLLException() {
		// je recupere ça:BLLException(String message, Throwable exception)
		this(null, null);
	}

	public BLLException(String message) {
		this(message, null);
	}

	public BLLException(String message, Throwable exception) {
		super(message, exception);
		this.listeCodesErreur = new ArrayList<>();
	}

	public String getMessage(String message) {

		return "BLL - " + super.getMessage();
	}

	public boolean hasErreurs() {
		return this.listeCodesErreur.size() > 0;
	}

}
