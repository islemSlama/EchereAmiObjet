package fr.eni.javaee.ProjetEnchereAmiObjet.dal;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Categorie;

public interface CategorieDAO {
	public List<Categorie> selectAll() throws DALException;

	public Categorie selectById(int idcategorie) throws BLLException;

}
