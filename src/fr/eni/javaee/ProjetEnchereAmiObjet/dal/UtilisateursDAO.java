package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

public interface UtilisateursDAO {

	public Utilisateur insert(Utilisateur utilisateur) throws DALException;

	public List<Utilisateur> select() throws DALException;

}
