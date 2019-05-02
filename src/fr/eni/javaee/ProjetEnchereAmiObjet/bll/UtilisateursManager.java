package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.ConnectionProvider;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAO;

public class UtilisateursManager {

	// a voir pk cette requette est là???????????????
	private static final String SELECT_USER_PASS = "select * from utilisateurs where pseudo = ?";
	private static UtilisateursManager instance = null;
	private UtilisateursDAO utilisateursDAO;

	public UtilisateursManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
	}

	public static UtilisateursManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new UtilisateursManager();
		}
		return instance;
	}

	public Utilisateur addUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws DALException {

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

		// System.out.println("test" + utilisateurs.getNoUtilisateur());

		return utilisateurs;
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

			System.out.println(utilisateur.getPseudo());
			// preparedStatement.setString(2, utilisateur.getMotDePasse());

			// hashpw(utilisateur.getMotDePasse(), BCrypt.gensalt(15)

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			String motdepassebdd = rs.getString("mot_de_passe");

			if (BCrypt.checkpw(utilisateur.getMotDePasse(), motdepassebdd)) {
				status = true;
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}

			System.out.println(status);

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

	public void updateUser(Utilisateur utilisateur, String nouveauMotDePasse, String confirmationNouveauMotDePasse)
			throws BLLException, DALException {
		BLLException blllException = new BLLException();

		validerChamps(utilisateur, nouveauMotDePasse, confirmationNouveauMotDePasse, blllException);

		if (blllException.hasErreurs()) {
			throw blllException;
		}

		utilisateur.setMotDePasse(nouveauMotDePasse);
		utilisateursDAO.update(utilisateur);
	}

	private void validerChamps(Utilisateur utilisateur, String nouveauMotDePasse, String confirmationNouveauMotDePasse,
			BLLException blllException) {
		if (utilisateur.getPseudo() == null || utilisateur.getNom() == null || utilisateur.getPrenom() == null
				|| utilisateur.getEmail() == null || utilisateur.getTelephone() == null || utilisateur.getRue() == null
				|| utilisateur.getCodePostal() == null || utilisateur.getVille() == null
				|| utilisateur.getMotDePasse() == null || utilisateur.getPseudo().isEmpty()
				|| utilisateur.getNom().isEmpty() || utilisateur.getPrenom().isEmpty()
				|| utilisateur.getEmail().isEmpty() || utilisateur.getTelephone().isEmpty()
				|| utilisateur.getRue().isEmpty() || utilisateur.getCodePostal().isEmpty()
				|| utilisateur.getVille().isEmpty() || utilisateur.getMotDePasse().isEmpty()
				|| nouveauMotDePasse == null || nouveauMotDePasse.isEmpty() || confirmationNouveauMotDePasse == null
				|| confirmationNouveauMotDePasse.isEmpty()) {
			// verif nmdp et cnmp
			blllException.getListeCodesErreur().add(new Integer("veuillez remplir les champs manquants"));
		}
	}

	public Utilisateur selectionnerUtilisateur(int idUtilisateur) throws BLLException {
		return utilisateursDAO.selectById(idUtilisateur);
	}

	public void supprimerUtilisateur(int idUtilisateur) throws BLLException {
		try {
			utilisateursDAO.delete(idUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}