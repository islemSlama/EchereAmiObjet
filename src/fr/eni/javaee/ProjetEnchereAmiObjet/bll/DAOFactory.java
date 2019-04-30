package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ArticleVenduDAOjdbcImpl;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.CategorieDAOjdbcImpl;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.EnchereDAOjdbcImpl;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.RetraitDAOjdbcImpl;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAOjdbcImpl;

public class DAOFactory {

	public static UtilisateursDAO getUtilisateursDAO() {
		return new UtilisateursDAOjdbcImpl();
	}

	public static ArticleVenduDAOjdbcImpl getArticleVenduDAO() {
		return new ArticleVenduDAOjdbcImpl();
	}

	public static RetraitDAOjdbcImpl getRetraitDAO() {
		return new RetraitDAOjdbcImpl();
	}

	public static CategorieDAOjdbcImpl getCategorieDAO() {
		return new CategorieDAOjdbcImpl();
	}

	public static EnchereDAOjdbcImpl getEnchereDAO() {
		return new EnchereDAOjdbcImpl();
	}

}
