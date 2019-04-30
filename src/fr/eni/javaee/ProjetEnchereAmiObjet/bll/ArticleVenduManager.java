package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.sql.Date;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ArticleVenduDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO;
	private static ArticleVenduManager instance = null;

	public static ArticleVenduManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}

	public ArticleVendu addArticle(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int no_utilisateur, int no_categorie) throws DALException {

		ArticleVendu article = new ArticleVendu();

		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setDateDebutEncheres((dateDebutEncheres));
		article.setDateFinEncheres(dateFinEncheres);
		article.setPrixInitial(prixInitial);
		article.setNoUtilsateur(no_utilisateur);
		article.setNoCategorie(no_categorie);

		this.articleVenduDAO.insertArticle(article);

		// System.out.println("test" + utilisateurs.getNoUtilisateur());

		return article;
	}

}
