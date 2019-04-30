package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Retrait;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

public class RetraitManager {

	public Retrait addRetrait(String rue, String codePostal, String ville) throws DALException {

		Retrait retrait = new Retrait();

		retrait.setRue(rue);
		retrait.setCodePostal(codePostal);
		retrait.setVille(ville);

		// System.out.println("test" + utilisateurs.getNoUtilisateur());

		return retrait;
	}

}
