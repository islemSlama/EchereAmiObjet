package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import java.util.List;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Categorie;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.CategorieDAO;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

public class CategorieManager {
	private List<Categorie> listCategories;
	private static CategorieManager instance = null;
	private CategorieDAO categorieDAO;

	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	public static CategorieManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	public List<Categorie> chargerMesCategories() throws BLLException {
		try {
			listCategories = categorieDAO.selectAll();

		} catch (DALException dale) {
			throw new BLLException("Echec du chargement du catalogue des aliments - ", dale);
		}
		return listCategories;
	}

	public Categorie selectionnerCategorie(int idCategorie) throws BLLException {
		return categorieDAO.selectById(idCategorie);
	}
}
