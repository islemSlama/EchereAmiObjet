package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Enchere;

public class EnchereDAOjdbcImpl implements EnchereDAO {

	private static final String SELECT_ENCHERES = "";

	public List<Enchere> select() throws DALException {

		List<Enchere> listeEncheres = new ArrayList<Enchere>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ENCHERES);
			ResultSet rs = pstmt.executeQuery();
			Enchere enchereCourant = new Enchere();
			while (rs.next()) {

				if (rs.getInt("no_utilisateur") != enchereCourant.getNoUtilisateur()) {
					enchereCourant = enchereBuilder(rs);
					listeEncheres.add(enchereCourant);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeEncheres;
	}

	private Enchere enchereBuilder(ResultSet rs) throws SQLException {
		Enchere enchereCourant;
		enchereCourant = new Enchere();
		enchereCourant.setNoUtilisateur(rs.getInt("no_utilisateur"));
		enchereCourant.setNoArticle(rs.getInt("no_article"));

		// comment set un type local time
		enchereCourant.setDatEnchere(rs.getDate("date_enchere"));
		enchereCourant.setMontantEnchere(rs.getInt("montant_enchere"));

		return enchereCourant;
	}

}
