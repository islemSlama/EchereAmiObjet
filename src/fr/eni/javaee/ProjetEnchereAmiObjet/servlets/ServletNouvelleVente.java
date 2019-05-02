package fr.eni.javaee.ProjetEnchereAmiObjet.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.ArticleVenduManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bll.CategorieManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bll.UtilisateursManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Categorie;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletNouvelleVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur utilisateur = null;
		List<Categorie> categories = null;

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");
		System.out.println("test" + idUtilisateur);

		UtilisateursManager managerUtilisateurModif = new UtilisateursManager();

		CategorieManager managerCategoriemodif = new CategorieManager();

		try {

			utilisateur = managerUtilisateurModif.selectionnerUtilisateur(idUtilisateur);

			categories = managerCategoriemodif.chargerMesCategories();
			// j'ai utiliser ça pour voir les listes que j'envois
			// System.out.println("test" + utilisateur);
			// System.out.println("test" + categories);

			// On passe l'utilisateur à la JSP via des setAttribute
			request.setAttribute("utilisateur", utilisateur);

			// je charge mes gategories et je les passe à la jsp

			request.setAttribute("categorie", categories);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp");
			rd.forward(request, response);

		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");

		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		Date dateDebutEncheres = null;
		try {
			// request.getParameter("debutEnchere")----> c'est les noms de mes champs dans
			// la JSP
			dateDebutEncheres = sdf.parse((request.getParameter("debutEnchere")));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		Date dateFinEncheres = null;
		try {
			dateFinEncheres = sdf.parse((request.getParameter("finEnchere")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int prixInitial = Integer.parseInt(request.getParameter("prix"));

		int numCategorie = Integer.parseInt(request.getParameter("no_categorie"));

		ArticleVenduManager articlesmanager;

		try {

			// int noArticle = Integer.parseInt(request.getParameter("no_article"));
			String rue = request.getParameter("rue");
			System.out.println("test" + rue);
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");

			articlesmanager = ArticleVenduManager.getInstance();

			Utilisateur utilisateurconstruit = new Utilisateur(rue, codePostal, ville);
			// System.out.println("tesssssssssssssssssssssssssst" + utilisateurconstruit);

			ArticleVendu maNouvVente = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres,
					prixInitial, idUtilisateur, numCategorie);
			articlesmanager.addArticleRetarit(maNouvVente, utilisateurconstruit);

			session.setAttribute("idArticle", maNouvVente.getNomArticle());
			request.setAttribute("article", maNouvVente);
			// request.setAttribute("utilisateur", utilisateurconstruit);

		} catch (DALException e) {
			e.printStackTrace();
		}
		// RequestDispatcher rd = request.getRequestDispatcher("profilConnecte");
		// rd.forward(request, response);
		response.sendRedirect("AccueilConnecteVente");
	}

}
