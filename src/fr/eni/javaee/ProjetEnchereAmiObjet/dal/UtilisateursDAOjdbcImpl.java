package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

public class UtilisateursDAOjdbcImpl implements UtilisateursDAO {

	private static final String INSERT_UTILISATEURS = "INSERT into UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_UTILISATEURS = "select pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs";
	private static final String SELECT_USER_PASS = "select * from utilisateurs where pseudo = ? and mot_de_passe = ? ";
	private static final String SELECT_BY_ID = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe from utilisateurs where no_utilisateur = ?";
	private static final String UPDATE_PROFILE = "UPDATE utilisateurs SET pseudo = ?, nom = ? , prenom = ?,  email = ?,  telephone = ?,  rue = ?,  code_postal = ?,  ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?";
	private static final String DELETE_USER = "delete from utilisateurs where no_utilisateur = ? ";

	private final static String CLEF_SALT = "$2a$15$oJdacDBNWLqlVZ4ZXiRAc.";

	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws DALException {

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
			pstmt.setString(9, BCrypt.hashpw(utilisateur.getMotDePasse(), CLEF_SALT));
			pstmt.setInt(10, 0);
			pstmt.setBoolean(11, false);

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
		return utilisateur;

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

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		if (utilisateur == null) {
			DALException dalException = new DALException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw dalException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PROFILE);

			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, BCrypt.hashpw(utilisateur.getMotDePasse(), CLEF_SALT));
			pstmt.setInt(10, utilisateur.getNoUtilisateur());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			// TODO : CodesResultatDAL
			// dalException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw dalException;
		}
	}

	public Utilisateur selectById(int id) throws BLLException {
		Utilisateur result = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
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

	private Utilisateur map(ResultSet rs) throws SQLException {

		int id = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String mot_de_passe = rs.getString("mot_de_passe");

		return new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
	}

	public void delete(int id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO : CodesResultatDAL
			throw new DALException("impossible de supprimer un utilisateur");
		}

	}

}
