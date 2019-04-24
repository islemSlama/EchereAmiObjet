package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.UtilisateursDAO;

public class UtilisateursManager {

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

}
