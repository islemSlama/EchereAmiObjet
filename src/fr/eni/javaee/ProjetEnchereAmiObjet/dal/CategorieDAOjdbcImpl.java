package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Categorie;

public class CategorieDAOjdbcImpl implements CategorieDAO {

	private static final String SELECT_BY_ID = "select no_categorie, libelle from categories where  no_categorie= ?";
	private static final String SELECT_ALL_CATEGORIE = "select no_categorie, libelle from categories";

	public Categorie selectById(int idCategorie) throws BLLException {
		Categorie result = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, idCategorie);
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

	private Categorie map(ResultSet rs) throws SQLException {

		int idCategorie = rs.getInt("no_categorie");
		String libelle = rs.getString("libelle");

		return new Categorie(idCategorie, libelle);
	}

	public List<Categorie> selectAll() throws DALException {
		List<Categorie> categories = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String libelle = rs.getString("libelle");
				int no_categorie = rs.getInt("no_categorie");
				Categorie categorie = new Categorie(no_categorie, libelle);
				categories.add(categorie);

			}
		} catch (SQLException e) {
			throw new DALException("Problème!! impossible de charger les catégories");
		}
		return categories;
	}
}
