package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Retrait;

public class RetraitDAOjdbcImpl {

	private static final String INSERT_RETRAIT = "insert into retraits (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";

	public Retrait insert(Retrait retrait) throws DALException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);

			// la je récupere l'adresse de mon utilisateur connecté

			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCodePostal());
			pstmt.setString(3, retrait.getVille());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				// à revoir lundi
				// retrait.set(rs.getInt(1));
			}
			rs.close();
			pstmt.close();

			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retrait;

	}
}
