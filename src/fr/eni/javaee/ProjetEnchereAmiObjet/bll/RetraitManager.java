package fr.eni.javaee.ProjetEnchereAmiObjet.bll;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Retrait;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.RetraitDAO;

public class RetraitManager {

	private static RetraitManager instance = null;
	private RetraitDAO retraitDAO;

	public RetraitManager() {
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}

	public RetraitManager(int noArticle, String rue, String codePostal, String ville) {

	}

	public static RetraitManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}

	public void addRetrait(Retrait nouvelretrait) throws DALException {

		try {
			// Validations métier
			try {
				validerRetrait(nouvelretrait);
			} catch (BLLException e) {
				e.printStackTrace();
			}

			// Ajout en base de données
			retraitDAO.insert(nouvelretrait);

		} catch (DALException dale) {
			try {
				throw new BLLException("Impossible d'ajouter l'article ( " + nouvelretrait + " )", dale);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

	}

	public void validerRetrait(Retrait retraitAValider) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();

		if (retraitAValider == null) {
			throw new BLLException("retaritAValider ne peut être null");
		}
		// Les attributs des articles sont obligatoires
		Integer no_article = (Integer) retraitAValider.getNoArticle();
		if (no_article == null) {
			sb.append("Le numero article est obligatoire pour le retrait.\n");
			valide = false;
		}
		String rue = retraitAValider.getRue();
		if (rue == null || rue.trim().isEmpty()) {
			sb.append("La rue est obligatoire pour le retrait.\n");
			valide = false;
		}
		String codepostal = retraitAValider.getCodePostal();
		if (codepostal == null || codepostal.trim().isEmpty()) {
			sb.append("Le code postal est obligatoire pour le retrait.\n");
			valide = false;
		}
		String ville = retraitAValider.getVille();
		if (ville == null || ville.trim().isEmpty()) {
			sb.append("La ville est obligatoire pour le retrait.\n");
			valide = false;
		}

		// Si les informations ne sont pas valides.
		if (!valide) {
			throw new BLLException(sb.toString());
		}

	}
}
