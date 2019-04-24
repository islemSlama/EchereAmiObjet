package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ConnectionProvider;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAO;

public class UtilisateursManager {

	private static final String SELECT_USER_PASS = "select * from utilisateurs where pseudo = ? and mot_de_passe = ? ";
	private UtilisateursDAO utilisateursDAO;

	public UtilisateursManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
	}

	public void addUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse, int credit,
			boolean administrateur) throws DALException {
		Utilisateur utilisateurs = new Utilisateur();
		utilisateurs.setPseudo(pseudo);
		utilisateurs.setNom(nom);
		utilisateurs.setPrenom(prenom);
		utilisateurs.setEmail(email);
		utilisateurs.setTelephone(telephone);
		utilisateurs.setRue(rue);
		utilisateurs.setCodePostal(codePostal);
		utilisateurs.setVille(ville);
		utilisateurs.setMotDePasse(motDePasse);

		this.utilisateursDAO.insert(utilisateurs);
	}

	public List<Utilisateur> selectAll() throws DALException {
		return this.utilisateursDAO.select();
	}

	public boolean validate(Utilisateur utilisateur) throws ClassNotFoundException, DALException {
		boolean status = false;

		// Class.forName("com.mysql.jdbc.Driver");

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement preparedStatement = cnx.prepareStatement(SELECT_USER_PASS);
			preparedStatement.setString(1, utilisateur.getPseudo());
			preparedStatement.setString(2, utilisateur.getMotDePasse());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;

	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}