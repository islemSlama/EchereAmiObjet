package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

public class UtilisateursDAOjdbcImpl implements UtilisateursDAO {

	private static final String INSERT_UTILISATEURS = "INSERT into UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_UTILISATEURS = "select pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs";

	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEURS,
					PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();

			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Utilisateur> select() throws DALException {

		List<Utilisateur> listeutilisateurs = new ArrayList<Utilisateur>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEURS);
			ResultSet rs = pstmt.executeQuery();
			Utilisateur utilisateurCourant = new Utilisateur();
			while (rs.next()) {

				if (rs.getInt("no_utilisateur") != utilisateurCourant.getNoUtilisateur()) {
					utilisateurCourant = utilisateursBuilder(rs);
					listeutilisateurs.add(utilisateurCourant);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeutilisateurs;
	}

	private Utilisateur utilisateursBuilder(ResultSet rs) throws SQLException {
		Utilisateur utilisateurCourant;
		utilisateurCourant = new Utilisateur();
		utilisateurCourant.setNoUtilisateur(rs.getInt("no_utilisateur"));
		utilisateurCourant.setNom(rs.getString("nom"));
		utilisateurCourant.setPrenom(rs.getString("prenom"));
		utilisateurCourant.setPseudo(rs.getString("pseudo"));
		utilisateurCourant.setEmail(rs.getString("email"));
		utilisateurCourant.setTelephone(rs.getString("telephone"));
		utilisateurCourant.setRue(rs.getString("rue"));
		utilisateurCourant.setCodePostal(rs.getString("codePostal"));
		utilisateurCourant.setVille(rs.getString("ville"));
		utilisateurCourant.setMotDePasse(rs.getString("motDePasse"));
		utilisateurCourant.setCredit(rs.getInt("credit"));
		utilisateurCourant.setAdministrateur(rs.getBoolean("administrateur"));

		return utilisateurCourant;
	}

}
