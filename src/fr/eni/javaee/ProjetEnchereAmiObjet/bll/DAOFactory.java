package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAOjdbcImpl;

public class DAOFactory {

	public static UtilisateursDAO getUtilisateursDAO() {
		return new UtilisateursDAOjdbcImpl();
	}

}
