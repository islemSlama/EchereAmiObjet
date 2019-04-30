package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public ArticleVendu insertArticle(ArticleVendu article) throws DALException;

	public List<ArticleVendu> selectAll() throws BLLException;
}
