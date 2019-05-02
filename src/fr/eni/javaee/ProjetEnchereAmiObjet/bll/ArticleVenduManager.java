package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Retrait;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ArticleVenduDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ArticleVenduDAOjdbcImpl;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.RetraitDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.RetraitDAOjdbcImpl;

public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOjdbcImpl();
	private RetraitDAO retraitDAO = new RetraitDAOjdbcImpl();
	private List<ArticleVendu> catalogueArticle = new ArrayList<>();
	private static ArticleVenduManager instance = null;

	private ArticleVenduManager() {
		try {
			this.chargerLesArticles();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}

	public void addArticleRetarit(ArticleVendu nouvelArticlevendu, Utilisateur utilisateurconstruit)
			throws DALException {

		if (catalogueArticle.contains(nouvelArticlevendu)) {
			// OU
			// if (newArticle.getIdArticle() != null) {

			try {
				throw new BLLException("Article deja existant.");
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		try {
			// Validations métier
			try {
				validerArticle(nouvelArticlevendu);
			} catch (BLLException e) {
				e.printStackTrace();
			}

			// Ajout en base de données
			articleVenduDAO.insertArticle(nouvelArticlevendu);

			// int noArticle = Integer.parseInt(request.getParameter("no_article"));

			int articlevendunum = nouvelArticlevendu.getNoArticle();

			System.out.println("test1" + articlevendunum);

			String rue = utilisateurconstruit.getRue();

			String codePostal = utilisateurconstruit.getCodePostal();
			String ville = utilisateurconstruit.getVille();

			Retrait retrait = new Retrait(articlevendunum, rue, codePostal, ville);
			// System.out.println("test3" + retrait);

			retraitDAO.insert(retrait);
			// Ajout dans le catalogue
			catalogueArticle.add(nouvelArticlevendu);

		} catch (DALException dale) {
			try {
				throw new BLLException("Impossible d'ajouter l'article ( " + nouvelArticlevendu + " )", dale);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

	}

	private void chargerLesArticles() throws BLLException {
		catalogueArticle = articleVenduDAO.selectAll();
	}

	public void validerArticle(ArticleVendu articleAValider) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();

		if (articleAValider == null) {
			throw new BLLException("articleAValider ne peut être null");
		}
		// Les attributs des articles sont obligatoires
		String nom_article = articleAValider.getNomArticle();
		if (nom_article == null || nom_article.trim().isEmpty()) {
			sb.append("La reference article est obligatoire.\n");
			valide = false;
		}
		String description = articleAValider.getDescription();
		if (description == null || description.trim().isEmpty()) {
			sb.append("La description  est obligatoire.\n");
			valide = false;
		}
		Date date_debut_enchère = articleAValider.getDateDebutEncheres();
		if (date_debut_enchère == null) {
			sb.append("La date du début de l'enchère est obligatoire.\n");
			valide = false;
		}

		Date date_fin_enchère = articleAValider.getDateFinEncheres();
		if (date_fin_enchère == null) {
			sb.append("La date de la fin de l'enchère est obligatoire.\n");
			valide = false;
		}

		// Si les informations ne sont pas valides.
		if (!valide) {
			throw new BLLException(sb.toString());
		}

	}

	public List<ArticleVendu> getCatalogue() {
		return catalogueArticle;
	}

	public ArticleVendu selectionnerArticle(int idArticle) throws BLLException {
		return articleVenduDAO.selectById(idArticle);
	}

	public List<ArticleVendu> selectionnerArticleUtilisateur(int idutilisateur) throws BLLException {
		return articleVenduDAO.selectAllUtilisateur(idutilisateur);
	}

}
