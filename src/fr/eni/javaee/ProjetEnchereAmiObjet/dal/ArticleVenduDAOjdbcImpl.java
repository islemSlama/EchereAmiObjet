package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;

public class ArticleVenduDAOjdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLE = "insert into articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ? , ? ,? ,? ,? ,?)";

	public ArticleVendu insertArticle(ArticleVendu article) throws DALException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, article.getDateDebutEncheres());
			pstmt.setDate(4, article.getDateFinEncheres());
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getNoUtilsateur());
			pstmt.setInt(7, article.getNoCategorie());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {

				article.setNoArticle(rs.getInt(1));
			}
			rs.close();
			pstmt.close();

			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;

	}

}
