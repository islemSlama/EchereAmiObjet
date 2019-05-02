package fr.eni.javaee.ProjetEnchereAmiObjet.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import fr.eni.javaee.ProjetEnchereAmiObjet.bll.UtilisateursManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.ArticleVendu;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

/**
 * Servlet implementation class profilConnectÃ©
 */
@WebServlet("/AccueilConnecteVente")
public class AcceuilConnecteVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceuilConnecteVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");

		UtilisateursManager managerUtilisateurModif = new UtilisateursManager();
		ArticleVenduManager managerarticle = ArticleVenduManager.getInstance();
		List<ArticleVendu> articles = new ArrayList<>();
		// List<ArticleVendu> articlescatalogue = managerarticle.getCatalogue();
		Utilisateur utilisateur = null;
		try {
			articles = managerarticle.selectionnerArticleUtilisateur(idUtilisateur);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			utilisateur = managerUtilisateurModif.selectionnerUtilisateur(idUtilisateur);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		//
		// //managerUtilisateurModif.selectionnerUtilisateur(idUtilisateur);
		//
		//
		// } catch (BLLException e) {
		// e.printStackTrace();
		// }
		// j'ai besoin d'un lien entre mon utilisateur avec l'attribut no-utilisateur
		// et l'article vendu avec la clé etrangère de mpn utilisateur dans la table
		// article vendu

		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("articles", articles);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecteVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession session = request.getSession();
		//
		// int idUtilisateur = (Integer) session.getAttribute("id");
		//
		// UtilisateursManager managerUtilisateurModif = new UtilisateursManager();
		// ArticleVenduManager managerarticle = ArticleVenduManager.getInstance();
		// List<ArticleVendu> articles = new ArrayList<>();
		// List<ArticleVendu> articlescatalogue = managerarticle.getCatalogue();
		// Utilisateur utilisateur = null;
		//
		// request.setAttribute("utilisateur", utilisateur);
		//
		// request.setAttribute("articleCatalogue", articlescatalogue);

	}

}
