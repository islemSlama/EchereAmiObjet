package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public ArticleVendu insertArticle(ArticleVendu article) throws DALException;
}
