package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;

public class ArticleVenduDAOjdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLE = "insert into articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ? , ? ,? ,? ,? ,?)";
	private static final String SELECT_ALL_ARTICLE = "select * from articles_vendus";
	private static final String SELECT_ARTICLE_utilisateur = "select * from articles_vendus where no_utilisateur = ?";
	private static final String SELECT_BY_ID_ARTICLE = "select nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,prix_vente, no_utilisateur, no_categorie from Articles_vendus where no_article = ?";

	public List<ArticleVendu> selectAllUtilisateur(int id) throws BLLException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_utilisateur);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result.add(map(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BLLException businessException = new BLLException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}

		if (result.isEmpty()) {
			BLLException businessException = new BLLException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}

		return result;
	}

	public ArticleVendu insertArticle(ArticleVendu article) throws DALException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);
			// System.out.println(">>>>>>>>>>>>>>>>>>>>" + article.getNoCategorie());
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, convertUtilToSql(article.getDateDebutEncheres()));
			pstmt.setDate(4, convertUtilToSql(article.getDateFinEncheres()));
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

	public List<ArticleVendu> selectAll() throws BLLException {
		List<ArticleVendu> mesarticles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mesarticles.add(map(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BLLException bllException = new BLLException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw bllException;
		}
		return mesarticles;
	}

	private java.sql.Date convertUtilToSql(java.util.Date parse) {
		java.util.Date uDate = new java.util.Date();

		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;

	}

	public ArticleVendu selectById(int id) throws BLLException {
		ArticleVendu result = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID_ARTICLE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = map(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BLLException businessException = new BLLException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}

		if (result == null) {
			BLLException businessException = new BLLException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}

		return result;
	}

	private ArticleVendu map(ResultSet rs) throws SQLException {

		int id = rs.getInt("no_article");
		String nom_article = rs.getString("nom_article");
		String description = rs.getString("description");
		Date date_debut_enchere = rs.getDate("date_debut_encheres");
		Date date_fin_enchere = rs.getDate("date_fin_encheres");
		int prix_initial = rs.getInt("prix_initial");
		int no_utilisateur = rs.getInt("no_utilisateur");
		int no_categorie = rs.getInt("no_categorie");

		return new ArticleVendu(id, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial,
				no_utilisateur, no_categorie);
	}

}
