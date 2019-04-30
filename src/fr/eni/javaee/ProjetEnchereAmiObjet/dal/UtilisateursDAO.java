package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

public interface UtilisateursDAO {

	public Utilisateur insert(Utilisateur utilisateur) throws DALException;

	public List<Utilisateur> select() throws DALException;

	void update(Utilisateur utilisateur) throws DALException;

	public Utilisateur selectById(int id) throws BLLException;

	public void delete(int idUtilisateur) throws BLLException, DALException;

}
